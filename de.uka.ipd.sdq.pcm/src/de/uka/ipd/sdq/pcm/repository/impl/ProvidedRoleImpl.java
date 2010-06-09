/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
import de.uka.ipd.sdq.pcm.core.entity.InterfaceProvidingEntity;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Provided Role</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.ProvidedRoleImpl#getProvidingEntity__ProvidedRole <em>Providing Entity Provided Role</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ProvidedRoleImpl extends RoleImpl implements ProvidedRole {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProvidedRoleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RepositoryPackage.Literals.PROVIDED_ROLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InterfaceProvidingEntity getProvidingEntity__ProvidedRole() {
		if (eContainerFeatureID() != RepositoryPackage.PROVIDED_ROLE__PROVIDING_ENTITY_PROVIDED_ROLE) return null;
		return (InterfaceProvidingEntity)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProvidingEntity__ProvidedRole(InterfaceProvidingEntity newProvidingEntity__ProvidedRole, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newProvidingEntity__ProvidedRole, RepositoryPackage.PROVIDED_ROLE__PROVIDING_ENTITY_PROVIDED_ROLE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProvidingEntity__ProvidedRole(InterfaceProvidingEntity newProvidingEntity__ProvidedRole) {
		if (newProvidingEntity__ProvidedRole != eInternalContainer() || (eContainerFeatureID() != RepositoryPackage.PROVIDED_ROLE__PROVIDING_ENTITY_PROVIDED_ROLE && newProvidingEntity__ProvidedRole != null)) {
			if (EcoreUtil.isAncestor(this, newProvidingEntity__ProvidedRole))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newProvidingEntity__ProvidedRole != null)
				msgs = ((InternalEObject)newProvidingEntity__ProvidedRole).eInverseAdd(this, EntityPackage.INTERFACE_PROVIDING_ENTITY__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY, InterfaceProvidingEntity.class, msgs);
			msgs = basicSetProvidingEntity__ProvidedRole(newProvidingEntity__ProvidedRole, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.PROVIDED_ROLE__PROVIDING_ENTITY_PROVIDED_ROLE, newProvidingEntity__ProvidedRole, newProvidingEntity__ProvidedRole));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RepositoryPackage.PROVIDED_ROLE__PROVIDING_ENTITY_PROVIDED_ROLE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetProvidingEntity__ProvidedRole((InterfaceProvidingEntity)otherEnd, msgs);
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
			case RepositoryPackage.PROVIDED_ROLE__PROVIDING_ENTITY_PROVIDED_ROLE:
				return basicSetProvidingEntity__ProvidedRole(null, msgs);
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
			case RepositoryPackage.PROVIDED_ROLE__PROVIDING_ENTITY_PROVIDED_ROLE:
				return eInternalContainer().eInverseRemove(this, EntityPackage.INTERFACE_PROVIDING_ENTITY__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY, InterfaceProvidingEntity.class, msgs);
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
			case RepositoryPackage.PROVIDED_ROLE__PROVIDING_ENTITY_PROVIDED_ROLE:
				return getProvidingEntity__ProvidedRole();
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
			case RepositoryPackage.PROVIDED_ROLE__PROVIDING_ENTITY_PROVIDED_ROLE:
				setProvidingEntity__ProvidedRole((InterfaceProvidingEntity)newValue);
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
			case RepositoryPackage.PROVIDED_ROLE__PROVIDING_ENTITY_PROVIDED_ROLE:
				setProvidingEntity__ProvidedRole((InterfaceProvidingEntity)null);
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
			case RepositoryPackage.PROVIDED_ROLE__PROVIDING_ENTITY_PROVIDED_ROLE:
				return getProvidingEntity__ProvidedRole() != null;
		}
		return super.eIsSet(featureID);
	}

} //ProvidedRoleImpl
