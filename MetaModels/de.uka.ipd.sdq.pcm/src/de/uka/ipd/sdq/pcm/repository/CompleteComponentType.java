
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Complete Component Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.CompleteComponentType#getParentProvidesComponentTypes <em>Parent Provides Component Types</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getCompleteComponentType()
 * @model
 * @generated
 */
public interface CompleteComponentType extends ProvidesComponentType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * Returns the value of the '<em><b>Parent Provides Component Types</b></em>' reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.repository.ProvidesComponentType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Provides Component Types</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Provides Component Types</em>' reference list.
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getCompleteComponentType_ParentProvidesComponentTypes()
	 * @model type="de.uka.ipd.sdq.pcm.repository.ProvidesComponentType" ordered="false"
	 * @generated
	 */
	EList getParentProvidesComponentTypes();


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * (
	 *  self.oclIsTypeOf(CompleteComponentType)
	 *  or
	 *  self.oclIsTypeOf(ImplementationComponentType)
	 *  or
	 *  self.oclIsTypeOf(CompositeComponent)
	 *  or
	 *  self.oclIsTypeOf(BasicComponent)
	 * )
	 * implies
	 * (
	 *  self.providedRoles->size() >= 1
	 *  or
	 *  self.requiredRoles->size() >= 1
	 * )
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean AtLeastOneInterfaceHasToBeProvidedOrRequiredByAUsefullCompleteComponentType(DiagnosticChain diagnostics, Map context);


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * -- CompleteTypes provided Interfaces have to be a superset
	 * -- of ProvidesComponentType provided Interfaces #
	 * --
	 * -- ACCx are used to accumulate Sets/Bags; usually only the very inner ACCx is used at all.
	 * --
	 * -- Recursive Query for parent Interface IDs
	 * -- see "lpar2005.pdf" (Second-order principles in specification languages for Object-Oriented Programs; Beckert, Tretelman) pp. 11 #
	 * let parentInterfaces : Bag(Interface) =
	 *  self.providedRoles->iterate(r : ProvidedRole; acc2 : Bag(Interface) = Bag{} |
	 *   acc2->union(r.providedInterface.parentInterface->asBag()) -- asBag required to allow Set operations #
	 *  ) in
	 * let anchestorInterfaces : Bag(Interface) =
	 *  self.providedRoles->iterate(r : ProvidedRole; acc4 : Bag(Interface) = Bag{} |
	 *   acc4->union(r.providedInterface.parentInterface->asBag()) -- asBag required to allow Set operations #
	 *  )->union( -- union with anchestors found in former recursion #
	 *   self.providedRoles->iterate(r : ProvidedRole; acc6 : Bag(Interface) = Bag{} |
	 *    acc6->union(r.providedInterface.parentInterface.anchestorInterfaces) --already Set/Bag
	 *   )
	 *  ) in
	 *  -- Directly provided anchestorInterfaces need to be a superset of provided interfaces of Supertype #
	 *  anchestorInterfaces.identifier.id->includesAll(
	 *   self.parentProvidesComponentTypes->iterate(pt : ProvidesComponentType; acc1 : Bag(String) = Bag{} |
	 *    pt.providedRoles->iterate(r : ProvidedRole; acc2 : Bag(String) = Bag{} |
	 *     acc2->union(r.providedInterface.identifier.id->asBag()) -- asBag required to allow Set operations #
	 *    )
	 *   )
	 *  )
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean providedInterfacesHaveToConformToProvidedType2(DiagnosticChain diagnostics, Map context);

} // CompleteComponentType