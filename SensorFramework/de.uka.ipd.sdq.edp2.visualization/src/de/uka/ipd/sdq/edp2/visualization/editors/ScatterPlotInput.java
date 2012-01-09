/**
 * 
 */
package de.uka.ipd.sdq.edp2.visualization.editors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.measure.Measure;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.views.properties.IPropertySource;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.DefaultXYItemRenderer;
import org.jfree.data.xy.DefaultXYDataset;

import de.uka.ipd.sdq.edp2.OrdinalMeasurementsDao;
import de.uka.ipd.sdq.edp2.impl.MeasurementsUtility;
import de.uka.ipd.sdq.edp2.impl.MetricDescriptionUtility;
import de.uka.ipd.sdq.edp2.models.ExperimentData.BaseMetricDescription;
import de.uka.ipd.sdq.edp2.models.ExperimentData.CaptureType;
import de.uka.ipd.sdq.edp2.models.ExperimentData.DataSeries;
import de.uka.ipd.sdq.edp2.models.ExperimentData.MetricDescription;
import de.uka.ipd.sdq.edp2.visualization.AbstractDataSource;
import de.uka.ipd.sdq.edp2.visualization.IDataSink;
import de.uka.ipd.sdq.edp2.visualization.properties.SpecificChartProperties;

/**
 * Input for {@link ScatterPlotEditor} .
 * 
 * @author Dominik Ernst, Roland Richter
 */
public class ScatterPlotInput extends JFreeChartEditorInput {

	/**
	 * Name constant, which is used to identify this class in properties.
	 */
	private static final String ELEMENT_NAME = "ScatterPlotInput";

	/**
	 * The default Title for newly created Plots.
	 */
	private static final String DEFAULT_TITLE = "ScatterPlot";

	/**
	 * Logger for this class.
	 */
	private final static Logger logger = Logger
			.getLogger(ScatterPlotInput.class.getCanonicalName());

	/**
	 * The data provided by this {@link JFreeChartEditorInput}
	 */
	private double[][] rawData;

	private NumberAxis domainAxis;

	private NumberAxis rangeAxis;

	private DefaultXYDataset dataset;

	private JFreeChart chart;

	private DefaultXYItemRenderer renderer;

	public ScatterPlotInput() {
		super();
		setTitle(DEFAULT_TITLE);
	}

	public ScatterPlotInput(AbstractDataSource source) {
		super(source);
		setTitle(DEFAULT_TITLE);
	}

	/**
	 * Retrieves actual measurements from repository and assigns them to the
	 * dataset. this dataset is used by the editor to display in the
	 * scatterplot.
	 */
	@SuppressWarnings("unchecked")
	public void updateDataset() {
		dataset = new DefaultXYDataset();
		logger.log(Level.INFO, "Editor input updateDataSet begin");
		ArrayList<OrdinalMeasurementsDao<Measure>> list = new ArrayList<OrdinalMeasurementsDao<Measure>>();
		for (DataSeries data : getSource().getOutput()) {
			list.add(MeasurementsUtility.getOrdinalMeasurementsDao(data));
		}
		OrdinalMeasurementsDao<Measure> omdSeries1 = MeasurementsUtility
				.getOrdinalMeasurementsDao(getSource().getOutput().get(0));
		OrdinalMeasurementsDao<Measure> omdSeries2 = MeasurementsUtility
				.getOrdinalMeasurementsDao(getSource().getOutput().get(1));
		List<Measure> list1 = omdSeries1.getMeasurements();

		List<Measure> list2 = omdSeries2.getMeasurements();
		
		rawData = new double[2][list1.size()];

		for (int i = 0; i < list1.size(); i++) {
				Measure x = list1.get(i);
				Measure y = list2.get(i);
				rawData[0][i] = x.doubleValue(x.getUnit());
				rawData[1][i] = y.doubleValue(y.getUnit());
			}
		
		dataset.addSeries(getTitle(), rawData);
		
		MetricDescription[] metrics = MetricDescriptionUtility
		.toBaseMetricDescriptions(getSource().getMeasurementsRange()
				.getMeasurements().getMeasure().getMetric());
		
		domainAxis = new NumberAxis(metrics[0].getName());
		rangeAxis = new NumberAxis(metrics[1].getName());

		/*
		 * setToolTipText(getSource().getMeasurementsRange().getMeasurements()
		 * .getMeasure().getMetric().getTextualDescription());
		 * 
		 * // label data series according to metric definitions
		 * MetricSetDescription md = (MetricSetDescription) getSource()
		 * .getOutput().get(0).getRawMeasurements().getMeasurementsRange()
		 * .getMeasurements().getMeasure().getMetric();
		 * 
		 * setLabelXScale(md.getSubsumedMetrics().get(0).getName() + " ( " +
		 * ((Measure) list1.get(0)).getUnit() + ")");
		 * setLabelYScale(md.getSubsumedMetrics().get(1).getName() + " ( " +
		 * ((Measure) list2.get(0)).getUnit() + ")");
		 */
		logger.log(Level.INFO, "Editor input updateDataSet end");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.uka.ipd.sdq.edp2.models.ExperimentData.presentation.IDataSink#canAccept
	 * (de.uka.ipd.sdq.edp2.models.ExperimentData.presentation.IDataSource)
	 */
	@Override
	public boolean canAccept(AbstractDataSource source) {
		BaseMetricDescription[] mds = MetricDescriptionUtility
				.toBaseMetricDescriptions(source.getOutput().get(0)
						.getRawMeasurements().getMeasurementsRange()
						.getMeasurements().getMeasure().getMetric());
		boolean allDataNumeric = true;
		for (BaseMetricDescription md : mds) {
			if (!(md.getCaptureType().equals(CaptureType.INTEGER_NUMBER) || md
					.getCaptureType().equals(CaptureType.REAL_NUMBER))) {
				allDataNumeric = false;
			}
		}
		return allDataNumeric && source.getOutput().size() == 2;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seede.uka.ipd.sdq.edp2.models.ExperimentData.presentation.IDataSink#
	 * getMetricRoles()
	 */
	@Override
	public ArrayList<MetricDescription> getMetricRoles() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IPersistableElement#getFactoryId()
	 */
	@Override
	public String getFactoryId() {
		// TODO Auto-generated method stub
		return ScatterPlotInputFactory.getFactoryId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IPersistable#saveState(org.eclipse.ui.IMemento)
	 */
	@Override
	public void saveState(IMemento memento) {
		ScatterPlotInputFactory.saveState(memento, this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
	 */
	@Override
	public Object getAdapter(Class adapter) {
		if (adapter == IPropertySource.class) {
			return this;
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
		updateDataset();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.ISelection#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.edp2.visualization.IDataFlow#getProperties()
	 */
	@Override
	public HashMap<String, Object> getProperties() {
		properties.put(ELEMENT_KEY, ELEMENT_NAME);
		return properties;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.uka.ipd.sdq.edp2.visualization.IDataFlow#setProperties(java.util.HashMap
	 * )
	 */
	@Override
	public void setProperties(HashMap<String, Object> newProperties) {
	}

	@Override
	public SpecificChartProperties getChartProperties() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DefaultXYDataset getDataTypeInstance() {
		return dataset;
	}


	@Override
	public JFreeChart getChart() {
		updateDataset();
		XYPlot plot = new XYPlot();
		plot.setDataset(dataset);
		renderer = new DefaultXYItemRenderer();
		plot.setRenderer(renderer);
		plot.setRangeAxis(rangeAxis);
		plot.setDomainAxis(domainAxis);
		chart = new JFreeChart(getName(),
				JFreeChart.DEFAULT_TITLE_FONT, plot, true);
		return chart;
	}

	@Override
	public double[][] getData() {
		return rawData;
	}

	@Override
	public IDataSink createCopyForSource(AbstractDataSource source) {
		ScatterPlotInput copy = new ScatterPlotInput();
		copy.setProperties(this.getProperties());
		copy.setSource(source);
		return null;
	}

	@Override
	public Composite getSpecificPropertiesComposite(Composite parent) {
		// TODO Auto-generated method stub
		return null;
	}

}
