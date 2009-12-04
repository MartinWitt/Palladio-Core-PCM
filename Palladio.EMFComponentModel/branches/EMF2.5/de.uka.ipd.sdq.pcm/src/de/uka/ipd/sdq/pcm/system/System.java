/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.system;

import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.pcm.core.entity.ComposedProvidingRequiringEntity;
import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.pcm.qosannotations.QoSAnnotations;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A System is the out-most entity of a PCM's assembly of components. It captures the modeling decision to which extend a system under investigation is modelled within the PCM.
 * A System is not composable (part of another composition) because it has QoS annotations which are only allowed in the "outer" composition thing. And a UsageModel must only access ProvidedRoles of a System and not of inner components.
 * The System is inheriting from ComposedProvidingRequiringEntity to have a unique means for expressing the inner composition of an entity (here: System). Also it allows using the same editor etc. being applied to ComposedProvidingRequiringEntity and thus also being useful for System.
 * 
 * A system consists of an assembly and is itself referenced by an allocation (only a System can be allocated). The first specifies how the components are connected with other components, the latter specifies how the components and connectors are mapped to the resource environment (hardware and middleware). From a structural point of view, Systems can be seen as special kind of CompositeComponents. Systems are not supposed to be reused as components are. The are assumed to be coupled by using special techniques for system integration.
 * 
 * A System has provided and required roles like a composite component. Only a system's provided role can be accessed from the usage profile. Only a system's required roles can have QOS annotations.
 * 
 * Like SubSystems, Systems are white-box entities for the Software Architect and also for the System Deployer. Thus, a System Deployer can and must allocate inner components of a System individually.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.system.System#getQosAnnotations_System <em>Qos Annotations System</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.system.SystemPackage#getSystem()
 * @model
 * @generated
 */
public interface System extends Entity, ComposedProvidingRequiringEntity {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, Karlsruhe Institute of Technology / University of Karlsruhe, Germany and SE, FZI Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Qos Annotations System</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.qosannotations.QoSAnnotations}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Qos Annotations System</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * QoS Annotations allow for specifing fixed (non-parameterised) QoS properties at the system boundary level for required services. For example, for a required service it can be specified that its response time is fixed "3 ms". See the QoS Annotations package for more details.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Qos Annotations System</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.system.SystemPackage#getSystem_QosAnnotations_System()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<QoSAnnotations> getQosAnnotations_System();

} // System