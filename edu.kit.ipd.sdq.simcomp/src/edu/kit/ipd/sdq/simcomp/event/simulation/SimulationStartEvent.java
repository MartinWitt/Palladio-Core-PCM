package edu.kit.ipd.sdq.simcomp.event.simulation;

public class SimulationStartEvent extends SimulationEvent {

	public static final String EVENT_ID = SimulationEvent.ID_PREFIX + "middleware/SIMULATION_START";

	public SimulationStartEvent() {
		super(SimulationStartEvent.EVENT_ID);
	}

}
