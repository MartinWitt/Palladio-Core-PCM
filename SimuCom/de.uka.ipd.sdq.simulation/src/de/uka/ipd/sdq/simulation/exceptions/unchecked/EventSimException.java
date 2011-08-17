package de.uka.ipd.sdq.simulation.exceptions.unchecked;

import de.uka.ipd.sdq.simulation.exceptions.UncheckedSimulationException;

/**
 * This exception indicates a general problem while performing an EventSim simulation run. If this
 * exception is not catched, the simulation aborts.
 * 
 * @author Philipp Merkle
 * 
 */
public class EventSimException extends UncheckedSimulationException {

    private static final long serialVersionUID = -7270433571897078637L;

    public EventSimException() {
        super();
    }

    public EventSimException(String message, Throwable cause) {
        super(message, cause);
    }

    public EventSimException(String message) {
        super(message);
    }

    public EventSimException(Throwable cause) {
        super(cause);
    }

}