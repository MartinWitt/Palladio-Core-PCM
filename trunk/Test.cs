using System;
using System.Collections;

namespace FSM
{
	/// <summary>
	/// A test for FSM
	/// </summary>
	public class Test
	{
		public Test()
		{
		}
		public static void Main()
		{
			//a FSM with no Startstate
			FSM fsmWithNoStartstate = new FSM();
			State noStartState = new State("s",false,false);
			StateIterator IteratesOverNoStart = new StateIterator(fsmWithNoStartstate);
			Console.WriteLine("Testing StateIterator for noStartState");
			while(IteratesOverNoStart.MoveNext())
			{
				Console.WriteLine(IteratesOverNoStart.Current.ToString());
				Console.WriteLine(IteratesOverNoStart.getCurrentTransition.ToString());
			}
			Console.WriteLine("---------------------------------------------------------------");

			Console.WriteLine("A FSM with contains only one state with one Transition witch leads to Startstate");
			FSM none = new FSM();
			State alpha = new State("alpha",true,true);	
			Input nullInput = new Input("0");
			Transition transition0 = new Transition(alpha,nullInput,alpha);
			none.setTransition(transition0);
			StateIterator iter = new StateIterator(none);
			while(iter.MoveNext())
			{
				Console.WriteLine("FSM.Test.none.Current: "+iter.Current.ToString());
				Console.WriteLine("FSM.Test.none.getCurrentTransition: "+iter.getCurrentTransition.ToString());
			}
			Console.WriteLine("------------------------------------------------------");
			FSM easy = new FSM();
			Input z = new Input("z");
			alpha = new State("alpha",true,false);
			State beta = new State("beta", false, true);
			Transition tu = new Transition(alpha, z,beta);
			easy.setTransition(tu);
			
			easy.DisplayOnConsole();
			StateIterator StateIterTest = new StateIterator(easy);
			Console.WriteLine("Testing StateIterator");
			while(StateIterTest.MoveNext())
			{
				Console.WriteLine("FSM.Test.easy.Current: "+StateIterTest.Current.ToString());
				Console.WriteLine("FSM.Test.easy.getCurrentTransition: "+StateIterTest.getCurrentTransition.ToString());
			}

			Console.WriteLine("------------------------------------");
			
			FSM tree = new FSM();
			Input q = new Input("q");
			State gamma = new State("gamma",false,true);
			Transition ti = new Transition(alpha,q,gamma);

			tree.setTransition(tu);
			tree.setTransition(ti);

			tree.DisplayOnConsole();
			StateIterTest = new StateIterator(tree);
			while(StateIterTest.MoveNext())
			{
				
				Console.WriteLine("FSM.Test.tree.Current: "+StateIterTest.Current.ToString());
				Console.WriteLine("FSM.Test.tree.getCurrenTransition: "+StateIterTest.getCurrentTransition.ToString());
			}
			
			Console.WriteLine("------------------------------------------------------------");
			FSM tree1 = new FSM();
			State delta =  new State("delta",false,true);
			Transition treetr1 = new Transition(beta,z,delta);
			tree1.setTransition(tu);
			tree1.setTransition(ti);
			tree1.setTransition(treetr1);
			iter = new StateIterator(tree1);
			while(iter.MoveNext())
			{
				Console.WriteLine("FSM.Test.tree1.Current: "+iter.Current.ToString());
				Console.WriteLine("FSM.Test.tree1.TransitionIterator: "+iter.getCurrentTransition.ToString());
			}
			tree1.DisplayOnConsole();

			Console.WriteLine("------------------------------------------------");
			Console.WriteLine("Another more difficult FSM");

			State s = new State("s",true,false);
			State r = new State("r",false,false);
			State v = new State("v",false,true);
			State g = new State("g",false,false);
			State t = new State("t",false,false);
			State x = new State("x",false,false);
			State u = new State("u",false,false);
			State y = new State("y",false,true);
			
			Input a = new Input("a");
			Input b = new Input("b");
			Input c = new Input("c");
			Input d = new Input("d");
			
			Transition t1 = new Transition(s,a,r);
			Transition t2 = new Transition(r,d,v);
			Transition t3 = new Transition(s,c,g);
			Transition t4 = new Transition(g,d,t);
			Transition t5 = new Transition(g,b,x);
			Transition t6 = new Transition(x,c,u);
			Transition t7 = new Transition(x,d,y);
			Transition t8 = new Transition(g,c,u);
			Transition t9 = new Transition(v,c,r); // RR
			Transition t10 = new Transition(v,a,g); // RR
			FSM fsm = new FSM();

			fsm.setTransition(t6);
			fsm.setTransition(t2);
			fsm.setTransition(t1);
			fsm.setTransition(t4);
			fsm.setTransition(t5);
			fsm.setTransition(t3);
			fsm.setTransition(t7);
			fsm.setTransition(t8);
			fsm.setTransition(t9);  // RR
			fsm.setTransition(t10); // RR

			StateIterator i = new StateIterator(fsm);
			while(i.MoveNext())
			{
				Console.WriteLine("FSM.Test.fsm.Current: "+i.Current.ToString());
				Console.WriteLine("FSM.Test.fsm.getCurrentTransition: "+i.getCurrentTransition.ToString());
			}
			fsm.DisplayOnConsole();
//
//			Console.WriteLine("Testing TransitionIterator:");
//			TransitionIterator trI1= new TransitionIterator(easy);
//			Console.WriteLine("for easy: ");
//			while(trI1.MoveNext())
//			{
//				Console.WriteLine(trI1.Current.ToString());
//			}
//			trI1= new TransitionIterator(tree);
//			Console.WriteLine("for tree: ");
//			while(trI1.MoveNext())
//				Console.WriteLine(trI1.Current.ToString());
//
//			trI1= new TransitionIterator(tree1);
//			Console.WriteLine("for tree1: ");
//			while(trI1.MoveNext())
//				Console.WriteLine(trI1.Current.ToString());
//
//			trI1= new TransitionIterator(fsm);
//			Console.WriteLine("for fsm: ");
//			while(trI1.MoveNext())
//				Console.WriteLine(trI1.Current.ToString());

			Console.WriteLine("-*-*-*-*-------------------------------------------------------");

			FSM chain = new FSM();
			Input ca = new Input("ca");
			Input cb = new Input("cb");
			Input cc = new Input("cc");
			State c1 = new State("c1",true,false);
			State c2 = new State("c2", false, false);
			State c3 = new State("c3", false, false);
			State c4 = new State("c4", false, true);
			Transition tc1 = new Transition(c1, ca ,c2);
			Transition tc2 = new Transition(c2, cb ,c3);
			Transition tc3 = new Transition(c3, cb ,c4);
			chain.setTransition(tc1);
			chain.setTransition(tc2);
			chain.setTransition(tc3);
			
			chain.DisplayOnConsole();
			StateIterTest = new StateIterator(chain);
			Console.WriteLine("Testing StateIterator");
			while(StateIterTest.MoveNext())
			{
				Console.WriteLine("FSM.Test.chain.Current: "+StateIterTest.Current.ToString());
				Console.WriteLine("FSM.Test.chain.getCurrentTransition: "+StateIterTest.getCurrentTransition.ToString());
			}
			Console.WriteLine("---------------------------------------------------------------");
			FSM testingNewStateIterator = new FSM();
			State ds = new State("ds",true, false);
			State dx = new State("dx", false,false);	
			State de = new State("de", false,false);
			State dy = new State("dy", false,false);


			Transition d1 = new Transition(ds,a,de);
			Transition d2 = new Transition(ds,b,dy);
			Transition d3 = new Transition(ds,c,dx);
			Transition d4 = new Transition(dy,b,dx);

			testingNewStateIterator.setTransition(d1);
			testingNewStateIterator.setTransition(d2);
			testingNewStateIterator.setTransition(d3);
			testingNewStateIterator.setTransition(d4);

			StateIterTest = new StateIterator(testingNewStateIterator);
			Console.WriteLine("Testing StateIterator");
			while(StateIterTest.MoveNext())
			{
				Console.WriteLine("FSM.Test.testingNewStateIterator.Current: "+StateIterTest.Current.ToString());
				Console.WriteLine("FSM.Test.testingNewStateIterator.getCurrentTransition: "+StateIterTest.	getCurrentTransition.ToString());
			}

			Console.WriteLine("finished");
			Console.Read();
		}
						  
	}
	
}
