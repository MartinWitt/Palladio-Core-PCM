using System;
using System.Collections;

namespace Palladio.ComponentModel.Exceptions
{
	/// <summary>
	/// Error indicating, that the provides interface is not a role of the IMapping.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2004/06/02 14:50:25  sbecker
	/// Initial Import after a major rework
	///
	/// Revision 1.4  2004/05/23 19:00:07  sliver
	/// added comments
	///
	/// Revision 1.3  2004/05/19 11:19:47  sliver
	/// connections are 1 on 1 now
	/// IProvidesMapping and IRequiresMapping joined to IMapping
	///
	/// Revision 1.2  2004/05/19 08:03:57  sbecker
	/// Changed Exceptions to ComponentModelExceptions
	/// Added CVS Logs
	///
	///
	/// </pre>
	/// </remarks>
	public class ProvidesInterfaceNotInMappingException : ComponentModelException
	{
		/// <summary>
		/// Error indicating, that the provides interface is not a role of the IMapping.
		/// </summary>
		/// <param name="aRoleID">Role which couldn't be found.</param>
		/// <param name="aMapping">Mapping with the missing role.</param>
		public ProvidesInterfaceNotInMappingException(string aRoleID, IMapping aMapping) : base( "Role " + aRoleID + " not found in " + aMapping + "!")
		{
		}
	}
}