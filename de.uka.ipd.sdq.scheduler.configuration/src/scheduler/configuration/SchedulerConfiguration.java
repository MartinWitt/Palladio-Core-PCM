/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scheduler.configuration;

import de.uka.ipd.sdq.identifier.Identifier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scheduler Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link scheduler.configuration.SchedulerConfiguration#getPriorityConfiguration <em>Priority Configuration</em>}</li>
 *   <li>{@link scheduler.configuration.SchedulerConfiguration#getPreemptionConfiguration <em>Preemption Configuration</em>}</li>
 *   <li>{@link scheduler.configuration.SchedulerConfiguration#getName <em>Name</em>}</li>
 *   <li>{@link scheduler.configuration.SchedulerConfiguration#getQueueingConfiguration <em>Queueing Configuration</em>}</li>
 *   <li>{@link scheduler.configuration.SchedulerConfiguration#isInFrontAfterWaiting <em>In Front After Waiting</em>}</li>
 *   <li>{@link scheduler.configuration.SchedulerConfiguration#getInterval <em>Interval</em>}</li>
 * </ul>
 * </p>
 *
 * @see scheduler.configuration.ConfigurationPackage#getSchedulerConfiguration()
 * @model
 * @generated
 */
public interface SchedulerConfiguration extends Identifier {
	/**
	 * Returns the value of the '<em><b>Priority Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Priority Configuration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Priority Configuration</em>' containment reference.
	 * @see #setPriorityConfiguration(PriorityConfiguration)
	 * @see scheduler.configuration.ConfigurationPackage#getSchedulerConfiguration_PriorityConfiguration()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	PriorityConfiguration getPriorityConfiguration();

	/**
	 * Sets the value of the '{@link scheduler.configuration.SchedulerConfiguration#getPriorityConfiguration <em>Priority Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Priority Configuration</em>' containment reference.
	 * @see #getPriorityConfiguration()
	 * @generated
	 */
	void setPriorityConfiguration(PriorityConfiguration value);

	/**
	 * Returns the value of the '<em><b>Preemption Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Preemption Configuration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Preemption Configuration</em>' containment reference.
	 * @see #setPreemptionConfiguration(PreemptionConfiguration)
	 * @see scheduler.configuration.ConfigurationPackage#getSchedulerConfiguration_PreemptionConfiguration()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	PreemptionConfiguration getPreemptionConfiguration();

	/**
	 * Sets the value of the '{@link scheduler.configuration.SchedulerConfiguration#getPreemptionConfiguration <em>Preemption Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Preemption Configuration</em>' containment reference.
	 * @see #getPreemptionConfiguration()
	 * @generated
	 */
	void setPreemptionConfiguration(PreemptionConfiguration value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see scheduler.configuration.ConfigurationPackage#getSchedulerConfiguration_Name()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link scheduler.configuration.SchedulerConfiguration#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Queueing Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Queueing Configuration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Queueing Configuration</em>' containment reference.
	 * @see #setQueueingConfiguration(QueueingConfiguration)
	 * @see scheduler.configuration.ConfigurationPackage#getSchedulerConfiguration_QueueingConfiguration()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	QueueingConfiguration getQueueingConfiguration();

	/**
	 * Sets the value of the '{@link scheduler.configuration.SchedulerConfiguration#getQueueingConfiguration <em>Queueing Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Queueing Configuration</em>' containment reference.
	 * @see #getQueueingConfiguration()
	 * @generated
	 */
	void setQueueingConfiguration(QueueingConfiguration value);

	/**
	 * Returns the value of the '<em><b>In Front After Waiting</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Front After Waiting</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Front After Waiting</em>' attribute.
	 * @see #setInFrontAfterWaiting(boolean)
	 * @see scheduler.configuration.ConfigurationPackage#getSchedulerConfiguration_InFrontAfterWaiting()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	boolean isInFrontAfterWaiting();

	/**
	 * Sets the value of the '{@link scheduler.configuration.SchedulerConfiguration#isInFrontAfterWaiting <em>In Front After Waiting</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>In Front After Waiting</em>' attribute.
	 * @see #isInFrontAfterWaiting()
	 * @generated
	 */
	void setInFrontAfterWaiting(boolean value);

	/**
	 * Returns the value of the '<em><b>Interval</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interval</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interval</em>' containment reference.
	 * @see #setInterval(TimeValue)
	 * @see scheduler.configuration.ConfigurationPackage#getSchedulerConfiguration_Interval()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	TimeValue getInterval();

	/**
	 * Sets the value of the '{@link scheduler.configuration.SchedulerConfiguration#getInterval <em>Interval</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interval</em>' containment reference.
	 * @see #getInterval()
	 * @generated
	 */
	void setInterval(TimeValue value);

} // SchedulerConfiguration