/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.uka.ipd.sdq.pcm.repository.ApplicationFailureType;
import de.uka.ipd.sdq.pcm.seff.FailureOccurrenceDescription;
import de.uka.ipd.sdq.pcm.seff.InternalAction;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Failure Occurrence Description</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.impl.FailureOccurrenceDescriptionImpl#getFailureProbability <em>Failure Probability</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.impl.FailureOccurrenceDescriptionImpl#getFailureType <em>Failure Type</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.impl.FailureOccurrenceDescriptionImpl#getFailureOccurenceDescriptions <em>Failure Occurence Descriptions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FailureOccurrenceDescriptionImpl extends EObjectImpl implements FailureOccurrenceDescription {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The default value of the '{@link #getFailureProbability() <em>Failure Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFailureProbability()
	 * @generated
	 * @ordered
	 */
	protected static final double FAILURE_PROBABILITY_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getFailureProbability() <em>Failure Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFailureProbability()
	 * @generated
	 * @ordered
	 */
	protected double failureProbability = FAILURE_PROBABILITY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFailureType() <em>Failure Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFailureType()
	 * @generated
	 * @ordered
	 */
	protected ApplicationFailureType failureType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FailureOccurrenceDescriptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SeffPackage.Literals.FAILURE_OCCURRENCE_DESCRIPTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getFailureProbability() {
		return failureProbability;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFailureProbability(double newFailureProbability) {
		double oldFailureProbability = failureProbability;
		failureProbability = newFailureProbability;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SeffPackage.FAILURE_OCCURRENCE_DESCRIPTION__FAILURE_PROBABILITY, oldFailureProbability, failureProbability));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApplicationFailureType getFailureType() {
		if (failureType != null && failureType.eIsProxy()) {
			InternalEObject oldFailureType = (InternalEObject)failureType;
			failureType = (ApplicationFailureType)eResolveProxy(oldFailureType);
			if (failureType != oldFailureType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SeffPackage.FAILURE_OCCURRENCE_DESCRIPTION__FAILURE_TYPE, oldFailureType, failureType));
			}
		}
		return failureType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApplicationFailureType basicGetFailureType() {
		return failureType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFailureType(ApplicationFailureType newFailureType) {
		ApplicationFailureType oldFailureType = failureType;
		failureType = newFailureType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SeffPackage.FAILURE_OCCURRENCE_DESCRIPTION__FAILURE_TYPE, oldFailureType, failureType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InternalAction getFailureOccurenceDescriptions() {
		if (eContainerFeatureID() != SeffPackage.FAILURE_OCCURRENCE_DESCRIPTION__FAILURE_OCCURENCE_DESCRIPTIONS) return null;
		return (InternalAction)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFailureOccurenceDescriptions(InternalAction newFailureOccurenceDescriptions, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newFailureOccurenceDescriptions, SeffPackage.FAILURE_OCCURRENCE_DESCRIPTION__FAILURE_OCCURENCE_DESCRIPTIONS, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFailureOccurenceDescriptions(InternalAction newFailureOccurenceDescriptions) {
		if (newFailureOccurenceDescriptions != eInternalContainer() || (eContainerFeatureID() != SeffPackage.FAILURE_OCCURRENCE_DESCRIPTION__FAILURE_OCCURENCE_DESCRIPTIONS && newFailureOccurenceDescriptions != null)) {
			if (EcoreUtil.isAncestor(this, newFailureOccurenceDescriptions))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newFailureOccurenceDescriptions != null)
				msgs = ((InternalEObject)newFailureOccurenceDescriptions).eInverseAdd(this, SeffPackage.INTERNAL_ACTION__FAILURE_OCCURRENCE_DESCRIPTIONS, InternalAction.class, msgs);
			msgs = basicSetFailureOccurenceDescriptions(newFailureOccurenceDescriptions, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SeffPackage.FAILURE_OCCURRENCE_DESCRIPTION__FAILURE_OCCURENCE_DESCRIPTIONS, newFailureOccurenceDescriptions, newFailureOccurenceDescriptions));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SeffPackage.FAILURE_OCCURRENCE_DESCRIPTION__FAILURE_OCCURENCE_DESCRIPTIONS:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetFailureOccurenceDescriptions((InternalAction)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SeffPackage.FAILURE_OCCURRENCE_DESCRIPTION__FAILURE_OCCURENCE_DESCRIPTIONS:
				return basicSetFailureOccurenceDescriptions(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case SeffPackage.FAILURE_OCCURRENCE_DESCRIPTION__FAILURE_OCCURENCE_DESCRIPTIONS:
				return eInternalContainer().eInverseRemove(this, SeffPackage.INTERNAL_ACTION__FAILURE_OCCURRENCE_DESCRIPTIONS, InternalAction.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SeffPackage.FAILURE_OCCURRENCE_DESCRIPTION__FAILURE_PROBABILITY:
				return getFailureProbability();
			case SeffPackage.FAILURE_OCCURRENCE_DESCRIPTION__FAILURE_TYPE:
				if (resolve) return getFailureType();
				return basicGetFailureType();
			case SeffPackage.FAILURE_OCCURRENCE_DESCRIPTION__FAILURE_OCCURENCE_DESCRIPTIONS:
				return getFailureOccurenceDescriptions();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SeffPackage.FAILURE_OCCURRENCE_DESCRIPTION__FAILURE_PROBABILITY:
				setFailureProbability((Double)newValue);
				return;
			case SeffPackage.FAILURE_OCCURRENCE_DESCRIPTION__FAILURE_TYPE:
				setFailureType((ApplicationFailureType)newValue);
				return;
			case SeffPackage.FAILURE_OCCURRENCE_DESCRIPTION__FAILURE_OCCURENCE_DESCRIPTIONS:
				setFailureOccurenceDescriptions((InternalAction)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SeffPackage.FAILURE_OCCURRENCE_DESCRIPTION__FAILURE_PROBABILITY:
				setFailureProbability(FAILURE_PROBABILITY_EDEFAULT);
				return;
			case SeffPackage.FAILURE_OCCURRENCE_DESCRIPTION__FAILURE_TYPE:
				setFailureType((ApplicationFailureType)null);
				return;
			case SeffPackage.FAILURE_OCCURRENCE_DESCRIPTION__FAILURE_OCCURENCE_DESCRIPTIONS:
				setFailureOccurenceDescriptions((InternalAction)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SeffPackage.FAILURE_OCCURRENCE_DESCRIPTION__FAILURE_PROBABILITY:
				return failureProbability != FAILURE_PROBABILITY_EDEFAULT;
			case SeffPackage.FAILURE_OCCURRENCE_DESCRIPTION__FAILURE_TYPE:
				return failureType != null;
			case SeffPackage.FAILURE_OCCURRENCE_DESCRIPTION__FAILURE_OCCURENCE_DESCRIPTIONS:
				return getFailureOccurenceDescriptions() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (failureProbability: ");
		result.append(failureProbability);
		result.append(')');
		return result.toString();
	}

} //FailureOccurrenceDescriptionImpl
