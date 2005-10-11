#region info
///////////////////////////////////////////////////////////////////////////////
// This software has been developed as a part of the diploma thesis 
// "Einfluss von Generatorkonfiguration auf die QoS-Vorhersage f�r 
// Komponentenadapter" ("Influence of the configuration of a generator on the 
// prediction of the QoS of component adaptors")
// at the 
// University of Oldenburg
// Department of Computing Science
// Software Engineering Group
// Palladio Research Group
// (http://se.informatik.uni-oldenburg.de/research/projects/Palladio)
// 
// Development period: July 2005 - January 2006
// 
// Author: Niels Streekmann
// E-mail: niels.streekmann@informatik.uni-oldenburg.de
///////////////////////////////////////////////////////////////////////////////
#endregion

namespace Palladio.QoSAdaptor.Pattern
{
	/// <summary>
	/// Public interface of a MismatchAttribute.
	/// 
	/// All constructors and setters are implemented as internal. The 
	/// interface only provides read methods.
	/// </summary>
	public interface IMismatchAttribute
	{
		#region properties
		/// <summary>
		/// The name of this mismatch attribute.
		/// </summary>
		string Name{get;}

		/// <summary>
		/// The suitability of this mismatch attribute.
		/// </summary>
		string Suitability{get;}
		#endregion
	}
}
