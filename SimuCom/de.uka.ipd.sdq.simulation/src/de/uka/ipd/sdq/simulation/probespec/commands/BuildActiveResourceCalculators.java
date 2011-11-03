package de.uka.ipd.sdq.simulation.probespec.commands;

import java.util.ArrayList;
import java.util.List;

import de.uka.ipd.sdq.pcm.resourceenvironment.SchedulingPolicy;
import de.uka.ipd.sdq.probespec.framework.ProbeSpecContext;
import de.uka.ipd.sdq.probespec.framework.calculator.Calculator;
import de.uka.ipd.sdq.probespec.framework.calculator.DemandCalculator;
import de.uka.ipd.sdq.probespec.framework.calculator.StateCalculator;
import de.uka.ipd.sdq.simulation.EventSimModel;
import de.uka.ipd.sdq.simulation.PCMModel;
import de.uka.ipd.sdq.simulation.command.ICommandExecutor;
import de.uka.ipd.sdq.simulation.command.IPCMCommand;
import de.uka.ipd.sdq.simulation.entities.SimActiveResource;
import de.uka.ipd.sdq.simulation.staticstructure.SimulatedResourceContainer;
import de.uka.ipd.sdq.simulation.staticstructure.SimulatedResourceEnvironment;

/**
 * This command creates and returns a list of {@link Calculator}s. The following calculators are
 * created:
 * <ul>
 * <li>a {@link DemandCalculator} for each resource. If the resource has more than one instance, a
 * demand calculator is created for each instance.</li>
 * <li>a {@link StateCalculator} for each resource. If the resource has more than one instance, a
 * state calculator is created for each instance.</li>
 * </ul>
 * 
 * @author Philipp Merkle
 * 
 */
public class BuildActiveResourceCalculators implements IPCMCommand<List<Calculator>> {

    private EventSimModel model;
    private SimulatedResourceEnvironment environment;

    /**
     * Constructs a new command that creates calculators for resources contained in the specified
     * resource environment.
     * 
     * @param environment
     *            the resource environment
     */
    public BuildActiveResourceCalculators(EventSimModel model, SimulatedResourceEnvironment environment) {
        this.environment = environment;
        this.model = model;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Calculator> execute(PCMModel model, ICommandExecutor<PCMModel> executor) {
        List<Calculator> calculators = new ArrayList<Calculator>();
        for (SimulatedResourceContainer c : environment.getResourceContainers()) {
            for (SimActiveResource r : c.getResources()) {
                calculators.add(setupDemandCalculator(this.model.getProbeSpecContext(), r));

                // setup utilization calculators depending on their scheduling strategy and number
                // of cores
                SchedulingPolicy strategy = r.getSchedulingStrategy();
                if (strategy.equals(SchedulingPolicy.PROCESSOR_SHARING)) {
                    if (r.getNumberOfInstances() == 1) {
                        calculators.addAll(setupResourceStateCalculator(this.model.getProbeSpecContext(), r));
                    } else {
                        calculators.add(setupOverallUtilisationCalculator(this.model.getProbeSpecContext(), r));
                    }
                } else if (strategy.equals(SchedulingPolicy.DELAY) || strategy.equals(SchedulingPolicy.FCFS)) {
                    assert (r.getNumberOfInstances() == 1) : "DELAY and FCFS resources are expected to "
                            + "have exactly one core";
                    calculators.addAll(setupResourceStateCalculator(this.model.getProbeSpecContext(), r));
                } else if (strategy.equals(SchedulingPolicy.EXACT)) {
                    calculators.add(setupOverallUtilisationCalculator(this.model.getProbeSpecContext(), r));
                } else {
                    throw new RuntimeException("Could not setup utilization calculator at resource "
                            + r.getDescription() + " as it is unknown how to handle the scheduling strategy "
                            + strategy.name() + ".");
                }
            }
        }
        return calculators;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean cachable() {
        return false;
    }

    /**
     * Returns the probe set ID for the demand probe of the specified resource.
     * 
     * @param resource
     *            the resource
     * @return the probe set ID
     */
    public static Integer getDemandedTimeProbeSetId(ProbeSpecContext probeSpecContext, SimActiveResource resource) {
        return probeSpecContext.obtainProbeSetId("demand_" + resource.getName() + "_" + resource.getId());
    }

    /**
     * Returns the probe set ID for the state probe of the specified resource instance.
     * 
     * @param resource
     *            the resource
     * @param instance
     *            the instance of the resource
     * @return the probe set ID
     */
    public static Integer getStateProbeSetId(ProbeSpecContext probeSpecContext, SimActiveResource resource, int instance) {
        return probeSpecContext.obtainProbeSetId("state_" + getInstanceDescription(resource, instance));
    }

    public static Integer getOverallUtilisationProbeSetId(ProbeSpecContext probeSpecContext, SimActiveResource resource) {
        return probeSpecContext.obtainProbeSetId("overallUtilization_" + resource.getDescription());
    }

    /**
     * Creates and returns a {@link DemandCalculator} for the specified resource
     * 
     * @param resource
     *            the resource
     * @return the created calculator
     */
    private DemandCalculator setupDemandCalculator(ProbeSpecContext probeSpecContext, final SimActiveResource resource) {
        final Integer probeSetId = getDemandedTimeProbeSetId(probeSpecContext, resource);
        DemandCalculator calculator = probeSpecContext.getCalculatorFactory().buildDemandCalculator(
                resource.getDescription(), probeSetId);
        return calculator;
    }

    /**
     * Creates and returns a {@link StateCalculator} for each instance of the specified resource.
     * 
     * @param resource
     *            the resource
     * @return the list of created calculators
     */
    private List<StateCalculator> setupResourceStateCalculator(ProbeSpecContext probeSpecContext,
            SimActiveResource resource) {
        List<StateCalculator> calculators = new ArrayList<StateCalculator>();
        for (int instance = 0; instance < resource.getNumberOfInstances(); instance++) {
            final Integer probeSetID = getStateProbeSetId(probeSpecContext, resource, instance);
            calculators.add(probeSpecContext.getCalculatorFactory().buildStateCalculator(
                    getInstanceDescription(resource, instance), probeSetID));
        }
        return calculators;
    }

    private StateCalculator setupOverallUtilisationCalculator(ProbeSpecContext probeSpecContext,
            SimActiveResource resource) {
        final Integer stateProbeSetID = getOverallUtilisationProbeSetId(probeSpecContext, resource);
        return probeSpecContext.getCalculatorFactory().buildOverallUtilizationCalculator(resource.getDescription(),
                stateProbeSetID);
    }

    /**
     * Returns a textual description of the specified resource instance.
     * 
     * @param resource
     *            the resource
     * @param instance
     *            the instance of the resource
     * @return the resource instance's description
     */
    private static String getInstanceDescription(SimActiveResource resource, int instance) {
        String description = resource.getDescription();
        if (resource.getNumberOfInstances() > 1) {
            description = "Core " + (instance + 1) + " " + description;
        }
        return description;
    }

}
