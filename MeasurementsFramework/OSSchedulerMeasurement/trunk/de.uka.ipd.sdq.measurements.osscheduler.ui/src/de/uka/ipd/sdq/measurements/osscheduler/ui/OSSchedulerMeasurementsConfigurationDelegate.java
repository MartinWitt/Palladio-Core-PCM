package de.uka.ipd.sdq.measurements.osscheduler.ui;

import java.util.ArrayList;

import org.apache.log4j.Level;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;

import de.uka.ipd.sdq.measurements.osscheduler.configurator.OSSchedulerMeasurementsConfiguration;
import de.uka.ipd.sdq.measurements.osscheduler.configurator.jobs.OSSchedulerMeasurementsJob;
import de.uka.ipd.sdq.workflow.IJob;
import de.uka.ipd.sdq.workflow.Workflow;
import de.uka.ipd.sdq.workflow.launchconfig.AbstractWorkflowBasedLaunchConfigurationDelegate;
import de.uka.ipd.sdq.workflow.launchconfig.LoggerAppenderStruct;

public class OSSchedulerMeasurementsConfigurationDelegate extends
AbstractWorkflowBasedLaunchConfigurationDelegate<OSSchedulerMeasurementsConfiguration, Workflow> {
	
	private static final String LOG_PATTERN = "%-5p: %m\n";

	@Override
	protected IJob createWorkflowJob(
			OSSchedulerMeasurementsConfiguration config, ILaunch launch)
			throws CoreException {
		return new OSSchedulerMeasurementsJob(config);
	}

	@Override
	protected OSSchedulerMeasurementsConfiguration deriveConfiguration(
			ILaunchConfiguration configuration, String mode)
			throws CoreException {
		OSSchedulerMeasurementsConfiguration config = new OSSchedulerMeasurementsConfiguration();
		config.setMeasurementScriptPath(configuration.getAttribute(Constants.MEASUREMENTSCRIPT_FILE, ""));
		return config;
	}
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.workflow.launchconfig.AbstractWorkflowBasedLaunchConfigurationDelegate#setupLogging(org.apache.log4j.Level)
	 */
	@Override
	protected ArrayList<LoggerAppenderStruct> setupLogging(Level logLevel)
			throws CoreException {
		
		ArrayList<LoggerAppenderStruct> loggerList = new ArrayList<LoggerAppenderStruct>();

		loggerList.add(setupLogger("de.uka.ipd.sdq.workflow", logLevel,	LOG_PATTERN));
		loggerList.add(setupLogger("de.uka.ipd.sdq.measurements", logLevel, LOG_PATTERN));
		return loggerList;
	}	

}
