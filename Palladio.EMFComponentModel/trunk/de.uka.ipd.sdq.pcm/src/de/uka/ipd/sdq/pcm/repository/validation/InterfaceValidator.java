/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository.validation;

import de.uka.ipd.sdq.pcm.protocol.Protocol;

import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.Signature;

import org.eclipse.emf.common.util.EList;

/**
 * A sample validator interface for {@link de.uka.ipd.sdq.pcm.repository.Interface}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface InterfaceValidator {
	boolean validate();

	boolean validateParentInterface__Interface(EList<Interface> value);
	boolean validateAnchestorInterfaces_Interface(EList<Interface> value);
	boolean validateProtocols__Interface(EList<Protocol> value);
	boolean validateSignatures__Interface(EList<Signature> value);
	boolean validateRepository_Interface(Repository value);
}
