/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.ByBench.provider;


import de.uka.ipd.sdq.ByBench.ByBenchFactory;
import de.uka.ipd.sdq.ByBench.ByBenchPackage;
import de.uka.ipd.sdq.ByBench.Scenario;

import de.uka.ipd.sdq.identifier.provider.IdentifierItemProvider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link de.uka.ipd.sdq.ByBench.Scenario} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ScenarioItemProvider
	extends IdentifierItemProvider
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScenarioItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addBenchmarkedInstructionPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Benchmarked Instruction feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBenchmarkedInstructionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Scenario_benchmarkedInstruction_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Scenario_benchmarkedInstruction_feature", "_UI_Scenario_type"),
				 ByBenchPackage.Literals.SCENARIO__BENCHMARKED_INSTRUCTION,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(ByBenchPackage.Literals.SCENARIO__SCENARIOPRECONDITION);
			childrenFeatures.add(ByBenchPackage.Literals.SCENARIO__MEASUREMENTSTART);
			childrenFeatures.add(ByBenchPackage.Literals.SCENARIO__SCENARIOCORE);
			childrenFeatures.add(ByBenchPackage.Literals.SCENARIO__MEASUREMENTEND);
			childrenFeatures.add(ByBenchPackage.Literals.SCENARIO__SCENARIOPOSTCONDITION);
			childrenFeatures.add(ByBenchPackage.Literals.SCENARIO__NAMEDCARDINALITY);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns Scenario.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Scenario"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Scenario)object).getId();
		return label == null || label.length() == 0 ?
			getString("_UI_Scenario_type") :
			getString("_UI_Scenario_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(Scenario.class)) {
			case ByBenchPackage.SCENARIO__SCENARIOPRECONDITION:
			case ByBenchPackage.SCENARIO__MEASUREMENTSTART:
			case ByBenchPackage.SCENARIO__SCENARIOCORE:
			case ByBenchPackage.SCENARIO__MEASUREMENTEND:
			case ByBenchPackage.SCENARIO__SCENARIOPOSTCONDITION:
			case ByBenchPackage.SCENARIO__NAMEDCARDINALITY:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(ByBenchPackage.Literals.SCENARIO__SCENARIOPRECONDITION,
				 ByBenchFactory.eINSTANCE.createScenarioPrecondition()));

		newChildDescriptors.add
			(createChildParameter
				(ByBenchPackage.Literals.SCENARIO__MEASUREMENTSTART,
				 ByBenchFactory.eINSTANCE.createMeasurementStart()));

		newChildDescriptors.add
			(createChildParameter
				(ByBenchPackage.Literals.SCENARIO__SCENARIOCORE,
				 ByBenchFactory.eINSTANCE.createScenarioCore()));

		newChildDescriptors.add
			(createChildParameter
				(ByBenchPackage.Literals.SCENARIO__MEASUREMENTEND,
				 ByBenchFactory.eINSTANCE.createMeasurementEnd()));

		newChildDescriptors.add
			(createChildParameter
				(ByBenchPackage.Literals.SCENARIO__SCENARIOPOSTCONDITION,
				 ByBenchFactory.eINSTANCE.createScenarioPostcondition()));

		newChildDescriptors.add
			(createChildParameter
				(ByBenchPackage.Literals.SCENARIO__NAMEDCARDINALITY,
				 ByBenchFactory.eINSTANCE.createNamedCardinality()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return ByBenchEditPlugin.INSTANCE;
	}

}