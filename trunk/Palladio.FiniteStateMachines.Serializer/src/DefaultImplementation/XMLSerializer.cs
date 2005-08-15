using System;
using System.Collections;
using System.IO;
using System.Text;
using System.Xml;
using Palladio.Attributes;
using Palladio.FiniteStateMachines.Serializer;

namespace Palladio.FiniteStateMachines.Serializer
{
	/// <summary>
	/// Serializer for the Palladio Finite State Machines (FSMs). Handles laoding and saving of
	/// FSMs including <see cref="IAttribute"/>s and <see cref="IInput"/>s.
	/// </summary>
	/// <remarks>
	/// Typical output of the serializer looks like this:
	/// <code>
	///		<?xml version="1.0" encoding="utf-8"?>
	///		<!--Finite State Machine - Palladio Research Group, Software Engineering, University of Oldenburg, Germany-->
	///		<Palladio.FiniteStateMachine>
	///		<!--List of states of the FSM:-->
	///		<states>
	///		<state id="2" isErrorState="False">
	///		<!--List of IAttributes:-->
	///		<attributes />
	///		</state>
	///		<state id="3" isErrorState="False">
	///		<!--List of IAttributes:-->
	///		<attributes />
	///		</state>
	///		<state id="1" isErrorState="False">
	///		<!--List of IAttributes:-->
	///		<attributes />
	///		</state>
	///		</states>
	///		<!--The start state of the FSM:-->
	///		<startState idref="1" />
	///		<!--List of final states:-->
	///		<finalStates>
	///		<finalState idref="1" />
	///		<finalState idref="3" />
	///		</finalStates>
	///		<!--List of transitions:-->
	///		<transitions>
	///		<transition sourceStateIdRef="2" destinationStateIdRef="3">
	///		<inputSymbol inputSymbolIdRef="c" />
	///		<!--List of IAttributes:-->
	///		<attributes />
	///		</transition>
	///		<transition sourceStateIdRef="3" destinationStateIdRef="1">
	///		<inputSymbol inputSymbolIdRef="eps" />
	///		<!--List of IAttributes:-->
	///		<attributes />
	///		</transition>
	///		<transition sourceStateIdRef="1" destinationStateIdRef="1">
	///		<inputSymbol inputSymbolIdRef="a" />
	///		<!--List of IAttributes:-->
	///		<attributes />
	///		</transition>
	///		<transition sourceStateIdRef="1" destinationStateIdRef="2">
	///		<inputSymbol inputSymbolIdRef="b" />
	///		<!--List of IAttributes:-->
	///		<attributes />
	///		</transition>
	///		</transitions>
	///		<inputSymbolAlphabet>
	///		<inputSymbol inputSymbolId="a" />
	///		<inputSymbol inputSymbolId="eps" />
	///		<inputSymbol inputSymbolId="b" />
	///		<inputSymbol inputSymbolId="c" />
	///		</inputSymbolAlphabet>
	///		</Palladio.FiniteStateMachine>
	///	-----------------
	/// Version history:
	///
	/// $Log$
	/// Revision 1.6  2005/08/15 09:51:50  kelsaka
	/// - added further test cases
	/// - use of GUID to identify attribute types
	///
	/// Revision 1.5  2005/08/15 07:59:24  kelsaka
	/// - added futher tests (including test classes)
	///
	/// Revision 1.4  2005/08/15 06:44:39  kelsaka
	/// - added handling for attribute serializer plugins
	///
	/// Revision 1.3  2005/08/14 18:18:50  kelsaka
	/// - changed method signature for saving into files
	///
	/// Revision 1.2  2005/08/14 16:22:46  kelsaka
	/// - added writing to xml without use of plugins.
	///
	/// Revision 1.1  2005/08/14 13:43:22  kelsaka
	/// - initial creation of FSM serialization
	///
	/// </code>
	/// </remarks>
	public class XMLSerializer : IXMLSerializer
	{
		/// <summary>
		/// Use the attribute type GUID as key.
		/// </summary>
		private Hashtable attributeSerializerPlugins;

		/// <summary>
		/// Default constructor.
		/// </summary>
		public XMLSerializer()
		{
			attributeSerializerPlugins = new Hashtable();
		}

		#region public methods

		#region Load methods

		/// <summary>
		/// Loads a <see cref="IFiniteStateMachine"/> from a <see cref="XmlNode"/>.
		/// </summary>
		/// <param name="xmlNode">A xmlNode that represents a FSM.</param>
		/// <returns>The deserialized <see cref="IFiniteStateMachine"/>, that was represented
		/// by the xmlNode.</returns>
		public IFiniteStateMachine Load (XmlNode xmlNode)
		{
			throw new NotImplementedException ();
		}

		/// <summary>
		/// Loads a <see cref="IFiniteStateMachine"/> from a file.
		/// </summary>
		/// <param name="xmlFilePath">Location of the xml file, that contains a FSM.</param>
		/// <returns>The deserialized <see cref="IFiniteStateMachine"/>, that was represented
		/// by the xml file.</returns>
		public IFiniteStateMachine Load (FileInfo xmlFilePath)
		{
			throw new NotImplementedException ();
		}

		#endregion

		#region Save methods

		/// <summary>
		/// Saves the given <see cref="IFiniteStateMachine"/> using the given <see cref="xmlWriter"/>.
		/// </summary>
		/// <param name="xmlWriter">Used to save the FSM.</param>
		/// <param name="fsm">The FSM to serialize.</param>
		/// <remarks>Note: The xmlWriter is NOT closed after writing.</remarks>
		public void Save (XmlWriter xmlWriter, IFiniteStateMachine fsm)
		{
			xmlWriter.WriteComment("Finite State Machine - Palladio Research Group, Software Engineering, University of Oldenburg, Germany");
			xmlWriter.WriteStartElement("Palladio.FiniteStateMachine");

			this.writeStates(xmlWriter, fsm);
			this.writeStartState(xmlWriter, fsm);
			this.writeFinalStates(xmlWriter, fsm);
			this.writeTransitions(xmlWriter, fsm);
			this.writeInputAlphabet(xmlWriter, fsm);

			xmlWriter.WriteEndElement();
		}

		/// <summary>
		/// Writes a list of states. For serialization of attribute the according method is used.
		/// </summary>
		/// <param name="xmlWriter">Writer to use.</param>
		/// <param name="fsm">FSM to serialize.</param>
		private void writeStates(XmlWriter xmlWriter, IFiniteStateMachine fsm)
		{
			xmlWriter.WriteComment("List of states of the FSM:");
			xmlWriter.WriteStartElement("states");

			foreach(IState state in fsm.States)
			{
				xmlWriter.WriteStartElement("state");

				xmlWriter.WriteAttributeString("id", state.ID);
				xmlWriter.WriteAttributeString("isErrorState", state.IsErrorState.ToString());

				writeAttributes (xmlWriter, state.Attributes);

				xmlWriter.WriteEndElement();
			}

			xmlWriter.WriteEndElement();
		}

		/// <summary>
		/// Writes a list of attributes.
		/// </summary>
		/// <param name="xmlWriter">The writer to use.</param>
		/// <param name="attributeHash">The Hash of attributes to serialize.</param>
		private void writeAttributes (XmlWriter xmlWriter, IAttributeHash attributeHash)
		{
			xmlWriter.WriteComment("List of IAttributes:");
			xmlWriter.WriteStartElement("attributes");
			xmlWriter.WriteComment("Written by plugin:");
	
			foreach(IAttributeType attributeType in attributeHash.AttributeTypes)
			{
				// use Plugin for serialization:
				if(attributeSerializerPlugins.ContainsKey(attributeType.GUID))
				{
					((IAttributeSerializerPlugin)attributeSerializerPlugins[attributeType.GUID])
						.SerializeAttribute(attributeType, attributeHash[attributeType], xmlWriter);
				}
				else
				{
					throw new AttributeNotSupportedException(
						"There is no serializer plugin registered for the attribute type " +
						attributeType.GUID.ToString() + "; " + attributeType.DisplayName);
				}
			}
	
			xmlWriter.WriteEndElement();
		}

		/// <summary>
		/// Write a XML node describing the start state.
		/// </summary>
		/// <param name="xmlWriter">Writer to use.</param>
		/// <param name="fsm">FSM to serialize.</param>
		private void writeStartState(XmlWriter xmlWriter, IFiniteStateMachine fsm)
		{
			xmlWriter.WriteComment("The start state of the FSM:");
			xmlWriter.WriteStartElement("startState");
			xmlWriter.WriteAttributeString("idref", fsm.StartState.ID);
			xmlWriter.WriteEndElement();
		}

		/// <summary>
		/// Writes a list of final states.
		/// </summary>
		/// <param name="xmlWriter">Writer to use.</param>
		/// <param name="fsm">FSM to serialize.</param>
		private void writeFinalStates(XmlWriter xmlWriter, IFiniteStateMachine fsm)
		{
			xmlWriter.WriteComment("List of final states:");
			xmlWriter.WriteStartElement("finalStates");

			foreach(IState state in fsm.FinalStates)
			{
				xmlWriter.WriteStartElement("finalState");
				xmlWriter.WriteAttributeString("idref", state.ID);
				xmlWriter.WriteEndElement();
			}

			xmlWriter.WriteEndElement();
		}

		/// <summary>
		/// Writes a list of transitions.
		/// </summary>
		/// <param name="xmlWriter">Writer to use.</param>
		/// <param name="fsm">FSM to serialize.</param>
		private void writeTransitions(XmlWriter xmlWriter, IFiniteStateMachine fsm)
		{
			xmlWriter.WriteComment("List of transitions:");
			xmlWriter.WriteStartElement("transitions");

			foreach(ITransition transition in fsm.Transitions)
			{
				xmlWriter.WriteStartElement("transition");
				
				xmlWriter.WriteAttributeString("sourceStateIdRef", transition.SourceState.ID);
				xmlWriter.WriteAttributeString("destinationStateIdRef", transition.DestinationState.ID);
				writeInputSymbol(xmlWriter, transition);
				writeAttributes(xmlWriter, transition.Attributes);

				xmlWriter.WriteEndElement();
			}

			xmlWriter.WriteEndElement();
		}

		/// <summary>
		/// Writes the input symbol for a given transition.
		/// </summary>
		/// <param name="xmlWriter">The writer to use.</param>
		/// <param name="transition">The transition whose input symbol shall be serialized.</param>
		private void writeInputSymbol (XmlWriter xmlWriter, ITransition transition)
		{
			xmlWriter.WriteStartElement("inputSymbol");

			//TODO: check use of ToString()
			xmlWriter.WriteAttributeString("inputSymbolIdRef", transition.InputSymbol.ID.ToString());
			
			xmlWriter.WriteEndElement();
		}

		/// <summary>
		/// Writes a list of input symbol for the given FSM.
		/// </summary>
		/// <param name="xmlWriter">Writer to use.</param>
		/// <param name="fsm">FSM to serialize.</param>
		private void writeInputAlphabet (XmlWriter xmlWriter, IFiniteStateMachine fsm)
		{
			xmlWriter.WriteStartElement("inputSymbolAlphabet");

			foreach (IInput input in fsm.InputAlphabet)
			{
				xmlWriter.WriteStartElement("inputSymbol");
				//TODO: check use of ToString()
				xmlWriter.WriteAttributeString("inputSymbolId", input.ID.ToString());
				//TODO: plugin use here.
				xmlWriter.WriteEndElement();
			}

			xmlWriter.WriteEndElement();
		}

		/// <summary>
		/// Saves the given <see cref="IFiniteStateMachine"/> in a file. For the document
		/// UTF8 encoding is used. The text indent is 4.
		/// </summary>
		/// <param name="xmlFilePath">The xml file location to save the FSM in.</param>
		/// <param name="fsm">The FSM to serialize.</param>
		public void Save (FileInfo xmlFilePath, IFiniteStateMachine fsm)
		{
			XmlTextWriter xmlWriter = null;
			try 
			{
				xmlWriter = new XmlTextWriter(xmlFilePath.Name, Encoding.UTF8);
				xmlWriter.Formatting = Formatting.Indented;
				xmlWriter.Indentation= 4;
				xmlWriter.Namespaces = true;
				xmlWriter.WriteStartDocument();
				xmlWriter.WriteProcessingInstruction("xml-stylesheet", "type='text/xsl' href='PalladioFSM.xsl'");

				this.Save(xmlWriter, fsm);
			}
			catch (Exception e)
			{
				xmlWriter.WriteComment("*** !!!There occured errors on writing this XML-file!!! This file might be invalid. ***");
				throw e;
			}
			finally
			{
				xmlWriter.Close();
			}
		}

		#endregion

		#region Plugin handling

		/// <summary>
		/// Adds a serializer for an <see cref="IAttribute"/>.
		/// </summary>
		/// <param name="plugin">The serializer for the attribute.</param>
		/// <param name="attributeType">The attribute type to register for. If there is already an plugin registered
		/// for the <see cref="IAttributeType"/> the new one is used. The GUID is used to identify the attribute
		/// type.</param>
		public void AddAttributeSerializerPlugin (IAttributeSerializerPlugin plugin, IAttributeType attributeType)
		{
			if(attributeSerializerPlugins.ContainsKey(attributeType.GUID))
			{
				attributeSerializerPlugins.Remove(attributeType.GUID);
			}
			attributeSerializerPlugins.Add(attributeType.GUID, plugin);
		}

		/// <summary>
		/// Removes an existing attribute serialiser plugin for the given <see cref="IAttribute"/>.
		/// </summary>
		/// <param name="attributeType">The attribute registration to be removed. The GUID is
		/// used to identify the attribute type.</param>
		public void RemoveAttributeSerializerPlugin (IAttributeType attributeType)
		{
			attributeSerializerPlugins.Remove(attributeType.GUID);
		}

		/// <summary>
		/// Adds a serializer for an <see cref="IInput"/>.
		/// </summary>
		/// <param name="plugin">The serializer for the input.</param>
		/// <param name="input">The input to register for.</param>
		public void AddInputSerializerPlugin (IInputSerializerPlugin plugin, IInput input)
		{
			throw new NotImplementedException ();
		}

		/// <summary>
		/// Removes an existing input serialiser plugin for the given <see cref="IInput"/>.
		/// </summary>
		/// <param name="input">The input registration to be removed.</param>
		public void RemoveAttributeInputPlugin (IInput input)
		{
			throw new NotImplementedException ();
		}

		#endregion

		#endregion
	}
}
