/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff;

import de.uka.ipd.sdq.identifier.Identifier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Demanding SEFF</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A resource demanding service effect specification (RDSEFF) is a special type of SEFF designed for performance and reliability predictions. Besides dependencies between provided and required services of a component, it additionally includes notions of resource usage, data flow, and parametric dependencies for more accurate predictions. Its control flow is hierarchically structured and can be enhanced with transition probabilities on branches and numbers of iterations on loops.
 * A ResourceDemandingSEFF is a ServiceEffectSpecification and a Resource-DemandingBehaviour at the same time inheriting from both classes. The reason for this construct lies in the fact, that ResourceDemandingBehaviours can be used recursively inside themselves to describe loop bodies or branched behaviours (explained later), and these inner behaviours should not be RDSEFFs themselves
 * <!-- end-model-doc -->
 *
 *
 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getResourceDemandingSEFF()
 * @model
 * @generated
 */
public interface ResourceDemandingSEFF extends ServiceEffectSpecification, Identifier, ResourceDemandingBehaviour {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2008 by SDQ, IPD, University of Karlsruhe, Germany";

} // ResourceDemandingSEFF
