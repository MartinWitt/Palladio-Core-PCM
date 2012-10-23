package de.uka.ipd.sdq.pcmbench.tabs.connectors;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyEventConnector;
import de.uka.ipd.sdq.pcm.core.composition.Connector;
import de.uka.ipd.sdq.pcm.core.composition.EventChannelSinkConnector;
import de.uka.ipd.sdq.pcmbench.tabs.generic.SelectionChangedListener;

public class EventFilterDeleteActionListener extends SelectionChangedListener implements SelectionListener {

	/**
	 * The transactional editing domain which is used to get the commands and
	 * alter the model
	 */
	private Connector selectedConnector;
	private TransactionalEditingDomain editingDomain = null;


	/* (non-Javadoc)
	 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	public void widgetSelected(SelectionEvent e) {
		Assert.isNotNull(selectedConnector);
		editingDomain = TransactionUtil.getEditingDomain(selectedConnector);

		
		RecordingCommand recCommand = new RecordingCommand(editingDomain) {
			@Override
			protected void doExecute() {
				if (selectedConnector instanceof EventChannelSinkConnector){
					((EventChannelSinkConnector) selectedConnector).setFilterCondition__EventChannelSinkConnector(null);
				}
				if (selectedConnector instanceof AssemblyEventConnector){
					((AssemblyEventConnector) selectedConnector).setFilterCondition__AssemblyEventConnector(null);
				}
			}
		};

		recCommand.setDescription("Delete ...");
		editingDomain.getCommandStack().execute(recCommand);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.swt.events.SelectionListener#widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	public void widgetDefaultSelected(SelectionEvent e) {
		// The implementation is not necessary.
	}
	
	/**
	 * @param selectedConnector The connector containing the filtercondition that should be set
	 */
	public void setSelectedConnector(Connector selectedConnector) {
		this.selectedConnector = selectedConnector;
	}
}
