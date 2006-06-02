/**
 * 
 */
package de.uka.ipd.sdq.simucom.usage;

import java.util.ArrayList;

import DerivedContext.Context;
import DerivedContext.DerivedContextFactory;
import de.uka.ipd.sdq.simucom.SimuComModel;
import desmoj.core.simulator.Model;
import desmoj.core.simulator.SimProcess;

/**
 * @author Snowball
 *
 */
public class OpenWorkloadPlayer 
extends SimProcess
{
	private ArrayList<OpenWorkloadPlayerObserver> myObservers = new ArrayList<OpenWorkloadPlayerObserver>();
	private double timeConsumed = 0;
	
	/**
	 * @param owner
	 * @param name
	 * @param showInTrace
	 */
	public OpenWorkloadPlayer(Model owner, String name, boolean showInTrace) {
		super(owner, name, showInTrace);
		// TODO: Fix hardcoded bounds	
	}

	public void addPlayerFinishedObserver(OpenWorkloadPlayerObserver o)
	{
		this.myObservers.add(o);
	}
	
	/* (non-Javadoc)
	 * @see desmoj.core.simulator.SimProcess#lifeCycle()
	 */
	@Override
	public void lifeCycle() {
		double activityStart = this.currentTime().getTimeValue();
		SystemPackage.System system = ((SimuComModel)getModel()).getSystem();
		
		Context callContext = DerivedContextFactory.eINSTANCE.createContext();
		callContext.setSystem(system);
		
		timeConsumed = this.currentTime().getTimeValue()-activityStart;
		for (OpenWorkloadPlayerObserver o : myObservers)
		{
			o.playFinished(timeConsumed);
		}
	}
}