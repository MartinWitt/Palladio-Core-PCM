/**
 * Copyright 2007-2008, SDQ, IPD, U Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.featuremodel;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.featuremodel.FeatureGroup#getMin <em>Min</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featuremodel.FeatureGroup#getMax <em>Max</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featuremodel.FeatureGroup#getChildren <em>Children</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.featuremodel.featuremodelPackage#getFeatureGroup()
 * @model
 * @generated
 */
public interface FeatureGroup extends ChildRelation {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007-2008, SDQ, IPD, U Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Min</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min</em>' attribute.
	 * @see #setMin(int)
	 * @see de.uka.ipd.sdq.featuremodel.featuremodelPackage#getFeatureGroup_Min()
	 * @model default="1" required="true" ordered="false"
	 * @generated
	 */
	int getMin();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.featuremodel.FeatureGroup#getMin <em>Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min</em>' attribute.
	 * @see #getMin()
	 * @generated
	 */
	void setMin(int value);

	/**
	 * Returns the value of the '<em><b>Max</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max</em>' attribute.
	 * @see #setMax(int)
	 * @see de.uka.ipd.sdq.featuremodel.featuremodelPackage#getFeatureGroup_Max()
	 * @model default="1" required="true" ordered="false"
	 * @generated
	 */
	int getMax();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.featuremodel.FeatureGroup#getMax <em>Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max</em>' attribute.
	 * @see #getMax()
	 * @generated
	 */
	void setMax(int value);

	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.featuremodel.Feature}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see de.uka.ipd.sdq.featuremodel.featuremodelPackage#getFeatureGroup_Children()
	 * @model containment="true" lower="2" ordered="false"
	 * @generated
	 */
	EList<Feature> getChildren();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * (self.groupType = GroupTypes::OR or self.groupType = GroupTypes::XOR) implies self.children->forAll(c|c.isMandatory)
	 * 
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean XORorORImpliesChildrenAreMandatory(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.groupType = GroupTypes::ALL implies (self.min = -1 and self.max = -1)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean ALLImpliesCardinalitiesToBeMinusOne(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.groupType = GroupTypes::OR implies (self.min = 1  and self.max = -1)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean ORImpliesCardinalitiesMinToBeOneAndMaxToBeMinusOne(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.groupType = GroupTypes::XOR implies (self.min = 1 and self.max = 1)
	 * 
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean XORImpliesCardinalitiesToBeOne(DiagnosticChain diagnostics, Map<Object, Object> context);

} // FeatureGroup
