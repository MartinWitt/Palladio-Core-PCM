using Palladio.ComponentModel.ModelDataManagement;
using Palladio.Identifier;

namespace Palladio.ComponentModel.Builder
{

	/// <summary>
	/// Interface implemented by all component model builders that create entities.
	/// </summary>
	/// <remarks>
	/// NOTE: currently this interface is empty.
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.11  2005/10/09 14:42:12  kelsaka
	/// - removed convenience properties to access a component model entity directly from a
	///  builder. use the access cm-environment>query instead
	///
	/// Revision 1.10  2005/06/05 10:36:34  joemal
	/// - replace the entities by the ids
	/// - components now can be added to more than one container
	///
	/// Revision 1.9  2005/05/27 13:34:41  kelsaka
	/// - AbstractEntity now holds the ModelDataManger and the BuilderManager
	///
	/// Revision 1.8  2005/05/25 19:44:54  kelsaka
	/// - optimized usings
	/// - builders are now returning identifiers again
	///
	/// Revision 1.7  2005/04/23 11:49:54  kelsaka
	/// - refactored enity-builder interface: currently no methods.
	///
	/// Revision 1.6  2005/04/23 11:00:44  kelsaka
	/// - removed Init-Methods from AbstractBuilder - created constructors
	///
	/// Revision 1.5  2005/04/20 21:02:35  kelsaka
	/// - added first methods for constraints
	///
	/// Revision 1.4  2005/04/15 08:29:46  kelsaka
	/// - fixed errors on xml-comments
	///
	/// Revision 1.3  2005/04/14 06:16:34  kelsaka
	/// - fixed bug on listening to name changed events.
	///
	/// Revision 1.2  2005/04/13 20:24:08  kelsaka
	/// - added enitity methods
	///
	/// Revision 1.1  2005/04/12 18:08:35  kelsaka
	/// - added events to builders
	///
	/// </pre>
	/// </remarks>
	public interface IEntityBuilder
	{
		#region methods

		#endregion

		#region properties

		/// <summary>
		/// called to returns the id of the entity that belongs to this builder
		/// </summary>
		IIdentifier Id { get; }
		
		#endregion		
	}
}
