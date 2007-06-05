/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository.validation;

import de.uka.ipd.sdq.pcm.repository.DataType;
import de.uka.ipd.sdq.pcm.repository.ParameterModifier;
import de.uka.ipd.sdq.pcm.repository.Signature;

/**
 * A sample validator interface for {@link de.uka.ipd.sdq.pcm.repository.Parameter}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface ParameterValidator {
	boolean validate();

	boolean validateDatatype__Parameter(DataType value);
	boolean validateParameterName(String value);
	boolean validateModifier__Parameter(ParameterModifier value);
	boolean validateSignature_Parameter(Signature value);
}
