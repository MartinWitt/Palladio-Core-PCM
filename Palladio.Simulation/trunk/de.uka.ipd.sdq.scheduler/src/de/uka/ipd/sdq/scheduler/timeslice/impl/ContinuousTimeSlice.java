package de.uka.ipd.sdq.scheduler.timeslice.impl;

import de.uka.ipd.sdq.probfunction.math.util.MathTools;
import de.uka.ipd.sdq.scheduler.timeslice.ITimeSlice;


public class ContinuousTimeSlice implements ITimeSlice {
	
	protected double remaining_time;
	protected double timeslice;
	
	protected double part;
	protected double remaining_part;
	
	public ContinuousTimeSlice(double timeslice, int granularity) {
		super();
		this.timeslice = timeslice;
		this.part = timeslice / granularity;
		this.remaining_time = 0;
		this.remaining_part = 0;
	}
	
	protected ContinuousTimeSlice(){
		this.timeslice = 0;
		this.part = 0;
		this.remaining_time = 0;
		this.remaining_part = 0;
	}

	@Override
	public double getTimeUntilNextInterruption() {
		return remaining_part;
	}

	@Override
	public boolean completelyFinished() {
		return MathTools.equalsDouble(remaining_time, 0.0);
	}
	
	@Override
	public boolean partFinished() {
		return MathTools.equalsDouble(remaining_part, 0.0);
	}

	public void substractTime(double time) {
		remaining_time -= time;
		remaining_part -= time;
		assert MathTools.lessOrEqual(0.0, remaining_time) : "Timeslice exceeded: " + remaining_time;
		assert MathTools.lessOrEqual(0.0, remaining_part) : "Part exceeded: " + remaining_part;
	}

	@Override
	public void reset() {
		remaining_part = part;
		if ( MathTools.equalsDouble( remaining_time, 0.0) )
			remaining_time = timeslice;
		if (remaining_part > remaining_time)
			remaining_time = remaining_part;
	}

	@Override
	public void fullReset() {
		remaining_time = timeslice;
		remaining_part = part;
	}

	@Override
	public double getRemainingTime() {
		return remaining_time;
	}

	@Override
	public void punish(int penalty) {
		double time = Math.min(penalty, remaining_time);
		substractTime(time);
	}

//	@Override
//	public void subTimeProcessing(double time) {
//		substractTime(time);
//	}
//
//	@Override
//	public void subTimeScheduling(double time) {
//		substractTime(time);
//	}

	@Override
	public void setExpired() {
		this.remaining_part = 0;
		this.remaining_time = 0;
		
	}

//	@Override
//	public void setTo(double d) {
//		remaining_part = d;
//		remaining_time = d;
//	}
//
//	@Override
//	public double getRemainingQuantumTime() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public void resetQuantum() {
//		// TODO Auto-generated method stub
//		
//	}

	@Override
	public void quantumFinished() {
		// TODO Auto-generated method stub
		
	}
}