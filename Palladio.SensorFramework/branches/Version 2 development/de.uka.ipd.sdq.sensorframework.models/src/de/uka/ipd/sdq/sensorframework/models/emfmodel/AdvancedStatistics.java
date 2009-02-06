/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensorframework.models.emfmodel;

import javax.measure.Measure;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Advanced Statistics</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.AdvancedStatistics#getMedian <em>Median</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.AdvancedStatistics#getVariance <em>Variance</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.AdvancedStatistics#getStandardDeviation <em>Standard Deviation</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.sensorframework.models.emfmodel.emfmodelPackage#getAdvancedStatistics()
 * @model
 * @generated
 */
public interface AdvancedStatistics extends Statistics {
	/**
	 * Returns the value of the '<em><b>Median</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Median</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Median</em>' attribute.
	 * @see #setMedian(Measure)
	 * @see de.uka.ipd.sdq.sensorframework.models.emfmodel.emfmodelPackage#getAdvancedStatistics_Median()
	 * @model dataType="de.uka.ipd.sdq.sensorframework.models.emfmodel.EJSMeasure" required="true" ordered="false"
	 * @generated
	 */
	Measure getMedian();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.AdvancedStatistics#getMedian <em>Median</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Median</em>' attribute.
	 * @see #getMedian()
	 * @generated
	 */
	void setMedian(Measure value);

	/**
	 * Returns the value of the '<em><b>Variance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variance</em>' attribute.
	 * @see #setVariance(double)
	 * @see de.uka.ipd.sdq.sensorframework.models.emfmodel.emfmodelPackage#getAdvancedStatistics_Variance()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	double getVariance();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.AdvancedStatistics#getVariance <em>Variance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variance</em>' attribute.
	 * @see #getVariance()
	 * @generated
	 */
	void setVariance(double value);

	/**
	 * Returns the value of the '<em><b>Standard Deviation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Standard Deviation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Standard Deviation</em>' attribute.
	 * @see #setStandardDeviation(double)
	 * @see de.uka.ipd.sdq.sensorframework.models.emfmodel.emfmodelPackage#getAdvancedStatistics_StandardDeviation()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	double getStandardDeviation();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.sensorframework.models.emfmodel.AdvancedStatistics#getStandardDeviation <em>Standard Deviation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Standard Deviation</em>' attribute.
	 * @see #getStandardDeviation()
	 * @generated
	 */
	void setStandardDeviation(double value);

} // AdvancedStatistics
