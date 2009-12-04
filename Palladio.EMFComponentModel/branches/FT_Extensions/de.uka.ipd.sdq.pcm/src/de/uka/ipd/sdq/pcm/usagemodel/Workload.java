/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.usagemodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Workload</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A Workload specifies the usage intensity of a system, which relates to the number of users concurrently
 * present in the system. The PCM usage model adopts this concept from classical queueing
 * theory [123]. The specified workloads can directly be used in queueing networks or easily be mapped
 * to markings in stochastic Petri nets. Workloads can either be open or closed.
 * 
 * The algorithms used to analyse queueing networks differ depending on whether open or closed workloads
 * are modelled [123]. Some special queueing networks can only be analysed given a particular workload
 * type (open or closed). Notice, that it is possible to specify a usage model with open workload usage
 * scenarios and closed workload usage scenarios at the same time. Open and closed workloads can be
 * executed in parallel when analysing the model.
 * 
 * [123] E. Lazowska, J. Zahorjan, G. Graham, and K. Sevcik, Quantitative System Performance. Prentice
 * Hall, 1984.
 * <!-- end-model-doc -->
 *
 *
 * @see de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage#getWorkload()
 * @model abstract="true"
 * @generated
 */
public interface Workload extends EObject {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

} // Workload