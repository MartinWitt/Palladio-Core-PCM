package de.uka.ipd.sdq.simulation.probespec;

import de.uka.ipd.sdq.probespec.framework.ProbeType;
import de.uka.ipd.sdq.probespec.framework.probes.IProbeStrategyRegistry;
import de.uka.ipd.sdq.probespec.framework.probes.ProbeStrategyRegistry;
import de.uka.ipd.sdq.simulation.entities.SimActiveResource;
import de.uka.ipd.sdq.simulation.entities.SimPassiveResource;
import de.uka.ipd.sdq.simulation.probespec.probes.TakePassiveResourceStateStrategy;
import de.uka.ipd.sdq.simulation.probespec.probes.TakeScheduledResourceDemandStrategy;
import de.uka.ipd.sdq.simulation.probespec.probes.TakeScheduledResourceStateStrategy;
import de.uka.ipd.sdq.simulation.probespec.probes.TakeSimulatedTimeStrategy;

/**
 * Implementation of the {@link IProbeStrategyRegistry} interface for EventSim.
 * <p>
 * Invoking the default constructor registers ProbeStrategies for the following
 * <code>({@link ProbeType}, measurable entity)</code>-pairs.
 * <ul>
 * <li>{@link ProbeType#CURRENT_TIME}, <code>null</code></li>
 * <li>{@link ProbeType#RESOURCE_DEMAND}, {@link SimActiveResource}</li>
 * <li>{@link ProbeType#RESOURCE_STATE}, {@link SimActiveResource}</li>
 * </ul>
 * 
 * @author Philipp Merkle
 * 
 */
public class EventSimProbeStrategyRegistry extends ProbeStrategyRegistry {

    /**
     * Default constructor. Sets up the SimuCom specific ProbeStrategies as described above.
     */
    public EventSimProbeStrategyRegistry() {
        setupProbeStrategies();
    }

    private void setupProbeStrategies() {
        /* CURRENT_TIME */
        registerProbeStrategy(new TakeSimulatedTimeStrategy(), ProbeType.CURRENT_TIME, null);

        /* RESOURCE_DEMAND */
        // active resources
        registerProbeStrategy(new TakeScheduledResourceDemandStrategy(), ProbeType.RESOURCE_DEMAND,
                SimActiveResource.class);

        /* RESOURCE_STATE */
        // active resources
        registerProbeStrategy(new TakeScheduledResourceStateStrategy(), ProbeType.RESOURCE_STATE,
                SimActiveResource.class);

        // passive resources
        registerProbeStrategy(new TakePassiveResourceStateStrategy(), ProbeType.RESOURCE_STATE,
                SimPassiveResource.class);
    }

}