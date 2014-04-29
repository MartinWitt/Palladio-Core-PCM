package edu.kit.ipd.sdq.simcomp.event.simulation;

public class SimulationStopEvent extends SimulationEvent {

	public static final String EVENT_ID = SimulationEvent.ID_PREFIX + "middleware/SIMULATION_STOP";

	public SimulationStopEvent() {
		super(SimulationStopEvent.EVENT_ID);
	}

}
