/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision.provider;

import de.uka.ipd.sdq.pcm.designdecision.util.designdecisionAdapterFactory;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class designdecisionItemProviderAdapterFactory extends designdecisionAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public designdecisionItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.pcm.designdecision.EquivalentComponents} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EquivalentComponentsItemProvider equivalentComponentsItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.designdecision.EquivalentComponents}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEquivalentComponentsAdapter() {
		if (equivalentComponentsItemProvider == null) {
			equivalentComponentsItemProvider = new EquivalentComponentsItemProvider(this);
		}

		return equivalentComponentsItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.pcm.designdecision.AvailableServers} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AvailableServersItemProvider availableServersItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.designdecision.AvailableServers}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAvailableServersAdapter() {
		if (availableServersItemProvider == null) {
			availableServersItemProvider = new AvailableServersItemProvider(this);
		}

		return availableServersItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.pcm.designdecision.ComponentChoice} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentChoiceItemProvider componentChoiceItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.designdecision.ComponentChoice}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createComponentChoiceAdapter() {
		if (componentChoiceItemProvider == null) {
			componentChoiceItemProvider = new ComponentChoiceItemProvider(this);
		}

		return componentChoiceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.pcm.designdecision.AllocationChoice} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AllocationChoiceItemProvider allocationChoiceItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.designdecision.AllocationChoice}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAllocationChoiceAdapter() {
		if (allocationChoiceItemProvider == null) {
			allocationChoiceItemProvider = new AllocationChoiceItemProvider(this);
		}

		return allocationChoiceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.pcm.designdecision.ProcessingRateChoice} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProcessingRateChoiceItemProvider processingRateChoiceItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.designdecision.ProcessingRateChoice}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createProcessingRateChoiceAdapter() {
		if (processingRateChoiceItemProvider == null) {
			processingRateChoiceItemProvider = new ProcessingRateChoiceItemProvider(this);
		}

		return processingRateChoiceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.pcm.designdecision.ProcessingRateDecision} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProcessingRateDecisionItemProvider processingRateDecisionItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.designdecision.ProcessingRateDecision}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createProcessingRateDecisionAdapter() {
		if (processingRateDecisionItemProvider == null) {
			processingRateDecisionItemProvider = new ProcessingRateDecisionItemProvider(this);
		}

		return processingRateDecisionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.pcm.designdecision.AllocationDecision} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AllocationDecisionItemProvider allocationDecisionItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.designdecision.AllocationDecision}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAllocationDecisionAdapter() {
		if (allocationDecisionItemProvider == null) {
			allocationDecisionItemProvider = new AllocationDecisionItemProvider(this);
		}

		return allocationDecisionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.pcm.designdecision.AssembledComponentDecision} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AssembledComponentDecisionItemProvider assembledComponentDecisionItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.designdecision.AssembledComponentDecision}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAssembledComponentDecisionAdapter() {
		if (assembledComponentDecisionItemProvider == null) {
			assembledComponentDecisionItemProvider = new AssembledComponentDecisionItemProvider(this);
		}

		return assembledComponentDecisionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.pcm.designdecision.IntegerRange} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IntegerRangeItemProvider integerRangeItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.designdecision.IntegerRange}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createIntegerRangeAdapter() {
		if (integerRangeItemProvider == null) {
			integerRangeItemProvider = new IntegerRangeItemProvider(this);
		}

		return integerRangeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.pcm.designdecision.DoubleRange} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DoubleRangeItemProvider doubleRangeItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.designdecision.DoubleRange}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDoubleRangeAdapter() {
		if (doubleRangeItemProvider == null) {
			doubleRangeItemProvider = new DoubleRangeItemProvider(this);
		}

		return doubleRangeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.pcm.designdecision.ResourceContainerReplicationChoice} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceContainerReplicationChoiceItemProvider resourceContainerReplicationChoiceItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.designdecision.ResourceContainerReplicationChoice}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createResourceContainerReplicationChoiceAdapter() {
		if (resourceContainerReplicationChoiceItemProvider == null) {
			resourceContainerReplicationChoiceItemProvider = new ResourceContainerReplicationChoiceItemProvider(this);
		}

		return resourceContainerReplicationChoiceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.pcm.designdecision.ResourceContainerReplicationDecision} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceContainerReplicationDecisionItemProvider resourceContainerReplicationDecisionItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.designdecision.ResourceContainerReplicationDecision}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createResourceContainerReplicationDecisionAdapter() {
		if (resourceContainerReplicationDecisionItemProvider == null) {
			resourceContainerReplicationDecisionItemProvider = new ResourceContainerReplicationDecisionItemProvider(this);
		}

		return resourceContainerReplicationDecisionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.pcm.designdecision.Genotype} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenotypeItemProvider genotypeItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.designdecision.Genotype}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createGenotypeAdapter() {
		if (genotypeItemProvider == null) {
			genotypeItemProvider = new GenotypeItemProvider(this);
		}

		return genotypeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.uka.ipd.sdq.pcm.designdecision.Problem} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProblemItemProvider problemItemProvider;

	/**
	 * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.designdecision.Problem}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createProblemAdapter() {
		if (problemItemProvider == null) {
			problemItemProvider = new ProblemItemProvider(this);
		}

		return problemItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (equivalentComponentsItemProvider != null) equivalentComponentsItemProvider.dispose();
		if (availableServersItemProvider != null) availableServersItemProvider.dispose();
		if (componentChoiceItemProvider != null) componentChoiceItemProvider.dispose();
		if (allocationChoiceItemProvider != null) allocationChoiceItemProvider.dispose();
		if (processingRateChoiceItemProvider != null) processingRateChoiceItemProvider.dispose();
		if (processingRateDecisionItemProvider != null) processingRateDecisionItemProvider.dispose();
		if (allocationDecisionItemProvider != null) allocationDecisionItemProvider.dispose();
		if (assembledComponentDecisionItemProvider != null) assembledComponentDecisionItemProvider.dispose();
		if (integerRangeItemProvider != null) integerRangeItemProvider.dispose();
		if (doubleRangeItemProvider != null) doubleRangeItemProvider.dispose();
		if (resourceContainerReplicationChoiceItemProvider != null) resourceContainerReplicationChoiceItemProvider.dispose();
		if (resourceContainerReplicationDecisionItemProvider != null) resourceContainerReplicationDecisionItemProvider.dispose();
		if (genotypeItemProvider != null) genotypeItemProvider.dispose();
		if (problemItemProvider != null) problemItemProvider.dispose();
	}

}