package de.uka.ipd.sdq.workflow.pcm.configurations;

import java.util.ArrayList;
import java.util.List;

import de.uka.ipd.sdq.workflow.pcm.runconfig.SensitivityAnalysisConfiguration;

/**
 * Base class of workflow configuration objects where the corresponding workflow
 * transforms PCM models into some kind of code
 *
 * @author Steffen Becker
 *
 */
public abstract class AbstractCodeGenerationWorkflowRunConfiguration extends
		AbstractPCMWorkflowRunConfiguration implements Cloneable {

	public enum CodeGenerationAdvice {
		SIMULATION("simulation_template_methods"), POJO("pojo_template_methods"), EJB3(
				"ejb3_template_methods"), PROTO("prototype_template_methods");

		private String templateFile;

		CodeGenerationAdvice(String templateFile) {
			this.templateFile = templateFile;
		}

		public String getTemplateFile() {
			return templateFile;
		}

	}

	protected boolean overwriteWithoutAsking = false;
	protected boolean loadMiddlewareAndCompletionFiles = false;
	protected CodeGenerationAdvice codeGenerationAdvice = CodeGenerationAdvice.SIMULATION;

	// The sensitivity analysis configurations have been moved here because the
	// PCM2CodeJob
	// requires the Sensitivity Analysis Config anyways. Also for other code
	// generation purposes (e.g. Protocom), sensitivity analysis can make sense.
	protected List<SensitivityAnalysisConfiguration> sensitivityAnalysisConfigurationList = new ArrayList<SensitivityAnalysisConfiguration>();
	protected boolean sensitivityAnalysisEnabled;

	/**
	 * @return Returns a string with information on the current sensitivity analysis run.
	 */
	private String getSensitivityAnalysisIdentifier() {
		String result = "";
		for (SensitivityAnalysisConfiguration sac : sensitivityAnalysisConfigurationList) {
			result += "." + sac.getRunNo();
		}
		return result;
	}

	/**
	 * @return Returns the ID of the Eclipse plugin to be generated by the code
	 *         transformation. This is the name of the Eclipse project which
	 *         will contain the generated code
	 */
	public String getStoragePluginID() {
		return sensitivityAnalysisEnabled ? super.getStoragePluginID()
				+ getSensitivityAnalysisIdentifier() : super.getStoragePluginID();
	}

	/**
	 * Set whether the code generation may overwrite any existing artifacts
	 * without asking the user. If set to false, the code generation has to ask
	 * the user first.
	 *
	 * @param overwriteWithoutAsking
	 */
	public void setOverwriteWithoutAsking(boolean overwriteWithoutAsking) {
		this.overwriteWithoutAsking = overwriteWithoutAsking;
	}

	/**
	 * Get whether the code generation may overwrite any existing artifacts
	 * without asking the user. If set to false, the code generation has to ask
	 * the user first.
	 *
	 * @return true if the code can be overwritten without asking, else false
	 */
	public boolean isOverwriteWithoutAsking() {
		return overwriteWithoutAsking;
	}

	/**
	 * Set whether the middleware files and completion files should be loaded,
	 * too. This is for example required for the simulation of linking
	 * resources.
	 *
	 * @param loadMiddlewareAndCompletionFiles
	 *            the loadMiddlewareAndCompletionFiles to set
	 */
	public void setLoadMiddlewareAndCompletionFiles(
			boolean loadMiddlewareAndCompletionFiles) {
		this.loadMiddlewareAndCompletionFiles = loadMiddlewareAndCompletionFiles;
	}

	/**
	 * Returns whether the middleware files and completion files should be
	 * loaded, too. This is for example required for the simulation of linking
	 * resources.
	 *
	 * @return the loadMiddlewareAndCompletionFiles
	 */
	public boolean isLoadMiddlewareAndCompletionFiles() {
		return loadMiddlewareAndCompletionFiles;
	}

	public boolean isSensitivityAnalysisEnabled() {
		return sensitivityAnalysisEnabled;
	}

	public List<SensitivityAnalysisConfiguration> getSensitivityAnalysisConfigurations() {
		if (!isSensitivityAnalysisEnabled())
			throw new UnsupportedOperationException(
					"GetSensitivityAnalysisConfiguration is only supported if isSensitivityAnaysisEnabled is true!");

		return sensitivityAnalysisConfigurationList;
	}

	public void setSensitivityAnalysisEnabled(boolean sensitivityAnalysisEnabled) {
		checkFixed();
		this.sensitivityAnalysisEnabled = sensitivityAnalysisEnabled;
	}

	public void setSensitivityAnalysisConfiguration(
			SensitivityAnalysisConfiguration sensitivityConfig) {
		checkFixed();
		this.sensitivityAnalysisConfigurationList = new ArrayList<SensitivityAnalysisConfiguration>();
		this.sensitivityAnalysisConfigurationList.add(sensitivityConfig);
	}

	public void setSensitivityAnalysisConfigurationList(
			List<SensitivityAnalysisConfiguration> sensitivityConfigList) {
		checkFixed();
		this.sensitivityAnalysisConfigurationList = sensitivityConfigList;

	}

	public CodeGenerationAdvice getCodeGenerationAdvice() {
		return codeGenerationAdvice;
	}

	public String getCodeGenerationAdvicesFile() {
		return this.codeGenerationAdvice.getTemplateFile();
	}

	public void setCodeGenerationAdvicesFile(CodeGenerationAdvice advice) {
		this.codeGenerationAdvice = advice;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.workflow.pcm.configurations.AbstractPCMWorkflowRunConfiguration#clone()
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		AbstractCodeGenerationWorkflowRunConfiguration config = (AbstractCodeGenerationWorkflowRunConfiguration) super.clone();
		config.codeGenerationAdvice = this.codeGenerationAdvice;
		config.loadMiddlewareAndCompletionFiles = this.loadMiddlewareAndCompletionFiles;
		config.overwriteWithoutAsking = this.overwriteWithoutAsking;
		List<SensitivityAnalysisConfiguration> newSensitivityAnalysisConfigurationList = new ArrayList<SensitivityAnalysisConfiguration>(this.sensitivityAnalysisConfigurationList.size());
		for(SensitivityAnalysisConfiguration saconfig : this.sensitivityAnalysisConfigurationList) {
			newSensitivityAnalysisConfigurationList.add(saconfig.getClone());
		}
		config.sensitivityAnalysisConfigurationList = newSensitivityAnalysisConfigurationList;
		config.sensitivityAnalysisEnabled = this.sensitivityAnalysisEnabled;
		return config;
	}
}
