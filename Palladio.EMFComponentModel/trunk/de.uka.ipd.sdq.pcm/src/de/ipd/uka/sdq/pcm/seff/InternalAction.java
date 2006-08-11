/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ipd.uka.sdq.pcm.seff;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Internal Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.ipd.uka.sdq.pcm.seff.InternalAction#getFailureProbability <em>Failure Probability</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.ipd.uka.sdq.pcm.seff.SeffPackage#getInternalAction()
 * @model
 * @generated
 */
public interface InternalAction extends AbstractResourceDemandingAction {
	/**
	 * Returns the value of the '<em><b>Failure Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Failure Probability</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Failure Probability</em>' attribute.
	 * @see #setFailureProbability(String)
	 * @see de.ipd.uka.sdq.pcm.seff.SeffPackage#getInternalAction_FailureProbability()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getFailureProbability();

	/**
	 * Sets the value of the '{@link de.ipd.uka.sdq.pcm.seff.InternalAction#getFailureProbability <em>Failure Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Failure Probability</em>' attribute.
	 * @see #getFailureProbability()
	 * @generated
	 */
	void setFailureProbability(String value);

} // InternalAction