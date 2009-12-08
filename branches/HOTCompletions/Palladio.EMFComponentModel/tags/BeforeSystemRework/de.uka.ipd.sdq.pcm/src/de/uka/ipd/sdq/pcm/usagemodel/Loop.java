
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.usagemodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Loop</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.usagemodel.Loop#getBodyBehaviour_Loop <em>Body Behaviour Loop</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.usagemodel.Loop#getIterations <em>Iterations</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage#getLoop()
 * @model
 * @generated
 */
public interface Loop extends AbstractUserAction {
	/**
	 * Returns the value of the '<em><b>Body Behaviour Loop</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body Behaviour Loop</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body Behaviour Loop</em>' containment reference.
	 * @see #setBodyBehaviour_Loop(ScenarioBehaviour)
	 * @see de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage#getLoop_BodyBehaviour_Loop()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	ScenarioBehaviour getBodyBehaviour_Loop();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.usagemodel.Loop#getBodyBehaviour_Loop <em>Body Behaviour Loop</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body Behaviour Loop</em>' containment reference.
	 * @see #getBodyBehaviour_Loop()
	 * @generated
	 */
	void setBodyBehaviour_Loop(ScenarioBehaviour value);

	/**
	 * Returns the value of the '<em><b>Iterations</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iterations</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Iterations</em>' attribute.
	 * @see #setIterations(String)
	 * @see de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage#getLoop_Iterations()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getIterations();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.usagemodel.Loop#getIterations <em>Iterations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Iterations</em>' attribute.
	 * @see #getIterations()
	 * @generated
	 */
	void setIterations(String value);

} // Loop