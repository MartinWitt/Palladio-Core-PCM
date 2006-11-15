
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository;


import de.uka.ipd.sdq.pcm.core.entity.Entity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Data Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.CollectionDataType#getInnerType_CollectionDataType <em>Inner Type Collection Data Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getCollectionDataType()
 * @model
 * @generated
 */
public interface CollectionDataType extends Entity, DataType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * Returns the value of the '<em><b>Inner Type Collection Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inner Type Collection Data Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inner Type Collection Data Type</em>' reference.
	 * @see #setInnerType_CollectionDataType(DataType)
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getCollectionDataType_InnerType_CollectionDataType()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	DataType getInnerType_CollectionDataType();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.repository.CollectionDataType#getInnerType_CollectionDataType <em>Inner Type Collection Data Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inner Type Collection Data Type</em>' reference.
	 * @see #getInnerType_CollectionDataType()
	 * @generated
	 */
	void setInnerType_CollectionDataType(DataType value);

} // CollectionDataType