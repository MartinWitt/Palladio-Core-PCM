using System;
using Palladio.ComponentModel.Builder.TypeLevelBuilder;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelEntities;

namespace Palladio.ComponentModel.Builder
{
	/// <summary>
	/// ISignatureBuilder. Builds ISignatures.
	/// </summary>
	/// <remarks>
	/// Currently the signatures can not be created using a builder.
	/// 
	/// <p>This builder interface contains all non model-level specifical methods of a signature.</p>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.8  2005/04/13 17:06:02  kelsaka
	/// - added further support for building signatures
	///
	/// Revision 1.7  2005/04/13 09:27:17  kelsaka
	/// - added builders (including interfaces) for types and parameters of signatures.
	///
	/// Revision 1.6  2005/04/12 18:08:35  kelsaka
	/// - added events to builders
	///
	/// Revision 1.5  2005/04/12 12:32:39  kelsaka
	/// - removed property to access typed IDs directly from the builders
	/// - renamed the property from 'SignaturID' to 'SignatureID' in ISignature
	///
	/// Revision 1.4  2005/04/09 12:23:20  kelsaka
	/// - added documentation
	///
	/// Revision 1.3  2005/04/08 16:50:31  kelsaka
	/// - added interface builder implementation
	///
	/// Revision 1.2  2005/04/08 15:40:06  kelsaka
	/// - added SignatureBuilder
	/// - fixed bug: some new entities were not added to component model
	///
	/// Revision 1.1  2005/04/06 19:06:59  kelsaka
	/// - added new builder interfaces to support the levels of the component model
	/// - added basic set of methods to interfaces
	///
	/// </pre>
	/// </remarks>
	public interface ISignatureBuilder : IEntityBuilder
	{
		#region Methods
		
		/// <summary>
		/// Sets the return type of the actual signature. The return type is newly created.
		/// </summary>
		/// <param name="typeName">The name of the return-type. It has to be a valid
		/// <see cref="Type"/>-name. This means that the type needs to exist.</param>
		/// <returns>A <see cref="ITypeTypeLevelBuilder"/> for the new type.</returns>
		/// <exception cref="Exceptions.TypeNotFoundException">Thrown if the given string is not
		/// a valid type-name.</exception>
		ITypeTypeLevelBuilder SetReturnType(string typeName);

		/// <summary>
		/// Sets the return type of the actual signature.
		/// </summary>
		/// <param name="type">The given type is used as return type.</param>
		/// <exception cref="Exceptions.TypeNotFoundException">Thrown if the given string is not
		/// a valid type-name.</exception>
		void SetReturnType(Type type);

		/// <summary>
		/// Sets the return type to <see cref="void"/>.
		/// </summary>
		void SetReturnTypeVoid();

		/// <summary>
		/// Appends a new parameter to the end of the parameter list of the signature. No modifiers
		/// (<see cref="ParameterModifierEnum"/> like "out" or "ref") are used.
		/// </summary>
		/// <param name="name">The new parameters name and the name of the <see cref="Type"/>
		/// to add. Both have to be named the same. The name has to be a valid name of a type.</param>
		/// <returns>A <see cref="IParameterTypeLevelBuilder"/> for the newly created
		/// parameter.</returns>
		/// <exception cref="Exceptions.TypeNotFoundException">Thrown if the given type-name (<see cref="name"/>) is not
		/// a valid type-name.</exception>
		IParameterTypeLevelBuilder AppendParameter(string name);

		/// <summary>
		/// Appends a new parameter to the end of the parameter list of the signature.
		/// The <see cref="ParameterModifierEnum"/> is set to <see cref="ParameterModifierEnum.NONE"/>
		/// by default.
		/// </summary>
		/// <param name="type">The type of the new parameter</param>
		/// <param name="name">The new parameters name.</param>
		/// <returns>A <see cref="IParameterTypeLevelBuilder"/> for the newly created
		/// parameter.</returns>
		IParameterTypeLevelBuilder AppendParameter(Type type, string name);

		/// <summary>
		/// Appends a new parameter to the end of the parameter list of the signature.
		/// </summary>
		/// <param name="type">The type of the new parameter</param>
		/// <param name="name">The new parameters name.</param>
		/// <param name="modifiers">The modifier (<see cref="ParameterModifierEnum"/> like "out"
		/// or "ref") of the actual parameter.</param>
		/// <returns>A <see cref="IParameterTypeLevelBuilder"/> for the newly created
		/// parameter.</returns>
		IParameterTypeLevelBuilder AppendParameter(Type type, string name, ParameterModifierEnum modifiers);

		/// <summary>
		/// Clears the list of parameters. Afterwards the signature contains no more parameters.
		/// </summary>
		/// <remarks>
		/// Currently parameters do not have IDs. As parameters might occur multiple times it can
		/// not be determined which parameter is meant to delete. So always the whole list has to
		/// be deleted.
		/// </remarks>
		void ClearParameterList();

		/// <summary>
		/// Adds a new exception with the given name to the unordered list of exceptions.
		/// Exceptions can only occur once in the list.
		/// </summary>
		/// <param name="typeName">The type-name of the new exception. It has to be a valid
		/// <see cref="Type"/>-name and a <see cref="Exception"/>.</param>
		/// <returns>A <see cref="ITypeTypeLevelBuilder"/> for the new exception.</returns>
		/// <exception cref="Exceptions.TypeNotFoundException">Thrown if the given type-name (<see cref="typeName"/>) is not
		/// a valid type-name.</exception>
		ITypeTypeLevelBuilder AddException(string typeName);

		/// <summary>
		/// Adds the given exception to the signature.
		/// </summary>
		/// <param name="type">The exception to add. It has to be a valid
		/// <see cref="Exception"/>.</param>
		/// <exception cref="Palladio.ComponentModel.Exceptions.TypeNotValidException">Thrown if the created
		/// type is not an exception (sub-) type.</exception>
		void AddException(Type type);

		/// <summary>
		/// Removes the given exception from the signature.
		/// </summary>
		/// <param name="exception">The exception to remove.</param>
		void RemoveException(Type exception);

		#endregion

		#region Properties


		/// <summary>
		/// Accesses the created instance.
		/// </summary>
		ISignature Signature
		{
			get;
		}

		#endregion
	}
}
