/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.pcm.parameter.VariableSetter;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Call Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Generic class realising call relations between behaviours (e.g. method call) for calls with parameters send to the called signature.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.CallAction#getVariableSetterInputs__CallAction <em>Variable Setter Inputs Call Action</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getCallAction()
 * @model abstract="true"
 * @generated
 */
public interface CallAction extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Variable Setter Inputs Call Action</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.parameter.VariableSetter}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.parameter.VariableSetter#getCallAction__VariableSetter <em>Call Action Variable Setter</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable Setter Inputs Call Action</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable Setter Inputs Call Action</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getCallAction_VariableSetterInputs__CallAction()
	 * @see de.uka.ipd.sdq.pcm.parameter.VariableSetter#getCallAction__VariableSetter
	 * @model opposite="callAction__VariableSetter" containment="true" ordered="false"
	 * @generated
	 */
	EList<VariableSetter> getVariableSetterInputs__CallAction();

} // CallAction
