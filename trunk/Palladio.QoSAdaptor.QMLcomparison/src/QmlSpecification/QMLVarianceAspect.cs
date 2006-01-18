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

using System;
using System.Globalization;
using antlr.collections;
using QmlParser;

namespace Palladio.QoSAdaptor.QMLComparison.QmlSpecification
{
	/// <summary>
	/// Represents a variance aspect of an aspect constraint.
	/// </summary>
	public class QMLVarianceAspect :IQMLStatConstraint
	{
		#region attributes
		/// <summary>
		/// The type of this variance aspect. The value is specified in 
		/// QMLParser.QMLTokenTypes
		/// </summary>
		private int type;

		/// <summary>
		/// The numeric operator of this variance aspect. Possible values are
		/// defined as constants in QMLParser.
		/// </summary>
		private int numericOperator;

		/// <summary>
		/// The value of this variance aspect. 
		/// </summary>
		private double value;
		#endregion

		#region constructor
		/// <summary>
		/// Constructor that takes an AST and constructs a new 
		/// QMLVarianceAspect containing the same information as the AST.
		/// </summary>
		/// <param name="varianceAspect">AST representing a QML variance 
		/// aspect.</param>
		public QMLVarianceAspect(AST varianceAspect)
		{
			if (varianceAspect.Type != QMLTokenTypes.VARIANCE_CONTR)
				throw new QMLSpecificationConstructionException
					("Illegal argument in QMLVarianceAspect constructor. "+
					"Invalid aspect type: "+varianceAspect.Type);

			this.type = varianceAspect.Type;

			AST child = varianceAspect.getFirstChild();
			if (NumericOperatorHelper.IsNumericOperator(child.Type))
				this.numericOperator = child.Type;
			else 
				throw new QMLSpecificationConstructionException
					("Error in QMLVarianceAspect constructor. "+
					"Unknown numeric operator.");
			
			child = child.getNextSibling();
			this.value = Double.Parse(child.getText(), 
													new CultureInfo("en-US"));
		}
		#endregion

		#region properties
		/// <summary>
		/// The type of this aspect. The value is specified in 
		/// QMLParser.QMLTokenTypes.
		/// </summary>
		public int Type
		{
			get
			{
				return this.type;	
			}
		}
		#endregion

		#region public methods
		/// <summary>
		/// Returns a new QML variance aspect string containing all 
		/// information in this QMLVarianceAspect which is compatible to the 
		/// grammar accepted by the QMLParser by Lars Karg.
		/// </summary>
		/// <returns>QML variance aspect.</returns>
		public override string ToString()
		{
			string s = "variance ";
			s += NumericOperatorHelper.NumericOperatorToString(
				this.numericOperator);
			s += " "+this.value+";";
			return s;
		}
		#endregion
	}
}
