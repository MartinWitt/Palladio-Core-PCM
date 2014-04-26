package de.uka.ipd.sdq.simucomframework.resources;

import java.util.Arrays;
import java.util.List;

import org.palladiosimulator.measurementspec.BasicMeasurement;
import org.palladiosimulator.metricspec.MetricDescription;
import org.palladiosimulator.metricspec.constants.MetricDescriptionConstants;
import org.palladiosimulator.probeframework.ProbeFrameworkContext;
import org.palladiosimulator.probeframework.probes.EventProbe;
import org.palladiosimulator.probeframework.probes.EventProbeSet;
import org.palladiosimulator.probeframework.probes.Probe;
import org.palladiosimulator.probeframework.probes.TriggeredProbe;
import org.palladiosimulator.probeframework.probes.TriggeredProbeSet;

import de.uka.ipd.sdq.scheduler.IPassiveResource;
import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.sensors.IPassiveResourceSensor;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.probes.TakeCurrentSimulationTimeProbe;
import de.uka.ipd.sdq.simucomframework.probes.TakePassiveResourceStateProbe;
import de.uka.ipd.sdq.simucomframework.probes.TakeScheduledResourceDemandProbe;
import de.uka.ipd.sdq.simucomframework.probes.TakeScheduledResourceStateProbe;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimulationControl;

/**
 * Offers static methods to setup different types of calculators for resources like
 * {@link AbstractScheduledResource} and {@link IPassiveResource}.
 * 
 * @author Philipp Merkle
 * 
 */
public final class CalculatorHelper {

    /**
     * Sets up a {@link WaitingTimeCalculator} for the specified resource. Also a
     * {@link IPassiveResourceSensor} will be registered at the resource which gets notified of
     * events that are relevant for calculating the waiting time. When such an event arrives, an
     * appropriate {@link BasicMeasurement} will be taken and published at the
     * {@link ISampleBlackboard}.
     * 
     * @param resource
     *            the resource
     * @param model
     *            The Simucom Model
     */
    public static void setupWaitingTimeCalculator(final IPassiveResource resource, final SimuComModel model) {
        final ProbeFrameworkContext ctx = model.getProbeFrameworkContext();

        // build waiting time calculator
        final List<Probe> startStopProbes = buildStartStopProbes(model);
        ctx.getCalculatorFactory().buildWaitingTimeCalculator(
                "Passive Resource " + resource.getName() + " " + resource.getId(), startStopProbes);

        resource.addObserver(new IPassiveResourceSensor() {

            @Override
            public void request(final ISchedulableProcess process, final long num) {
                ((TriggeredProbe)startStopProbes.get(0)).takeMeasurement();
            }

            @Override
            public void acquire(final ISchedulableProcess process, final long num) {
                ((TriggeredProbe)startStopProbes.get(1)).takeMeasurement();
            }

            @Override
            public void release(final ISchedulableProcess process, final long num) {
                // nothing to do here
            }

        });

    }

    /**
     * Sets up a {@link HoldTimeCalculator} for the specified resource. Also a
     * {@link IPassiveResourceSensor} will be registered at the resource which gets notified of
     * events that are relevant for calculating the hold time. When such an event arrives, an
     * appropriate {@link BasicMeasurement} will be taken and published at the
     * {@link ISampleBlackboard}.
     * 
     * @param r
     *            the resource
     */
    public static void setupHoldTimeCalculator(final IPassiveResource resource, final SimuComModel model) {
        final ProbeFrameworkContext ctx = model.getProbeFrameworkContext();

        final List<Probe> startStopProbes = buildStartStopProbes(model);
        ctx.getCalculatorFactory().buildHoldTimeCalculator(
                "Passive Resource " + resource.getName() + " " + resource.getId(), startStopProbes);

        resource.addObserver(new IPassiveResourceSensor() {

            @Override
            public void request(final ISchedulableProcess process, final long num) {
                // nothing to do here
            }

            @Override
            public void acquire(final ISchedulableProcess process, final long num) {
                ((TriggeredProbe)startStopProbes.get(0)).takeMeasurement();
            }

            @Override
            public void release(final ISchedulableProcess process, final long num) {
                ((TriggeredProbe)startStopProbes.get(0)).takeMeasurement();
            }
        });
    }

    /**
     * @param model
     * @return
     */
    protected static List<Probe> buildStartStopProbes(final SimuComModel model) {
        return Arrays.asList((Probe) new TakeCurrentSimulationTimeProbe(model.getSimulationControl()),
                (Probe) new TakeCurrentSimulationTimeProbe(model.getSimulationControl()));
    }

    /**
     * Sets up a {@link DemandCalculator} for the specified resource. Also a {@link IDemandListener}
     * will be registered at the resource which gets notified of events that are relevant for
     * calculating the demanded time. When such an event arrives, an appropriate
     * {@link BasicMeasurement} will be taken and published at the {@link ISampleBlackboard}.
     * 
     * @param r
     *            the resource
     */
    public static void setupDemandCalculator(final AbstractScheduledResource r, final SimuComModel model) {
        final ProbeFrameworkContext ctx = model.getProbeFrameworkContext();

        final Probe scheduledResourceProbe = getEventProbeSetWithCurrentTime(model.getSimulationControl(),
                new TakeScheduledResourceDemandProbe(r), "Demand");
        ctx.getCalculatorFactory().buildDemandCalculator(r.getDescription(), scheduledResourceProbe);
    }

    /**
     * Sets up a {@link StateCalculator} for the specified resource. Also a {@link IStateListener}
     * will be registered at the resource which gets notified of events that are relevant for
     * calculating the state. When such an event arrives, an appropriate {@link BasicMeasurement}
     * will be taken and published at the {@link ISampleBlackboard}.
     * 
     * @param scheduledResource
     *            the resource
     */
    public static void setupStateCalculator(final AbstractScheduledResource scheduledResource, final SimuComModel model) {
        final ProbeFrameworkContext ctx = model.getProbeFrameworkContext();

        // setup a calculator for each instance
        for (int instance = 0; instance < scheduledResource.getNumberOfInstances(); instance++) {
            final String instanceDescription = "Core " + (instance + 1) + " " + scheduledResource.getDescription();
            final TriggeredProbe scheduledResourceProbe = getTriggeredProbeSetWithCurrentTime(model.getSimulationControl(),
                    new TakeScheduledResourceStateProbe(scheduledResource, instance),MetricDescriptionConstants.CPU_STATE_OVER_TIME_METRIC);
            ctx.getCalculatorFactory().buildStateCalculator(instanceDescription, scheduledResourceProbe);

            scheduledResource.addStateListener(new IStateListener() {
                @Override
                public void stateChanged(final long state, final int instanceId) {
                    scheduledResourceProbe.takeMeasurement();
                }
            }, instance);
        }
    }

    public static void setupOverallUtilizationCalculator(final AbstractScheduledResource r, final SimuComModel model) {
        final ProbeFrameworkContext ctx = model.getProbeFrameworkContext();

        r.addOverallUtilizationListener(new IOverallUtilizationListener() {

            @Override
            public void utilizationChanged(final double resourceDemand, final double totalTime) {

                // FIXME following line was commented-out. Make code working again.
                //ctx.getCalculatorFactory().buildOverallUtilizationCalculator(r.getDescription(), null);
                // FIXME: Define a new probe which results in the overall observed utilisation and hands it to the calculator
                //                // FIXME This is a hack that allows to add samples to the blackboard even when
                //                // the simulation has stopped.
                //                if (!(ctx.getSampleBlackboard() instanceof DiscardInvalidMeasurementsBlackboardDecorator)) {
                //                    return;
                //                }
                //                final DiscardInvalidMeasurementsBlackboardDecorator blackboard = (DiscardInvalidMeasurementsBlackboardDecorator) ctx
                //                        .getSampleBlackboard();
                //
                //                // build ProbeSetSamples and publish them on the blackboard
                //                // TODO maybe null instead of empty string is better here
                //                final RequestContext context = new RequestContext("");
                //                blackboard.addSampleAfterSimulationEnd(ProbeFrameworkUtils.buildProbeSetSample(takeTimeSample(0.0, ctx),
                //                        takeStateProbe(1l, ctx), context, "", stateProbeSetID));
                //                blackboard.addSampleAfterSimulationEnd(ProbeFrameworkUtils.buildProbeSetSample(
                //                        takeTimeSample(resourceDemand, ctx), takeStateProbe(0l, ctx), context, "", stateProbeSetID));
                //                blackboard.addSampleAfterSimulationEnd(ProbeFrameworkUtils.buildProbeSetSample(
                //                        takeTimeSample(totalTime, ctx), takeStateProbe(1l, ctx), context, "", stateProbeSetID));
            }
        });
    }

    public static void setupStateCalculator(final IPassiveResource resource, final SimuComModel model) {
        final ProbeFrameworkContext ctx = model.getProbeFrameworkContext();

        final TriggeredProbe scheduledResourceProbe = getTriggeredProbeSetWithCurrentTime(model.getSimulationControl(),
                new TakePassiveResourceStateProbe(resource),"State");
        ctx.getCalculatorFactory().buildStateCalculator(
                "Passive Resource " + resource.getName() + " " + resource.getId(), scheduledResourceProbe);

        resource.addObserver(new IPassiveResourceSensor() {

            @Override
            public void request(final ISchedulableProcess process, final long num) {
                // nothing to do here
            }

            @Override
            public void release(final ISchedulableProcess process, final long num) {
                scheduledResourceProbe.takeMeasurement();
            }

            @Override
            public void acquire(final ISchedulableProcess process, final long num) {
                scheduledResourceProbe.takeMeasurement();
            }
        });
    }

    protected static TriggeredProbeSet getTriggeredProbeSetWithCurrentTime(final ISimulationControl control, final Probe additionalProbe,
            final MetricDescription metric) {
        return new TriggeredProbeSet(Arrays.asList(new TakeCurrentSimulationTimeProbe(control),additionalProbe), metric);
    }

    protected static TriggeredProbeSet getTriggeredProbeSetWithCurrentTime(final ISimulationControl control, final Probe additionalProbe,
            final String metricName) {
        return new TriggeredProbeSet(Arrays.asList(new TakeCurrentSimulationTimeProbe(control),additionalProbe), metricName);
    }

    protected static EventProbeSet getEventProbeSetWithCurrentTime(final ISimulationControl control, final EventProbe<?> additionalProbe,
            final String metricName) {
        return new EventProbeSet(additionalProbe,Arrays.asList((Probe)new TakeCurrentSimulationTimeProbe(control)), metricName);
    }
}
