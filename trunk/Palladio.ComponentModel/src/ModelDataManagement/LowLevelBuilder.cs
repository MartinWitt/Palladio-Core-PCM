using System.Data;
using Palladio.ComponentModel.Exceptions;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelDataManagement;
using Palladio.ComponentModel.ModelEntities;
using Palladio.Identifier;

namespace Palladio.ComponentModel.ModelDataManagement
{
	/// <summary>
	/// This is the implementation of the LowLevelBuilder for the componentmodel. It supports several basic non 
	/// hierarical methods to create the componentmodel.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.5  2005/03/28 19:02:16  joemal
	/// primary keys in the dataset now are the guids of the entities
	///
	/// Revision 1.4  2005/03/28 18:13:33  joemal
	/// move private methods to private region
	///
	/// Revision 1.3  2005/03/19 18:35:41  joemal
	/// implement the rest of the lowlevelbuilder
	///
	/// Revision 1.2  2005/03/16 13:32:34  joemal
	/// implement lowlevelbuilder
	///
	/// Revision 1.1  2005/03/15 12:31:02  joemal
	/// initial class creation
	///
	///
	///
	/// </pre>
	/// </remarks>
	internal class LowLevelBuilder : ILowLevelBuilder
	{
		#region data

		//the counter of the ids
		private long idCntr=0;

		//holds the database of the model
		private ModelDataSet modelDataset;

		//holds the entities of the model
		private EntityHashtable entityHashtable;

		//holds the constrains check for the componentmodel
		private ModelConstrainsCheck modelCheck;

		#endregion

		#region constructor

		/// <summary>
		/// called to create a new LowLevelBuilder for the componentmodel.
		/// </summary>
		/// <param name="dataset">the datasets that represents the relational db to the model</param>
		/// <param name="hashtable">the entity hashable that holds the entities of the model</param>
		public LowLevelBuilder(ModelDataSet dataset, EntityHashtable hashtable)
		{
			this.modelDataset = dataset;
			this.entityHashtable = hashtable;
			this.modelCheck = new ModelConstrainsCheck(dataset,hashtable);
			Init();
		}

		#endregion

		#region private methods

		//connect the rowremoved-events of the tables to the eventhandler in this class
		private void Init()
		{
			ComponentsTable.RowDeleted += new DataRowChangeEventHandler(this.EntityDatatable_HandleRowDeleted);			
			InterfacesTable.RowDeleted += new DataRowChangeEventHandler(this.EntityDatatable_HandleRowDeleted);			
			SignaturesTable.RowDeleted += new DataRowChangeEventHandler(this.EntityDatatable_HandleRowDeleted);			
			ProtocolsTable.RowDeleted += new DataRowChangeEventHandler(this.EntityDatatable_HandleRowDeleted);			
			ConnectionsTable.RowDeleted += new DataRowChangeEventHandler(this.EntityDatatable_HandleRowDeleted);			
		}

		//queries the role by componentid, interfaceid and role
		private ModelDataSet.RolesRow QueryRole(IComponentIdentifier compId, IInterfaceIdentifier iFaceId, InterfaceRole role)
		{
			ModelDataSet.ComponentsRow compRow = ComponentsTable.FindByguid(compId.Key);
			ModelDataSet.InterfacesRow ifaceRow = InterfacesTable.FindByguid(iFaceId.Key);

			if (compRow == null || ifaceRow == null) return null;

			string query = "fk_comp = '"+compRow.guid+"' and fk_iface = '"+ifaceRow.guid+"' and type = "+(sbyte)role;
			DataRow[] result = modelDataset.Roles.Select(query);

			if (result.Length == 0) return null;	

			return (ModelDataSet.RolesRow) result[0];
		}

		//add a connection
		private void AddDelegation(IComponentIdentifier innerCompID, IInterfaceIdentifier innerIFaceID, IComponentIdentifier outerCompID, 
			IInterfaceIdentifier outerIFaceID, IConnection connection, InterfaceRole role)
		{
			modelCheck.EntityAlreadyExistsCheck(connection.ID);
			
			ModelDataSet.RolesRow innerRole = QueryRole(innerCompID,innerIFaceID,role);
			ModelDataSet.RolesRow outerRole = QueryRole(outerCompID,outerIFaceID,role);

			if (role == InterfaceRole.PROVIDES)
				modelCheck.AddProvidesDelegationCheck(innerCompID,innerIFaceID,outerCompID,outerIFaceID,innerRole,outerRole);
			else
				modelCheck.AddRequiresDelegationCheck(innerCompID,innerIFaceID,outerCompID,outerIFaceID,innerRole,outerRole);
	
			ConnectionsTable.AddConnectionsRow(innerRole, outerRole,connection.ID.Key);
			ConnectionsTable.AcceptChanges();
		}

		//the handler of the RowRemovedEvents of the datasets tables. 
		//all tables that are observed by this handler must contain a column from type string that holds
		//the key of the entities identifier. This key is used to find the entity in the hashtable.
		private void EntityDatatable_HandleRowDeleted(object sender, DataRowChangeEventArgs e)
		{
			this.entityHashtable.RemoveEntity((string) e.Row["guid",DataRowVersion.Original]);
		}

		#endregion

		#region public methods

		/// <summary>
		/// call to remove all entities and there relations from the model
		/// </summary>
		public void ClearAll()
		{
			RolesTable.Clear();
			ComponentsTable.Clear();
			InterfacesTable.Clear();
			SignaturesTable.Clear();
			ProtocolsTable.Clear();
			ConnectionsTable.Clear();
			entityHashtable.Clear();
			idCntr = 0;
		}

		/// <summary>
		/// call to add a component to the dataset.
		/// </summary>
		/// <param name="component">the component which has to be added</param>
		/// <param name="parentComponentID">the id of the parent component of this one. 
		/// Set this value to null if the component belongs to the top level of the static view.</param>
		/// <exception cref="ComponentNotFoundException">the parent component could not be found in the model.</exception>
		/// <exception cref="WrongComponentTypeException">the parent component is not a composite component.</exception>
		/// <exception cref="EntityAlreadyExistsException">an entity with given id already exists in cm</exception>
		public void AddComponent(IComponent component, IComponentIdentifier parentComponentID)
		{	
			modelCheck.AddComponentCheck(component,parentComponentID);
		
			ModelDataSet.ComponentsRow newRow = ComponentsTable.NewComponentsRow();
			newRow.guid = component.ID.Key;
			newRow.type = (sbyte) component.Type;

			if (parentComponentID != null)
				newRow.parentComponent = parentComponentID.Key;

			ComponentsTable.AddComponentsRow(newRow);
			ComponentsTable.AcceptChanges();

			entityHashtable.AddEntity(component);
		}

		/// <summary>
		/// called to remove the component which belongs to the given id. All contained components and
		/// all connections to and from this components are also removed. If the entity could not be found in 
		/// componentmodel, the method returns without doing anything.
		/// </summary>
		/// <param name="componentId">the id of the component to be removed</param>
		public void RemoveComponent(IComponentIdentifier componentId)
		{
			ModelDataSet.ComponentsRow row = ComponentsTable.FindByguid(componentId.Key);
			if (row == null) return;
			
			row.Delete();
			ComponentsTable.AcceptChanges();
		}

		/// <summary>
		/// called to add an existing interface to a component.
		/// </summary>
		/// <param name="componentIdentifier">the id of component</param>
		/// <param name="ifaceIdentifier">the id of the interface</param>
		/// <param name="role">determ whether the interface is bound as requires or provides interface</param>
		/// <exception cref="InterfaceNotFoundException">the interface could not be found in cm</exception>
		/// <exception cref="ComponentNotFoundException">the component could not be found in cm</exception>
		public void AddInterfaceToComponent(IComponentIdentifier componentIdentifier, IInterfaceIdentifier ifaceIdentifier, 
			InterfaceRole role)
		{
			modelCheck.AddIFaceToCompCheck(componentIdentifier,ifaceIdentifier,role);

			ModelDataSet.ComponentsRow compRow = ComponentsTable.FindByguid(componentIdentifier.Key);
			ModelDataSet.InterfacesRow ifaceRow = InterfacesTable.FindByguid(ifaceIdentifier.Key);

			string query = "fk_comp = '"+componentIdentifier+"' and fk_iface = '"+ifaceIdentifier+"'";
			DataRow[] result = modelDataset.Roles.Select(query);

			//still exists
			if (result.Length == 2) return;
			if (result.Length == 1)
				if (((ModelDataSet.RolesRow)result[0]).type == (sbyte)role) return;
            
			RolesTable.AddRolesRow(this.NextID,compRow,ifaceRow,(sbyte) role);
			RolesTable.AcceptChanges();
		}

		/// <summary>
		/// called to remove an interface from a component. If the entity could not be found in 
		/// componentmodel, the method returns without doing anything.
		/// </summary>
		/// <param name="componentIdentifier">the id of component</param>
		/// <param name="ifaceIdentifier">the id of the interface</param>
		/// <param name="role">the role bound of the interface in the component</param>
		public void RemoveInterfaceFromComponent(IComponentIdentifier componentIdentifier, IInterfaceIdentifier ifaceIdentifier,
			InterfaceRole role)
		{
			ModelDataSet.RolesRow rolesRow = QueryRole(componentIdentifier,ifaceIdentifier,role);
			if (rolesRow == null) return;

			rolesRow.Delete();
			RolesTable.AcceptChanges();
		}

		/// <summary>
		/// called to add a delegationconnector from the provides interface of an component to the provides 
		/// interface of an inner component.
		/// </summary>
		/// <param name="connection">the connection to be added</param>
		/// <param name="outerCompID">the id of the outer component</param>
		/// <param name="outerIFaceID">the id of the outer component</param>
		/// <param name="innerCompID">the id of the inner component</param>
		/// <param name="innerIFaceID">the id of the inner components interface</param>
		/// <exception cref="InterfaceNotFoundException">an interface could not be found in cm</exception>
		/// <exception cref="ComponentNotFoundException">a component could not be found in cm</exception>
		/// <exception cref="ComponentHierarchyException">the outer component is not the parent of the inner component</exception>
		/// <exception cref="NotAProvidesIFaceException">one of the given interfaces is not a provides
		/// interface of the component</exception>
		/// <exception cref="EntityAlreadyExistsException">an entity with given id already exists in cm</exception>
		public void AddProvidesDelegationConnector(IConnection connection, IComponentIdentifier outerCompID, IInterfaceIdentifier outerIFaceID, IComponentIdentifier innerCompID, IInterfaceIdentifier innerIFaceID)
		{			
			AddDelegation(innerCompID, innerIFaceID, outerCompID, outerIFaceID, connection, InterfaceRole.PROVIDES);
		}

		/// <summary>
		/// called to add a delegationconnector from the requires interface of an component to the requires 
		/// interface of its parent component
		/// </summary>
		/// <param name="connection">the connection to be added</param>
		/// <param name="innerCompID">the id of the inner component</param>
		/// <param name="innerIFaceID">the id of the inner components interface</param>
		/// <param name="outerCompID">the id of the outer component</param>
		/// <param name="outerIFaceID">the id of the outer component</param>
		/// <exception cref="InterfaceNotFoundException">an interface could not be found in cm</exception>
		/// <exception cref="ComponentNotFoundException">a component could not be found in cm</exception>
		/// <exception cref="ComponentHierarchyException">the outer component is not the parent of the inner component</exception>
		/// <exception cref="NotARequiresIFaceException">one of the given interfaces is not a requires 
		/// interface of the component</exception>
		/// <exception cref="EntityAlreadyExistsException">an entity with given id already exists in cm</exception>
		public void AddRequiresDelegationConnector(IConnection connection, IComponentIdentifier innerCompID, IInterfaceIdentifier innerIFaceID, IComponentIdentifier outerCompID, IInterfaceIdentifier outerIFaceID)
		{
			AddDelegation(innerCompID, innerIFaceID, outerCompID, outerIFaceID, connection, InterfaceRole.REQUIRES);
		}

		/// <summary>
		/// called to add an assemblyConnector from a requires interfaces of a component to a provides interface of 
		/// another component. Both components must have the same parent component or must be placed at the top level of the
		/// model.
		/// </summary>
		/// <param name="connection">the connection to be added</param>
		/// <param name="reqCompID">the id of the incoming component</param>
		/// <param name="reqIFaceID">the incoming components interface</param>
		/// <param name="provCompID">the id of the outgoing component</param>
		/// <param name="provIFaceID">the outgoing components interface</param>
		/// <exception cref="EntityAlreadyExistsException">an entity with given id already exists in cm</exception>
		/// <exception cref="InterfaceNotFoundException">an interface could not be found in cm</exception>
		/// <exception cref="ComponentNotFoundException">a component could not be found in cm</exception>
		/// <exception cref="ComponentHierarchyException">both components have not the same parent id</exception>
		/// <exception cref="NotARequiresIFaceException">one of the given interfaces is not a requires</exception> 
		/// <exception cref="NotAProvidesIFaceException">one of the given interfaces is not a provides </exception>
		public void AddAssemblyConnector(IConnection connection, IComponentIdentifier reqCompID, IInterfaceIdentifier reqIFaceID, IComponentIdentifier provCompID, IInterfaceIdentifier provIFaceID)
		{
			modelCheck.EntityAlreadyExistsCheck(connection.ID);

			ModelDataSet.RolesRow reqRole = QueryRole(reqCompID,reqIFaceID,InterfaceRole.REQUIRES);
			ModelDataSet.RolesRow provRole = QueryRole(provCompID,provIFaceID,InterfaceRole.PROVIDES);

			modelCheck.AddAssemblyConnectorCheck(reqCompID,reqIFaceID,provCompID,provIFaceID,reqRole,provRole);

			ConnectionsTable.AddConnectionsRow(reqRole, provRole,connection.ID.Key);
			ConnectionsTable.AcceptChanges();
		}

		/// <summary>
		/// called to remove the connection that belongs to the given id. If the entity could not be found in 
		/// componentmodel, the method returns without doing anything.
		/// </summary>
		/// <param name="connectionID">the id of the connection that has to be removed</param>
		public void RemoveConnection(IConnectionIdentifier connectionID)
		{
			ModelDataSet.ConnectionsRow row = ConnectionsTable.FindByguid(connectionID.Key);
			if (row == null) return;
			row.Delete();
			ConnectionsTable.AcceptChanges();
		}

		/// <summary>
		/// called to add an interface to the model. 
		/// </summary>
		/// <param name="iface">the interface to be added</param>
		/// <exception cref="EntityAlreadyExistsException">an interface with given id already exists in cm</exception>
		public void AddInterface(IInterface iface)
		{
			this.modelCheck.AddInterfaceCheck(iface);
			this.InterfacesTable.AddInterfacesRow(iface.ID.Key);
			this.InterfacesTable.AcceptChanges();
			this.entityHashtable.AddEntity(iface);
		}

		/// <summary>
		/// called to remove the interface from the model. All signatures and protocolinformations that have been 
		/// added to the interface are also removed. If the entity could not be found in 
		/// componentmodel, the method returns without doing anything.
		/// </summary>
		/// <param name="ifaceID">the id of the interface that has to be removed</param>
		public void RemoveInterface(IInterfaceIdentifier ifaceID)
		{
			ModelDataSet.InterfacesRow row = InterfacesTable.FindByguid(ifaceID.Key);
			if (row == null) return;
			row.Delete();
			InterfacesTable.AcceptChanges();
		}

		/// <summary>
		/// called to add the given signature to the interfaces, specified by the given interface id.
		/// </summary>
		/// <param name="signature">the signature to be added</param>
		/// <param name="ifaceID">the id of the interface, to which the signature has to be added</param>
		/// <exception cref="EntityAlreadyExistsException">an signature with given id already exists in cm</exception>
		/// <exception cref="InterfaceNotFoundException">the interface could not be found in cm</exception>
		public void AddSignature(ISignature signature, IInterfaceIdentifier ifaceID)
		{
			modelCheck.AddSignatureCheck(signature, ifaceID);
			ModelDataSet.InterfacesRow ifaceRow = InterfacesTable.FindByguid(ifaceID.Key);
			SignaturesTable.AddSignaturesRow(signature.ID.Key,ifaceRow);
			entityHashtable.AddEntity(signature);
		}

		/// <summary>
		/// called to remove the signature with given id. If the entity could not be found in 
		/// componentmodel, the method returns without doing anything.
		/// </summary>
		/// <param name="signatureID">the id of the signature that has to be removed</param>
		public void RemoveSignature(ISignatureIdentifier signatureID)
		{
			ModelDataSet.SignaturesRow row = SignaturesTable.FindByguid(signatureID.Key);
			if (row == null) return;
			row.Delete();
			SignaturesTable.AcceptChanges();
		}

		/// <summary>
		/// called to add a protocol to the interfaces that is specified by the given interface id.
		/// </summary>
		/// <param name="protocol">the protocol to be added</param>
		/// <param name="ifaceID">the id of the interface, to which the protocol has to be added</param>
		/// <exception cref="InterfaceNotFoundException">the interface could not be found in cm</exception>
		/// <exception cref="EntityAlreadyExistsException">an entity with given id already exists in cm</exception>
		public void AddProtocol(IProtocol protocol, IInterfaceIdentifier ifaceID)
		{
			modelCheck.AddProtocolCheck(protocol,ifaceID);

			ModelDataSet.InterfacesRow ifaceRow = InterfacesTable.FindByguid(ifaceID.Key);
			ProtocolsTable.AddProtocolsRow(protocol.ID.Key,ifaceRow);
			ProtocolsTable.AcceptChanges();
			entityHashtable.AddEntity(protocol);
		}

		/// <summary>
		/// called to remove the protocol with given id. If the entity could not be found in 
		/// componentmodel, the method returns without doing anything.
		/// </summary>
		/// <param name="protocolID">the id of the protocol that has to be removed</param>
		public void RemoveProtocol(IProtocolIdentifier protocolID)
		{
			ModelDataSet.ProtocolsRow row = ProtocolsTable.FindByguid(protocolID.Key);
			if (row == null) return;
			row.Delete();
			ProtocolsTable.AcceptChanges();
		}

		#endregion

		#region properties

		//returns the table of the components
		private ModelDataSet.ComponentsDataTable ComponentsTable
		{
			get
			{
				return modelDataset.Components;
			}
		}
		
		//returns the table of the interfaces
		private ModelDataSet.InterfacesDataTable InterfacesTable
		{
			get
			{
				return modelDataset.Interfaces;
			}
		}
		
		//returns the table of the signatures
		private ModelDataSet.SignaturesDataTable SignaturesTable
		{
			get
			{
				return modelDataset.Signatures;
			}
		}
		
		//returns the table of the protocols
		private ModelDataSet.ProtocolsDataTable ProtocolsTable
		{
			get
			{
				return modelDataset.Protocols;
			}
		}
		
		//returns the table of the roles
		private ModelDataSet.RolesDataTable RolesTable
		{
			get
			{
				return modelDataset.Roles;
			}
		}
		
		//returns the table of the connections
		private ModelDataSet.ConnectionsDataTable ConnectionsTable
		{
			get
			{
				return modelDataset.Connections;
			}
		}

		//call return a new id
		private long NextID
		{
			get
			{
				return idCntr++;
			}
		}
		#endregion
	}
}
