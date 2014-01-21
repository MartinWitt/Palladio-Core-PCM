package org.palladiosimulator.protocom.traverse.framework.repository;

import de.uka.ipd.sdq.pcm.repository.CompositeComponent;
import org.palladiosimulator.protocom.traverse.framework.PcmRepresentative;

/**
 * Leaf for Composite Components.
 * 
 * Meant to be inherited by a specific transformation if this PCM entity should
 * result in generated files.
 * 
 * @author Thomas Zolynski
 */
@SuppressWarnings("all")
public class XCompositeComponent extends PcmRepresentative<CompositeComponent> {
}