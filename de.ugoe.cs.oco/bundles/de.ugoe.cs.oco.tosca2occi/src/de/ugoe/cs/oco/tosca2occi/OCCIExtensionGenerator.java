/**
 * 
 */
package de.ugoe.cs.oco.tosca2occi;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.cmf.occi.core.OCCIPackage;
import org.eclipse.cmf.occi.core.util.OCCIResourceFactoryImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.eclipse.epsilon.common.parse.problem.ParseProblem;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.emc.emf.InMemoryEmfModel;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.models.IRelativePathResolver;
import org.eclipse.epsilon.etl.EtlModule;
import org.eclipse.xsd.XSDPackage;

import de.ugoe.cs.oco.tosca.DocumentRoot;
import de.ugoe.cs.oco.tosca.TImport;
import de.ugoe.cs.oco.tosca.ToscaPackage;
import de.ugoe.cs.oco.tosca.ValidImportTypes;
import de.ugoe.cs.oco.tosca.util.ToscaResourceFactoryImpl;

/**
 * Class responsible for handling the transformation of TOSCA models to OCCI models.
 * @author Fabian Korte
 */
public class OCCIExtensionGenerator {
	/**
	 * @param toscaModelURI The input path to the TOSCA model
	 * @param occiModelURI The output path where the generated OCCI model will be stored. 
	 * @return
	 * @throws Exception
	 */
	public String generate(URI toscaModelURI, URI occiModelURI) throws Exception{
		//EcorePlugin.ExtensionProcessor.process(null);
					
		ResourceSet occiSet = new ResourceSetImpl();
		ResourceSet toscaSet = new ResourceSetImpl();
		
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("tosca", new ToscaResourceFactoryImpl());
		m.put("occie", new OCCIResourceFactoryImpl());
		
		EtlModule module = new EtlModule();
		Object result = null;	  
		try {
			module.parse(this.getClass().getClassLoader().getResource("model/helper/generateExtension.etl").toURI());
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (module.getParseProblems().size() > 0) {
			System.err.println("Parse errors occured...");
			for (ParseProblem problem : module.getParseProblems()) {
				System.err.println(problem.toString());
			}   
		}

		try {
			
			occiSet.getPackageRegistry().put(OCCIPackage.eNS_URI, OCCIPackage.eINSTANCE);
			
			HashMap<String, String> extensionMap = new HashMap<String, String>();
			extensionMap.put("http://schemas.ogf.org/occi/core", "Core");
			extensionMap.put("http://schemas.modmacao.org/modmacao", "MODMACAO");

			for (Entry<String, String> entry: extensionMap.entrySet()) {
				Resource resource = occiSet.getResource(URI.createURI(entry.getKey(), true), true);
				IModel model = new InMemoryEmfModel(resource);
				model.setName(entry.getValue());
				module.getContext().getModelRepository().addModel(model);		
			}
			
			//List<Resource> externalResources = new EcoreModelLoader().searchAndLoadEcoreModels(
			//		toscaModelURI.trimSegments(1), toscaSet);
			
			//for (Resource externalResource: externalResources) {
			//	EPackage externalPackage = (EPackage) externalResource.getContents().get(0);
			//	InMemoryEmfModel model = new InMemoryEmfModel(externalResource);
			//	model.setName(externalPackage.getName());
			//	module.getContext().getModelRepository().addModel(model);
			//}
			
			
			Resource resource = null;
						
			toscaSet.getPackageRegistry().put(XMLTypePackage.eNS_URI, XMLTypePackage.eINSTANCE);
			toscaSet.getPackageRegistry().put(ToscaPackage.eNS_URI, ToscaPackage.eINSTANCE);
			
			resource = toscaSet.getResource(toscaModelURI, true);
			InMemoryEmfModel toscaModel = new InMemoryEmfModel(resource);
			toscaModel.setName("Types");
			
			DocumentRoot root = (DocumentRoot) resource.getContents().get(0);
			List<TImport> imports = root.getDefinitions().get(0).getImport();
			
			toscaSet.getPackageRegistry().put(XSDPackage.eNS_URI, XSDPackage.eINSTANCE);
			// we assume here that there is only one import
			for (TImport imp: imports) {
				if (imp.getImportType().equals(ValidImportTypes.XSD_TYPE)) {
					URI xsdpath = URI.createFileURI(imp.getLocation()).resolve(toscaModelURI);
					Resource xsdResource = toscaSet.getResource(xsdpath, true);
					InMemoryEmfModel xsdModel = new InMemoryEmfModel(xsdResource);
					xsdModel.getAliases().add("TypesXSD");
					module.getContext().getModelRepository().addModel(xsdModel);
				}
			}
			
			
			
			resource = occiSet.createResource(occiModelURI);
			InMemoryEmfModel occiModel = new InMemoryEmfModel(resource);
			occiModel.setMetamodelUri("http://schemas.ogf.org/occi/core/ecore");
			occiModel.setName("OCCIE");
						
			module.getContext().getModelRepository().addModel(toscaModel);
			module.getContext().getModelRepository().addModel(occiModel);
			
			
			result = module.execute();
			occiModel.getResource().save(null);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result.toString();
	}
	
	  protected static EmfModel createEmfModel(String name, String model, 
		      String metamodel, boolean readOnLoad, boolean storeOnDisposal) 
		          throws EolModelLoadingException, URISyntaxException {
		    EmfModel emfModel = new EmfModel();
		    StringProperties properties = new StringProperties();
		    properties.put(EmfModel.PROPERTY_NAME, name);
		    properties.put(EmfModel.PROPERTY_MODEL_URI, model);
		    properties.put(EmfModel.PROPERTY_METAMODEL_URI, metamodel);
		    properties.put(EmfModel.PROPERTY_READONLOAD, readOnLoad + "");
		    properties.put(EmfModel.PROPERTY_STOREONDISPOSAL, 
		        storeOnDisposal + "");
		    emfModel.load(properties, (IRelativePathResolver) null);
		    return emfModel;
	}
}

