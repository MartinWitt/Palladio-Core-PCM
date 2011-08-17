package de.uka.ipd.sdq.simulation.probespec.commands;

import java.util.ArrayList;
import java.util.List;

import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.repository.OperationInterface;
import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;
import de.uka.ipd.sdq.pcm.usagemodel.UsageModel;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.probespec.framework.ProbeSpecContext;
import de.uka.ipd.sdq.probespec.framework.calculator.Calculator;
import de.uka.ipd.sdq.probespec.framework.calculator.CalculatorRegistry;
import de.uka.ipd.sdq.probespec.framework.calculator.ResponseTimeCalculator;
import de.uka.ipd.sdq.simulation.PCMModel;
import de.uka.ipd.sdq.simulation.command.ICommandExecutor;
import de.uka.ipd.sdq.simulation.command.IPCMCommand;
import de.uka.ipd.sdq.simulation.command.seff.FindExternalCallActionsInSeff;
import de.uka.ipd.sdq.simulation.command.seff.FindSeffsForAssemblyContext;
import de.uka.ipd.sdq.simulation.command.usage.FindSystemCallsOfScenario;

/**
 * This command creates and returns a list of {@link ResponseTimeCalculator}s. The following
 * calculators are created:
 * <ul>
 * <li>one for each {@link UsageScenario}</li>
 * <li>one for each {@link EntryLevelSystemCall} contained in a {@link UsageScenario}</li>
 * <li>one for each {@link ExternalCallAction} contained in a {@link AssemblyContext}
 * </ul>
 * 
 * @author Philipp Merkle
 * 
 */
public class BuildResponseTimeCalculators implements IPCMCommand<List<Calculator>> {

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Calculator> execute(PCMModel pcm, ICommandExecutor<PCMModel> executor) {
        List<Calculator> calculators = new ArrayList<Calculator>();
        CalculatorRegistry registry = ProbeSpecContext.instance().getCalculatorRegistry();

        // build a calculator for each UsageScenario
        UsageModel usageModel = pcm.getUsageModel();
        for (UsageScenario s : usageModel.getUsageScenario_UsageModel()) {
            Calculator calculator = ProbeSpecContext.instance().getCalculatorFactory().buildResponseTimeCalculator(
                    s.getEntityName(), ProbeSpecContext.instance().obtainProbeSetId(s.getId() + "_start"),
                    ProbeSpecContext.instance().obtainProbeSetId(s.getId() + "_end"));
            calculators.add(calculator);
            registry.registerCalculator(s.getId(), calculator);
        }

        // build a calculator for each EntryLevelSystemCall
        for (UsageScenario s : usageModel.getUsageScenario_UsageModel()) {
            List<EntryLevelSystemCall> calls = executor.execute(new FindSystemCallsOfScenario(s));
            for (EntryLevelSystemCall c : calls) {
                Calculator calculator = ProbeSpecContext.instance().getCalculatorFactory().buildResponseTimeCalculator(
                        buildSystemCallName(c), ProbeSpecContext.instance().obtainProbeSetId(c.getId() + "_start"),
                        ProbeSpecContext.instance().obtainProbeSetId(c.getId() + "_end"));
                calculators.add(calculator);
                registry.registerCalculator(c.getId(), calculator);
            }
        }

        // build a calculator for each ExternalCallAction
        for (AllocationContext allocationCtx : pcm.getAllocationModel().getAllocationContexts_Allocation()) {
            AssemblyContext assemblyCtx = allocationCtx.getAssemblyContext_AllocationContext();

            // find all SEFFs in the assembly context
            List<ResourceDemandingSEFF> seffs = executor.execute(new FindSeffsForAssemblyContext(assemblyCtx));

            // find all calls in the SEFFs
            List<ExternalCallAction> calls = new ArrayList<ExternalCallAction>();
            for (ResourceDemandingSEFF s : seffs) {
                calls.addAll(executor.execute(new FindExternalCallActionsInSeff(s)));
            }

            // build and register a calculator for each call
            for (ExternalCallAction c : calls) {
                Calculator calculator = ProbeSpecContext.instance().getCalculatorFactory().buildResponseTimeCalculator(
                        buildExternalCallName(c, assemblyCtx),
                        ProbeSpecContext.instance().obtainProbeSetId(c.getId() + "," + assemblyCtx.getId() + "_start"),
                        ProbeSpecContext.instance().obtainProbeSetId(c.getId() + "," + assemblyCtx.getId() + "_end"));
                calculators.add(calculator);
                registry.registerCalculator(c.getId(), calculator);
            }
        }

        return calculators;
    }

    /**
     * Creates and returns a string describing the specified {@link EntryLevelSystemCall}.
     * 
     * @param call
     *            the system call
     * @return a description of the specified call
     */
    private String buildSystemCallName(EntryLevelSystemCall call) {
        StringBuilder builder = new StringBuilder();
        builder.append("Call_");
        builder.append(call.getOperationSignature__EntryLevelSystemCall().getEntityName());
        builder.append(getPositionInInterface(call.getOperationSignature__EntryLevelSystemCall()));
        builder.append(" <EntryLevelSystemCall id: ");
        builder.append(call.getId());
        builder.append(">");
        return builder.toString();
    }

    /**
     * Creates and returns a string describing the specified {@link ExternalCallAction}.
     * 
     * @param call
     *            the external call
     * @param assemblyCtx
     *            the assembly context from which the call is issued
     * @return a description of the specified call
     */
    private String buildExternalCallName(ExternalCallAction call, AssemblyContext assemblyCtx) {
        StringBuilder builder = new StringBuilder();
        builder.append("Call ");
        builder.append(call.getCalledService_ExternalService().getInterface__OperationSignature().getEntityName());
        builder.append(".");
        builder.append(call.getCalledService_ExternalService().getEntityName());
        builder.append(getPositionInInterface(call.getCalledService_ExternalService()));
        builder.append(" <Component: ");
        builder.append(assemblyCtx.getEncapsulatedComponent_AssemblyContext().getEntityName());
        builder.append(", AssemblyCtx: ");
        builder.append(assemblyCtx.getId());
        builder.append(", CallID: ");
        builder.append(call.getId());
        builder.append(">");
        return builder.toString();
    }

    /**
     * Returns the position of the specified signature in its interface.
     * 
     * @param signature
     *            the signature
     * @return the position of the signature, starting at 0 for the first position.
     */
    private int getPositionInInterface(OperationSignature signature) {
        OperationInterface interfaze = signature.getInterface__OperationSignature();
        return interfaze.getSignatures__OperationInterface().indexOf(signature);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean cachable() {
        return false;
    }

}
