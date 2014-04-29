package edu.kit.ipd.sdq.eventsim.system.events;

import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimEventDelegator;
import edu.kit.ipd.sdq.eventsim.interpreter.state.UserState;
import edu.kit.ipd.sdq.eventsim.system.EventSimSystemModel;
import edu.kit.ipd.sdq.eventsim.system.entities.Request;
import edu.kit.ipd.sdq.eventsim.system.interpreter.seff.SeffBehaviourInterpreter;
import edu.kit.ipd.sdq.eventsim.system.staticstructure.ComponentInstance;

/**
 * Schedule this event to begin the traversal of a {@link ResourceDemandingSEFF} (RD-SEFF).
 * <p>
 * The {@link Request} that is supposed to traverse the SEFF, is passed to the {@code schedule()}
 * method.
 * 
 * @author Philipp Merkle
 * 
 */
public class BeginSeffTraversalEvent extends AbstractSimEventDelegator<Request> {

    private final ComponentInstance component;
    private final OperationSignature signature;
    private final UserState parentState;
	private EventSimSystemModel model;

    /**
     * Use this constructor to begin the traversal of the RD-SEFF provided by the specified {@code
     * component}. The {@code signature} specifies which SEFF is to be used, as a component may
     * contain a SEFF for each provided signature.
     * 
     * @param model
     *            the model
     * @param component
     *            the component providing the SEFF
     * @param signature
     *            the signature whose SEFF is to be traversed
     * @param parentState
     *            the state of the usage traversal
     */
    public BeginSeffTraversalEvent(final EventSimSystemModel model, final ComponentInstance component, final OperationSignature signature, UserState parentState) {
        super(model.getSimulationMiddleware().getSimulationModel(), "BeginUsageTraversalEvent");
        this.model = model;
        this.component = component;
        this.signature = signature;
        this.parentState = parentState;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void eventRoutine(final Request who) {
        SeffBehaviourInterpreter interpreter = this.model.getSeffInterpreter();
        interpreter.beginTraversal(who, this.component, this.signature, this.parentState);
    }

}
