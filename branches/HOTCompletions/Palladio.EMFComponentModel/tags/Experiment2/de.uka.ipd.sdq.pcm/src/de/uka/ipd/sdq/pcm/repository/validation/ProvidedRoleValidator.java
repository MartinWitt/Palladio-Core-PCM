/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository.validation;

import de.uka.ipd.sdq.pcm.core.entity.InterfaceProvidingEntity;

import de.uka.ipd.sdq.pcm.repository.Interface;

/**
 * A sample validator interface for {@link de.uka.ipd.sdq.pcm.repository.ProvidedRole}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface ProvidedRoleValidator {
	boolean validate();

	boolean validateProvidedInterface__ProvidedRole(Interface value);
	boolean validateProvidingEntity_ProvidedRole(InterfaceProvidingEntity value);
}