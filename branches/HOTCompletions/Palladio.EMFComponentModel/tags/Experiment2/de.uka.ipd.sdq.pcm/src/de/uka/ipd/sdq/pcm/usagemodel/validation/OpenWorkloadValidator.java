/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.usagemodel.validation;

import de.uka.ipd.sdq.pcm.usagemodel.InterArrivalTime;

/**
 * A sample validator interface for {@link de.uka.ipd.sdq.pcm.usagemodel.OpenWorkload}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface OpenWorkloadValidator {
	boolean validate();

	boolean validateInterArrivalTime_OpenWorkload(InterArrivalTime value);
}