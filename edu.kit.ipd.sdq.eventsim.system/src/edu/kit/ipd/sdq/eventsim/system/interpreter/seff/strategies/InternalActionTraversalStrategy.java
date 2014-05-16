package edu.kit.ipd.sdq.eventsim.system.interpreter.seff.strategies;

import java.util.LinkedList;
import java.util.Queue;

import de.uka.ipd.sdq.pcm.seff.InternalAction;
import de.uka.ipd.sdq.pcm.seff.seff_performance.ParametricResourceDemand;
import edu.kit.ipd.sdq.eventsim.entities.Request;
import edu.kit.ipd.sdq.eventsim.interpreter.state.ITraversalStrategyState;
import edu.kit.ipd.sdq.eventsim.interpreter.state.RequestState;
import edu.kit.ipd.sdq.eventsim.system.EventSimSystemModel;
import edu.kit.ipd.sdq.eventsim.system.events.ResumeSeffTraversalEvent;
import edu.kit.ipd.sdq.eventsim.system.interpreter.seff.IRequestTraversalInstruction;
import edu.kit.ipd.sdq.eventsim.system.interpreter.seff.ISeffTraversalStrategy;
import edu.kit.ipd.sdq.eventsim.system.interpreter.seff.instructions.RequestTraversalInstructionFactory;
import edu.kit.ipd.sdq.simcomp.component.IActiveResource;
import edu.kit.ipd.sdq.simcomp.component.ISimulationMiddleware;

/**
 * This traversal strategy is responsible for {@link InternalAction}s.
 * 
 * @author Philipp Merkle
 * @author Christoph Föhrdes
 * 
 */
public class InternalActionTraversalStrategy implements ISeffTraversalStrategy<InternalAction> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IRequestTraversalInstruction traverse(final InternalAction action, final Request request, final RequestState state) {
		// restore or create state
		InternalActionTraversalState internalState = (InternalActionTraversalState) state.getInternalState(action);
		if (internalState == null) {
			internalState = this.initialiseState(request, action, state);
		}
		request.setRequestState(state);
		
		final ParametricResourceDemand demand = internalState.dequeueDemand();

		// fetch the resource simulation component
		// TODO (SimComp): build list of key value pairs as context
        ISimulationMiddleware middleware = request.getEventSimModel().getSimulationMiddleware();
        IActiveResource resourceSimComp = (IActiveResource) middleware.getSimulationComponent(IActiveResource.class, null);

        // consume the resource demand
        resourceSimComp.consume(request, demand);
		
		EventSimSystemModel systemModel = (EventSimSystemModel) request.getEventSimModel();
		if (internalState.hasPendingDemands()) {
			request.passivate(new ResumeSeffTraversalEvent(systemModel, state));
			return RequestTraversalInstructionFactory.interruptTraversal(action);
		} else {
			request.passivate(new ResumeSeffTraversalEvent(systemModel, state));
			return RequestTraversalInstructionFactory.interruptTraversal(action.getSuccessor_AbstractAction());
		}

	}

	private InternalActionTraversalState initialiseState(final Request request, final InternalAction action, final RequestState state) {
		// create and set state
		final InternalActionTraversalState internalState = new InternalActionTraversalState();
		for (final ParametricResourceDemand d : action.getResourceDemand_Action()) {
			internalState.enqueueDemand(d);
		}

		state.addInternalState(action, internalState);

		return internalState;
	}

	private static final class InternalActionTraversalState implements ITraversalStrategyState {

		private final Queue<ParametricResourceDemand> pendingDemands;

		public InternalActionTraversalState() {
			this.pendingDemands = new LinkedList<ParametricResourceDemand>();
		}

		public void enqueueDemand(final ParametricResourceDemand demand) {
			this.pendingDemands.add(demand);
		}

		public ParametricResourceDemand dequeueDemand() {
			return this.pendingDemands.poll();
		}

		public boolean hasPendingDemands() {
			return !this.pendingDemands.isEmpty();
		}

	}

}