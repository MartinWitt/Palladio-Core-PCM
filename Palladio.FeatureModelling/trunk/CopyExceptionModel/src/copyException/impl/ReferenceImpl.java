/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package copyException.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import copyException.CopyExceptionPackage;
import copyException.Reference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link copyException.impl.ReferenceImpl#getO <em>O</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReferenceImpl extends ExceptionImpl implements Reference {
	/**
	 * The cached value of the '{@link #getO() <em>O</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getO()
	 * @generated
	 * @ordered
	 */
	protected EPackage o;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CopyExceptionPackage.Literals.REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPackage getO() {
		if (o != null && o.eIsProxy()) {
			InternalEObject oldO = (InternalEObject)o;
			o = (EPackage)eResolveProxy(oldO);
			if (o != oldO) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CopyExceptionPackage.REFERENCE__O, oldO, o));
			}
		}
		return o;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPackage basicGetO() {
		return o;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setO(EPackage newO) {
		EPackage oldO = o;
		o = newO;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CopyExceptionPackage.REFERENCE__O, oldO, o));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CopyExceptionPackage.REFERENCE__O:
				if (resolve) return getO();
				return basicGetO();
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
			case CopyExceptionPackage.REFERENCE__O:
				setO((EPackage)newValue);
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
			case CopyExceptionPackage.REFERENCE__O:
				setO((EPackage)null);
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
			case CopyExceptionPackage.REFERENCE__O:
				return o != null;
		}
		return super.eIsSet(featureID);
	}

} //ReferenceImpl
