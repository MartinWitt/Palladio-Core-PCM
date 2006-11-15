
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository.impl;

import de.uka.ipd.sdq.pcm.repository.DataType;
import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.ProvidesComponentType;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;

import de.uka.ipd.sdq.pcm.repository.util.RepositoryValidator;

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
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.ocl.expressions.OCLExpression;

import org.eclipse.emf.ocl.expressions.util.EvalEnvironment;
import org.eclipse.emf.ocl.expressions.util.ExpressionsUtil;

import org.eclipse.emf.ocl.parser.Environment;
import org.eclipse.emf.ocl.parser.ParserException;

import org.eclipse.emf.ocl.query.Query;
import org.eclipse.emf.ocl.query.QueryFactory;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Repository</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.RepositoryImpl#getRepositoryDescription <em>Repository Description</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.RepositoryImpl#getRepositoryName <em>Repository Name</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.RepositoryImpl#getComponents__Repository <em>Components Repository</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.RepositoryImpl#getInterfaces__Repository <em>Interfaces Repository</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.RepositoryImpl#getDatatypes_Repository <em>Datatypes Repository</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RepositoryImpl extends EObjectImpl implements Repository {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * The default value of the '{@link #getRepositoryDescription() <em>Repository Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepositoryDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String REPOSITORY_DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRepositoryDescription() <em>Repository Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepositoryDescription()
	 * @generated
	 * @ordered
	 */
	protected String repositoryDescription = REPOSITORY_DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getRepositoryName() <em>Repository Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepositoryName()
	 * @generated
	 * @ordered
	 */
	protected static final String REPOSITORY_NAME_EDEFAULT = "New Component Model";


	/**
	 * The cached value of the '{@link #getRepositoryName() <em>Repository Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepositoryName()
	 * @generated
	 * @ordered
	 */
	protected String repositoryName = REPOSITORY_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getComponents__Repository() <em>Components Repository</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponents__Repository()
	 * @generated
	 * @ordered
	 */
	protected EList components__Repository = null;

	/**
	 * The cached value of the '{@link #getInterfaces__Repository() <em>Interfaces Repository</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterfaces__Repository()
	 * @generated
	 * @ordered
	 */
	protected EList interfaces__Repository = null;


	/**
	 * The cached value of the '{@link #getDatatypes_Repository() <em>Datatypes Repository</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDatatypes_Repository()
	 * @generated
	 * @ordered
	 */
	protected EList datatypes_Repository = null;


	private static final String OCL_ANNOTATION_SOURCE = "http://www.eclipse.org/emf/2002/GenModel";
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RepositoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return RepositoryPackage.Literals.REPOSITORY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRepositoryDescription() {
		return repositoryDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepositoryDescription(String newRepositoryDescription) {
		String oldRepositoryDescription = repositoryDescription;
		repositoryDescription = newRepositoryDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.REPOSITORY__REPOSITORY_DESCRIPTION, oldRepositoryDescription, repositoryDescription));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRepositoryName() {
		return repositoryName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepositoryName(String newRepositoryName) {
		String oldRepositoryName = repositoryName;
		repositoryName = newRepositoryName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.REPOSITORY__REPOSITORY_NAME, oldRepositoryName, repositoryName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getComponents__Repository() {
		if (components__Repository == null) {
			components__Repository = new EObjectContainmentEList(ProvidesComponentType.class, this, RepositoryPackage.REPOSITORY__COMPONENTS_REPOSITORY);
		}
		return components__Repository;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getInterfaces__Repository() {
		if (interfaces__Repository == null) {
			interfaces__Repository = new EObjectContainmentEList(Interface.class, this, RepositoryPackage.REPOSITORY__INTERFACES_REPOSITORY);
		}
		return interfaces__Repository;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getDatatypes_Repository() {
		if (datatypes_Repository == null) {
			datatypes_Repository = new EObjectContainmentEList(DataType.class, this, RepositoryPackage.REPOSITORY__DATATYPES_REPOSITORY);
		}
		return datatypes_Repository;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RepositoryPackage.REPOSITORY__COMPONENTS_REPOSITORY:
				return ((InternalEList)getComponents__Repository()).basicRemove(otherEnd, msgs);
			case RepositoryPackage.REPOSITORY__INTERFACES_REPOSITORY:
				return ((InternalEList)getInterfaces__Repository()).basicRemove(otherEnd, msgs);
			case RepositoryPackage.REPOSITORY__DATATYPES_REPOSITORY:
				return ((InternalEList)getDatatypes_Repository()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RepositoryPackage.REPOSITORY__REPOSITORY_DESCRIPTION:
				return getRepositoryDescription();
			case RepositoryPackage.REPOSITORY__REPOSITORY_NAME:
				return getRepositoryName();
			case RepositoryPackage.REPOSITORY__COMPONENTS_REPOSITORY:
				return getComponents__Repository();
			case RepositoryPackage.REPOSITORY__INTERFACES_REPOSITORY:
				return getInterfaces__Repository();
			case RepositoryPackage.REPOSITORY__DATATYPES_REPOSITORY:
				return getDatatypes_Repository();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case RepositoryPackage.REPOSITORY__REPOSITORY_DESCRIPTION:
				setRepositoryDescription((String)newValue);
				return;
			case RepositoryPackage.REPOSITORY__REPOSITORY_NAME:
				setRepositoryName((String)newValue);
				return;
			case RepositoryPackage.REPOSITORY__COMPONENTS_REPOSITORY:
				getComponents__Repository().clear();
				getComponents__Repository().addAll((Collection)newValue);
				return;
			case RepositoryPackage.REPOSITORY__INTERFACES_REPOSITORY:
				getInterfaces__Repository().clear();
				getInterfaces__Repository().addAll((Collection)newValue);
				return;
			case RepositoryPackage.REPOSITORY__DATATYPES_REPOSITORY:
				getDatatypes_Repository().clear();
				getDatatypes_Repository().addAll((Collection)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case RepositoryPackage.REPOSITORY__REPOSITORY_DESCRIPTION:
				setRepositoryDescription(REPOSITORY_DESCRIPTION_EDEFAULT);
				return;
			case RepositoryPackage.REPOSITORY__REPOSITORY_NAME:
				setRepositoryName(REPOSITORY_NAME_EDEFAULT);
				return;
			case RepositoryPackage.REPOSITORY__COMPONENTS_REPOSITORY:
				getComponents__Repository().clear();
				return;
			case RepositoryPackage.REPOSITORY__INTERFACES_REPOSITORY:
				getInterfaces__Repository().clear();
				return;
			case RepositoryPackage.REPOSITORY__DATATYPES_REPOSITORY:
				getDatatypes_Repository().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case RepositoryPackage.REPOSITORY__REPOSITORY_DESCRIPTION:
				return REPOSITORY_DESCRIPTION_EDEFAULT == null ? repositoryDescription != null : !REPOSITORY_DESCRIPTION_EDEFAULT.equals(repositoryDescription);
			case RepositoryPackage.REPOSITORY__REPOSITORY_NAME:
				return REPOSITORY_NAME_EDEFAULT == null ? repositoryName != null : !REPOSITORY_NAME_EDEFAULT.equals(repositoryName);
			case RepositoryPackage.REPOSITORY__COMPONENTS_REPOSITORY:
				return components__Repository != null && !components__Repository.isEmpty();
			case RepositoryPackage.REPOSITORY__INTERFACES_REPOSITORY:
				return interfaces__Repository != null && !interfaces__Repository.isEmpty();
			case RepositoryPackage.REPOSITORY__DATATYPES_REPOSITORY:
				return datatypes_Repository != null && !datatypes_Repository.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (repositoryDescription: ");
		result.append(repositoryDescription);
		result.append(", repositoryName: ");
		result.append(repositoryName);
		result.append(')');
		return result.toString();
	}

} //RepositoryImpl