using System;
using System.Collections;
using Utils.Collections;
using Utils.Exceptions;
using Palladio.FiniteStateMachines;
using Palladio.FiniteStateMachines.Visitors;


namespace Palladio.FiniteStateMachines.DefaultFSM
{

	/// <summary>
	///     The AbstractFiniteStateMachine implements some
	///     default functionality useful for most finite state
	///     machines.
	/// </summary>
	internal abstract class AbstractFSM : IFiniteStateMachine 
	{
		#region Properties

		public abstract IState StartState { get; set; }

		public abstract IState[] FinalStates { get; set; }

		public abstract IInput[] InputAlphabet { get; set; }

		public virtual IState[] States 
		{
			get
			{
				StateVisitor visitor = new StateVisitor(this);
				visitor.Visit(StartState);
				return visitor.VisitedStates;
			}
		}

		public virtual ITransition[] Transitions
		{
			get
			{
				TransitionVisitor visitor = new TransitionVisitor(this);
				visitor.Visit(StartState);
				return visitor.VisitedTransitions;
			}
		}

		#endregion

		#region Methods

		public abstract ITransition GetNextTransition(IState aSourceState, IInput anInput);
        
		public abstract ITransition[] GetNextTransitions(IState aSourceState, IInput anInput);

		public abstract bool IsFinalState(IState aState);
		
		public abstract object Clone();

		public virtual IState GetNextState(IState aSourceState, IInput anInput) 
		{
			return GetNextTransition(aSourceState,anInput).DestinationState;
		}
																																		
		public virtual IState[] GetNextStates(IState aSourceState, IInput anInput)
		{
			ITransition[] transitions = GetNextTransitions(aSourceState, anInput);
			Set statesSet = new Set();
			foreach (ITransition trans in transitions)
			{
				statesSet.Add(trans.DestinationState);
			}
			IState[] resultStates = new IState[statesSet.Count];
			statesSet.CopyTo(resultStates,0);
			return resultStates;
		}

		public virtual ITransition[] GetOutgoingTransitions(IState aSourceState) 
		{
			IList transList = new Vector();
			foreach( IInput input in InputAlphabet ) 
			{
				ITransition[] transArray = GetNextTransitions(aSourceState,input);
				foreach (ITransition trans in transArray)
				{
					if ( !trans.DestinationState.IsErrorState ) 
					{
						transList.Add(trans);
					}
				}
			}
			ITransition[] resultTransArray = new ITransition[transList.Count];
			transList.CopyTo(resultTransArray,0);
			return resultTransArray;
		}


	public virtual IState[] GetReachableStates(IState aState) 
		{
			IList stateList = new Vector();
			GetReachableStatesRecursive(aState,ref stateList);
			IState[] resultStates = new IState[stateList.Count];
			stateList.CopyTo(resultStates,0);
			return resultStates;
		}

		private void GetReachableStatesRecursive(IState aState,ref IList resultSet) 
		{
			if ((!resultSet.Contains(aState)) && (aState.IsErrorState)) 
			{
				resultSet.Add(aState);
				IList transitions = GetOutgoingTransitions(aState);
				if (transitions != null) 
				{
					foreach (ITransition trans in transitions) 
					{
						GetReachableStatesRecursive(trans.DestinationState,ref resultSet);
					}
				}
			}
		}

		public override bool Equals(object obj) 
		{
			if ( obj is IFiniteStateMachine) 
			{
//TODO				return FSMFactory.AreEqual( this, (IFiniteStateMachine) obj );
				return false;
			} 
			return false;
		}

		public override string ToString() 
		{
//			string result = "start state : ";
//			try 
//			{
//				result += StartState+"\n";
//				result += "transitions : \n";
//				DynamicTransitionIterator iterator = new DynamicTransitionIterator(StartState,this);
//				while(iterator.MoveNext())
//				{
//					result += "\t"+iterator.Current+"\n";
//					iterator.Append(iterator.Current.DestinationState);
//				}
//			} 
//			catch (InvalidStateException e)
//			{
//				result += e.Message+"\n";
//			}	
//			try 
//			{
//				result += "final states: ";
//				foreach (IState state in FinalStates) 
//				{
//					result += state + " ";
//				}
//			} 
//			catch (InvalidStateException e)
//			{
//				result += e.Message+"\n";
//			}	
//			return result;
			return "";
		}

		public override int GetHashCode() 
		{
			return base.GetHashCode();
		}

		#endregion

		#region Static Data

		protected static IState ERROR_STATE = new DefaultState("ERROR_STATE", true);
		#endregion
	}
}

