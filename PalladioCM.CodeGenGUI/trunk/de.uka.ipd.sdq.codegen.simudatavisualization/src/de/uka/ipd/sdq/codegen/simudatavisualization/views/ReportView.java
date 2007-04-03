package de.uka.ipd.sdq.codegen.simudatavisualization.views;

import java.util.Collection;

import org.eclipse.birt.chart.device.IDeviceRenderer;
import org.eclipse.birt.chart.exception.ChartException;
import org.eclipse.birt.chart.internal.log.DefaultLoggerImpl;
import org.eclipse.birt.chart.util.PluginSettings;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorInputTransfer;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.Histogram;
import de.uka.ipd.sdq.codegen.simudatavisualization.actions.ChartSwtViewer;
import de.uka.ipd.sdq.codegen.simudatavisualization.birt.ChartVisualization;
import de.uka.ipd.sdq.codegen.simudatavisualization.birt.RunEntry;
import de.uka.ipd.sdq.codegen.simudatavisualization.jfreechart.JFreeChartHistogramViewer;
import de.uka.ipd.sdq.sensorfactory.entities.Sensor;
import de.uka.ipd.sdq.sensorframework.adapter.AdapterRegistry;
import de.uka.ipd.sdq.sensorframework.adapter.IAdapter;
import de.uka.ipd.sdq.sensorframework.visualisation.IVisualisation;
import java.util.ArrayList;
public class ReportView extends EditorPart implements
		ITabbedPropertySheetPageContributor,
		IVisualisation {
	
	public static String EDITOR_ID = "de.uka.ipd.sdq.codegen.simudatavisualization.views.ReportView";

	private ChartVisualization visualization;

	private JFreeChartHistogramViewer myViewer;
	

	@Override
	public void createPartControl(Composite parent) {
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

		getSite().setSelectionProvider(new ISelectionProvider() {

			@Override
			public void addSelectionChangedListener(
					ISelectionChangedListener listener) {
			}

			@Override
			public ISelection getSelection() {
				return new StructuredSelection(this);
			}

			@Override
			public void removeSelectionChangedListener(
					ISelectionChangedListener listener) {
			}

			@Override
			public void setSelection(ISelection selection) {
				// TODO Auto-generated method stub

			}
		});
		
		addDropSupport(parent);
	}
	
	private void addDropSupport(Control control) {
	
		int operations = DND.DROP_COPY | DND.DROP_DEFAULT;
		DropTarget target = new DropTarget(control, operations);
		
		Transfer[] transferTypes = new Transfer[] {EditorInputTransfer.getInstance()};
		target.setTransfer(transferTypes);
		target.addDropListener(new ViewDropTargetListener());
	}
	
	@Override
	public Object getAdapter(Class adapter) {
		if (adapter == IPropertySheetPage.class)
			return new TabbedPropertySheetPage(this);
		return super.getAdapter(adapter);
	}

	@Override
	public String getContributorId() {
		return getSite().getId();
	}

	/**
	 * @return the visualization
	 */
	public ChartVisualization getVisualization() {
		return visualization;
	}

	@Override
	public void setFocus() {
	}
	
	@Override
	public void doSave(IProgressMonitor monitor) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void doSaveAs() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void init(IEditorSite site, IEditorInput input)
	throws PartInitException {
		setSite(site);
		setInput(input);
	}
	
	@Override
	public boolean isDirty() {
		return false;
	}
	
	@Override
	public boolean isSaveAsAllowed() {
		return false;
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
		for(Object o: c)
		{
			IAdapter adapter = AdapterRegistry.singleton().getAdapter(o, Histogram.class);
			if (adapter != null)
				adapters.add(adapter);
		}
		myViewer.setHistograms(adapters);
	}
}
