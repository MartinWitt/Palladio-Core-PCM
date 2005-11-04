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

using System.Collections;

namespace Palladio.QoSAdaptor.Pattern
{
	/// <summary>
	/// A MismatchAttribute describes the suitability of a design 
	/// pattern for solving problems with certain attributes. For the 
	/// quality-based interface model this can be quality attributes like 
	/// performance or reliability.
	/// The class has the attributes name and suitability, where
	/// suitability describes the suitability of the pattern to
	/// solve a problem with the attribute referred to by 
	/// name. 
	/// 
	/// TODO: Is the classification of attributes and subattributes also 
	/// usable for other interface models?
	/// </summary>
	internal class MismatchAttribute : IMismatchAttribute
	{
		#region attributes
		/// <summary>
		/// The name of the mismatch attribute.
		/// </summary>
		private string name;

		/// <summary>
		/// Describes the influence of the pattern this mismatch attribute 
		/// is defined for on this attribute.
		/// </summary>
		private SuitabilityValue suitability;

		/// <summary>
		/// A list of subattributes.
		/// </summary>
		private ArrayList subAttributes;
		#endregion 

		#region constructor
		/// <summary>
		/// Constructs a new MismatchAttribute with the given name.
		/// </summary>
		/// <param name="name">The name of the QoSAttribute</param>
		internal MismatchAttribute(string name)
		{
			this.name = name;
			this.subAttributes = new ArrayList();
		}
		#endregion

		#region properties
		/// <summary>
		/// The name of this mismatch attribute.
		/// </summary>
		public string Name
		{
			get
			{
				return name;
			}
		}

		/// <summary>
		/// The suitability of this mismatch attribute.
		/// </summary>
		public SuitabilityValue Suitability
		{
			get
			{
				return suitability;
			}
			set
			{
				suitability = value;
			}
		}

		/// <summary>
		/// A list of all defined subattributes.
		/// </summary>
		public ICollection SubAttributes
		{
			get
			{
				return this.subAttributes;
			}
		}
		#endregion

		#region public methods
		/// <summary>
		/// Adds the given subattribute to the list of subattributes.
		/// </summary>
		/// <param name="attribute">A MismatchSubAttribute.</param>
		public void AddSubAttribute (MismatchSubAttribute attribute)
		{
			this.subAttributes.Add(attribute);
		}
		#endregion
	}
}
