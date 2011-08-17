package de.uka.ipd.sdq.simulation.command;

import de.uka.ipd.sdq.simulation.PCMModel;

/**
 * Instances of this interface provide operations that require access to a PCM model in order to
 * produce the desired result.
 * 
 * @author Philipp Merkle
 * 
 * @param <R>
 *            the return type of the command. Use {@link Void}, if the command is not supposed to
 *            return a value.
 * @see ICommand
 */
public interface IPCMCommand<R> extends ICommand<R, PCMModel> {

    // the sole purpose of this interface is to define the model type parameter for commands using
    // PCM models

}
