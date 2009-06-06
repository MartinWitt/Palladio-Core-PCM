package de.uka.ipd.sdq.workflow.mdsd.oaw;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.openarchitectureware.workflow.WorkflowContext;
import org.openarchitectureware.workflow.WorkflowContextDefaultImpl;
import org.openarchitectureware.workflow.issues.Issues;
import org.openarchitectureware.workflow.issues.IssuesImpl;
import org.openarchitectureware.workflow.lib.AbstractWorkflowComponent2;
import org.openarchitectureware.workflow.util.ProgressMonitorAdapter;

import de.uka.ipd.sdq.workflow.IJob;
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.RollbackFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;

/**
 * This class allows the use of jobs of the openArchitectureWare workflow engine as part of the SDQ workflow engine
 * 
 * @author Steffen Becker
 *
 * @param <T> The class of the oAW job bridged by an specific instance of this class
 */
public abstract class AbstractOAWWorkflowJobBridge<T extends AbstractWorkflowComponent2>
implements IJob {

	private Logger logger = Logger.getLogger(AbstractOAWWorkflowJobBridge.class);
	
	protected T oawJob = null;
	private HashMap<String, EObject> slotContents;
	
	/**
	 * Constructor of the oAW bridge
	 * @param job The oAW job to wrap for execution in the SDQ workflow engine
	 */
	public AbstractOAWWorkflowJobBridge(T job) {
		this(job,new HashMap<String, EObject>());
	}
	
	/** Constructor of the oAW bridge
	 * @param job The oAW job to wrap for execution in the SDQ workflow engine
	 * @param slotContents Contains models of the oAW workflow engine's blackboard, i.e., models to be transformed
	 * by the encapsulated oAW job
	 */
	public AbstractOAWWorkflowJobBridge(T job,
			HashMap<String, EObject> slotContents) {
		super();
		
		this.oawJob = job;
		this.slotContents = slotContents;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.workflow.IJob#execute(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void execute(IProgressMonitor monitor) throws JobFailedException,
			UserCanceledException {
		Issues issues = new IssuesImpl();
		WorkflowContext ctx = new WorkflowContextDefaultImpl();
		setupContext(ctx);
		
		try {
			setupOAWJob(oawJob);
			
			logger.info("Validating oAW configuration settings...");
			oawJob.checkConfiguration(issues);
			if (issues.hasErrors()) {
				String message = issues.toString();
				throw new JobFailedException("oAW Job configuration is invalid: "+message);
			}
			
			logger.info("Running oAW task....");
			oawJob.invoke(ctx, new ProgressMonitorAdapter(monitor), issues);
			if (issues.hasErrors())
				throw new JobFailedException("oAW Job failed");	
		} catch(Exception e) {
			throw new JobFailedException("oAW Failed",e);
		}
	}

	/**
	 * Creates the oAW job's {@link WorkflowContext}
	 * @param ctx The context to configure. Add all the models needed by the oAW job
	 */
	protected void setupContext(WorkflowContext ctx) {
		for (String slot : slotContents.keySet()) {
			ctx.set(slot, slotContents.get(slot));
		}
	}

	/** 
	 * Template method in which hiers can add logic to configure their specific oAW jobs 
	 * @param oawJob2 The job to be set up
	 */
	protected abstract void setupOAWJob(T oawJob2);

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.workflow.IJob#getName()
	 */
	public String getName() {
		return oawJob.getId() == null ? "oAW Job" : oawJob.getId();
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.workflow.IJob#rollback(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void rollback(IProgressMonitor monitor)
			throws RollbackFailedException {
	}

}
