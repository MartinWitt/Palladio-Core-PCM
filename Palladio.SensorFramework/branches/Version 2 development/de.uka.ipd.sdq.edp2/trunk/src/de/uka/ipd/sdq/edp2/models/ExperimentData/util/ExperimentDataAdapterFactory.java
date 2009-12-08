/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.ExperimentData.util;

import de.uka.ipd.sdq.edp2.models.ExperimentData.*;

import java.util.Map;

import javax.measure.quantity.Duration;
import javax.measure.quantity.Quantity;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage
 * @generated
 */
public class ExperimentDataAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ExperimentDataPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExperimentDataAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ExperimentDataPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExperimentDataSwitch<Adapter> modelSwitch =
		new ExperimentDataSwitch<Adapter>() {
			@Override
			public Adapter caseAggregatedMeasurements(AggregatedMeasurements object) {
				return createAggregatedMeasurementsAdapter();
			}
			@Override
			public Adapter caseIdentifiable(Identifiable object) {
				return createIdentifiableAdapter();
			}
			@Override
			public Adapter caseMeasurementsRange(MeasurementsRange object) {
				return createMeasurementsRangeAdapter();
			}
			@Override
			public Adapter casePropertyable(Propertyable object) {
				return createPropertyableAdapter();
			}
			@Override
			public Adapter caseEStringtoEObjectMapEntry(Map.Entry<String, Object> object) {
				return createEStringtoEObjectMapEntryAdapter();
			}
			@Override
			public Adapter caseRawMeasurements(RawMeasurements object) {
				return createRawMeasurementsAdapter();
			}
			@Override
			public Adapter caseDataSeries(DataSeries object) {
				return createDataSeriesAdapter();
			}
			@Override
			public Adapter caseNominalStatistics(NominalStatistics object) {
				return createNominalStatisticsAdapter();
			}
			@Override
			public Adapter caseFixedWidthAggregatedMeasurements(FixedWidthAggregatedMeasurements object) {
				return createFixedWidthAggregatedMeasurementsAdapter();
			}
			@Override
			public Adapter caseFixedIntervals(FixedIntervals object) {
				return createFixedIntervalsAdapter();
			}
			@Override
			public Adapter caseMeasurements(Measurements object) {
				return createMeasurementsAdapter();
			}
			@Override
			public Adapter caseEdp2Measure(Edp2Measure object) {
				return createEdp2MeasureAdapter();
			}
			@Override
			public Adapter caseExperimentGroup(ExperimentGroup object) {
				return createExperimentGroupAdapter();
			}
			@Override
			public Adapter caseExperimentSetting(ExperimentSetting object) {
				return createExperimentSettingAdapter();
			}
			@Override
			public Adapter caseExperimentRun(ExperimentRun object) {
				return createExperimentRunAdapter();
			}
			@Override
			public Adapter caseDescription(Description object) {
				return createDescriptionAdapter();
			}
			@Override
			public Adapter caseMetricDescription(MetricDescription object) {
				return createMetricDescriptionAdapter();
			}
			@Override
			public Adapter caseAggregationFunctionDescription(AggregationFunctionDescription object) {
				return createAggregationFunctionDescriptionAdapter();
			}
			@Override
			public Adapter caseAggregationStatistics(AggregationStatistics object) {
				return createAggregationStatisticsAdapter();
			}
			@Override
			public Adapter caseBaseMetricDescription(BaseMetricDescription object) {
				return createBaseMetricDescriptionAdapter();
			}
			@Override
			public Adapter caseCategoryIdentifier(CategoryIdentifier object) {
				return createCategoryIdentifierAdapter();
			}
			@Override
			public Adapter caseDescriptions(Descriptions object) {
				return createDescriptionsAdapter();
			}
			@Override
			public Adapter caseDoubleBinaryMeasurements(DoubleBinaryMeasurements object) {
				return createDoubleBinaryMeasurementsAdapter();
			}
			@Override
			public Adapter caseIntervalStatistics(IntervalStatistics object) {
				return createIntervalStatisticsAdapter();
			}
			@Override
			public Adapter caseOrdinalStatistics(OrdinalStatistics object) {
				return createOrdinalStatisticsAdapter();
			}
			@Override
			public Adapter casePercentile(Percentile object) {
				return createPercentileAdapter();
			}
			@Override
			public Adapter caseJSXmlMeasurements(JSXmlMeasurements object) {
				return createJSXmlMeasurementsAdapter();
			}
			@Override
			public Adapter caseLongBinaryMeasurements(LongBinaryMeasurements object) {
				return createLongBinaryMeasurementsAdapter();
			}
			@Override
			public Adapter caseMetricSetDescription(MetricSetDescription object) {
				return createMetricSetDescriptionAdapter();
			}
			@Override
			public Adapter caseNominalMeasure(NominalMeasure object) {
				return createNominalMeasureAdapter();
			}
			@Override
			public Adapter caseNominalMeasurements(NominalMeasurements object) {
				return createNominalMeasurementsAdapter();
			}
			@Override
			public Adapter caseObservedCategory(ObservedCategory object) {
				return createObservedCategoryAdapter();
			}
			@Override
			public Adapter caseObservedNominalMeasurements(ObservedNominalMeasurements object) {
				return createObservedNominalMeasurementsAdapter();
			}
			@Override
			public Adapter caseOrdinalMeasure(OrdinalMeasure object) {
				return createOrdinalMeasureAdapter();
			}
			@Override
			public Adapter caseRatioStatistics(RatioStatistics object) {
				return createRatioStatisticsAdapter();
			}
			@Override
			public Adapter caseSensorFrameworkV1DoubleBinaryMeasurements(SensorFrameworkV1DoubleBinaryMeasurements object) {
				return createSensorFrameworkV1DoubleBinaryMeasurementsAdapter();
			}
			@Override
			public Adapter caseSensorFrameworkV1NominalMeasurements(SensorFrameworkV1NominalMeasurements object) {
				return createSensorFrameworkV1NominalMeasurementsAdapter();
			}
			@Override
			public Adapter caseIJSDuration(Duration object) {
				return createIJSDurationAdapter();
			}
			@Override
			public Adapter caseIJSQuantity(Quantity object) {
				return createIJSQuantityAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.AggregatedMeasurements <em>Aggregated Measurements</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.AggregatedMeasurements
	 * @generated
	 */
	public Adapter createAggregatedMeasurementsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.Identifiable <em>Identifiable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.Identifiable
	 * @generated
	 */
	public Adapter createIdentifiableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.MeasurementsRange <em>Measurements Range</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.MeasurementsRange
	 * @generated
	 */
	public Adapter createMeasurementsRangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.Propertyable <em>Propertyable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.Propertyable
	 * @generated
	 */
	public Adapter createPropertyableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>EStringto EObject Map Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createEStringtoEObjectMapEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.RawMeasurements <em>Raw Measurements</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.RawMeasurements
	 * @generated
	 */
	public Adapter createRawMeasurementsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.DataSeries <em>Data Series</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.DataSeries
	 * @generated
	 */
	public Adapter createDataSeriesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.NominalStatistics <em>Nominal Statistics</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.NominalStatistics
	 * @generated
	 */
	public Adapter createNominalStatisticsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.FixedWidthAggregatedMeasurements <em>Fixed Width Aggregated Measurements</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.FixedWidthAggregatedMeasurements
	 * @generated
	 */
	public Adapter createFixedWidthAggregatedMeasurementsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.FixedIntervals <em>Fixed Intervals</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.FixedIntervals
	 * @generated
	 */
	public Adapter createFixedIntervalsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.Measurements <em>Measurements</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.Measurements
	 * @generated
	 */
	public Adapter createMeasurementsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.Edp2Measure <em>Edp2 Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.Edp2Measure
	 * @generated
	 */
	public Adapter createEdp2MeasureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentGroup <em>Experiment Group</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentGroup
	 * @generated
	 */
	public Adapter createExperimentGroupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentSetting <em>Experiment Setting</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentSetting
	 * @generated
	 */
	public Adapter createExperimentSettingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentRun <em>Experiment Run</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentRun
	 * @generated
	 */
	public Adapter createExperimentRunAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.Description <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.Description
	 * @generated
	 */
	public Adapter createDescriptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.MetricDescription <em>Metric Description</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.MetricDescription
	 * @generated
	 */
	public Adapter createMetricDescriptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.AggregationFunctionDescription <em>Aggregation Function Description</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.AggregationFunctionDescription
	 * @generated
	 */
	public Adapter createAggregationFunctionDescriptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.AggregationStatistics <em>Aggregation Statistics</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.AggregationStatistics
	 * @generated
	 */
	public Adapter createAggregationStatisticsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.BaseMetricDescription <em>Base Metric Description</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.BaseMetricDescription
	 * @generated
	 */
	public Adapter createBaseMetricDescriptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.CategoryIdentifier <em>Category Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.CategoryIdentifier
	 * @generated
	 */
	public Adapter createCategoryIdentifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.Descriptions <em>Descriptions</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.Descriptions
	 * @generated
	 */
	public Adapter createDescriptionsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.DoubleBinaryMeasurements <em>Double Binary Measurements</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.DoubleBinaryMeasurements
	 * @generated
	 */
	public Adapter createDoubleBinaryMeasurementsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.IntervalStatistics <em>Interval Statistics</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.IntervalStatistics
	 * @generated
	 */
	public Adapter createIntervalStatisticsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.OrdinalStatistics <em>Ordinal Statistics</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.OrdinalStatistics
	 * @generated
	 */
	public Adapter createOrdinalStatisticsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.Percentile <em>Percentile</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.Percentile
	 * @generated
	 */
	public Adapter createPercentileAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.JSXmlMeasurements <em>JS Xml Measurements</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.JSXmlMeasurements
	 * @generated
	 */
	public Adapter createJSXmlMeasurementsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.LongBinaryMeasurements <em>Long Binary Measurements</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.LongBinaryMeasurements
	 * @generated
	 */
	public Adapter createLongBinaryMeasurementsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.MetricSetDescription <em>Metric Set Description</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.MetricSetDescription
	 * @generated
	 */
	public Adapter createMetricSetDescriptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.NominalMeasure <em>Nominal Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.NominalMeasure
	 * @generated
	 */
	public Adapter createNominalMeasureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.NominalMeasurements <em>Nominal Measurements</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.NominalMeasurements
	 * @generated
	 */
	public Adapter createNominalMeasurementsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.ObservedCategory <em>Observed Category</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ObservedCategory
	 * @generated
	 */
	public Adapter createObservedCategoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.ObservedNominalMeasurements <em>Observed Nominal Measurements</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ObservedNominalMeasurements
	 * @generated
	 */
	public Adapter createObservedNominalMeasurementsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.OrdinalMeasure <em>Ordinal Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.OrdinalMeasure
	 * @generated
	 */
	public Adapter createOrdinalMeasureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.RatioStatistics <em>Ratio Statistics</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.RatioStatistics
	 * @generated
	 */
	public Adapter createRatioStatisticsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.SensorFrameworkV1DoubleBinaryMeasurements <em>Sensor Framework V1 Double Binary Measurements</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.SensorFrameworkV1DoubleBinaryMeasurements
	 * @generated
	 */
	public Adapter createSensorFrameworkV1DoubleBinaryMeasurementsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.SensorFrameworkV1NominalMeasurements <em>Sensor Framework V1 Nominal Measurements</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.SensorFrameworkV1NominalMeasurements
	 * @generated
	 */
	public Adapter createSensorFrameworkV1NominalMeasurementsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link javax.measure.quantity.Duration <em>IJS Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see javax.measure.quantity.Duration
	 * @generated
	 */
	public Adapter createIJSDurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link javax.measure.quantity.Quantity <em>IJS Quantity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see javax.measure.quantity.Quantity
	 * @generated
	 */
	public Adapter createIJSQuantityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ExperimentDataAdapterFactory