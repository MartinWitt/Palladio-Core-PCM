using System;
using System.Collections;
using ReflectionBasedVisitor;

namespace Palladio.FiniteStateMachines.DefaultFSM {

	/// <summary>
	///		Class representing the abstract type of a state.
	///		
	///		author: JH
	/// </summary>
	internal abstract class AbstractState : IState 
	{
		protected bool isErrorState = false;
		protected Hashtable attributeTable;
		protected string id;

		/// <summary>
		/// If true, this state is an error state in which the FSM can drop if
		/// running along an invalid transition
		/// </summary>
		public bool IsErrorState
		{
			get
			{
				return isErrorState;
			}
			set
			{
				isErrorState = value;
			}
		}
		
		/// <summary>
		/// Return a string representation of this state, e.g. for graphical output.
		/// Here implemented as payload.ToString();
		/// </summary>
		public string ID
		{
			get
			{
				return id;
			}
		}

		/// <summary>
		/// Information describing this state. Any type of information object can be
		/// associated to a state.
		/// </summary>
		public virtual Hashtable AttributeTable
		{
			get
			{
				return attributeTable;
			}
		}

		/// <summary>
		///		Default implementation of GetHashCode(). 
		///		Refers to the hashcode of name.
		/// </summary>
		/// <returns>
		///		Hashcode of Name
		///	</returns>
		public override int GetHashCode() 
		{
			return id.GetHashCode();
		}
		
		/// <summary>
		///		Default implementation of Equals.
		/// </summary>
		/// <param name="obj">
		///		The other object.
		///	</param>
		/// <returns>
		///		True, if Name, IsStartState and
		///		IsFinalState are Equal; false otherwise.
		///	</returns>
		public override bool Equals(object obj) 
		{
			if (obj is IState) 
			{ 
				IState state = (IState)obj;
				return id.Equals(state.ID);
			}
			return false;
		}

		/// <summary>
		/// Overriden ToString for debug purposes
		/// </summary>
		/// <returns>The label of this state</returns>
		public override string ToString()
		{
			return ID;
		}

		/// <summary>
		/// Implementation of the data structure driven visitor movement. It is
		/// not implemented here!
		/// </summary>
		/// <param name="v">The visitor visiting this object</param>
		public virtual void AcceptVisitor(IVisitor v) {}

	}
}