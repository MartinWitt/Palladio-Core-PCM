/**
 * 
 */
package de.uka.ipd.sdq.reliability.solver.sensitivity;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisationType;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelFactory;
import de.uka.ipd.sdq.sensitivity.StringParameterSequence;
import de.uka.ipd.sdq.stoex.AbstractNamedReference;
import de.uka.ipd.sdq.stoex.NamespaceReference;
import de.uka.ipd.sdq.stoex.VariableReference;

/**
 * This class provides rudimentary support for sensitivity analysis of a system
 * call variable usage.
 * 
 * Further refactorings required.
 * 
 * @author brosch
 * 
 */
public class SystemCallSensitivity extends MarkovSensitivity {

	/**
	 * The current parameter specification.
	 */
	private String currentSpecification;

	/**
	 * The property of the input parameter to alter.
	 */
	private VariableCharacterisationType parameterCharacterisation;

	/**
	 * The name of the input parameter to alter.
	 */
	private String parameterName;

	/**
	 * The ID of the EntryLevelSystemCall to alter.
	 */
	private String systemCallId;

	/**
	 * The name of the EntryLevelSystemCall to alter.
	 */
	private String systemCallName;

	/**
	 * The constructor.
	 * 
	 * @param systemCallId
	 *            the ID of the EntryLevelSystemCall to alter
	 * @param parameterName
	 *            the name of the EntryLevelSystemCall to alter
	 * @param parameterCharacterisation
	 *            the property of the input parameter to alter
	 * @param sequence
	 *            the sequence of parameter specifications
	 * @param resultLogFile
	 *            path where to log sensitivity analysis results
	 */
	public SystemCallSensitivity(final String name, final String systemCallId,
			final String parameterName,
			final VariableCharacterisationType parameterCharacterisation,
			final StringParameterSequence sequence, final String resultLogFile) {

		// Initialize basic variables:
		super(name, sequence, resultLogFile);

		// Further initializations:
		this.systemCallId = systemCallId;
		this.parameterName = parameterName;
		this.parameterCharacterisation = parameterCharacterisation;
	}

	/**
	 * Retrieves the relevant random variable to be altered.
	 * 
	 * @return the random variable
	 */
	private PCMRandomVariable getRandomVariable() {

		// Retrieve the PCM usage model:
		if (getModel().getUsageModel() == null) {
			// No usage model found!
			return null;
		}

		// Search for the relevant system call:
		EntryLevelSystemCall systemCall = null;
		EList<EObject> systemCalls = helper.getElements(getModel()
				.getUsageModel(), UsagemodelFactory.eINSTANCE
				.createEntryLevelSystemCall().eClass());
		for (EObject object : systemCalls) {
			if (((EntryLevelSystemCall) object).getId().equals(systemCallId)) {
				systemCall = (EntryLevelSystemCall) object;
				break;
			}
		}
		if (systemCall == null) {
			// No corresponding system call found!
			return null;
		}
		systemCallName = systemCall.getEntityName();

		// Search for the relevant parameter specification:
		PCMRandomVariable specification = null;
		for (VariableUsage usage : systemCall
				.getInputParameterUsages_EntryLevelSystemCall()) {
			if (checkParameterName(usage.getNamedReference__VariableUsage(),
					parameterName.split("\\."), 0)) {
				for (VariableCharacterisation characterisation : usage
						.getVariableCharacterisation_VariableUsage()) {
					if (characterisation.getType().equals(parameterCharacterisation)) {
						specification = characterisation
								.getSpecification_VariableCharacterisation();
						break;
					}
				}
				if (specification != null) {
					break;
				}
			}
		}
		return specification;
	}

	/**
	 * Checks if a given parameter name is compliant with a given named
	 * reference.
	 * 
	 * @param reference
	 *            the named reference
	 * @param paramName
	 *            the parameter name
	 * @return TRUE if the parameter is compliant with the named reference
	 */
	private boolean checkParameterName(final AbstractNamedReference reference,
			final String[] paramName, int index) {
		if (!reference.getReferenceName().equals(paramName[index])) {
			return false;
		}
		if (reference instanceof VariableReference) {
			return (paramName.length == index + 1);
		}
		return checkParameterName(((NamespaceReference) reference)
				.getInnerReference_NamespaceReference(), paramName, index + 1);
	}

	/**
	 * Sets the current specification.
	 * 
	 * @param variable
	 *            the random variable to alter.
	 */
	private void setSpecification(final PCMRandomVariable variable) {

		// Determine the current failure probability:
		currentSpecification = calculator.calculateCurrentStringValue(
				getStringSequence(), getCurrentStepNumber());

		// Set the failure probability:
		variable.setSpecification(currentSpecification);
	}

	/**
	 * Alters the model according to the next sensitivity analysis step.
	 * 
	 * @return indicates if the model could be successfully altered
	 */
	protected boolean alterModel() {

		// Retrieve the relevant random variable that shall be altered:
		PCMRandomVariable variable = getRandomVariable();
		if (variable == null) {
			return false;
		}

		// Alter the parameter:
		setSpecification(variable);

		// Everything ok:
		return true;
	}

	/**
	 * Builds the headings strings for logging.
	 * 
	 * @return the log headings strings
	 */
	protected List<List<String>> getLogHeadingsMulti() {

		// Create a result list:
		List<List<String>> resultList = new ArrayList<List<String>>();

		// Create the headings:
		ArrayList<String> headings = new ArrayList<String>();
		headings.add("System Call Name");
		headings.add("System Call ID");
		headings.add("Parameter Name");
		headings.add("Parameter Characterisation");
		headings.add("Parameter Specification");
		resultList.add(headings);

		// Return the result:
		return resultList;
	}

	/**
	 * Builds the results strings for sensitivity logging.
	 * 
	 * @return the results strings
	 */
	protected List<String> getLogSingleResultsMulti() {

		// Create a result list:
		List<String> resultList = new ArrayList<String>();

		// Create the result strings:
		resultList.add(systemCallName);
		resultList.add(systemCallId);
		resultList.add(parameterName);
		resultList.add(parameterCharacterisation.getName());
		resultList.add(currentSpecification);

		// Return the result:
		return resultList;
	}
}
