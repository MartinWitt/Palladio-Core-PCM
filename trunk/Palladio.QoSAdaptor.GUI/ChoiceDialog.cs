#region info
///////////////////////////////////////////////////////////////////////////////
/// This software has been developed as a part of the diploma thesis 
/// "Einfluss von Generatorkonfiguration auf die QoS-Vorhersage f�r 
/// Komponentenadapter" ("Influence of the configuration of a generator on the 
/// prediction of the QoS of component adaptors")
/// at the 
/// University of Oldenburg
/// Department of Computing Science
/// Software Engineering Group
/// Palladio Research Group
/// (http://se.informatik.uni-oldenburg.de/research/projects/Palladio)
/// 
/// Development period: July 2005 - January 2006
/// 
/// Author: Niels Streekmann
/// E-mail: niels.streekmann@informatik.uni-oldenburg.de
///////////////////////////////////////////////////////////////////////////////
#endregion

using System.ComponentModel;
using Palladio.QoSAdaptor.Configuration;
using Palladio.QoSAdaptor.Pattern;
using System;
using System.Collections;
using System.Diagnostics;
using System.Windows.Forms;

namespace Palladio.QoSAdaptor.GUI
{
	/// <summary>
	/// This class implements a window in which one of the 
	/// recommended patters can be chosen. 
	/// </summary>
	public class ChoiceDialog : System.Windows.Forms.Form
	{
		#region data
		/// <summary>
		/// Erforderliche Designervariable.
		/// </summary>
		private System.ComponentModel.Container components = null;
		private IList patterns;
		private ArrayList rButtons;
		private string patternDirectory;
		private IList templates;
		private Button generateAdaptorButton;
		private Button generatePredictionButton;
		#endregion

		#region constructor
		/// <summary>
		/// Constructor. 
		/// </summary>
		/// <param name="patterns">A list of patterns to choose 
		/// from.</param>
		public ChoiceDialog(IList patterns)
		{
			// TODO: add model class ???
			this.patterns = patterns;
			this.rButtons = new ArrayList();
			this.generateAdaptorButton = new Button();
			this.generatePredictionButton = new Button();
			//
			// Erforderlich f�r die Windows Form-Designerunterst�tzung
			//
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
			System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(ChoiceDialog));
			// 
			// ChoiceDialog
			// 
			this.AutoScaleBaseSize = new System.Drawing.Size(5, 13);
			this.ClientSize = new System.Drawing.Size(292, 273);
			this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
			this.Name = "ChoiceDialog";
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
			IEnumerator enu = this.patterns.GetEnumerator();
			int counter = 0;
			while (enu.MoveNext())
			{
				RadioButton rbutton = new RadioButton();
				Button button = new Button();

				rbutton.Location = new System.Drawing.Point(25, (25+(counter*40)));
				rbutton.Name = ((PatternDescription)enu.Current).Name;
				rbutton.TabIndex = counter*2;
				rbutton.Text = ((PatternDescription)enu.Current).Name;
				this.rButtons.Add(rbutton);	

				button.Location = new System.Drawing.Point(250,(25+(counter*40)));
				button.Name = ((PatternDescription)enu.Current).Name;
				button.TabIndex = (counter*2)+1;
				button.Text = "Details";
				button.Click += new System.EventHandler(this.Button_Click);

				this.Controls.Add(button);
				this.Controls.Add(rbutton);

				counter++;
			}

			generateAdaptorButton.Location = new System.Drawing.Point(15, (64+(counter*40)));
			generateAdaptorButton.Name = "generateAdaptorButton";
			generateAdaptorButton.TabIndex = (counter*2);
			generateAdaptorButton.Size = new System.Drawing.Size(150, 23);
			generateAdaptorButton.Text = "Generate Adaptor";
			generateAdaptorButton.Click += new System.EventHandler(this.Generator_Click);
			this.Controls.Add(generateAdaptorButton);
			
			generatePredictionButton.Location = new System.Drawing.Point(180, (64+(counter*40)));
			generatePredictionButton.Name = "generatePredictionButton";
			generatePredictionButton.TabIndex = (counter*2);
			generatePredictionButton.Size = new System.Drawing.Size(150, 23);
			generatePredictionButton.Text = "Generate Prediction Model";
			generatePredictionButton.Click += new System.EventHandler(this.Generator_Click);
			this.Controls.Add(generatePredictionButton);

			int height = 130+(counter*40);
			this.Size = new System.Drawing.Size(350, height);
		}
		#endregion

		#region event handling
		/// <summary>
		/// This method is called, when one of the buttons for the
		/// detailed view is clicked. 
		/// The method opens a new window which lists the details
		/// of the chosen pattern. 
		/// </summary>
		/// <param name="sender"></param>
		/// <param name="e"></param>
		private void Button_Click(object sender, System.EventArgs e)
		{
			string bName = ((Button)sender).Name;
			IEnumerator enu = this.patterns.GetEnumerator();
			while (enu.MoveNext())
			{
				if (((PatternDescription)enu.Current).Name.Equals(bName))
				{
					DetailView details = new DetailView((PatternDescription)enu.Current);
					details.Show();
				}
			}
		}


		/// <summary>
		/// This method is called, when a generator button has 
		/// been clicked. 
		/// The method opens a new instance of CodeSmith for 
		/// every template that is listed in the 
		/// PatternDescription of the chosen pattern. 
		/// If no pattern is chosen a MessageBox is opened. 
		/// </summary>
		/// <param name="sender"></param>
		/// <param name="e"></param>
		private void Generator_Click(object sender, System.EventArgs e)
		{
			bool check = false;
			IEnumerator enu = this.rButtons.GetEnumerator();
			while (enu.MoveNext())
			{
				if (((RadioButton)enu.Current).Checked)
				{
					check = true;
					ChoosePattern(sender, ((RadioButton)enu.Current).Name);
				}
			}
			if (!check)
				MessageBox.Show("No Pattern has been chosen.");
		}

		/// <summary>
		/// This is a helper method for generator_Click which
		/// chooses the selected pattern and calls another
		/// functions to open the corresponding templates.
		/// </summary>
		/// <param name="patternName">The name of the selected 
		/// pattern</param>
		private void ChoosePattern(object sender, string patternName)
		{
			IEnumerator enu = this.patterns.GetEnumerator();
			while (enu.MoveNext())
			{
				PatternDescription pattern = ((PatternDescription)enu.Current);
				if (pattern.Name.Equals(patternName))
				{
					this.patternDirectory = Config.PATTERN_DIRECTORY+pattern.Name+"\\";
					if (sender.Equals(this.generateAdaptorButton))
						this.templates = (IList)((ICloneable)pattern.AdapterTemplates).Clone();
					else
						this.templates = (IList)((ICloneable)pattern.PredictionTemplates).Clone();
					OpenTemplates();
				}
			}
		}

		/// <summary>
		/// This is a helper method for generator_Click which opens
		/// the given templates in CodeSmith.
		/// </summary>
		private void OpenTemplates()
		{
			this.generateAdaptorButton.Enabled = false;
			this.generatePredictionButton.Enabled = false;
			IEnumerator enu = this.templates.GetEnumerator();
			if (enu.MoveNext())
			{
				string template = (string)enu.Current;
				//start CodeSmith
				Process proc = new Process();

				//proc.StartInfo.FileName = Config.CODESMITH_EXE;
				proc.StartInfo.FileName = "CodeSmith.exe";
				string arg = this.patternDirectory+template;
				proc.StartInfo.Arguments = arg;
				proc.EnableRaisingEvents = true;
				proc.Exited +=new EventHandler(Proc_Exited);
				try 
				{
					proc.Start();
				}
				catch (Win32Exception e)
				{
					MessageBox.Show(e.Message);
				}
				this.templates.Remove(enu.Current);
			}
			else 
			{
				MessageBox.Show("All necessary templates have been generated.");
				// TODO: compile adaptor
				// TODO: reactivate button when the message when the adaptor has been compiled
				this.generateAdaptorButton.Enabled = true;
				this.generatePredictionButton.Enabled = true;
			}
		}

		private void Proc_Exited(object sender, EventArgs e)
		{
			OpenTemplates();
		}
		#endregion

		
	}
}
