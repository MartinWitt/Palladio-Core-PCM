package de.uka.ipd.sdq.prototype.framework;

import de.uka.ipd.sdq.prototype.framework.utils.RunProperties;
import de.uka.ipd.sdq.sensorframework.entities.Experiment;
import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.simucomframework.variables.StackContext;

public abstract class AbstractOpenScenarioThread extends AbstractScenarioThread {

	private RunProperties runProps;
	private String interarrivalTime;

	public AbstractOpenScenarioThread(Experiment exp,
			ExperimentRun expRun,
			String scenarioName, RunProperties runProps, 
			String interarrivalTimeInSec) {
		super(exp, expRun, scenarioName, runProps);
		this.runProps = runProps;
		this.interarrivalTime = interarrivalTimeInSec;

	}

	@Override
	protected void runAndMeasureUsageScenarioIteration() {

		// TODO Lots of threads created here. Check if this is needed. (lehrig)
		new Thread() {
			public void run() {

				Runnable us = getScenarioRunner(runProps);
				logger.debug("Starting my scenario");
				long start = System.nanoTime();
				new Thread(us).run();
				takeScenarioMeasurement(start);
				logger.debug("Finished my scenario");

			}
		}.start();

		try {
			
			Object object = StackContext.evaluateStatic(this.interarrivalTime);
			if (object instanceof Number){
				//interarrival time in milliseconds
				Double interarrivalTime = ((Number)object).doubleValue() * 1000.0;
				// Wait for specified model time
				Thread.sleep(interarrivalTime.longValue());
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
