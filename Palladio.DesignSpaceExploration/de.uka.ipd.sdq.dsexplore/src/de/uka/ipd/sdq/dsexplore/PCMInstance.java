package de.uka.ipd.sdq.dsexplore;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import de.uka.ipd.sdq.workflow.launchconfig.ConstantsContainer;
import de.uka.ipd.sdq.dsexplore.helper.ConfigurationHelper;
import de.uka.ipd.sdq.identifier.Identifier;
import de.uka.ipd.sdq.pcm.allocation.Allocation;
import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;
import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceEnvironment;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceRepository;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceType;
import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.system.System;
import de.uka.ipd.sdq.pcm.system.SystemPackage;
import de.uka.ipd.sdq.pcm.usagemodel.UsageModel;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;
import de.uka.ipd.sdq.simucomframework.SimuComConfig;

/**
 * Encapsulated an PCM instance. Represents ONE candidate only and needs to be copied when changed. 
 * 
 * 	// TODO: refactor the getter names of the filenames to getOrginalFileName
	// and getFileName? Or leave the original to get longer and longer file
	// names... no.
 * 
 * TODO: change the file naming as it becomes too long... Or just increase the strengthen resource value?
 * TODO: repair the naming of instances: Using altcomponents seems to delete the strengthen part. See textfile on desktop with a previous run.
 * 
 * @author Anne
 * 
 */
public class PCMInstance {

	/** Logger for log4j. */
	private static Logger logger = Logger.getLogger("de.uka.ipd.sdq.dsexplore");

	private Allocation allocation;
	private String allocationFileName;

	private Repository mwRepository;
	
	private String name;
	
	private Repository repository;
	private String repositoryFileName;
	
	private String resEnvFileName;
	private ResourceEnvironment resourceenvironment;
	
	private ResourceRepository resourceRepository;
	private String resourceRepositoryFileName;
	
	private ResourceType resourcetype;

	private String storagePath;

	private System system;
	private String systemFileName;

	private UsageModel usageModel;
	private String usageModelFileName;
	
	private ILaunchConfiguration launchConfiguration;

	public PCMInstance() {
		super();
	}

	/**
	 * Copied From de.uka.ipd.sdq.pcmsolver.models.PCMInstance.
	 * 
	 * @param configuration
	 *            Config given by Eclipse
	 * @throws CoreException
	 */
	public PCMInstance(final ILaunchConfiguration configuration)
			throws CoreException {
		// this.usage = ComputedUsageFactory.eINSTANCE.createComputedUsage();
		// this.actualAllocation =
		// ComputedAllocationFactory.eINSTANCE.createComputedAllocation();
		
		this.launchConfiguration = configuration;

		logger.debug("PCM Instance Constructor called");
		this.setName(configuration.getAttribute(SimuComConfig.EXPERIMENT_RUN,
				"Initial instance"));

		this.storagePath = configuration.getAttribute("outputPath", ".");

		String filename = configuration.getAttribute(
				ConstantsContainer.ALLOCATION_FILE, "");
		this.allocation = ((Allocation) ConfigurationHelper.loadFromXMIFile(filename));
		this.allocationFileName = filename;

		filename = configuration.getAttribute(
				ConstantsContainer.REPOSITORY_FILE, "");
		this.repository = ((Repository) ConfigurationHelper.loadFromXMIFile(filename));
		this.repositoryFileName = filename;
		this.resourceenvironment = this.allocation
				.getTargetResourceEnvironment_Allocation();

		filename = configuration.getAttribute(
				ConstantsContainer.RESOURCETYPEREPOSITORY_FILE, "");
		this.resourceRepository = ((ResourceRepository) ConfigurationHelper.loadFromXMIFile(filename));
		this.resourceRepositoryFileName = filename;

		filename = configuration
				.getAttribute(ConstantsContainer.USAGE_FILE, "");
		this.usageModel = ((UsageModel) ConfigurationHelper.loadFromXMIFile(filename));
		this.usageModelFileName = filename;

		this.system = this.allocation.getSystem_Allocation();
		this.systemFileName = configuration.getAttribute(
				ConstantsContainer.SYSTEM_FILE, "");

		this.resEnvFileName = this.allocation
				.getTargetResourceEnvironment_Allocation().eResource().getURI()
				.toFileString();
		logger.debug("ResourceEnv: " + this.resEnvFileName);
	}

	/**
	 * Initialise this PCM instance with the given models.
	 * 
	 * @param repository
	 * @param system
	 * @param allocation
	 * @param resourceenvironment
	 * @param resourcetype
	 * @param mwRepository
	 */
	public PCMInstance(Repository repository, System system,
			Allocation allocation, ResourceEnvironment resourceenvironment,
			ResourceType resourcetype, Repository mwRepository) {
		super();
		this.repository = repository;
		this.system = system;
		this.allocation = allocation;
		this.resourceenvironment = resourceenvironment;
		this.resourcetype = resourcetype;
		this.mwRepository = mwRepository;
	}

	public PCMInstance(Repository repository, System system,
			Allocation allocation, ResourceEnvironment resourceenvironment,
			ResourceType resourcetype, Repository mwRepository,
			String storagePath, ResourceRepository resourceRepository,
			UsageModel usageModel, String allocationFileName,
			String repositoryFileName, String resourceRepositoryFileName,
			String usageModelFileName, String systemFileName,
			String resourceEnvironmentFileName, String name) {
		super();
		this.repository = repository;
		this.system = system;
		this.allocation = allocation;
		this.resourceenvironment = resourceenvironment;
		this.resourcetype = resourcetype;
		this.mwRepository = mwRepository;
		this.storagePath = storagePath;
		this.resourceRepository = resourceRepository;
		this.usageModel = usageModel;
		this.allocationFileName = allocationFileName;
		this.repositoryFileName = repositoryFileName;
		this.resourceRepositoryFileName = resourceRepositoryFileName;
		this.usageModelFileName = usageModelFileName;
		this.systemFileName = systemFileName;
		this.resEnvFileName = resourceEnvironmentFileName;
		this.name = name;
	}

	public void appendToAllocationFileName(String allocationFileNameSuffix) {
		this.allocationFileName = appendToFilename(allocationFileNameSuffix, this.allocationFileName);
	}

	public void appendToResEnvFileName(String resEnvFileNameSuffix) {
		this.resEnvFileName = appendToFilename(resEnvFileNameSuffix, this.resEnvFileName);
	}

	public void appendToSystemFileName(String systemFileNameSuffix) {
		this.systemFileName = appendToFilename(systemFileNameSuffix, this.systemFileName);

	}

/**
 * Checks equality based on the name. {@inheritDoc}
 * 
 * @see java.lang.Object#equals(java.lang.Object)
 */
public boolean equals(Object o) {
	if (!PCMInstance.class.isInstance(o)) {
		return false;
	}
	PCMInstance other = (PCMInstance) o;
	
	return this.getName().equals(other.getName());

}

	public Allocation getAllocation() {
		return allocation;
	}

	public String getAllocationFileName() {
		return allocationFileName;
	}

	public List<ResourceContainer> getAllResourceContainers() {
			return this.resourceenvironment
					.getResourceContainer_ResourceEnvironment();
		}

	public Repository getMwRepository() {
		return mwRepository;
	}

	public String getName() {
		return this.name;
	}

	public Repository getRepository() {
		return repository;
	}

	public String getRepositoryFileName() {
		return repositoryFileName;
	}

	public String getResEnvFileName() {
		return resEnvFileName;
	}

	public ResourceEnvironment getResourceenvironment() {
		return resourceenvironment;
	}

	public ResourceRepository getResourceRepository() {
		return resourceRepository;
	}

	public String getResourceRepositoryFileName() {
		return resourceRepositoryFileName;
	}

	public ResourceType getResourcetype() {
		return resourcetype;
	}

	public System getSystem() {
		return system;
	}

	public String getSystemFileName() {
		return systemFileName;
	}

	public UsageModel getUsageModel() {
		return usageModel;

	}

	public String getUsageModelFileName() {
		return usageModelFileName;
	}



	public void saveAllocationToFile() {
		saveToXMIFile(allocation, allocationFileName);
	}

	public void saveResEnvToFile() {
		saveToXMIFile(resourceenvironment, resEnvFileName);
	}

	public void saveSystemToFile() {
		saveToXMIFile(system, systemFileName);
	}

	/**
	 * Save the contained models back to xmi Files.
	 */
	/*public void saveToFiles() {
		// fileNamePrefix = storagePath + "\\" + fileNamePrefix;
		// java.lang.System.out.println(storagePath);
		saveToXMIFile(allocation, allocationFileName); // fileNamePrefix+".allocation");
		saveToXMIFile(repository, repositoryFileName); // fileNamePrefix+".repository");
		// saveToXMIFile(resourceenvironment,
		// fileNamePrefix+".resourceenvironment");
		// saveToXMIFile(resourceRepository, resourceRepositoryFileName);
		// //fileNamePrefix+".resourcetype");
		saveSystemToFile(); // fileNamePrefix+".system");
		saveToXMIFile(usageModel, usageModelFileName); // fileNamePrefix+".usagemodel");

		// saveToXMIFile(usage, fileNamePrefix+".usage");
		// saveToXMIFile(actualAllocation, fileNamePrefix+".actualallocation");

	}*/

	public void saveUpdatesToFile() {
		// FIXME: Whenever more than just the system is changes, I need to save
		// more here.
		saveSystemToFile();
		saveResEnvToFile();
		
		//The URI must additionally be set for all allocation contexts. If not, they still reference the old resource environment.
		List<AllocationContext> contexts = this.getAllocation().getAllocationContexts_Allocation();
		//URI rightURI = re.eResource().getURI();
		URI fileURI = URI.createFileURI(new File(this.getResEnvFileName()).getAbsolutePath());
		for (Iterator<AllocationContext> iterator = contexts.iterator(); iterator
				.hasNext();) {
			AllocationContext allocationContext = iterator.next();
			//try to adjust the URI in the Resource, if there is any
			Resource resource = allocationContext.getResourceContainer_AllocationContext().eResource();
			if (resource != null){
				resource.setURI(fileURI);
			} else {
				logger.warn("Resource of allocation context "+allocationContext.getEntityName()+" has a null eResource!");
			}
		}
		
		saveAllocationToFile();
	}

	public void setAllocation(Allocation allocation) {
		this.allocation = allocation;
	}

	public void setMwRepository(Repository mwRepository) {
		this.mwRepository = mwRepository;
	}

	public void setName(String newName) {
		this.name = newName;
	}

	public void setRepository(Repository repository) {
		this.repository = repository;
	}

	public void setResEnvFileName(String resEnvFileName) {
		this.resEnvFileName = resEnvFileName;
	}

	public void setResourceenvironment(ResourceEnvironment resourceenvironment) {
		this.resourceenvironment = resourceenvironment;
	}

	public void setResourcetype(ResourceType resourcetype) {
		this.resourcetype = resourcetype;
	}

	public void setSystem(System system) {
		this.system = system;
	}

	/**
	 * Returns a new PCM instance that references the same model elements than
	 * this one and has the same filenames.
	 */
	public PCMInstance shallowCopy() {
		PCMInstance pcm = new PCMInstance(this.repository, this.system,
				this.allocation, this.resourceenvironment, this.resourcetype,
				this.mwRepository, this.storagePath, this.resourceRepository,
				this.usageModel, this.allocationFileName,
				this.repositoryFileName, this.resourceRepositoryFileName,
				this.usageModelFileName, this.systemFileName,
				this.resEnvFileName, this.name);
		return pcm;
	}
	
	/**
	 * This tries to do a deep copy of the main models, but it is not tested yet. 
	 * The Repository, the system, the allocation and the resource environment are copied.  
	 * 
	 * //TODO: Probably I need to fix the references better (e.g. from system to new 
	 * repository instead of old repository, as the filenames change.)
	 * 
	 * The varied filenames are extended by "-c" (for copy) so that the old ones are not deleted. 
	 * 
	 * Be careful: The ResourceType, the ResourceRepository, the middlewareRepository, and the UsageModel are not copied.
	 * 
	 * Make sure to save this instance first. 
	 * @return an yet unsaved PCM instance
	 */
	public PCMInstance deepCopy(){
		//Do I need the repository?
		//Repository r = (Repository)EcoreUtil.copy(this.repository);
		System s = (System)EcoreUtil.copy(this.system);
		
		ResourceEnvironment re = (ResourceEnvironment)EcoreUtil.copy(this.resourceenvironment);
		Allocation a = (Allocation)EcoreUtil.copy(this.allocation);
		a.setTargetResourceEnvironment_Allocation(re);
			
		PCMInstance pcm = new PCMInstance(this.repository, s, a, re, this.resourcetype, this.mwRepository,
				this.storagePath, this.resourceRepository,
				this.usageModel, appendToFilename("c",this.allocationFileName),
				this.repositoryFileName, this.resourceRepositoryFileName,
				this.usageModelFileName, appendToFilename("c",this.systemFileName),
				appendToFilename("c",this.resEnvFileName), this.name+"-c");
		
		return pcm;

	}

	private String appendToFilename(String fileNameSuffix, String fileName) {
		int indexOfLastDot = fileName.lastIndexOf(".");
		return fileName.substring(0, indexOfLastDot) + fileNameSuffix
				+ fileName.substring(indexOfLastDot);
	}

	/**
	 * Save the given EObject to the file given by filename.
	 * 
	 * @param modelToSave
	 *            The EObject to save
	 * @param fileName
	 *            The filename where to save.
	 */
	private void saveToXMIFile(final EObject modelToSave, final String fileName) {
		logger.debug("Saving " + modelToSave.toString() + " to " + fileName);

		// Create a resource set.
		ResourceSet resourceSet = new ResourceSetImpl();

		// Register the default resource factory -- only needed for stand-alone!
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put(Resource.Factory.Registry.DEFAULT_EXTENSION,
						new XMIResourceFactoryImpl());
	
		URI fileURI = URI.createFileURI(new File(fileName).getAbsolutePath());
		Resource resource = resourceSet.createResource(fileURI);
		resource.getContents().add(modelToSave);
		


		try {
			resource.save(Collections.EMPTY_MAP);
		} catch (FileNotFoundException e){
			if (fileName.length() > 250){
				//try again with a shorter filename
				saveToXMIFile(modelToSave, fileName.substring(0, fileName.indexOf("-"))+"-shortened-"+fileName.hashCode());
			}
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
		// logger.debug("Saved " + fileURI);
	}

	public ILaunchConfiguration getLaunchConfiguration() {
		return launchConfiguration;
	}

}