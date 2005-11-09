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

using System.CodeDom.Compiler;
using System.Collections;
using System.IO;
using System.Windows.Forms;
using Palladio.QoSAdaptor.Compiler;
using Palladio.QoSAdaptor.Configuration;
using Palladio.QoSAdaptor.Enumerations;
using Palladio.QoSAdaptor.Exceptions;
using Palladio.QoSAdaptor.Generation;
using Palladio.QoSAdaptor.Interfaces;
using Palladio.QoSAdaptor.PatternSelection;
using Palladio.QoSAdaptor.Pattern;
using Palladio.QoSAdaptor.QMLComparison;
using Palladio.Utils.Collections;

namespace Palladio.QoSAdaptor.Control
{
	/// <summary>
	/// The main class of the QoSAdaptor software. Represents the only 
	/// interface that should be used from outside.
	/// 
	/// Takes two interface model specifications as arguments, where the first 
	/// is the required specification and the second is the provided 
	/// specification.
	/// 
	/// The application first calls the QMLComparison. If mismatches are 
	/// returned all pattern descriptions in the Patterns folder are parsed and
	/// for each returned mismatches aspect all adequate patterns are listed in
	/// a selection dialog. There on of the patterns can be selected and the 
	/// adaptor and the prediction model belonging to chosen pattern can be 
	/// generated.
	/// </summary>
	public class Controller : IController
	{
		#region public methods
		public void Start(InterfaceModel interfaceModel, TextReader required, 
			TextReader provided)
		{
			QMLComparator comparator = null;
			if (interfaceModel == InterfaceModel.QUALITY)
				comparator = new QMLComparator();
			else
			{
				//throw exception
			}

			IInterfaceModelSpecification requiredSpecification = null;
			IInterfaceModelSpecification providedSpecification = null;

			requiredSpecification = comparator.CreateQMLSpecification(
				required);
			providedSpecification = comparator.CreateQMLSpecification(
				provided);

			Start (interfaceModel, requiredSpecification, 
				providedSpecification);
		}

		/// <summary>
		/// This method starts the the analysis of the interface models,
		/// the selection of a pattern that solves interface model mismatches 
		/// and the generation of an adaptor and a prediction model using that
		/// pattern.
		/// </summary>
		/// <param name="interfaceModel">The considered interface model.
		/// </param>
		/// <param name="requiredSpecification">Interface model specification 
		/// of the required interface.</param>
		/// <param name="providedSpecification">Interface model specification 
		/// of the provided interface.</param>
		public void Start(InterfaceModel interfaceModel, 
			IInterfaceModelSpecification requiredSpecification, 
			IInterfaceModelSpecification providedSpecification)
		{
			IList mismatches = null;
			try
			{
				mismatches = FindMismatches(interfaceModel, 
					requiredSpecification, providedSpecification);
			}
			catch (IncompleteInterfaceCopingException e)
			{
				MessageBox.Show(e.Message);
			}

			if (mismatches != null)
			{
				if (mismatches.Count > 0)
				{
					// TODO: Loop selection, configuration and generation until it
					// is aborted by the user.

					// Pattern selection
					IPatternDescription selectedPattern = SelectPattern(mismatches, 
						interfaceModel,
						requiredSpecification.ToString(), 
						providedSpecification.ToString());
				
					if (selectedPattern != null)
					{
						// Pattern configuration
						// TODO: Use Palladio.QoSAdaptor.Configuration instead of the 
						// CodeSmith configuration interfaced currently used in  
						// Palladio.QoSAdaptor.Generation

						// Generation
						IGenerator generator = new Generator();
						bool generated = generator.Start(selectedPattern, null);

						if (generated)
						{
							// Compilation
							Compile(selectedPattern);
						}
					}
				}
				else
					MessageBox.Show("No mismatches have been found.");
			}

		}
		#endregion

		#region private methods
		/// <summary>
		/// Looks for mismatches in the two given specifications. 
		/// </summary>
		/// <param name="interfaceModel">The currently considered 
		/// interfaceModel.</param>
		/// <param name="requiredSpecification">Interface model specification 
		/// of the required interface.</param>
		/// <param name="providedSpecification">Interface model specification 
		/// of the provided interface.</param>
		private IList FindMismatches(InterfaceModel interfaceModel,
			IInterfaceModelSpecification requiredSpecification, 
			IInterfaceModelSpecification providedSpecification)
		{
			IList mismatches = new ArrayList();
			IComparator comparator = null;

			if (interfaceModel == InterfaceModel.QUALITY)
			{
				comparator = new QMLComparator();
				try
				{
					((QMLComparator)comparator).CheckCompleteCoping(
						requiredSpecification, providedSpecification);
				}
				catch (IncompleteInterfaceCopingException e)
				{
					throw e;
				}
			}
			else
			{
				//TODO: throw exception
			}

			mismatches = comparator.FindMismatches(requiredSpecification, 
					providedSpecification);
			
			return mismatches;
		}

		/// <summary>
		/// Semi-automatic selection of a pattern that is able to correct the 
		/// found mismatches. 
		/// </summary>
		/// <param name="mismatches">A list of found mismatches.</param>
		/// <param name="requiredSpecification">String representation of the 
		/// required specification.</param>
		/// <param name="providedSpecification">String representation of the
		/// provided specification.</param>
		/// <returns></returns>
		private IPatternDescription SelectPattern(IList mismatches, 
			InterfaceModel interfaceModel,
			string requiredSpecification, string providedSpecification)
		{
			// Automatic pattern preselection
			ArrayList patterns = GetPatternDescriptions(interfaceModel);
			IPatternPreselectionStrategy strategy = 
				new SinglePatternPreselectionWithSubattributes();
			Hashmap mismatchSolvingPatterns = strategy.PreselectPatterns(
				mismatches, patterns);

			// Selection of patterns by the user and configuration and 
			// generation using CodeSmith
			// TODO: Use self-implemented PatternConfiguration.
			// Run the GUI with the given patterns.
			ISelector selector = new Selector();
			return selector.StartSelection(mismatchSolvingPatterns, 
				requiredSpecification, providedSpecification);
		}

		/// <summary>
		/// Reads the PatternDescriptions from their XML representations.
		/// </summary>
		/// <returns>A list of PatternDescription objects.</returns>
		private ArrayList GetPatternDescriptions(
			InterfaceModel interfaceModel)
		{
			// Read all xml files from the Pattern folder 
			ArrayList patterns = new ArrayList();
			System.IO.DirectoryInfo dirInfo = new DirectoryInfo(
				Config.PATTERN_DIRECTORY);
			FileInfo[] fileInfos = dirInfo.GetFiles("*.xml");
			foreach (FileInfo fileInfo in fileInfos)
			{
				// TODO: Change PatternDescriptionParser so that it takes 
				// a TextReader as argument. And insert a Parse method.
				PatternDescriptionParser parser = new 
					PatternDescriptionParser (fileInfo.FullName);
				// Only take PatternDescriptions with the correct 
				// interfaceModel.
				// TODO: Throw exception in the parser, if an error occurs 
				// while parsing.
				if (parser.Pattern == null)
				{
					MessageBox.Show("Could not parse pattern description in "+
						fileInfo.FullName);
				}
				else
				{
					if (parser.Pattern.InterfaceModel == interfaceModel)
					{
						patterns.Add(parser.Pattern);
					}
					else
						MessageBox.Show("Pattern description in "+
							fileInfo.FullName+" is not further considered, "+
							"because it can not be used for the quality-based "
							+"interface model.");
				}
			}
			return patterns;
		}

		/// <summary>
		/// Scans the src folder of the selected pattern for compilable 
		/// artifacts, compiles them and copies the compilation to the 
		/// corresponding bin folder. At the moment only .cs files are
		/// compiled. All other artifacts are left unchanged in the 
		/// src folder.
		/// </summary>
		private void Compile(IPatternDescription selectedPattern)
		{
			string patternDirectory = Config.PATTERN_DIRECTORY+
				selectedPattern.Name;
			string sourceDirectory = patternDirectory+"\\src\\";
			string binDirectory = patternDirectory+"\\bin\\";
			string libDirectory = patternDirectory+"\\lib\\";

			DirectoryInfo patternDir = new DirectoryInfo(patternDirectory);
			if (patternDir.Exists)
			{
				DirectoryInfo srcDir = new DirectoryInfo(sourceDirectory);
				if (!srcDir.Exists)
					patternDir.CreateSubdirectory("src");
				DirectoryInfo binDir = new DirectoryInfo(sourceDirectory);
				if (!binDir.Exists)
					patternDir.CreateSubdirectory("bin");
	
				FileInfo [] libs = GetLibs(libDirectory);

				// compile adaptor, if source file have been generated
				CompileAdaptor(sourceDirectory, binDirectory, libs);
				
			
				// compile prediction model if source files have been generated.
				CompilePredictionModels(selectedPattern.PredictionModels, 
					sourceDirectory, binDirectory, libs);

				MessageBox.Show("Compilation completed. All .cs files in the"+
					"subdirectories of "+sourceDirectory+" have been "+
					"compiled. The compilations have been copied to "+
					binDirectory+". All other artifacts in "+sourceDirectory+
					" have been left unchanged.");
			}
			else 
				MessageBox.Show("The folder "+patternDir.FullName+" could not"+
					" be found. Compilation is aborted.");
		}

		/// <summary>
		/// Compiles the given files with the CSharpCompiler and returns the
		/// path to the created assembly.
		/// </summary>
		/// <param name="sourceFiles">Array of CSharp files.</param>
		/// <param name="libs">Array of DLLs needed to compile the given 
		/// source files.</param>
		/// <returns>Full path to created assembly.</returns>
		private string CompileCSharpFiles(FileInfo[] sourceFiles, 
			FileInfo[] libs)
		{
			CSharpCompiler compiler = new CSharpCompiler();
			foreach (FileInfo lib in libs)
				compiler.ImportedDlls.Add(lib.FullName);
			foreach (FileInfo sourceFile in sourceFiles)
				compiler.FilesToCompile.Add(sourceFile.FullName);

			CompilerResults results = compiler.Compile();

			return results.PathToAssembly;
		}

		/// <summary>
		/// Copies the assembly at the given path to the given subfolder of the
		/// bin folder.
		/// </summary>
		/// <param name="assembly">Full path of the compiled assembly.
		/// </param>
		/// <param name="folderName">Destination folder to 
		/// copy the assembly to.</param>
		/// <param name="newAssemblyName">Destination name of the new assembly.</param>
		private void CopyAssembly(string assembly, 
			string folderName, string newAssemblyName)
		{
			// TODO: Check if dir exists or create it. 
			System.IO.File.Delete(folderName+newAssemblyName);
			System.IO.File.Copy(assembly, folderName+newAssemblyName);
		}

		/// <summary>
		/// Returns the lib files in the given path.
		/// </summary>
		/// <param name="libDirectory">Path to the lib directory.</param>
		/// <returns>An array of DLLs.</returns>
		private FileInfo[] GetLibs(string libDirectory)
		{
			DirectoryInfo libDir = new DirectoryInfo(libDirectory);
			FileInfo[] libs = {};
			if (libDir.Exists)
			{
				libs = libDir.GetFiles("*.dll");
			}
			return libs;
		}

		/// <summary>
		/// Compiles the adaptor, if source files exist.
		/// </summary>
		/// <param name="sourceDirectory">The source directory of the 
		/// selected pattern.</param>
		/// <param name="binDirectory">The bin directory of the 
		/// selected pattern.</param>
		/// <param name="libs">DLLs needed to compile the source files.</param>
		private void CompileAdaptor(string sourceDirectory, 
			string binDirectory, FileInfo[] libs)
		{
			System.IO.DirectoryInfo adaptorFolder = new DirectoryInfo(
				sourceDirectory+"adaptor\\");
			if (adaptorFolder.Exists)
			{
				FileInfo[] sourceFiles = adaptorFolder.GetFiles(".cs");
				if (sourceFiles.Length > 0)
				{
					string assemblyPath = CompileCSharpFiles(sourceFiles,libs);
					CopyAssembly(assemblyPath, binDirectory+"adaptor\\", 
						"Adaptor.dll");
				}
			}
		}

		/// <summary>
		/// Compiles the prediction models of the selected pattern, if source 
		/// files exist.
		/// </summary>
		/// <param name="predictionModels">Prediction models of the selected
		/// pattern.</param>
		/// <param name="sourceDirectory">The source directory of the 
		/// selected pattern.</param>
		/// <param name="binDirectory">The bin directory of the 
		/// selected pattern.</param>
		/// <param name="libs">DLLs needed to compile the source files.</param>
		private void CompilePredictionModels(IList predictionModels, 
			string sourceDirectory, string binDirectory, FileInfo[] libs)
		{
			foreach (IPredictionModel predictionModel in predictionModels)
			{
				System.IO.DirectoryInfo modelFolder = new DirectoryInfo(
					sourceDirectory+predictionModel.Name+"\\");
				if (modelFolder.Exists)
				{
					FileInfo[] sourceFiles = modelFolder.GetFiles(".cs");
					if (sourceFiles.Length > 0)
					{
						string assemblyPath = CompileCSharpFiles(sourceFiles, 
							libs);
						CopyAssembly(assemblyPath, binDirectory+
							predictionModel.Name+"\\", 
							".dll");
					}
				}
			}
		}
		#endregion
	}
}
