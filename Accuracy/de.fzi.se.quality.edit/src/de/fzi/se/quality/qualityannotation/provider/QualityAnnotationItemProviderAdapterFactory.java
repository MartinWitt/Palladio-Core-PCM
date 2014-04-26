/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.qualityannotation.provider;

import de.fzi.se.quality.qualityannotation.util.QualityAnnotationAdapterFactory;

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
public class QualityAnnotationItemProviderAdapterFactory extends QualityAnnotationAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
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
	public QualityAnnotationItemProviderAdapterFactory() {
        supportedTypes.add(IEditingDomainItemProvider.class);
        supportedTypes.add(IStructuredItemContentProvider.class);
        supportedTypes.add(ITreeItemContentProvider.class);
        supportedTypes.add(IItemLabelProvider.class);
        supportedTypes.add(IItemPropertySource.class);
    }

	/**
     * This keeps track of the one adapter used for all {@link de.fzi.se.quality.qualityannotation.ParameterValueDeviation} instances.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected ParameterValueDeviationItemProvider parameterValueDeviationItemProvider;

	/**
     * This creates an adapter for a {@link de.fzi.se.quality.qualityannotation.ParameterValueDeviation}.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Adapter createParameterValueDeviationAdapter() {
        if (parameterValueDeviationItemProvider == null) {
            parameterValueDeviationItemProvider = new ParameterValueDeviationItemProvider(this);
        }

        return parameterValueDeviationItemProvider;
    }

	/**
     * This keeps track of the one adapter used for all {@link de.fzi.se.quality.qualityannotation.QualityAnnotation} instances.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected QualityAnnotationItemProvider qualityAnnotationItemProvider;

	/**
     * This creates an adapter for a {@link de.fzi.se.quality.qualityannotation.QualityAnnotation}.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Adapter createQualityAnnotationAdapter() {
        if (qualityAnnotationItemProvider == null) {
            qualityAnnotationItemProvider = new QualityAnnotationItemProvider(this);
        }

        return qualityAnnotationItemProvider;
    }

	/**
     * This keeps track of the one adapter used for all {@link de.fzi.se.quality.qualityannotation.RequiredElementDeviation} instances.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected RequiredElementDeviationItemProvider requiredElementDeviationItemProvider;

	/**
     * This creates an adapter for a {@link de.fzi.se.quality.qualityannotation.RequiredElementDeviation}.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Adapter createRequiredElementDeviationAdapter() {
        if (requiredElementDeviationItemProvider == null) {
            requiredElementDeviationItemProvider = new RequiredElementDeviationItemProvider(this);
        }

        return requiredElementDeviationItemProvider;
    }

	/**
     * This keeps track of the one adapter used for all {@link de.fzi.se.quality.qualityannotation.InternalStateInfluenceAnalysisAggregation} instances.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected InternalStateInfluenceAnalysisAggregationItemProvider internalStateInfluenceAnalysisAggregationItemProvider;

	/**
     * This creates an adapter for a {@link de.fzi.se.quality.qualityannotation.InternalStateInfluenceAnalysisAggregation}.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Adapter createInternalStateInfluenceAnalysisAggregationAdapter() {
        if (internalStateInfluenceAnalysisAggregationItemProvider == null) {
            internalStateInfluenceAnalysisAggregationItemProvider = new InternalStateInfluenceAnalysisAggregationItemProvider(this);
        }

        return internalStateInfluenceAnalysisAggregationItemProvider;
    }

	/**
     * This keeps track of the one adapter used for all {@link de.fzi.se.quality.qualityannotation.REPrecision} instances.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected REPrecisionItemProvider rePrecisionItemProvider;

	/**
     * This creates an adapter for a {@link de.fzi.se.quality.qualityannotation.REPrecision}.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Adapter createREPrecisionAdapter() {
        if (rePrecisionItemProvider == null) {
            rePrecisionItemProvider = new REPrecisionItemProvider(this);
        }

        return rePrecisionItemProvider;
    }

	/**
     * This keeps track of the one adapter used for all {@link de.fzi.se.quality.qualityannotation.PCMParameterPartition} instances.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected PCMParameterPartitionItemProvider pcmParameterPartitionItemProvider;

	/**
     * This creates an adapter for a {@link de.fzi.se.quality.qualityannotation.PCMParameterPartition}.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Adapter createPCMParameterPartitionAdapter() {
        if (pcmParameterPartitionItemProvider == null) {
            pcmParameterPartitionItemProvider = new PCMParameterPartitionItemProvider(this);
        }

        return pcmParameterPartitionItemProvider;
    }

	/**
     * This keeps track of the one adapter used for all {@link de.fzi.se.quality.qualityannotation.CharacterisedPCMParameterPartitionInterval} instances.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected CharacterisedPCMParameterPartitionIntervalItemProvider characterisedPCMParameterPartitionIntervalItemProvider;

	/**
     * This creates an adapter for a {@link de.fzi.se.quality.qualityannotation.CharacterisedPCMParameterPartitionInterval}.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Adapter createCharacterisedPCMParameterPartitionIntervalAdapter() {
        if (characterisedPCMParameterPartitionIntervalItemProvider == null) {
            characterisedPCMParameterPartitionIntervalItemProvider = new CharacterisedPCMParameterPartitionIntervalItemProvider(this);
        }

        return characterisedPCMParameterPartitionIntervalItemProvider;
    }

	/**
     * This keeps track of the one adapter used for all {@link de.fzi.se.quality.qualityannotation.CharacterisedPCMParameterPartitionRange} instances.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected CharacterisedPCMParameterPartitionRangeItemProvider characterisedPCMParameterPartitionRangeItemProvider;

	/**
     * This creates an adapter for a {@link de.fzi.se.quality.qualityannotation.CharacterisedPCMParameterPartitionRange}.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Adapter createCharacterisedPCMParameterPartitionRangeAdapter() {
        if (characterisedPCMParameterPartitionRangeItemProvider == null) {
            characterisedPCMParameterPartitionRangeItemProvider = new CharacterisedPCMParameterPartitionRangeItemProvider(this);
        }

        return characterisedPCMParameterPartitionRangeItemProvider;
    }

	/**
     * This keeps track of the one adapter used for all {@link de.fzi.se.quality.qualityannotation.ExactlyAsSpecifiedPrecision} instances.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected ExactlyAsSpecifiedPrecisionItemProvider exactlyAsSpecifiedPrecisionItemProvider;

	/**
     * This creates an adapter for a {@link de.fzi.se.quality.qualityannotation.ExactlyAsSpecifiedPrecision}.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Adapter createExactlyAsSpecifiedPrecisionAdapter() {
        if (exactlyAsSpecifiedPrecisionItemProvider == null) {
            exactlyAsSpecifiedPrecisionItemProvider = new ExactlyAsSpecifiedPrecisionItemProvider(this);
        }

        return exactlyAsSpecifiedPrecisionItemProvider;
    }

	/**
     * This keeps track of the one adapter used for all {@link de.fzi.se.quality.qualityannotation.LimitedDeviationPrecision} instances.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected LimitedDeviationPrecisionItemProvider limitedDeviationPrecisionItemProvider;

	/**
     * This creates an adapter for a {@link de.fzi.se.quality.qualityannotation.LimitedDeviationPrecision}.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Adapter createLimitedDeviationPrecisionAdapter() {
        if (limitedDeviationPrecisionItemProvider == null) {
            limitedDeviationPrecisionItemProvider = new LimitedDeviationPrecisionItemProvider(this);
        }

        return limitedDeviationPrecisionItemProvider;
    }

	/**
     * This keeps track of the one adapter used for all {@link de.fzi.se.quality.qualityannotation.NoPrecision} instances.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected NoPrecisionItemProvider noPrecisionItemProvider;

	/**
     * This creates an adapter for a {@link de.fzi.se.quality.qualityannotation.NoPrecision}.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Adapter createNoPrecisionAdapter() {
        if (noPrecisionItemProvider == null) {
            noPrecisionItemProvider = new NoPrecisionItemProvider(this);
        }

        return noPrecisionItemProvider;
    }

	/**
     * This keeps track of the one adapter used for all {@link de.fzi.se.quality.qualityannotation.PCMRECategory} instances.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected PCMRECategoryItemProvider pcmreCategoryItemProvider;

	/**
     * This creates an adapter for a {@link de.fzi.se.quality.qualityannotation.PCMRECategory}.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Adapter createPCMRECategoryAdapter() {
        if (pcmreCategoryItemProvider == null) {
            pcmreCategoryItemProvider = new PCMRECategoryItemProvider(this);
        }

        return pcmreCategoryItemProvider;
    }

	/**
     * This keeps track of the one adapter used for all {@link de.fzi.se.quality.qualityannotation.PCMREInterface} instances.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected PCMREInterfaceItemProvider pcmreInterfaceItemProvider;

	/**
     * This creates an adapter for a {@link de.fzi.se.quality.qualityannotation.PCMREInterface}.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Adapter createPCMREInterfaceAdapter() {
        if (pcmreInterfaceItemProvider == null) {
            pcmreInterfaceItemProvider = new PCMREInterfaceItemProvider(this);
        }

        return pcmreInterfaceItemProvider;
    }

	/**
     * This keeps track of the one adapter used for all {@link de.fzi.se.quality.qualityannotation.PCMRERole} instances.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected PCMRERoleItemProvider pcmreRoleItemProvider;

	/**
     * This creates an adapter for a {@link de.fzi.se.quality.qualityannotation.PCMRERole}.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Adapter createPCMRERoleAdapter() {
        if (pcmreRoleItemProvider == null) {
            pcmreRoleItemProvider = new PCMRERoleItemProvider(this);
        }

        return pcmreRoleItemProvider;
    }

	/**
     * This keeps track of the one adapter used for all {@link de.fzi.se.quality.qualityannotation.PCMRESignature} instances.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected PCMRESignatureItemProvider pcmreSignatureItemProvider;

	/**
     * This creates an adapter for a {@link de.fzi.se.quality.qualityannotation.PCMRESignature}.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Adapter createPCMRESignatureAdapter() {
        if (pcmreSignatureItemProvider == null) {
            pcmreSignatureItemProvider = new PCMRESignatureItemProvider(this);
        }

        return pcmreSignatureItemProvider;
    }

	/**
     * This keeps track of the one adapter used for all {@link de.fzi.se.quality.qualityannotation.PCMServiceSpecification} instances.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected PCMServiceSpecificationItemProvider pcmServiceSpecificationItemProvider;

	/**
     * This creates an adapter for a {@link de.fzi.se.quality.qualityannotation.PCMServiceSpecification}.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Adapter createPCMServiceSpecificationAdapter() {
        if (pcmServiceSpecificationItemProvider == null) {
            pcmServiceSpecificationItemProvider = new PCMServiceSpecificationItemProvider(this);
        }

        return pcmServiceSpecificationItemProvider;
    }

	/**
     * This keeps track of the one adapter used for all {@link de.fzi.se.quality.qualityannotation.PCMREResourceInterface} instances.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected PCMREResourceInterfaceItemProvider pcmreResourceInterfaceItemProvider;

	/**
     * This creates an adapter for a {@link de.fzi.se.quality.qualityannotation.PCMREResourceInterface}.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Adapter createPCMREResourceInterfaceAdapter() {
        if (pcmreResourceInterfaceItemProvider == null) {
            pcmreResourceInterfaceItemProvider = new PCMREResourceInterfaceItemProvider(this);
        }

        return pcmreResourceInterfaceItemProvider;
    }

	/**
     * This keeps track of the one adapter used for all {@link de.fzi.se.quality.qualityannotation.PCMREResourceSignature} instances.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected PCMREResourceSignatureItemProvider pcmreResourceSignatureItemProvider;

	/**
     * This creates an adapter for a {@link de.fzi.se.quality.qualityannotation.PCMREResourceSignature}.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Adapter createPCMREResourceSignatureAdapter() {
        if (pcmreResourceSignatureItemProvider == null) {
            pcmreResourceSignatureItemProvider = new PCMREResourceSignatureItemProvider(this);
        }

        return pcmreResourceSignatureItemProvider;
    }

	/**
     * This keeps track of the one adapter used for all {@link de.fzi.se.quality.qualityannotation.PCMREResource} instances.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected PCMREResourceItemProvider pcmreResourceItemProvider;

	/**
     * This creates an adapter for a {@link de.fzi.se.quality.qualityannotation.PCMREResource}.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Adapter createPCMREResourceAdapter() {
        if (pcmreResourceItemProvider == null) {
            pcmreResourceItemProvider = new PCMREResourceItemProvider(this);
        }

        return pcmreResourceItemProvider;
    }

	/**
     * This keeps track of the one adapter used for all {@link de.fzi.se.quality.qualityannotation.PCMREResourceRole} instances.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected PCMREResourceRoleItemProvider pcmreResourceRoleItemProvider;

	/**
     * This creates an adapter for a {@link de.fzi.se.quality.qualityannotation.PCMREResourceRole}.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Adapter createPCMREResourceRoleAdapter() {
        if (pcmreResourceRoleItemProvider == null) {
            pcmreResourceRoleItemProvider = new PCMREResourceRoleItemProvider(this);
        }

        return pcmreResourceRoleItemProvider;
    }

	/**
     * This keeps track of the one adapter used for all {@link de.fzi.se.quality.qualityannotation.PCMRECIBehavior} instances.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected PCMRECIBehaviorItemProvider pcmreciBehaviorItemProvider;

	/**
     * This creates an adapter for a {@link de.fzi.se.quality.qualityannotation.PCMRECIBehavior}.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Adapter createPCMRECIBehaviorAdapter() {
        if (pcmreciBehaviorItemProvider == null) {
            pcmreciBehaviorItemProvider = new PCMRECIBehaviorItemProvider(this);
        }

        return pcmreciBehaviorItemProvider;
    }

	/**
     * This keeps track of the one adapter used for all {@link de.fzi.se.quality.qualityannotation.PCMREInfrastructureInterface} instances.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected PCMREInfrastructureInterfaceItemProvider pcmreInfrastructureInterfaceItemProvider;

	/**
     * This creates an adapter for a {@link de.fzi.se.quality.qualityannotation.PCMREInfrastructureInterface}.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Adapter createPCMREInfrastructureInterfaceAdapter() {
        if (pcmreInfrastructureInterfaceItemProvider == null) {
            pcmreInfrastructureInterfaceItemProvider = new PCMREInfrastructureInterfaceItemProvider(this);
        }

        return pcmreInfrastructureInterfaceItemProvider;
    }

	/**
     * This keeps track of the one adapter used for all {@link de.fzi.se.quality.qualityannotation.PCMREInfrastructureRole} instances.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected PCMREInfrastructureRoleItemProvider pcmreInfrastructureRoleItemProvider;

	/**
     * This creates an adapter for a {@link de.fzi.se.quality.qualityannotation.PCMREInfrastructureRole}.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Adapter createPCMREInfrastructureRoleAdapter() {
        if (pcmreInfrastructureRoleItemProvider == null) {
            pcmreInfrastructureRoleItemProvider = new PCMREInfrastructureRoleItemProvider(this);
        }

        return pcmreInfrastructureRoleItemProvider;
    }

	/**
     * This keeps track of the one adapter used for all {@link de.fzi.se.quality.qualityannotation.PCMREInfrastructureSignature} instances.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected PCMREInfrastructureSignatureItemProvider pcmreInfrastructureSignatureItemProvider;

	/**
     * This creates an adapter for a {@link de.fzi.se.quality.qualityannotation.PCMREInfrastructureSignature}.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Adapter createPCMREInfrastructureSignatureAdapter() {
        if (pcmreInfrastructureSignatureItemProvider == null) {
            pcmreInfrastructureSignatureItemProvider = new PCMREInfrastructureSignatureItemProvider(this);
        }

        return pcmreInfrastructureSignatureItemProvider;
    }

	/**
     * This keeps track of the one adapter used for all {@link de.fzi.se.quality.qualityannotation.PCMPEAllDecisions} instances.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected PCMPEAllDecisionsItemProvider pcmpeAllDecisionsItemProvider;

	/**
     * This creates an adapter for a {@link de.fzi.se.quality.qualityannotation.PCMPEAllDecisions}.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Adapter createPCMPEAllDecisionsAdapter() {
        if (pcmpeAllDecisionsItemProvider == null) {
            pcmpeAllDecisionsItemProvider = new PCMPEAllDecisionsItemProvider(this);
        }

        return pcmpeAllDecisionsItemProvider;
    }

	/**
     * This keeps track of the one adapter used for all {@link de.fzi.se.quality.qualityannotation.PCMPEDecision} instances.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected PCMPEDecisionItemProvider pcmpeDecisionItemProvider;

	/**
     * This creates an adapter for a {@link de.fzi.se.quality.qualityannotation.PCMPEDecision}.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Adapter createPCMPEDecisionAdapter() {
        if (pcmpeDecisionItemProvider == null) {
            pcmpeDecisionItemProvider = new PCMPEDecisionItemProvider(this);
        }

        return pcmpeDecisionItemProvider;
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
            if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
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
        if (parameterValueDeviationItemProvider != null) parameterValueDeviationItemProvider.dispose();
        if (qualityAnnotationItemProvider != null) qualityAnnotationItemProvider.dispose();
        if (requiredElementDeviationItemProvider != null) requiredElementDeviationItemProvider.dispose();
        if (internalStateInfluenceAnalysisAggregationItemProvider != null) internalStateInfluenceAnalysisAggregationItemProvider.dispose();
        if (rePrecisionItemProvider != null) rePrecisionItemProvider.dispose();
        if (pcmParameterPartitionItemProvider != null) pcmParameterPartitionItemProvider.dispose();
        if (characterisedPCMParameterPartitionIntervalItemProvider != null) characterisedPCMParameterPartitionIntervalItemProvider.dispose();
        if (characterisedPCMParameterPartitionRangeItemProvider != null) characterisedPCMParameterPartitionRangeItemProvider.dispose();
        if (exactlyAsSpecifiedPrecisionItemProvider != null) exactlyAsSpecifiedPrecisionItemProvider.dispose();
        if (limitedDeviationPrecisionItemProvider != null) limitedDeviationPrecisionItemProvider.dispose();
        if (noPrecisionItemProvider != null) noPrecisionItemProvider.dispose();
        if (pcmreCategoryItemProvider != null) pcmreCategoryItemProvider.dispose();
        if (pcmreInterfaceItemProvider != null) pcmreInterfaceItemProvider.dispose();
        if (pcmreRoleItemProvider != null) pcmreRoleItemProvider.dispose();
        if (pcmreSignatureItemProvider != null) pcmreSignatureItemProvider.dispose();
        if (pcmServiceSpecificationItemProvider != null) pcmServiceSpecificationItemProvider.dispose();
        if (pcmreResourceInterfaceItemProvider != null) pcmreResourceInterfaceItemProvider.dispose();
        if (pcmreResourceSignatureItemProvider != null) pcmreResourceSignatureItemProvider.dispose();
        if (pcmreResourceItemProvider != null) pcmreResourceItemProvider.dispose();
        if (pcmreResourceRoleItemProvider != null) pcmreResourceRoleItemProvider.dispose();
        if (pcmreciBehaviorItemProvider != null) pcmreciBehaviorItemProvider.dispose();
        if (pcmreInfrastructureInterfaceItemProvider != null) pcmreInfrastructureInterfaceItemProvider.dispose();
        if (pcmreInfrastructureRoleItemProvider != null) pcmreInfrastructureRoleItemProvider.dispose();
        if (pcmreInfrastructureSignatureItemProvider != null) pcmreInfrastructureSignatureItemProvider.dispose();
        if (pcmpeAllDecisionsItemProvider != null) pcmpeAllDecisionsItemProvider.dispose();
        if (pcmpeDecisionItemProvider != null) pcmpeDecisionItemProvider.dispose();
    }

}
