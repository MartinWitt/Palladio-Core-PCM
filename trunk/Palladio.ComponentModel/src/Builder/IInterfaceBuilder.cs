using System;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelEntities;

namespace Palladio.ComponentModel.Builder
{
	/// <summary>
	/// IInterfaceBuilder. Builder for creating interfaces including signatures and protocols.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.4  2005/04/08 15:40:06  kelsaka
	/// - added SignatureBuilder
	/// - fixed bug: some new entities were not added to component model
	///
	/// Revision 1.3  2005/04/08 10:41:18  kelsaka
	/// - added return of IDs
	/// - added implementation of defined interfaces
	/// - redefined interfaces for builder-context
	/// - added CC-levels
	///
	/// Revision 1.2  2005/04/06 19:06:58  kelsaka
	/// - added new builder interfaces to support the levels of the component model
	/// - added basic set of methods to interfaces
	///
	/// Revision 1.1  2005/03/17 18:30:35  kelsaka
	/// - added first builder-interfaces
	///
	/// </pre>
	/// </remarks>
	public interface IInterfaceBuilder
	{
		/// <summary>
		/// Adds a new signature with the given name to the actual Interface.
		/// </summary>
		/// <param name="signatureName">The new signatures name.</param>
		/// <returns>SignatureBuilder</returns>
		ISignatureBuilder AddSignature(string signatureName);

		/// <summary>
		/// called to remove the signature with given id. If the entity could not be found in 
		/// componentmodel, the method returns without doing anything.
		/// </summary>
		/// <param name="signatureID">the id of the signature that has to be removed</param>
		void RemoveSignature(ISignatureIdentifier signatureID);

		/// <summary>
		/// Adds a new protocol to the interface.
		/// </summary>
		/// <param name="protocolName">The new protocols name.</param>
		void AddProtocol(string protocolName);

		/// <summary>
		/// called to remove the protocol with given id. If the entity could not be found in 
		/// componentmodel, the method returns without doing anything.
		/// </summary>
		/// <param name="protocolID">the id of the protocol that has to be removed</param>
		void RemoveProtocol(IProtocolIdentifier protocolID);

		/// <summary>
		/// Returns the <see cref="IInterfaceIdentifier"/> of the actual interface.
		/// </summary>
		IInterfaceIdentifier InterfaceID
		{
			get;
		}
	}
}
