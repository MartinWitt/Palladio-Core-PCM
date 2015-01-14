package org.palladiosimulator.protocom.framework.java.ee.experiment;

import java.util.Stack;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.palladiosimulator.protocom.framework.java.ee.prototype.ICallVisitor;

/**
 *
 * @author Christian Klaussner
 */
class StartTime {
	private String id;
	private long time;

	public StartTime(String id, long time) {
		this.id = id;
		this.time = time;
	}

	public String getId() {
		return id;
	}

	public long getTime() {
		return time;
	}
}

/**
 *
 * @author Christian Klaussner
 */
@Singleton
public final class ExperimentVisitor implements ICallVisitor {
	public ExperimentVisitor() {
	}
	
	@Inject
	private IExperiment experiment;

	private final Stack<StartTime> startTimes = new Stack<StartTime>();

	@Override
	public void preCallVisit(String callId) {
		StartTime start = new StartTime(callId, System.nanoTime());
		startTimes.push(start);
	}

	@Override
	public void postCallVisit(String callId) {
		long now = System.nanoTime();
		StartTime start = startTimes.pop();

		experiment.takeMeasurement(callId, start.getTime(), now);
	}
}
