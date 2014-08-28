/**
 */
package org.palladiosimulator.pcmmeasuringpoint;

import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>External Call Action Reference</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.palladiosimulator.pcmmeasuringpoint.ExternalCallActionReference#getExternalCall
 * <em>External Call</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage#getExternalCallActionReference()
 * @model abstract="true"
 * @generated
 */
public interface ExternalCallActionReference extends EObject {
    /**
     * Returns the value of the '<em><b>External Call</b></em>' reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>External Call</em>' reference isn't clear, there really should be
     * more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>External Call</em>' reference.
     * @see #setExternalCall(ExternalCallAction)
     * @see org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage#getExternalCallActionReference_ExternalCall()
     * @model required="true"
     * @generated
     */
    ExternalCallAction getExternalCall();

    /**
     * Sets the value of the '
     * {@link org.palladiosimulator.pcmmeasuringpoint.ExternalCallActionReference#getExternalCall
     * <em>External Call</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>External Call</em>' reference.
     * @see #getExternalCall()
     * @generated
     */
    void setExternalCall(ExternalCallAction value);

} // ExternalCallActionReference
