package de.uka.ipd.sdq.simucomframework;

import java.util.Map;

/**
 * @author roman
 * 
 * The class encases all configuration options for SimuCom.
 */
public class SimuComConfig {

	/** SimuCom configuration tab */
	public static String EXPERIMENT_RUN = "experimentRun";
	public static String SIMULATION_TIME = "simTime";
	
	/** configuration options */
	private String nameExperimentRun;
	private long simuTime;

	/**
	 * @param ILaunchConfiguration
	 */
	public SimuComConfig(Map configuration){
		try {
			this.nameExperimentRun = (String) configuration.get(
					EXPERIMENT_RUN);
			this.simuTime = Long.valueOf((String)configuration.get(
					SIMULATION_TIME));
		} catch (Exception e) {
			// TODO
			this.nameExperimentRun = "ExceptionName";
			this.simuTime = 1500000;
			//throw new Exception("Setting up properties failed", e);
		}
	}

	public String getNameExperimentRun() {
		return nameExperimentRun;
	}

	public long getSimuTime() {
		return simuTime;
	}

}
