package edu.kit.ipd.sdq.eventsim.system.handler;

import java.util.List;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;
import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe;
import edu.kit.ipd.sdq.eventsim.system.entities.Request;
import edu.kit.ipd.sdq.eventsim.system.interpreter.state.RequestState;
import edu.kit.ipd.sdq.eventsim.util.ParameterHelper;
import edu.kit.ipd.sdq.simcomp.event.IEventHandler;
import edu.kit.ipd.sdq.simcomp.event.system.SystemRequestProcessed;

public class AfterSystemCallParameterHandler implements  IEventHandler<SystemRequestProcessed> {

    private static final Logger logger = Logger.getLogger(AfterSystemCallParameterHandler.class);

	@Override
	public void handle(SystemRequestProcessed simulationEvent) {
		if (logger.isDebugEnabled()) {
            logger.debug("Begin handling system call output parameters");
        }

		Request request = (Request) simulationEvent.getRequest();
		RequestState state = request.getRequestState();

        final EntryLevelSystemCall call = request.getSystemCall();
        final StackContext ctx = state.getStoExContext();

        // get a reference on the current stack frame which is being removed soon
        final SimulatedStackframe<Object> serviceBodyFrame = ctx.getStack().currentStackFrame();

        // remove the current stack frame. This restores the pre-call scope.
        ctx.getStack().removeStackFrame();

        // evaluate the return parameters of the call and add them to the current scope
        final List<VariableUsage> parameters = call.getOutputParameterUsages_EntryLevelSystemCall();
        final SimulatedStackframe<Object> currentFrame = ctx.getStack().currentStackFrame();
        ParameterHelper.evaluateParametersAndCopyToFrame(parameters, serviceBodyFrame, currentFrame);

        if (logger.isDebugEnabled()) {
            logger.debug("Finished handling system call output parameters");
        }
	}

}
