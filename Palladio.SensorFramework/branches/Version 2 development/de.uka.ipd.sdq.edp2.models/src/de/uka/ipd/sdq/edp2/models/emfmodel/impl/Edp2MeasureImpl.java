/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.emfmodel.impl;

import de.uka.ipd.sdq.edp2.models.emfmodel.Edp2Measure;
import de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage;
import de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentGroup;
import de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentSetting;
import de.uka.ipd.sdq.edp2.models.emfmodel.MetricDescription;
import de.uka.ipd.sdq.edp2.models.emfmodel.PersistenceKindOptions;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Edp2 Measure</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.Edp2MeasureImpl#getExperimentGroup <em>Experiment Group</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.Edp2MeasureImpl#getExperimentSettings <em>Experiment Settings</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.Edp2MeasureImpl#getPersistencyKind <em>Persistency Kind</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.Edp2MeasureImpl#getMeasuredObject <em>Measured Object</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.Edp2MeasureImpl#getMetric <em>Metric</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class Edp2MeasureImpl extends EObjectImpl implements Edp2Measure {
	/**
	 * The cached value of the '{@link #getExperimentSettings() <em>Experiment Settings</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExperimentSettings()
	 * @generated
	 * @ordered
	 */
	protected EList<ExperimentSetting> experimentSettings;

	/**
	 * The default value of the '{@link #getPersistencyKind() <em>Persistency Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPersistencyKind()
	 * @generated
	 * @ordered
	 */
	protected static final PersistenceKindOptions PERSISTENCY_KIND_EDEFAULT = PersistenceKindOptions.BINARY_PREFERRED;

	/**
	 * The cached value of the '{@link #getPersistencyKind() <em>Persistency Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPersistencyKind()
	 * @generated
	 * @ordered
	 */
	protected PersistenceKindOptions persistencyKind = PERSISTENCY_KIND_EDEFAULT;

	/**
	 * The default value of the '{@link #getMeasuredObject() <em>Measured Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeasuredObject()
	 * @generated
	 * @ordered
	 */
	protected static final String MEASURED_OBJECT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMeasuredObject() <em>Measured Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeasuredObject()
	 * @generated
	 * @ordered
	 */
	protected String measuredObject = MEASURED_OBJECT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMetric() <em>Metric</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetric()
	 * @generated
	 * @ordered
	 */
	protected MetricDescription metric;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Edp2MeasureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfmodelPackage.Literals.EDP2_MEASURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExperimentGroup getExperimentGroup() {
		if (eContainerFeatureID() != EmfmodelPackage.EDP2_MEASURE__EXPERIMENT_GROUP) return null;
		return (ExperimentGroup)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExperimentGroup(ExperimentGroup newExperimentGroup, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newExperimentGroup, EmfmodelPackage.EDP2_MEASURE__EXPERIMENT_GROUP, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExperimentGroup(ExperimentGroup newExperimentGroup) {
		if (newExperimentGroup != eInternalContainer() || (eContainerFeatureID() != EmfmodelPackage.EDP2_MEASURE__EXPERIMENT_GROUP && newExperimentGroup != null)) {
			if (EcoreUtil.isAncestor(this, newExperimentGroup))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newExperimentGroup != null)
				msgs = ((InternalEObject)newExperimentGroup).eInverseAdd(this, EmfmodelPackage.EXPERIMENT_GROUP__MEASURE, ExperimentGroup.class, msgs);
			msgs = basicSetExperimentGroup(newExperimentGroup, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfmodelPackage.EDP2_MEASURE__EXPERIMENT_GROUP, newExperimentGroup, newExperimentGroup));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExperimentSetting> getExperimentSettings() {
		if (experimentSettings == null) {
			experimentSettings = new EObjectWithInverseResolvingEList.ManyInverse<ExperimentSetting>(ExperimentSetting.class, this, EmfmodelPackage.EDP2_MEASURE__EXPERIMENT_SETTINGS, EmfmodelPackage.EXPERIMENT_SETTING__MEASURE);
		}
		return experimentSettings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PersistenceKindOptions getPersistencyKind() {
		return persistencyKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPersistencyKind(PersistenceKindOptions newPersistencyKind) {
		PersistenceKindOptions oldPersistencyKind = persistencyKind;
		persistencyKind = newPersistencyKind == null ? PERSISTENCY_KIND_EDEFAULT : newPersistencyKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfmodelPackage.EDP2_MEASURE__PERSISTENCY_KIND, oldPersistencyKind, persistencyKind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMeasuredObject() {
		return measuredObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMeasuredObject(String newMeasuredObject) {
		String oldMeasuredObject = measuredObject;
		measuredObject = newMeasuredObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfmodelPackage.EDP2_MEASURE__MEASURED_OBJECT, oldMeasuredObject, measuredObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetricDescription getMetric() {
		if (metric != null && metric.eIsProxy()) {
			InternalEObject oldMetric = (InternalEObject)metric;
			metric = (MetricDescription)eResolveProxy(oldMetric);
			if (metric != oldMetric) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmfmodelPackage.EDP2_MEASURE__METRIC, oldMetric, metric));
			}
		}
		return metric;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetricDescription basicGetMetric() {
		return metric;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetric(MetricDescription newMetric) {
		MetricDescription oldMetric = metric;
		metric = newMetric;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfmodelPackage.EDP2_MEASURE__METRIC, oldMetric, metric));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EmfmodelPackage.EDP2_MEASURE__EXPERIMENT_GROUP:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetExperimentGroup((ExperimentGroup)otherEnd, msgs);
			case EmfmodelPackage.EDP2_MEASURE__EXPERIMENT_SETTINGS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getExperimentSettings()).basicAdd(otherEnd, msgs);
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
			case EmfmodelPackage.EDP2_MEASURE__EXPERIMENT_GROUP:
				return basicSetExperimentGroup(null, msgs);
			case EmfmodelPackage.EDP2_MEASURE__EXPERIMENT_SETTINGS:
				return ((InternalEList<?>)getExperimentSettings()).basicRemove(otherEnd, msgs);
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
			case EmfmodelPackage.EDP2_MEASURE__EXPERIMENT_GROUP:
				return eInternalContainer().eInverseRemove(this, EmfmodelPackage.EXPERIMENT_GROUP__MEASURE, ExperimentGroup.class, msgs);
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
			case EmfmodelPackage.EDP2_MEASURE__EXPERIMENT_GROUP:
				return getExperimentGroup();
			case EmfmodelPackage.EDP2_MEASURE__EXPERIMENT_SETTINGS:
				return getExperimentSettings();
			case EmfmodelPackage.EDP2_MEASURE__PERSISTENCY_KIND:
				return getPersistencyKind();
			case EmfmodelPackage.EDP2_MEASURE__MEASURED_OBJECT:
				return getMeasuredObject();
			case EmfmodelPackage.EDP2_MEASURE__METRIC:
				if (resolve) return getMetric();
				return basicGetMetric();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EmfmodelPackage.EDP2_MEASURE__EXPERIMENT_GROUP:
				setExperimentGroup((ExperimentGroup)newValue);
				return;
			case EmfmodelPackage.EDP2_MEASURE__EXPERIMENT_SETTINGS:
				getExperimentSettings().clear();
				getExperimentSettings().addAll((Collection<? extends ExperimentSetting>)newValue);
				return;
			case EmfmodelPackage.EDP2_MEASURE__PERSISTENCY_KIND:
				setPersistencyKind((PersistenceKindOptions)newValue);
				return;
			case EmfmodelPackage.EDP2_MEASURE__MEASURED_OBJECT:
				setMeasuredObject((String)newValue);
				return;
			case EmfmodelPackage.EDP2_MEASURE__METRIC:
				setMetric((MetricDescription)newValue);
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
			case EmfmodelPackage.EDP2_MEASURE__EXPERIMENT_GROUP:
				setExperimentGroup((ExperimentGroup)null);
				return;
			case EmfmodelPackage.EDP2_MEASURE__EXPERIMENT_SETTINGS:
				getExperimentSettings().clear();
				return;
			case EmfmodelPackage.EDP2_MEASURE__PERSISTENCY_KIND:
				setPersistencyKind(PERSISTENCY_KIND_EDEFAULT);
				return;
			case EmfmodelPackage.EDP2_MEASURE__MEASURED_OBJECT:
				setMeasuredObject(MEASURED_OBJECT_EDEFAULT);
				return;
			case EmfmodelPackage.EDP2_MEASURE__METRIC:
				setMetric((MetricDescription)null);
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
			case EmfmodelPackage.EDP2_MEASURE__EXPERIMENT_GROUP:
				return getExperimentGroup() != null;
			case EmfmodelPackage.EDP2_MEASURE__EXPERIMENT_SETTINGS:
				return experimentSettings != null && !experimentSettings.isEmpty();
			case EmfmodelPackage.EDP2_MEASURE__PERSISTENCY_KIND:
				return persistencyKind != PERSISTENCY_KIND_EDEFAULT;
			case EmfmodelPackage.EDP2_MEASURE__MEASURED_OBJECT:
				return MEASURED_OBJECT_EDEFAULT == null ? measuredObject != null : !MEASURED_OBJECT_EDEFAULT.equals(measuredObject);
			case EmfmodelPackage.EDP2_MEASURE__METRIC:
				return metric != null;
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
		result.append(" (persistencyKind: ");
		result.append(persistencyKind);
		result.append(", measuredObject: ");
		result.append(measuredObject);
		result.append(')');
		return result.toString();
	}

} //Edp2MeasureImpl