//------------------------------------------------------------------------------
// <autogenerated>
//     This code was generated by CodeSmith.
//     Version: 2.6.0.117
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </autogenerated>
//------------------------------------------------------------------------------
using System;
using System.Collections;
using Palladio.Attributes;
using Palladio.FiniteStateMachines;
using ReflectionBasedVisitor;
using Palladio.ComponentModel.Exceptions;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// A ProtocolIModel is an extension of a SignatureListModel. In
	/// addition to the list of services it describes the set of all possible
	/// call sequences of these services using a finite state machine 
	/// called protocol. The language accepted by the protocol
	/// represents the possible call sequences.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.3.2.8  2005/02/11 10:27:49  joemal
	/// merge the changes made by uffi with the template
	///
	/// Revision 1.2.2.4  2005/02/11 10:24:48  joemal
	/// merge the changes made by uffi with the template
	///
	/// Revision 1.2.2.3  2005/02/10 19:21:33  joemal
	/// merge the changes made by uffi with the template
	///
	/// Revision 1.2.2.2  2005/02/10 18:39:25  joemal
	/// merge the changes made by uffi with the template
	///
	/// Revision 1.2.2.1  2004/12/02 23:39:49  uffi
	/// IAttributeHash replaced by AttributeHash,
	/// added attribute serialization
	///
	/// Revision 1.2  2004/06/09 12:36:31  sbecker
	/// Fixed documentation and renamed IExternalSignature
	///
	/// Revision 1.1  2004/06/03 14:37:29  sbecker
	/// Added the possibility to attach auxiliary specifications to a basic component
	///
	/// Revision 1.1  2004/06/02 14:50:25  sbecker
	/// Initial Import after a major rework
	///
	/// Revision 1.8  2004/05/24 21:56:39  sbecker
	/// Small Bugfix related to IInput and ISignature
	///
	/// Revision 1.7  2004/05/24 15:03:14  sliver
	/// added tests for fsmprotocols in a basic component
	///
	/// Revision 1.6  2004/05/24 13:54:07  sbecker
	/// Added GetSignaturesByName
	///
	/// Revision 1.5  2004/05/24 12:42:34  sbecker
	/// Added test cases for creating protocol interfaces
	///
	/// Revision 1.4  2004/05/23 16:03:56  sliver
	/// completed unit tests
	///
	/// Revision 1.3  2004/05/19 07:54:24  sbecker
	/// Added CVS header
	///
	///
	/// </pre>
	/// </remarks>
	internal class FSMInterface : IFSMInterface
	{
		protected IEditableFiniteStateMachine editFSM = null;

		public IEditableFiniteStateMachine EditFSM
		{
			get
			{
				if (editFSM == null)
				{
					editFSM = FSMFactory.GetEditableFSM(fsm);
					fsm = editFSM;
				}
				return editFSM;
			}
		}

		#region Properties
		/// <summary>
		/// A Protocol describing
		/// the possible call sequences of the services.
		/// </summary>
		public IFiniteStateMachine FSM
		{
			get { return fsm; }
		}

		/// <summary>
		/// Signatures  of the interface.
		/// </summary>
		public ISignature[] Signatures 
		{
			get
			{
				try
				{
					ISignature[] result = new ISignature[fsm.InputAlphabet.Length];
					for (int i = 0; i < fsm.InputAlphabet.Length; i++)
					{
						result[i] = (ISignature)fsm.InputAlphabet[i].ID;
					}
					return result;
				}
				catch (InvalidCastException ex)
				{
					throw new FSMNotProtocolAutomatonException("Protocol FSMs need to have ISignature objects "+
						"attached to their transitions",ex);
				}
			}
		}

		/// <summary>
		/// A list of attributes attached an object. 
		/// </summary>
		public AttributeHash Attributes 
		{ 
			get { return attributes; }
		}
		#endregion
		
		#region Methods
		/// <summary>
		/// This method is called by the <see cref="ReflectionBasedVisitor"/> to allow data
		/// structure driven visiting of the structure.<br></br>
		/// Leave this method's body empty if you don't need data structure driven visiting.
		/// </summary>
		/// <param name="visitor">The visitor to accept</param>
		public void AcceptVisitor (IVisitor visitor) {}

		public void SignatureListChangeEventHandler(object sender, SignatureListChangeEventArgs args)
		{
			if (args.ChangeTime == ChangeTimeEnum.BEFORE)
			{
				switch (args.ChangeType)
				{
					case ChangeTypeEnum.ADD:
						EditFSM.AddInputSymbols(FSMFactory.CreateInputFromList(args.Signature).StoredInputs);
						break;
					case ChangeTypeEnum.DELETE:
						EditFSM.DeleteInputSymbols(FSMFactory.CreateInputFromList(args.Signature).StoredInputs);
						break;
				}
			}
		}

		/// <summary>
		/// Creates a copy of the current instance.
		/// </summary>
		/// <returns>A new object with the same values as the current instance.</returns>
		public object Clone()
		{
			return new FSMInterface(attributes,fsm);
		}
		
		public override bool Equals(object obj)
		{
			if (!(obj is FSMInterface)) return false;
			if (obj == this) return true;
			FSMInterface other = (FSMInterface)obj;
			return other.FSM.Equals(this.FSM);
		}

		public override int GetHashCode()
		{
			return (fsm == null ? 0 : fsm.GetHashCode());
		}
		
		
		public void Serialize(System.Xml.XmlTextWriter writer)
		{
		
		}
		
		public void Deserialize(System.Xml.XmlNode element)
		{
		
		}
	
		#endregion

		#region Constructors
		/// <summary>
		/// Copy constructor
		/// </summary>
		/// <param name="fsm">The FSM to be stored in the cloned class</param>
		/// <param name="hash">The attributes to clone</param>
		internal FSMInterface ( AttributeHash hash, IFiniteStateMachine fsm)
		{
			this.fsm = (IFiniteStateMachine)fsm.Clone();
			this.attributes = (AttributeHash)hash.Clone();
		}

		#endregion
		
		#region Data
		
		private AttributeHash attributes;
		private IFiniteStateMachine fsm;
		
		#endregion

	}
	
	/// <summary>
	/// A ProtocolIModel is an extension of a SignatureListModel. In
	/// addition to the list of services it describes the set of all possible
	/// call sequences of these services using a finite state machine 
	/// called protocol. The language accepted by the protocol
	/// represents the possible call sequences.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.3.2.8  2005/02/11 10:27:49  joemal
	/// merge the changes made by uffi with the template
	///
	/// Revision 1.2.2.4  2005/02/11 10:24:48  joemal
	/// merge the changes made by uffi with the template
	///
	/// Revision 1.2.2.3  2005/02/10 19:21:33  joemal
	/// merge the changes made by uffi with the template
	///
	/// Revision 1.2.2.2  2005/02/10 18:39:25  joemal
	/// merge the changes made by uffi with the template
	///
	/// Revision 1.2.2.1  2004/12/02 23:39:49  uffi
	/// IAttributeHash replaced by AttributeHash,
	/// added attribute serialization
	///
	/// Revision 1.2  2004/06/09 12:36:31  sbecker
	/// Fixed documentation and renamed IExternalSignature
	///
	/// Revision 1.1  2004/06/03 14:37:29  sbecker
	/// Added the possibility to attach auxiliary specifications to a basic component
	///
	/// Revision 1.1  2004/06/02 14:50:25  sbecker
	/// Initial Import after a major rework
	///
	/// Revision 1.8  2004/05/24 21:56:39  sbecker
	/// Small Bugfix related to IInput and ISignature
	///
	/// Revision 1.7  2004/05/24 15:03:14  sliver
	/// added tests for fsmprotocols in a basic component
	///
	/// Revision 1.6  2004/05/24 13:54:07  sbecker
	/// Added GetSignaturesByName
	///
	/// Revision 1.5  2004/05/24 12:42:34  sbecker
	/// Added test cases for creating protocol interfaces
	///
	/// Revision 1.4  2004/05/23 16:03:56  sliver
	/// completed unit tests
	///
	/// Revision 1.3  2004/05/19 07:54:24  sbecker
	/// Added CVS header
	///
	///
	/// </pre>
	/// </remarks>
	internal class FSMServiceEffect : IFSMServiceEffect
	{
		protected IEditableFiniteStateMachine editFSM = null;

		public IEditableFiniteStateMachine EditFSM
		{
			get
			{
				if (editFSM == null)
				{
					editFSM = FSMFactory.GetEditableFSM(fsm);
					fsm = editFSM;
				}
				return editFSM;
			}
		}

		#region Properties
		/// <summary>
		/// A Protocol describing
		/// the possible call sequences of the services.
		/// </summary>
		public IFiniteStateMachine FSM
		{
			get { return fsm; }
		}

		/// <summary>
		/// Services  of the interface.
		/// </summary>
		public IService[] Services 
		{
			get
			{
				try
				{
					IService[] result = new IService[fsm.InputAlphabet.Length];
					for (int i = 0; i < fsm.InputAlphabet.Length; i++)
					{
						result[i] = (IService)fsm.InputAlphabet[i].ID;
					}
					return result;
				}
				catch (InvalidCastException ex)
				{
					throw new FSMNotProtocolAutomatonException("Protocol FSMs need to have ISignature objects "+
						"attached to their transitions",ex);
				}
			}
		}

		/// <summary>
		/// A list of attributes attached an object. 
		/// </summary>
		public AttributeHash Attributes 
		{ 
			get { return attributes; }
		}
		#endregion
		
		#region Methods
		/// <summary>
		/// This method is called by the <see cref="ReflectionBasedVisitor"/> to allow data
		/// structure driven visiting of the structure.<br></br>
		/// Leave this method's body empty if you don't need data structure driven visiting.
		/// </summary>
		/// <param name="visitor">The visitor to accept</param>
		public void AcceptVisitor (IVisitor visitor) {}

		public void ServiceListChangeEventHandler(object sender, ServiceListChangeEventArgs args)
		{
			if (args.ChangeTime == ChangeTimeEnum.BEFORE)
			{
				switch (args.ChangeType)
				{
					case ChangeTypeEnum.ADD:
						EditFSM.AddInputSymbols(FSMFactory.CreateInputFromList(args.Service).StoredInputs);
						break;
					case ChangeTypeEnum.DELETE:
						EditFSM.DeleteInputSymbols(FSMFactory.CreateInputFromList(args.Service).StoredInputs);
						break;
				}
			}
		}

		/// <summary>
		/// Creates a copy of the current instance.
		/// </summary>
		/// <returns>A new object with the same values as the current instance.</returns>
		public object Clone()
		{
			return new FSMServiceEffect(attributes,fsm);
		}
		
		public override bool Equals(object obj)
		{
			if (!(obj is FSMServiceEffect)) return false;
			if (obj == this) return true;
			FSMServiceEffect other = (FSMServiceEffect)obj;
			return other.FSM.Equals(this.FSM);
		}

		public override int GetHashCode()
		{
			return (fsm == null ? 0 : fsm.GetHashCode());
		}
		
		
		public void Serialize(System.Xml.XmlTextWriter writer)
		{
		
		}
		
		public void Deserialize(System.Xml.XmlNode element)
		{
		
		}
	
		#endregion

		#region Constructors
		/// <summary>
		/// Copy constructor
		/// </summary>
		/// <param name="fsm">The FSM to be stored in the cloned class</param>
		/// <param name="hash">The attributes to clone</param>
		internal FSMServiceEffect ( AttributeHash hash, IFiniteStateMachine fsm)
		{
			this.fsm = (IFiniteStateMachine)fsm.Clone();
			this.attributes = (AttributeHash)hash.Clone();
		}

		#endregion
		
		#region Data
		
		private AttributeHash attributes;
		private IFiniteStateMachine fsm;
		
		#endregion

	}
}
