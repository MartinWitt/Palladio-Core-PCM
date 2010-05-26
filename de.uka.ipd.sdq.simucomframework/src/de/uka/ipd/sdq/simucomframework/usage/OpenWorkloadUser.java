package de.uka.ipd.sdq.simucomframework.usage;

import de.uka.ipd.sdq.simucomframework.abstractSimEngine.SimProcess;
import de.uka.ipd.sdq.simucomframework.exceptions.FailureException;
import de.uka.ipd.sdq.simucomframework.exceptions.FailureStatistics;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

/**
 * Base class for open workload users. Open workload users begin their life,
 * execute their behaviour once, and then they die
 * 
 * @author Steffen Becker
 * 
 */
public class OpenWorkloadUser extends SimProcess implements IUser {

	private IScenarioRunner scenarioRunner;
	
	public OpenWorkloadUser(SimuComModel owner, String name,
			IScenarioRunner scenarioRunner) {
		super(owner, name);
		this.scenarioRunner = scenarioRunner;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see desmoj.core.simulator.SimProcess#lifeCycle()
	 */
	@Override
	protected void internalLifeCycle() {
		logger.debug(this.getName() + " started! I'm alive!!!");
		try {
			scenarioRunner(this);
		} catch (FailureException exception) {		
			if (this.getModel().getConfig().getSimulateFailures()) {
				FailureStatistics.getInstance().increaseSystemFailureCounter(exception.getFailureType());
			}
		}
		finally {
			// Increase measurements counter manually as usage scenario run is not finished:
			this.getModel().increaseMainMeasurementsCount();
		}
		logger.debug(this.getName() + " done! I'm dying!!!");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.simucomframework.usage.IScenarioRunner#scenarioRunner(desmoj.core.simulator.SimProcess)
	 */
	public void scenarioRunner(SimProcess thread) {
		this.scenarioRunner.scenarioRunner(thread);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.simucomframework.usage.IUser#startUserLife()
	 */
	public void startUserLife() {
		this.scheduleAt(0);
	}

	/**
	 * Retrieves the failure counter values of the user class.
	 * 
	 * @param type
	 *            the type of faiure to retrieve
	 * @return the failure count
	 */
	public static int getFailureCount(SimulationFailureType type) {
		switch (type) {
		case InternalActionFailed:
			return INTERNALACTIONFAILURECOUNT;
		case CommunicationLinkFailed:
			return COMMUNICATIONLINKFAILURECOUNT;
		default:
			return RESOURCEUNAVAILABILITYCOUNT;
		}
	}

	/**
	 * Resets the static failure counters of the user class.
	 */
	public static void resetFailureCounters() {
		INTERNALACTIONFAILURECOUNT = 0;
		COMMUNICATIONLINKFAILURECOUNT = 0;
		RESOURCEUNAVAILABILITYCOUNT = 0;
	}
}
