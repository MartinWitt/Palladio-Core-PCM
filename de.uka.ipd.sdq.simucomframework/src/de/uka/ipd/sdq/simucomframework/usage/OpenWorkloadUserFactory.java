package de.uka.ipd.sdq.simucomframework.usage;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

/**
 * A factory for creating open workload users
 * 
 * @author Steffen Becker
 * 
 */
public abstract class OpenWorkloadUserFactory extends AbstractWorkloadUserFactory implements IUserFactory {

    public OpenWorkloadUserFactory(final SimuComModel model, final String usageScenarioID) {
        super(model,usageScenarioID);
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.uka.ipd.sdq.simucomframework.usage.IUserFactory#createUser()
     */
    @Override
    public IUser createUser() {
        final IScenarioRunner scenarioRunner = this.createScenarioRunner();
        return new OpenWorkloadUser(model, "OpenUser", scenarioRunner,
                usageScenarioID, usageStartStopProbes);
    }

    /**
     * Template method filled in by the generator. Returns an object
     * representing the user behaviour needed for the new users.
     * 
     * @return The behaviour of the users created by this factory
     */
    public abstract IScenarioRunner createScenarioRunner();

}
