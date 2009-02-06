package de.uka.ipd.sdq.sensorframework;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.Before;
import org.junit.BeforeClass;

import de.uka.ipd.sdq.sensorframework.file.impl.EmfModelXMIResourceFactoryImpl;
import de.uka.ipd.sdq.sensorframework.models.emfmodel.ExperimentGroup;
import de.uka.ipd.sdq.sensorframework.models.emfmodel.emfmodelFactory;
import de.uka.ipd.sdq.sensorframework.models.emfmodel.emfmodelPackage;

/**Abstract class which provides helper methods to classes testing persistence.
 * @author groenda
 */
public abstract class PersistenceTest {
	protected final static emfmodelFactory EmfModelFactory = emfmodelFactory.eINSTANCE;
	protected static ResourceSet resourceSet = new ResourceSetImpl();
	protected static File tempFile = null;

	@BeforeClass
	public static void prepareEmf() {
		// Register the default resource factory -- only needed for stand-alone!
		// With SetUUID==true; uuid is identifiable element id (if applicable)
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put(EmfModelXMIResourceFactoryImpl.EXTENSION_SENSORFRAMEWORK,
						new EmfModelXMIResourceFactoryImpl());
//		// With SetUUID==false
//		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
//		.put(SensorFrameworkXMIResourceFactoryImpl.EXTENSION_SENSORFRAMEWORK,
//				new XMIResourceFactoryImpl());

		// Register the package -- only needed for stand-alone!
		@SuppressWarnings("unused")
		emfmodelPackage sp = emfmodelPackage.eINSTANCE;
	}

	@Before
	public void initializeEnvironment() throws IOException {
		tempFile = File.createTempFile(PropertyablePersistenceTest.class.getName() 
				+ "_", "." + EmfModelXMIResourceFactoryImpl.EXTENSION_SENSORFRAMEWORK);
		tempFile.deleteOnExit();
	}
	
	protected void serialize(ExperimentGroup eg) throws IOException {
		// Get the URI of the model file.
		URI fileURI = URI.createFileURI(tempFile.getAbsolutePath());

		// Create a resource for this file.
		Resource resource = resourceSet.createResource(fileURI);

		// Add the book and writer objects to the contents.
		resource.getContents().add(eg);

		// Save the contents of the resource to the file system.
		resource.save(Collections.EMPTY_MAP);
	}

	protected ExperimentGroup deserialize() {
		// Get the URI of the model file.
		URI fileURI = URI.createFileURI(tempFile.getAbsolutePath());

		// Demand load the resource for this file.
		Resource resource = resourceSet.getResource(fileURI, true);

		ExperimentGroup eg = (ExperimentGroup) resource.getContents().get(0);
		return eg;
	}
}
