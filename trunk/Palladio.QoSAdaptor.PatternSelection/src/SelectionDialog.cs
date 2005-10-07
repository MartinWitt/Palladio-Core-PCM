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

using Palladio.QoSAdaptor.Interfaces;
using Palladio.QoSAdaptor.Pattern;
using System.Collections;
using System.Windows.Forms;
using Palladio.Utils.Collections;

namespace Palladio.QoSAdaptor.PatternSelection
{
	/// <summary>
	/// This class implements a window in which one of the 
	/// recommended patterns can be chosen. 
	/// </summary>
	public class SelectionDialog : System.Windows.Forms.Form
	{
		#region data
		/// <summary>
		/// Erforderliche Designervariable.
		/// </summary>
		private System.ComponentModel.Container components = null;
		private Hashmap mismatchSolvingPatterns;
		private ArrayList rButtons;
		private Button generateAdaptorButton;
		private Button generatePredictionButton;
		private int counter;
		private int tabCounter;
		private Selector controller;
		#endregion

		#region properties
		/// <summary>
		/// A list of all radio buttons of the GUI. Each button is linked to a
		/// certain pattern.
		/// </summary>
		public IList RButtons
		{
			get
			{
				return this.rButtons;
			}
		}

		/// <summary>
		/// The button pressed to generate an adaptor.
		/// </summary>
		public Button GenerateAdaptorButton
		{
			get
			{
				return this.generateAdaptorButton;
			}
		}

		/// <summary>
		/// The button pressed to generate a prediction model.
		/// </summary>
		public Button GeneratePredictionButton
		{
			get
			{
				return this.generatePredictionButton;
			}
		}
		#endregion

		#region constructor
		/// <summary>
		/// Constructor. 
		/// </summary>
		/// <param name="mismatchSolvingPatterns">A hashmap with mismatches as
		/// keys and lists of patterns that are able to solve the 
		/// corresponding mismatches as values.</param>+
		public SelectionDialog(Hashmap mismatchSolvingPatterns, 
			Selector controller)
		{
			// TODO: add model class ???
			this.counter = 0;
			this.tabCounter = 0;
			this.mismatchSolvingPatterns = mismatchSolvingPatterns;
			this.rButtons = new ArrayList();
			this.generateAdaptorButton = new Button();
			this.generatePredictionButton = new Button();
			this.controller = controller;
			
			InitializeComponent();	

			InitializeChoice();
		}
		#endregion

		#region Code generated by the form designer. 
		/// <summary>
		/// Die verwendeten Ressourcen bereinigen.
		/// </summary>
		protected override void Dispose( bool disposing )
		{
			if( disposing )
			{
				if(components != null)
				{
					components.Dispose();
				}
			}
			base.Dispose( disposing );
		}

		/// <summary>
		/// Erforderliche Methode f�r die Designerunterst�tzung. 
		/// Der Inhalt der Methode darf nicht mit dem Code-Editor ge�ndert werden.
		/// </summary>
		private void InitializeComponent()
		{
			System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(SelectionDialog));
			// 
			// SelectionDialog
			// 
			this.AutoScaleBaseSize = new System.Drawing.Size(5, 13);
			this.ClientSize = new System.Drawing.Size(292, 273);
			this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
			this.Name = "SelectionDialog";
			this.Text = "Choose a pattern";

		}
		#endregion

		#region manual GUI creation
		/// <summary>
		/// This method creates a choice view for different
		/// design patterns. It also creates buttons which lead
		/// to a detailed view of the corresponding
		/// PatternDescriptions.
		/// </summary>
		private void InitializeChoice()
		{
			AddSpecificationButtons();

			foreach (IMismatch mismatch in this.mismatchSolvingPatterns.Keys)
			{
				AddMismatch(mismatch);
			}
			AddGeneratorButtons();

			int height = 130+(counter*10);
			this.Size = new System.Drawing.Size(350, height);
		}

		/// <summary>
		/// Adds the mismatch text and the belonging patterns to the GUI.
		/// </summary>
		/// <param name="mismatch"></param>
		private void AddMismatch (IMismatch mismatch)
		{
			Label label = new Label();
			label.Name = mismatch.ToString();
			label.Location = new System.Drawing.Point(15, 
				(10+(counter*10)));
			label.Size = new System.Drawing.Size(220, 40);
			label.Text = mismatch.ToString();
			IList mismatchPatterns = (IList)
				this.mismatchSolvingPatterns[mismatch];
			if (mismatchPatterns.Count > 0)
				label.Text += "\nThe mismatch can be fixed by using one "+
					"of the following design patterns:";
			else
				label.Text += "\nThere are no known patterns to fix this "+
					"mismatch.";
			this.Controls.Add(label);
			counter += 4;

			ListPatterns(mismatchPatterns);

			Label separator = new Label();
			separator.Location = new System.Drawing.Point(15, 
				(10+(counter*10)));
			separator.Size = new System.Drawing.Size(350, 15);
			separator.Text = "------------------------------------------"+
				"------------------------------------------";
			this.Controls.Add(separator);

			counter += 2;
		}

		/// <summary>
		/// Adds the "Generate Adaptor" and "Generate Prediction Model" buttons
		/// to the GUI.
		/// </summary>
		private void AddGeneratorButtons()
		{
			generateAdaptorButton.Location = new System.Drawing.Point(15, 
				(64+(counter*10)));
			generateAdaptorButton.Name = "generateAdaptorButton";
			generateAdaptorButton.TabIndex = tabCounter;
			generateAdaptorButton.Size = new System.Drawing.Size(150, 23);
			generateAdaptorButton.Text = "Generate Adaptor";
			generateAdaptorButton.Click += new System.EventHandler
				(this.controller.Generator_Click);
			this.Controls.Add(generateAdaptorButton);
			tabCounter++;
			
			generatePredictionButton.Location = new System.Drawing.Point(180, 
				(64+(counter*10)));
			generatePredictionButton.Name = "generatePredictionButton";
			generatePredictionButton.TabIndex = tabCounter;
			generatePredictionButton.Size = new System.Drawing.Size(150, 23);
			generatePredictionButton.Text = "Generate Prediction Model";
			generatePredictionButton.Click += new System.EventHandler
				(this.controller.Generator_Click);
			this.Controls.Add(generatePredictionButton);
		}

		/// <summary>
		/// Adds the "Provided Specification" and "Required Specification" 
		/// buttons to the GUI.
		/// </summary>
		private void AddSpecificationButtons()
		{
			Button requiredButton = new Button();
			requiredButton.Location = new System.Drawing.Point(15, 
				(10+(counter*10)));
			requiredButton.Name = "Required Specification";
			requiredButton.TabIndex = tabCounter;
			requiredButton.Size = new System.Drawing.Size(150, 23);
			requiredButton.Text = "Required Specification";
			requiredButton.Click += new System.EventHandler
				(this.controller.Specification_Click);
			this.Controls.Add(requiredButton);
			tabCounter++;
			
			Button providedButton = new Button();
			providedButton.Location = new System.Drawing.Point(180, 
				(10+(counter*10)));
			providedButton.Name = "Provided Specification";
			providedButton.TabIndex = tabCounter;
			providedButton.Size = new System.Drawing.Size(150, 23);
			providedButton.Text = "Provided Specification";
			providedButton.Click += new System.EventHandler
				(this.controller.Specification_Click);
			this.Controls.Add(providedButton);
			counter += 5;
		}

		/// <summary>
		/// Lists the given patterns and creates a choice and a details button
		/// for each pattern.
		/// </summary>
		/// <param name="mismatchPatterns">A list of patterns.</param>
		private void ListPatterns(IList mismatchPatterns)
		{
			foreach (PatternDescription pattern in mismatchPatterns)
			{
				RadioButton rbutton = new RadioButton();
				Button button = new Button();
				string name = pattern.Name;

				rbutton.Location = new System.Drawing.Point(25, 
					(25+(counter*10)));
				rbutton.Name = name;
				rbutton.TabIndex = tabCounter;
				rbutton.Text = pattern.Name;
				this.rButtons.Add(rbutton);	
				tabCounter++;

				button.Location = new System.Drawing.Point(250,
					(25+(counter*10)));
				button.Name = name;
				button.TabIndex = tabCounter;
				button.Text = "Details";
				button.Click += new System.EventHandler(this.controller.
					Button_Click);

				this.Controls.Add(button);
				this.Controls.Add(rbutton);

				tabCounter++;
				counter += 4;
			}
		}
		#endregion
	}
}
