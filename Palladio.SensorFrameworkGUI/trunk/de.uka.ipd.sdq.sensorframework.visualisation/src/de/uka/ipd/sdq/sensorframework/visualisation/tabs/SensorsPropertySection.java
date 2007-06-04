/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.visualisation.tabs;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.DialogCellEditor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import de.uka.ipd.sdq.sensorfactory.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorfactory.entities.Sensor;
import de.uka.ipd.sdq.sensorfactory.entities.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorframework.visualisation.IVisualisation;
import de.uka.ipd.sdq.sensorframework.visualisation.SimuImages;
import de.uka.ipd.sdq.sensorframework.visualisation.SimuPlugin;
import de.uka.ipd.sdq.sensorframework.visualisation.dialogs.ExperimentRunsDialog;
import de.uka.ipd.sdq.sensorframework.visualisation.dialogs.SensorsDialog;
import de.uka.ipd.sdq.sensorframework.visualisation.editor.AbstractReportView;
import de.uka.ipd.sdq.sensorframework.visualisation.editor.ConfigEditorInput;
import de.uka.ipd.sdq.sensorframework.visualisation.editor.ConfigEntry;
import de.uka.ipd.sdq.sensorframework.visualisation.views.TreeObject;

/**
 * @author admin
 * 
 */
public class SensorsPropertySection extends AbstractPropertySection implements
		Observer {

	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(Observable subject, Object signal) {
		if (subject instanceof ConfigEditorInput) {
			ConfigEditorInput input = (ConfigEditorInput) subject;
			refresh();
			if (!input.isEmpty())
				updateButton.setEnabled(true);
			else
				updateButton.setEnabled(false);
		}
	}

	private ConfigEditorInput configObject;
	private ConfigEntry selectedEntry;
	private TableViewer viewer;
	private Button updateButton;
	private ToolItem deleteRunItem;

	public static final int ICON_COLUMN_INDEX = 0;
	public static final int CONTEXT_COLUMN_INDEX = 1;
	public static final int RUN_COLUMN_INDEX = 2;
	public static final int SENSORS_COLUMN_INDEX = 3;

	/**
	 * Columns of a table, which is used into ParameterEditDialog
	 */

	public final static String ICON_COLUMN = "";
	public final static String CONTEXT_COLUMN = "Context";
	public final static String RUN_COLUMN = "Experiment Datetime";
	public final static String SENSORS_COLUMN = "Sensors";

	// Set column names of Tabele
	protected static String[] columnNames = new String[] { ICON_COLUMN,
			CONTEXT_COLUMN, RUN_COLUMN, SENSORS_COLUMN };

	// style the style of table to construct
	int style = SWT.SINGLE | SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL
			| SWT.FULL_SELECTION | SWT.HIDE_SELECTION;

	/* (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#createControls(org.eclipse.swt.widgets.Composite,
	 *      org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage)
	 */
	@Override
	public void createControls(Composite parent,
			TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);

		Composite composite = getWidgetFactory()
				.createFlatFormComposite(parent);
		composite.setLayout(new FormLayout());

		/**
		 * Create the cell editors for Name, Type column
		 */
		CellEditor[] editors = new CellEditor[columnNames.length];

		Table table = new Table(composite, style);
		final FormData fd_table = new FormData();
		fd_table.bottom = new FormAttachment(0, 120);
		fd_table.left = new FormAttachment(0, 5);
		fd_table.top = new FormAttachment(0, 4);
		table.setLayoutData(fd_table);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);

		viewer = new TableViewer(table);

		viewer.setColumnProperties(columnNames);
		viewer.setContentProvider(new SensorsTabContentProvider());
		viewer.setLabelProvider(new SensorsTabLabelProvider());
		viewer.setCellModifier(new SensorsCellModifier());
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				Object object = ((IStructuredSelection) viewer.getSelection())
						.getFirstElement();
				selectedEntry = (ConfigEntry) object;
				
				if (selectedEntry != null)
					deleteRunItem.setEnabled(true);
				else deleteRunItem.setEnabled(false);
			}
		});
		editors[SENSORS_COLUMN_INDEX] = new DialogCellEditor(table) {

			protected Object openDialogBox(Control cellEditorWindow) {
				SensorsDialog dialog = new SensorsDialog(cellEditorWindow
						.getShell(), selectedEntry);

				if (dialog.open() == dialog.OK)
					viewer.refresh();

				if (!selectedEntry.getSensors().isEmpty())
					updateButton.setEnabled(true);
				else
					updateButton.setEnabled(false);

				return null;
			}
		};
		// Assign the cell editors to the viewer
		viewer.setCellEditors(editors);
		
		// Definere the table columns
		final TableColumn zeroColumn = new TableColumn(table, SWT.NONE);
		zeroColumn.setResizable(false);
		zeroColumn.setWidth(30);

		final TableColumn contextColumn = new TableColumn(table, SWT.NONE);
		contextColumn.setWidth(100);
		contextColumn.setText(CONTEXT_COLUMN);

		final TableColumn runColumn = new TableColumn(table, SWT.NONE);
		runColumn.setWidth(140);
		runColumn.setText(RUN_COLUMN);

		final TableColumn sensorsColumn = new TableColumn(table, SWT.NONE);
		sensorsColumn.setWidth(200);
		sensorsColumn.setText(SENSORS_COLUMN);

		ToolBar toolBar = new ToolBar(composite, SWT.VERTICAL | SWT.FLAT | SWT.RIGHT);
		fd_table.right = new FormAttachment(toolBar, -5, SWT.LEFT);
		final FormData fd_toolBar = new FormData();
		fd_toolBar.left = new FormAttachment(100, -32);
		fd_toolBar.bottom = new FormAttachment(0, 120);
		fd_toolBar.right = new FormAttachment(100, -6);
		fd_toolBar.top = new FormAttachment(0, 4);
		toolBar.setLayoutData(fd_toolBar);

		ToolItem addRunItem = new ToolItem(toolBar, SWT.PUSH);
		addRunItem.setImage(SimuImages.imageRegistry.get(SimuImages.ADD));
		addRunItem.addSelectionListener(new SelectionAdapter() {
		
			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				ExperimentRunsDialog dialog = new ExperimentRunsDialog(
						e.display.getActiveShell());
				if (dialog.open() == Window.OK && dialog.getResult() != null) {
					TreeObject object = dialog.getResult();
					configObject.addNewConfigEntry(
							(ExperimentRun) object.getObject(), object
									.getExperiment());
					viewer.refresh();
				}
			}
		});

		deleteRunItem = new ToolItem(toolBar, SWT.PUSH);
		deleteRunItem.setImage(SimuImages.imageRegistry.get(SimuImages.DELETE));
		deleteRunItem.addSelectionListener(new SelectionAdapter(){

			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				configObject.removeConfigEntry(selectedEntry);
			}
			
		});
		deleteRunItem.setEnabled(false);

		updateButton = new Button(composite, SWT.NONE);
		final FormData fd_updateButton = new FormData();
		fd_updateButton.right = new FormAttachment(0, 95);
		fd_updateButton.top = new FormAttachment(table, 5, SWT.BOTTOM);
		fd_updateButton.left = new FormAttachment(table, 0, SWT.LEFT);
		updateButton.setLayoutData(fd_updateButton);
		updateButton.setText("Update Chart");
		updateButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				EditorPart editor = (EditorPart) SimuPlugin.getDefault()
						.getWorkbench().getActiveWorkbenchWindow()
						.getActivePage().getActiveEditor();
				// ((ReportView) editor).getVisualization().initChart();
				ArrayList<SensorAndMeasurements> list = new ArrayList<SensorAndMeasurements>();
				IVisualisation vis = (IVisualisation) editor;

				for (ConfigEntry re : configObject.getConfigEntrys()) {
					for (Sensor s : re.getSensors()) {
						try {
							list.add(re.getExperimentRun()
									.getMeasurementsOfSensor(s));
						} catch (Exception e1) {
							showMessage(s.getSensorName(),
									"Missing the Measurements of sensor!");
						}
					}
				}

				vis.setInput(list);
			}
		});
		
		updateButton.setEnabled(false);

		/** set Observer to the ConfigObject */
		AbstractReportView view = (AbstractReportView) SimuPlugin.getDefault()
				.getWorkbench().getActiveWorkbenchWindow().getActivePage()
				.getActiveEditor();
		configObject = (ConfigEditorInput) view.getEditorInput();
		configObject.addObserver(this);
		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#getSelection()
	 */
	@Override
	public ISelection getSelection() {
		// TODO Auto-generated method stub
		return super.getSelection();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#refresh()
	 */
	@Override
	public void refresh() {
		viewer.refresh();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#setInput(org.eclipse.ui.IWorkbenchPart,
	 *      org.eclipse.jface.viewers.ISelection)
	 */
	@Override
	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);

		if (part instanceof AbstractReportView) {
			AbstractReportView view = (AbstractReportView) part;
			configObject = (ConfigEditorInput) view.getEditorInput();
			viewer.setInput(configObject);
		}
	}

	public Button getUpdateButton() {
		return updateButton;
	}
	
	/** show exeption message */
	private void showMessage(String title, String message) {
		MessageDialog.openInformation(viewer.getControl().getShell(), title,
				message);
	}
}
