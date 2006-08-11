/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ipd.uka.sdq.pcm.resourceenvironment;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Environment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.ipd.uka.sdq.pcm.resourceenvironment.ResourceEnvironment#getLinkingresource <em>Linkingresource</em>}</li>
 *   <li>{@link de.ipd.uka.sdq.pcm.resourceenvironment.ResourceEnvironment#getResourceContainer_ResourceEnvironment <em>Resource Container Resource Environment</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.ipd.uka.sdq.pcm.resourceenvironment.ResourceenvironmentPackage#getResourceEnvironment()
 * @model
 * @generated
 */
public interface ResourceEnvironment extends EObject {
	/**
	 * Returns the value of the '<em><b>Linkingresource</b></em>' containment reference list.
	 * The list contents are of type {@link de.ipd.uka.sdq.pcm.resourceenvironment.LinkingResource}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Linkingresource</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Linkingresource</em>' containment reference list.
	 * @see de.ipd.uka.sdq.pcm.resourceenvironment.ResourceenvironmentPackage#getResourceEnvironment_Linkingresource()
	 * @model type="de.ipd.uka.sdq.pcm.resourceenvironment.LinkingResource" containment="true" ordered="false"
	 * @generated
	 */
	EList getLinkingresource();

	/**
	 * Returns the value of the '<em><b>Resource Container Resource Environment</b></em>' containment reference list.
	 * The list contents are of type {@link de.ipd.uka.sdq.pcm.resourceenvironment.ResourceContainer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Container Resource Environment</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Container Resource Environment</em>' containment reference list.
	 * @see de.ipd.uka.sdq.pcm.resourceenvironment.ResourceenvironmentPackage#getResourceEnvironment_ResourceContainer_ResourceEnvironment()
	 * @model type="de.ipd.uka.sdq.pcm.resourceenvironment.ResourceContainer" containment="true" ordered="false"
	 * @generated
	 */
	EList getResourceContainer_ResourceEnvironment();

} // ResourceEnvironment