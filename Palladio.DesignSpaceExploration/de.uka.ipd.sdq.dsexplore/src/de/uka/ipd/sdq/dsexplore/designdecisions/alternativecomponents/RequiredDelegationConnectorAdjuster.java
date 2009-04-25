package de.uka.ipd.sdq.dsexplore.designdecisions.alternativecomponents;

import de.uka.ipd.sdq.pcm.core.composition.RequiredDelegationConnector;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;

public class RequiredDelegationConnectorAdjuster implements ConnectorAdjuster {
	
	private RequiredDelegationConnector connector;
	private RequiredRole role;

	@Override
	public void build() {
		connector.setInnerRequiredRole_RequiredDelegationConnector(role);

	}

}