package de.uka.ipd.sdq.codegen.ejb;

import de.uka.ipd.sdq.workflow.pcm.configurations.AbstractCodeGenerationWorkflowRunConfiguration;

public class EjbCodeGenerationConfiguration extends
		AbstractCodeGenerationWorkflowRunConfiguration {

	@Override
	public String getErrorMessage() {
		// must be null; otherwise a non-empty error message will result in
		// a workflow config being considered invalid
		return null; 
	}

	@Override
	public void setDefaults() {
		throw new RuntimeException("Not implemented. No defaults defined.");
	}

}
