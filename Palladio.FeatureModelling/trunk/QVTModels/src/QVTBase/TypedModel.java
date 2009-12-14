/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package QVTBase;

import org.eclipse.emf.common.util.EList;

import EMOF.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Typed Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link QVTBase.TypedModel#getDependsOn <em>Depends On</em>}</li>
 *   <li>{@link QVTBase.TypedModel#getTransformation <em>Transformation</em>}</li>
 *   <li>{@link QVTBase.TypedModel#getUsedPackage <em>Used Package</em>}</li>
 * </ul>
 * </p>
 *
 * @see QVTBase.QVTBasePackage#getTypedModel()
 * @model
 * @generated
 */
public interface TypedModel extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Depends On</b></em>' reference list.
	 * The list contents are of type {@link QVTBase.TypedModel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Depends On</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Depends On</em>' reference list.
	 * @see QVTBase.QVTBasePackage#getTypedModel_DependsOn()
	 * @model ordered="false"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='dependent'"
	 * @generated
	 */
	EList<TypedModel> getDependsOn();

	/**
	 * Returns the value of the '<em><b>Transformation</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link QVTBase.Transformation#getModelParameter <em>Model Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transformation</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transformation</em>' container reference.
	 * @see #setTransformation(Transformation)
	 * @see QVTBase.QVTBasePackage#getTypedModel_Transformation()
	 * @see QVTBase.Transformation#getModelParameter
	 * @model opposite="modelParameter" resolveProxies="false" required="true"
	 * @generated
	 */
	Transformation getTransformation();

	/**
	 * Sets the value of the '{@link QVTBase.TypedModel#getTransformation <em>Transformation</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transformation</em>' container reference.
	 * @see #getTransformation()
	 * @generated
	 */
	void setTransformation(Transformation value);

	/**
	 * Returns the value of the '<em><b>Used Package</b></em>' reference list.
	 * The list contents are of type {@link EMOF.Package}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Used Package</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Used Package</em>' reference list.
	 * @see QVTBase.QVTBasePackage#getTypedModel_UsedPackage()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<EMOF.Package> getUsedPackage();

} // TypedModel
