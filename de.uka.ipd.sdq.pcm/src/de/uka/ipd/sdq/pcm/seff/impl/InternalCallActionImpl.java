/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.impl;

import de.uka.ipd.sdq.identifier.Identifier;
import de.uka.ipd.sdq.identifier.IdentifierPackage;

import de.uka.ipd.sdq.identifier.util.IdentifierValidator;

import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
import de.uka.ipd.sdq.pcm.core.entity.NamedElement;

import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.AbstractInternalControlFlowAction;
import de.uka.ipd.sdq.pcm.seff.InternalCallAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingInternalBehaviour;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;

import de.uka.ipd.sdq.pcm.seff.performance.ParametricResourceDemand;
import de.uka.ipd.sdq.pcm.seff.performance.PerformancePackage;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Internal Call Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.impl.InternalCallActionImpl#getId <em>Id</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.impl.InternalCallActionImpl#getEntityName <em>Entity Name</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.impl.InternalCallActionImpl#getPredecessor_AbstractAction <em>Predecessor Abstract Action</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.impl.InternalCallActionImpl#getSuccessor_AbstractAction <em>Successor Abstract Action</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.impl.InternalCallActionImpl#getResourceDemand_Action <em>Resource Demand Action</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.impl.InternalCallActionImpl#getCalledResourceDemandingInternalBehaviour <em>Called Resource Demanding Internal Behaviour</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InternalCallActionImpl extends CallActionImpl implements InternalCallAction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getEntityName() <em>Entity Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntityName()
	 * @generated
	 * @ordered
	 */
	protected static final String ENTITY_NAME_EDEFAULT = "aName";

	/**
	 * The cached value of the '{@link #getEntityName() <em>Entity Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntityName()
	 * @generated
	 * @ordered
	 */
	protected String entityName = ENTITY_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPredecessor_AbstractAction() <em>Predecessor Abstract Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPredecessor_AbstractAction()
	 * @generated
	 * @ordered
	 */
	protected AbstractAction predecessor_AbstractAction;

	/**
	 * The cached value of the '{@link #getSuccessor_AbstractAction() <em>Successor Abstract Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuccessor_AbstractAction()
	 * @generated
	 * @ordered
	 */
	protected AbstractAction successor_AbstractAction;

	/**
	 * The cached value of the '{@link #getResourceDemand_Action() <em>Resource Demand Action</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceDemand_Action()
	 * @generated
	 * @ordered
	 */
	protected EList<ParametricResourceDemand> resourceDemand_Action;

	/**
	 * The cached value of the '{@link #getCalledResourceDemandingInternalBehaviour() <em>Called Resource Demanding Internal Behaviour</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCalledResourceDemandingInternalBehaviour()
	 * @generated
	 * @ordered
	 */
	protected ResourceDemandingInternalBehaviour calledResourceDemandingInternalBehaviour;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InternalCallActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SeffPackage.Literals.INTERNAL_CALL_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SeffPackage.INTERNAL_CALL_ACTION__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEntityName() {
		return entityName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEntityName(String newEntityName) {
		String oldEntityName = entityName;
		entityName = newEntityName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SeffPackage.INTERNAL_CALL_ACTION__ENTITY_NAME, oldEntityName, entityName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractAction getPredecessor_AbstractAction() {
		if (predecessor_AbstractAction != null && predecessor_AbstractAction.eIsProxy()) {
			InternalEObject oldPredecessor_AbstractAction = (InternalEObject)predecessor_AbstractAction;
			predecessor_AbstractAction = (AbstractAction)eResolveProxy(oldPredecessor_AbstractAction);
			if (predecessor_AbstractAction != oldPredecessor_AbstractAction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SeffPackage.INTERNAL_CALL_ACTION__PREDECESSOR_ABSTRACT_ACTION, oldPredecessor_AbstractAction, predecessor_AbstractAction));
			}
		}
		return predecessor_AbstractAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractAction basicGetPredecessor_AbstractAction() {
		return predecessor_AbstractAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPredecessor_AbstractAction(AbstractAction newPredecessor_AbstractAction, NotificationChain msgs) {
		AbstractAction oldPredecessor_AbstractAction = predecessor_AbstractAction;
		predecessor_AbstractAction = newPredecessor_AbstractAction;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SeffPackage.INTERNAL_CALL_ACTION__PREDECESSOR_ABSTRACT_ACTION, oldPredecessor_AbstractAction, newPredecessor_AbstractAction);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPredecessor_AbstractAction(AbstractAction newPredecessor_AbstractAction) {
		if (newPredecessor_AbstractAction != predecessor_AbstractAction) {
			NotificationChain msgs = null;
			if (predecessor_AbstractAction != null)
				msgs = ((InternalEObject)predecessor_AbstractAction).eInverseRemove(this, SeffPackage.ABSTRACT_ACTION__SUCCESSOR_ABSTRACT_ACTION, AbstractAction.class, msgs);
			if (newPredecessor_AbstractAction != null)
				msgs = ((InternalEObject)newPredecessor_AbstractAction).eInverseAdd(this, SeffPackage.ABSTRACT_ACTION__SUCCESSOR_ABSTRACT_ACTION, AbstractAction.class, msgs);
			msgs = basicSetPredecessor_AbstractAction(newPredecessor_AbstractAction, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SeffPackage.INTERNAL_CALL_ACTION__PREDECESSOR_ABSTRACT_ACTION, newPredecessor_AbstractAction, newPredecessor_AbstractAction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractAction getSuccessor_AbstractAction() {
		if (successor_AbstractAction != null && successor_AbstractAction.eIsProxy()) {
			InternalEObject oldSuccessor_AbstractAction = (InternalEObject)successor_AbstractAction;
			successor_AbstractAction = (AbstractAction)eResolveProxy(oldSuccessor_AbstractAction);
			if (successor_AbstractAction != oldSuccessor_AbstractAction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SeffPackage.INTERNAL_CALL_ACTION__SUCCESSOR_ABSTRACT_ACTION, oldSuccessor_AbstractAction, successor_AbstractAction));
			}
		}
		return successor_AbstractAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractAction basicGetSuccessor_AbstractAction() {
		return successor_AbstractAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSuccessor_AbstractAction(AbstractAction newSuccessor_AbstractAction, NotificationChain msgs) {
		AbstractAction oldSuccessor_AbstractAction = successor_AbstractAction;
		successor_AbstractAction = newSuccessor_AbstractAction;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SeffPackage.INTERNAL_CALL_ACTION__SUCCESSOR_ABSTRACT_ACTION, oldSuccessor_AbstractAction, newSuccessor_AbstractAction);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuccessor_AbstractAction(AbstractAction newSuccessor_AbstractAction) {
		if (newSuccessor_AbstractAction != successor_AbstractAction) {
			NotificationChain msgs = null;
			if (successor_AbstractAction != null)
				msgs = ((InternalEObject)successor_AbstractAction).eInverseRemove(this, SeffPackage.ABSTRACT_ACTION__PREDECESSOR_ABSTRACT_ACTION, AbstractAction.class, msgs);
			if (newSuccessor_AbstractAction != null)
				msgs = ((InternalEObject)newSuccessor_AbstractAction).eInverseAdd(this, SeffPackage.ABSTRACT_ACTION__PREDECESSOR_ABSTRACT_ACTION, AbstractAction.class, msgs);
			msgs = basicSetSuccessor_AbstractAction(newSuccessor_AbstractAction, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SeffPackage.INTERNAL_CALL_ACTION__SUCCESSOR_ABSTRACT_ACTION, newSuccessor_AbstractAction, newSuccessor_AbstractAction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParametricResourceDemand> getResourceDemand_Action() {
		if (resourceDemand_Action == null) {
			resourceDemand_Action = new EObjectContainmentWithInverseEList<ParametricResourceDemand>(ParametricResourceDemand.class, this, SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_DEMAND_ACTION, PerformancePackage.PARAMETRIC_RESOURCE_DEMAND__ACTION_PARAMETRIC_RESOURCE_DEMAND);
		}
		return resourceDemand_Action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceDemandingInternalBehaviour getCalledResourceDemandingInternalBehaviour() {
		if (calledResourceDemandingInternalBehaviour != null && calledResourceDemandingInternalBehaviour.eIsProxy()) {
			InternalEObject oldCalledResourceDemandingInternalBehaviour = (InternalEObject)calledResourceDemandingInternalBehaviour;
			calledResourceDemandingInternalBehaviour = (ResourceDemandingInternalBehaviour)eResolveProxy(oldCalledResourceDemandingInternalBehaviour);
			if (calledResourceDemandingInternalBehaviour != oldCalledResourceDemandingInternalBehaviour) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SeffPackage.INTERNAL_CALL_ACTION__CALLED_RESOURCE_DEMANDING_INTERNAL_BEHAVIOUR, oldCalledResourceDemandingInternalBehaviour, calledResourceDemandingInternalBehaviour));
			}
		}
		return calledResourceDemandingInternalBehaviour;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceDemandingInternalBehaviour basicGetCalledResourceDemandingInternalBehaviour() {
		return calledResourceDemandingInternalBehaviour;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCalledResourceDemandingInternalBehaviour(ResourceDemandingInternalBehaviour newCalledResourceDemandingInternalBehaviour) {
		ResourceDemandingInternalBehaviour oldCalledResourceDemandingInternalBehaviour = calledResourceDemandingInternalBehaviour;
		calledResourceDemandingInternalBehaviour = newCalledResourceDemandingInternalBehaviour;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SeffPackage.INTERNAL_CALL_ACTION__CALLED_RESOURCE_DEMANDING_INTERNAL_BEHAVIOUR, oldCalledResourceDemandingInternalBehaviour, calledResourceDemandingInternalBehaviour));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean idHasToBeUnique(DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 IdentifierValidator.DIAGNOSTIC_SOURCE,
						 IdentifierValidator.IDENTIFIER__ID_HAS_TO_BE_UNIQUE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "idHasToBeUnique", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
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
			case SeffPackage.INTERNAL_CALL_ACTION__PREDECESSOR_ABSTRACT_ACTION:
				if (predecessor_AbstractAction != null)
					msgs = ((InternalEObject)predecessor_AbstractAction).eInverseRemove(this, SeffPackage.ABSTRACT_ACTION__SUCCESSOR_ABSTRACT_ACTION, AbstractAction.class, msgs);
				return basicSetPredecessor_AbstractAction((AbstractAction)otherEnd, msgs);
			case SeffPackage.INTERNAL_CALL_ACTION__SUCCESSOR_ABSTRACT_ACTION:
				if (successor_AbstractAction != null)
					msgs = ((InternalEObject)successor_AbstractAction).eInverseRemove(this, SeffPackage.ABSTRACT_ACTION__PREDECESSOR_ABSTRACT_ACTION, AbstractAction.class, msgs);
				return basicSetSuccessor_AbstractAction((AbstractAction)otherEnd, msgs);
			case SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_DEMAND_ACTION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getResourceDemand_Action()).basicAdd(otherEnd, msgs);
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
			case SeffPackage.INTERNAL_CALL_ACTION__PREDECESSOR_ABSTRACT_ACTION:
				return basicSetPredecessor_AbstractAction(null, msgs);
			case SeffPackage.INTERNAL_CALL_ACTION__SUCCESSOR_ABSTRACT_ACTION:
				return basicSetSuccessor_AbstractAction(null, msgs);
			case SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_DEMAND_ACTION:
				return ((InternalEList<?>)getResourceDemand_Action()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SeffPackage.INTERNAL_CALL_ACTION__ID:
				return getId();
			case SeffPackage.INTERNAL_CALL_ACTION__ENTITY_NAME:
				return getEntityName();
			case SeffPackage.INTERNAL_CALL_ACTION__PREDECESSOR_ABSTRACT_ACTION:
				if (resolve) return getPredecessor_AbstractAction();
				return basicGetPredecessor_AbstractAction();
			case SeffPackage.INTERNAL_CALL_ACTION__SUCCESSOR_ABSTRACT_ACTION:
				if (resolve) return getSuccessor_AbstractAction();
				return basicGetSuccessor_AbstractAction();
			case SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_DEMAND_ACTION:
				return getResourceDemand_Action();
			case SeffPackage.INTERNAL_CALL_ACTION__CALLED_RESOURCE_DEMANDING_INTERNAL_BEHAVIOUR:
				if (resolve) return getCalledResourceDemandingInternalBehaviour();
				return basicGetCalledResourceDemandingInternalBehaviour();
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
			case SeffPackage.INTERNAL_CALL_ACTION__ID:
				setId((String)newValue);
				return;
			case SeffPackage.INTERNAL_CALL_ACTION__ENTITY_NAME:
				setEntityName((String)newValue);
				return;
			case SeffPackage.INTERNAL_CALL_ACTION__PREDECESSOR_ABSTRACT_ACTION:
				setPredecessor_AbstractAction((AbstractAction)newValue);
				return;
			case SeffPackage.INTERNAL_CALL_ACTION__SUCCESSOR_ABSTRACT_ACTION:
				setSuccessor_AbstractAction((AbstractAction)newValue);
				return;
			case SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_DEMAND_ACTION:
				getResourceDemand_Action().clear();
				getResourceDemand_Action().addAll((Collection<? extends ParametricResourceDemand>)newValue);
				return;
			case SeffPackage.INTERNAL_CALL_ACTION__CALLED_RESOURCE_DEMANDING_INTERNAL_BEHAVIOUR:
				setCalledResourceDemandingInternalBehaviour((ResourceDemandingInternalBehaviour)newValue);
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
			case SeffPackage.INTERNAL_CALL_ACTION__ID:
				setId(ID_EDEFAULT);
				return;
			case SeffPackage.INTERNAL_CALL_ACTION__ENTITY_NAME:
				setEntityName(ENTITY_NAME_EDEFAULT);
				return;
			case SeffPackage.INTERNAL_CALL_ACTION__PREDECESSOR_ABSTRACT_ACTION:
				setPredecessor_AbstractAction((AbstractAction)null);
				return;
			case SeffPackage.INTERNAL_CALL_ACTION__SUCCESSOR_ABSTRACT_ACTION:
				setSuccessor_AbstractAction((AbstractAction)null);
				return;
			case SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_DEMAND_ACTION:
				getResourceDemand_Action().clear();
				return;
			case SeffPackage.INTERNAL_CALL_ACTION__CALLED_RESOURCE_DEMANDING_INTERNAL_BEHAVIOUR:
				setCalledResourceDemandingInternalBehaviour((ResourceDemandingInternalBehaviour)null);
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
			case SeffPackage.INTERNAL_CALL_ACTION__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case SeffPackage.INTERNAL_CALL_ACTION__ENTITY_NAME:
				return ENTITY_NAME_EDEFAULT == null ? entityName != null : !ENTITY_NAME_EDEFAULT.equals(entityName);
			case SeffPackage.INTERNAL_CALL_ACTION__PREDECESSOR_ABSTRACT_ACTION:
				return predecessor_AbstractAction != null;
			case SeffPackage.INTERNAL_CALL_ACTION__SUCCESSOR_ABSTRACT_ACTION:
				return successor_AbstractAction != null;
			case SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_DEMAND_ACTION:
				return resourceDemand_Action != null && !resourceDemand_Action.isEmpty();
			case SeffPackage.INTERNAL_CALL_ACTION__CALLED_RESOURCE_DEMANDING_INTERNAL_BEHAVIOUR:
				return calledResourceDemandingInternalBehaviour != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == Identifier.class) {
			switch (derivedFeatureID) {
				case SeffPackage.INTERNAL_CALL_ACTION__ID: return IdentifierPackage.IDENTIFIER__ID;
				default: return -1;
			}
		}
		if (baseClass == NamedElement.class) {
			switch (derivedFeatureID) {
				case SeffPackage.INTERNAL_CALL_ACTION__ENTITY_NAME: return EntityPackage.NAMED_ELEMENT__ENTITY_NAME;
				default: return -1;
			}
		}
		if (baseClass == Entity.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == AbstractAction.class) {
			switch (derivedFeatureID) {
				case SeffPackage.INTERNAL_CALL_ACTION__PREDECESSOR_ABSTRACT_ACTION: return SeffPackage.ABSTRACT_ACTION__PREDECESSOR_ABSTRACT_ACTION;
				case SeffPackage.INTERNAL_CALL_ACTION__SUCCESSOR_ABSTRACT_ACTION: return SeffPackage.ABSTRACT_ACTION__SUCCESSOR_ABSTRACT_ACTION;
				default: return -1;
			}
		}
		if (baseClass == AbstractInternalControlFlowAction.class) {
			switch (derivedFeatureID) {
				case SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_DEMAND_ACTION: return SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__RESOURCE_DEMAND_ACTION;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == Identifier.class) {
			switch (baseFeatureID) {
				case IdentifierPackage.IDENTIFIER__ID: return SeffPackage.INTERNAL_CALL_ACTION__ID;
				default: return -1;
			}
		}
		if (baseClass == NamedElement.class) {
			switch (baseFeatureID) {
				case EntityPackage.NAMED_ELEMENT__ENTITY_NAME: return SeffPackage.INTERNAL_CALL_ACTION__ENTITY_NAME;
				default: return -1;
			}
		}
		if (baseClass == Entity.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == AbstractAction.class) {
			switch (baseFeatureID) {
				case SeffPackage.ABSTRACT_ACTION__PREDECESSOR_ABSTRACT_ACTION: return SeffPackage.INTERNAL_CALL_ACTION__PREDECESSOR_ABSTRACT_ACTION;
				case SeffPackage.ABSTRACT_ACTION__SUCCESSOR_ABSTRACT_ACTION: return SeffPackage.INTERNAL_CALL_ACTION__SUCCESSOR_ABSTRACT_ACTION;
				default: return -1;
			}
		}
		if (baseClass == AbstractInternalControlFlowAction.class) {
			switch (baseFeatureID) {
				case SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__RESOURCE_DEMAND_ACTION: return SeffPackage.INTERNAL_CALL_ACTION__RESOURCE_DEMAND_ACTION;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (id: ");
		result.append(id);
		result.append(", entityName: ");
		result.append(entityName);
		result.append(')');
		return result.toString();
	}

} //InternalCallActionImpl
