using System;
using System.Xml;
using Palladio.Attributes;
using Palladio.FiniteStateMachines.Serializer;
using Palladio.FiniteStateMachines.Serializer.Interfaces;

namespace Palladio.FiniteStateMachines.UnitTests.TestClasses
{
	/// <summary>
	/// Attribute serializer plugin for testing purposes
	/// </summary>
	/// <remarks>
	/// <code>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/08/21 18:07:42  kelsaka
	/// - added further tests
	///
	/// Revision 1.2  2005/08/21 10:05:01  kelsaka
	/// - REadded test cases
	///
	/// Revision 1.1  2005/08/15 09:53:20  kelsaka
	/// - added further test cases
	/// - use of GUID to identify attribute types
	///
	/// </code>
	/// </remarks>
	public class Test1AttributeSerializer : IAttributeSerializerPlugin
	{
		/// <summary>
		/// Default.
		/// </summary>
		public Test1AttributeSerializer()
		{
			
		}

		/// <summary>
		/// Serializes the given attribute and writes the results to the given xmlwriter.
		/// </summary>
		/// <param name="attributeType">The attributes type to serialize. This information has be serialized
		/// as well.</param>
		/// <param name="attribute">The attribute to serialize.</param>
		/// <param name="xmlWriter">The writer to use for serializing attributes.</param>
		public void SerializeAttribute (IAttributeType attributeType, IAttribute attribute, XmlWriter xmlWriter)
		{
			xmlWriter.WriteAttributeString("GUID", attributeType.GUID.ToString());
			xmlWriter.WriteAttributeString("displayName", attributeType.DisplayName);
			xmlWriter.WriteAttributeString("description", attributeType.Description);
			xmlWriter.WriteAttributeString("valueType", attributeType.ValueType.ToString());
		}

		/// <summary>
		/// Deserializes the given xmlNode, that represents an <see cref="IAttribute"/>
		/// including an <see cref="IAttributeType"/>.
		/// </summary>
		/// <param name="xmlNode">The node to deserialize.</param>
		/// <returns>The deserialized attribute information.</returns>
		public AttributeInfo DeserializeAttribute (XmlNode xmlNode)
		{
			Test1AttributeType at = new Test1AttributeType();
			if (!xmlNode.Attributes.GetNamedItem("displayName").Value.Equals(at.DisplayName))
			{
				throw new ModelSerializationException("displayName was incorrect or not found");
			}

			return new AttributeInfo(new Test1Attribute(), at);
		}

		/// <summary>
		/// The namespace of the IAttribute elements. (read)
		/// </summary>
		public string XmlNamespace
		{
			get { return "Test2-Namespace.com"; }
		}

		/// <summary>
		/// The URI of the XSD-File that describes the XML-Scheme of the Plugin output. This XSD is used
		/// for validation. (read)
		/// </summary>
		public string XmlSchemaURI
		{
			get { return "Test1.xsd"; }
		}


	}
}
