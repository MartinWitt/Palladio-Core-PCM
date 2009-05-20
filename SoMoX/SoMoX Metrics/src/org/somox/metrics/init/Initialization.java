package org.somox.metrics.init;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;

import de.fzi.gast.accesses.provider.accessesItemProviderAdapterFactory;
import de.fzi.gast.annotations.provider.annotationsItemProviderAdapterFactory;
import de.fzi.gast.core.ModelElement;
import de.fzi.gast.core.Package;
import de.fzi.gast.core.Root;
import de.fzi.gast.core.provider.coreItemProviderAdapterFactory;
import de.fzi.gast.functions.provider.functionsItemProviderAdapterFactory;
import de.fzi.gast.statements.provider.statementsItemProviderAdapterFactory;
import de.fzi.gast.types.GASTClass;
import de.fzi.gast.types.provider.typesItemProviderAdapterFactory;
import de.fzi.gast.variables.provider.variablesItemProviderAdapterFactory;


/**
 * Initialization class for the metrics.
 * 
 * Classes are extracted from the Resource and "bundled" with their inner classes.
 * 
 * @author Grischa Liebel
 *
 */
public class Initialization {
	private AdapterFactoryEditingDomain editingDomain;

	private ComposedAdapterFactory adapterFactory;
	
	private Resource resource;
	
	private Root root = null;
	private List<ModelElement> elements;
	
	/**
	 * Class lists are extracted from the resource at the given URI
	 * 
	 * @param uri The URI of the model file
	 * @return a list of class lists. Each class list contains one outer class and its inner classes
	 */
	public List<List<GASTClass>> extractLists (URI uri) {
		initializeEditingDomain();
		createResource(uri);
		return extractClasses();		
	}
	
	/**
	 * Returns the root object of the given modell
	 * @return the root object
	 */
	public Root getRoot () {
		return root;
	}
	
	/**
	 * Extracts all outer classes with their inner classes 
	 * 
	 * @return a list of class lists. Every list element is a list containing one outer and all of its inner classes
	 */
	private List<List<GASTClass>> extractClasses () {
		EList<EObject> contents = resource.getContents();
		
		elements = new LinkedList<ModelElement>();
		
		for (EObject current : contents) {
			if (current instanceof Root) {
				root = (Root)current;
			}
		}
		if (root != null) {
			EList<de.fzi.gast.core.Package> packages = root.getPackages();
			iteratePackages(packages);
		}
		
		
		return addInnerClasses(elements);
	}
	
	/**
	 * Adds all inner classes to the given outer classes
	 * 
	 * @param elements A list of ModelElements
	 * @return a list of lists of GASTClasses
	 */
	private List<List<GASTClass>> addInnerClasses (List<ModelElement> elements) {
		List<List<GASTClass>> elementList = new LinkedList<List<GASTClass>>();
		
		if (elements.size() > 0) {
			for (ModelElement element : elements) {
				if (element instanceof GASTClass) {
					elementList.add(getInnerClasses((GASTClass)element));
				}
			}
		}
		
		return elementList;
	}
	
	/**
	 * Returns a list of the given class itself and all of its inner classes
	 * 
	 * @param element A GASTClass object
	 * @return a list containing the given class plus all inner classes
	 */
	private List<GASTClass> getInnerClasses (GASTClass element) {
		List<GASTClass> currentList = new LinkedList<GASTClass>();
		currentList.add((GASTClass)element);
		
		EList<GASTClass> innerClasses = ((GASTClass)element).getInnerClasses();
		
		if (innerClasses != null) {
			currentList.addAll(innerClasses);
		}
		for (GASTClass innerClass : innerClasses) {
			currentList.addAll(getInnerClasses(innerClass));
		}
		
		return currentList;
	}
	
	/**
	 * Iterates recursively over all packages to extract every GASTClass
	 * @param packages a list of packages
	 */
	private void iteratePackages (EList<Package> packages) {
		for (de.fzi.gast.core.Package current : packages) {
			//TODO implement black-/whitelist concept
			//if (!current.getSimpleName().equals("java") && !current.getSimpleName().equals("javax") && !current.getSimpleName().equals("junit") && !current.getSimpleName().equals("apache") && !current.getSimpleName().equals("netlib") && !current.getSimpleName().equals("sun") && !current.getSimpleName().equals("info") && !current.getSimpleName().equals("de")) {
				EList<GASTClass> classes = current.getClasses();
				for (GASTClass currentClass : classes) {
					elements.add(currentClass);
				}
				EList<de.fzi.gast.core.Package> subPackages = current.getSubPackages();
				if (subPackages.size() > 0) {
					iteratePackages(subPackages);
				}
			//}
		}
	}
	
	/**
	 * Creates a resource from a given URI
	 * 
	 * @param fileURI The model URI
	 */
	private void createResource(URI fileURI) {
		// Register the default resource factory -- only needed for stand-alone!
		editingDomain.getResourceSet().getResourceFactoryRegistry().getExtensionToFactoryMap().put(
				Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());

		//Try to load the resource through the editingDomain.
		resource = null;
		try {
			resource = editingDomain.getResourceSet().getResource(fileURI, true);
		}
		catch (Exception e) {
			resource = editingDomain.getResourceSet().getResource(fileURI, false);
		}

		System.out.println("Resource \"" + fileURI.lastSegment() + "\" loaded: " + resource.isLoaded() + "\n");
	}
	
	
	/**
	 * Initializes the editing domain
	 */
	private void initializeEditingDomain () {
		adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new statementsItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new coreItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new annotationsItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new typesItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new functionsItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new accessesItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new variablesItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

		BasicCommandStack commandStack = new BasicCommandStack();

		editingDomain = new AdapterFactoryEditingDomain(adapterFactory, commandStack, new HashMap<Resource, Boolean>());
	}

}
