package de.uka.sdq.pcm.transformations.builder.connectors;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector;
import de.uka.ipd.sdq.pcm.resourceenvironment.LinkingResource;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.sdq.pcm.transformations.builder.IComponentBuilder;
import de.uka.sdq.pcm.transformations.builder.infrastructure.IMiddlewareInteractingComponentBuilder;
import de.uka.sdq.pcm.transformations.builder.infrastructure.MarshallingComponentBuilder;
import de.uka.sdq.pcm.transformations.builder.util.PCMAndCompletionModelHolder;

/**
 * Implementation of an InnerConnectorCompletionBuilder which adds the impact of marshalling parameters
 * @author Snowball
 *
 */
public class MarshallingConnectorCompletionBuilder
extends AbstractClientServerConnectorCompletionBuilder {

	private ResourceContainer fromResourceContainer;
	private ResourceContainer toResourceContainer;

	public MarshallingConnectorCompletionBuilder(
			PCMAndCompletionModelHolder models,
			AssemblyConnector connector,
			ResourceContainer fromResourceContainer,
			ResourceContainer toResourceContainer,
			IComponentBuilder innerBuilder) {
		super(models, connector, null, innerBuilder);
		this.fromResourceContainer = fromResourceContainer;
		this.toResourceContainer = toResourceContainer;
	}

	/**
	 * By default, a dummy component is created which does nothing besides delegating the call.
	 * Override if more actions are needed
	 * @return
	 */
	@Override
	protected IMiddlewareInteractingComponentBuilder createClientSideBuilder() {
		return 	new MarshallingComponentBuilder(
				myModels, 
				this.connectorToReplace.getRequiredRole_CompositeAssemblyConnector().getRequiredInterface__RequiredRole(),
				this.connectorToReplace.getRequiredRole_CompositeAssemblyConnector().getRequiredInterface__RequiredRole(),
				this.middlewareInterface,
				fromResourceContainer,
				MarshallingComponentBuilder.MarshallerSide.CLIENT);
	}
	
	/**
	 * By default, a dummy component is created which does nothing besides delegating the call.
	 * Override if more actions are needed
	 * @return
	 */
	@Override
	protected IMiddlewareInteractingComponentBuilder createServerSideBuilder() {
		return new MarshallingComponentBuilder(
				myModels, 
				this.connectorToReplace.getRequiredRole_CompositeAssemblyConnector().getRequiredInterface__RequiredRole(),
				this.connectorToReplace.getRequiredRole_CompositeAssemblyConnector().getRequiredInterface__RequiredRole(),
				this.middlewareInterface,
				toResourceContainer,
				MarshallingComponentBuilder.MarshallerSide.SERVER);
	}
}
