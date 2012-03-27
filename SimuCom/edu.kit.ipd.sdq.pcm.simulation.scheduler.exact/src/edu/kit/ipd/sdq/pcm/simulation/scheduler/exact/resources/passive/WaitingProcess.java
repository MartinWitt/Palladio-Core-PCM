package edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.resources.passive;

import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.processes.IActiveProcess;

public class WaitingProcess {

	private IActiveProcess process;
	private int num_requested;

	public WaitingProcess(IActiveProcess process, int num_requested) {
		super();
		this.process = process;
		this.num_requested = num_requested;
	}

	public IActiveProcess getProcess() {
		return process;
	}

	public int getNumRequested() {
		return num_requested;
	}
}