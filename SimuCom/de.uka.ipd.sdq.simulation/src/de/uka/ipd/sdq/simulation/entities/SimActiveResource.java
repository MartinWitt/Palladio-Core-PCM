package de.uka.ipd.sdq.simulation.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.pcm.resourceenvironment.SchedulingPolicy;
import de.uka.ipd.sdq.scheduler.IActiveResource;
import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.sensors.IActiveResourceStateSensor;
import de.uka.ipd.sdq.simucomframework.Context;
import de.uka.ipd.sdq.simulation.EventSimModel;
import de.uka.ipd.sdq.simulation.resources.listener.IDemandListener;
import de.uka.ipd.sdq.simulation.resources.listener.IOverallUtilizationListener;
import de.uka.ipd.sdq.simulation.resources.listener.IStateListener;

/**
 * An active resource can process demands of {@link Request}s.
 * 
 * @author Philipp Merkle
 * 
 */
public class SimActiveResource extends EventSimEntity {

    private static Logger logger = Logger.getLogger(SimActiveResource.class);

    /** the encapsulated scheduler resource */
    private IActiveResource schedulerResource;
    private String processingRate;
    private int numberOfInstances;
    private String description;
    private Map<Integer, List<IStateListener>> stateListener;
    private List<IDemandListener> demandListener;
    private List<IOverallUtilizationListener> overallUtilizationListener;
    private SchedulingPolicy schedulingStrategy;
    private double totalDemandedTime;

    /**
     * Constructs an active resource that wraps the specified resource.
     * 
     * @param model
     *            the simulation model
     * @param resource
     *            the wrapped scheduler resource
     * @param processingRate
     * @param numberOfInstances
     */
    public SimActiveResource(EventSimModel model, IActiveResource resource, String processingRate,
            int numberOfInstances, SchedulingPolicy schedulingStrategy) {
        super(model, "SimActiveResource");
        this.schedulerResource = resource;
        this.processingRate = processingRate;
        this.numberOfInstances = numberOfInstances;
        this.schedulingStrategy = schedulingStrategy;

        this.setupStateListenerAdapter(this.schedulerResource);
        stateListener = new HashMap<Integer, List<IStateListener>>();
        for (int instance = 0; instance < numberOfInstances; instance++) {
            stateListener.put(instance, new ArrayList<IStateListener>());
        }
        overallUtilizationListener = new ArrayList<IOverallUtilizationListener>();
        demandListener = new ArrayList<IDemandListener>();
    }

    /**
     * Translates the {@link IActiveResourceStateSensor} listener to the {@link IStateListener}. As
     * a result, all {@link IStateListener} of this resource gets notified if the encapsulated
     * scheduler resource fires a {@link IActiveResourceStateSensor} event.
     */
    private void setupStateListenerAdapter(IActiveResource resource) {
        resource.addObserver(new IActiveResourceStateSensor() {
            @Override
            public void update(int state, int instanceId) {
                fireStateEvent(state, instanceId);
            }
        });
    }

    /**
     * Processes the specified demand issued by the given process.
     * 
     * @param process
     *            the process that has requested the demand
     * @param abstractDemand
     *            the demand
     */
    public void consumeResource(ISchedulableProcess process, double abstractDemand) {
        if (logger.isDebugEnabled()) {
            logger.debug("Requested resource " + schedulerResource + " with an abstract demand of " + abstractDemand);
        }
        double concreteDemand = calculateConcreteDemand(abstractDemand);
        this.totalDemandedTime += concreteDemand;
        schedulerResource.process(process, concreteDemand);

        // notify demands listeners
        fireDemand(abstractDemand);
    }

    private double calculateConcreteDemand(double abstractDemand) {
        return abstractDemand / (Double) Context.evaluateStatic(processingRate, Double.class);
    }

    /**
     * Returns the resource ID. The ID of the resource is the ID of the encapsulated scheduler
     * resource.
     * 
     * @return the resource's ID
     * 
     * @see IActiveResource#getId()
     */
    public String getId() {
        return schedulerResource.getId();
    }

    /**
     * Returns the name of the resource. The resource name is the name of the encapsulated scheduler
     * resource.
     * 
     * @return the resource's name
     * 
     * @see IActiveResource#getName()
     */
    public String getName() {
        return schedulerResource.getName();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the number of instances of this resource.
     * 
     * @return the number of instances
     */
    public int getNumberOfInstances() {
        return numberOfInstances;
    }

    public SchedulingPolicy getSchedulingStrategy() {
        return schedulingStrategy;
    }

    public void addDemandListener(IDemandListener listener) {
        demandListener.add(listener);
    }

    public void addOverallUtilizationListener(IOverallUtilizationListener listener) {
        overallUtilizationListener.add(listener);
    }

    public void addStateListener(final IStateListener listener, int instance) {
        stateListener.get(instance).add(listener);
    }

    /**
     * Notifies the demand listeners that the specified demand has been requested.
     * 
     * @param demand
     *            the requested demand
     */
    protected void fireDemand(double demand) {
        for (IDemandListener l : demandListener) {
            l.demand(demand);
        }
    }

    /**
     * Notifies the overall utilisation listeners.
     * 
     * @param resourceDemand
     *            the cumulative resource demand
     * @param totalTime
     *            the total simulation time
     */
    protected void fireOverallUtilization(double resourceDemand, double totalTime) {
        for (IOverallUtilizationListener l : overallUtilizationListener) {
            l.utilizationChanged(resourceDemand, totalTime);
        }
    }

    /**
     * Notifies the state listeners that the state of the specified instance has changed.
     * 
     * @param state
     *            the resource's queue length
     * @param instance
     *            the affected resource instance
     */
    protected void fireStateEvent(int state, int instance) {
        for (IStateListener l : stateListener.get(instance)) {
            l.stateChanged(state, instance);
        }
    }

    /**
     * Called to notify this resource that the simulation run has stopped.
     */
    public void deactivateResource() {
        double totalTime = getModel().getSimulationControl().getCurrentSimulationTime() * numberOfInstances;
        if (totalDemandedTime > totalTime) {
            totalDemandedTime = totalTime;
        }
        fireOverallUtilization(totalDemandedTime, totalTime);

        schedulerResource.stop();
    }

}