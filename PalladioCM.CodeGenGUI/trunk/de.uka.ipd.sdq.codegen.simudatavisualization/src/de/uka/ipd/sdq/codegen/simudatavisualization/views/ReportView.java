package de.uka.ipd.sdq.codegen.simudatavisualization.views;


import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.birt.chart.device.IDeviceRenderer;
import org.eclipse.birt.chart.exception.ChartException;
import org.eclipse.birt.chart.internal.log.DefaultLoggerImpl;
import org.eclipse.birt.chart.util.PluginSettings;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;

import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.Histogram;
import de.uka.ipd.sdq.codegen.simudatavisualization.birt.ChartVisualization;
import de.uka.ipd.sdq.codegen.simudatavisualization.editor.AbstractReportView;
import de.uka.ipd.sdq.codegen.simudatavisualization.jfreechart.JFreeChartHistogramViewer;
import de.uka.ipd.sdq.sensorframework.adapter.AdapterRegistry;
import de.uka.ipd.sdq.sensorframework.adapter.IAdapter;
import de.uka.ipd.sdq.sensorframework.visualisation.IVisualisation;

public class ReportView extends AbstractReportView implements
		ITabbedPropertySheetPageContributor,
		IVisualisation {

	public static String EDITOR_ID = "de.uka.ipd.sdq.codegen.simudatavisualization.views.ReportView";
	
	ChartVisualization visualization;

	JFreeChartHistogramViewer myViewer;
	
	public void createReportControls(Composite parent){
		IDeviceRenderer idr = null;
		final PluginSettings ps = PluginSettings.instance();
		try {
			idr = ps.getDevice("dv.SWT");
		} catch (ChartException pex) {
			DefaultLoggerImpl.instance().log(pex);
		}
	
		// create new chart
		visualization = new ChartVisualization();
		
		// render chart
		//new ChartSwtViewer(parent, 0, idr, visualization.getChart());
		myViewer = new JFreeChartHistogramViewer(parent,0);
	}

	/**
	 * @return the visualization
	 */
	public ChartVisualization getVisualization() {
		return visualization;
	}
	
	@Override
	public void addInput(Collection c) {
	}

	@Override
	public void deleteInput(Collection c) {
	}

	@Override
	public void setInput(Collection c) {
		ArrayList<IAdapter> adapters = new ArrayList<IAdapter>();
		for (Object o : c) {
			IAdapter adapter = AdapterRegistry.singleton().getAdapter(o,
					Histogram.class);
			if (adapter != null)
				adapters.add(adapter);
		}
		myViewer.setHistograms(adapters);
	}

}
