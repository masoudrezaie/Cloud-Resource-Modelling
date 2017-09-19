package de.ugoe.cs.oco.occi2deployment.comparator;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.emc.emf.CachedResourceSet;
import org.occiware.clouddesigner.occi.AttributeState;
import org.occiware.clouddesigner.occi.Entity;
import org.occiware.clouddesigner.occi.Mixin;
import org.occiware.clouddesigner.occi.Resource;

import de.ugoe.cs.oco.occi2deployment.Connection;
import de.ugoe.cs.oco.occi2deployment.ModelUtility;
import de.ugoe.cs.oco.occi2deployment.extraction.Extractor;
import de.ugoe.cs.oco.occi2deployment.extraction.ExtractorFactory;
import de.ugoe.cs.oco.occi2deployment.transformation.Transformator;
import de.ugoe.cs.oco.occi2deployment.transformation.TransformatorFactory;
import pcg.*;
import pcg.impl.PcgFactoryImpl;


/**Complex Comparator implements the similiarity flooding algorithm combined with the EMF Compare
 * results as intial weighting.
 * @author rockodell
 *
 */
public class MixedComparator extends AbsComplexComparator {
	/**Constructor executing the compare method to fill the ELists of the Object.
	 * @param oldModelPath
	 * @param newModelPath
	 * @param conn 
	 */
	public MixedComparator(Path oldModelPath, Path newModelPath, Connection conn) {
		this.connection = conn;
		compare(oldModelPath, newModelPath);
	}

	@Override
	void createResourceMatch(Path oldModelPath, EList<EObject> oldModel, Path newModelPath, EList<EObject> newModel) {		
		Comparator simple = ComparatorFactory.getComparator("Simple", oldModelPath, newModelPath, this.connection);
		
		Transformator occiToPcg = TransformatorFactory.getTransformator("OCCI2PCG");
		Path pcgPath = Paths.get("./src/de/ugoe/cs/oco/occi2deployment/tests/models/My.pcg");
		occiToPcg.transform(oldModelPath, newModelPath, pcgPath);
		
		adaptPCG(pcgPath, simple);
		
		Path ipgPath = Paths.get("./src/de/ugoe/cs/oco/occi2deployment/tests/models/My2.pcg");
		Transformator pcgToIpg = TransformatorFactory.getTransformator("PCG2IPG");
		pcgToIpg.transform(pcgPath, ipgPath);
		
		Map<String, List<Vertex>> map = calculateFixpointValueMap(ipgPath);
		this.matches = this.createMatch(map, oldModel, newModel);
		
		checkNewAndMissingMatchesForSimilarities(this.matches, oldModel, newModel);
	}

	private void adaptPCG(Path pcgPath, Comparator comp) {
		EList<EObject> pcg = ModelUtility.loadPCG(pcgPath);
		Graph pcgGraph = (Graph) pcg.get(0);
		adjustElementsInGraph(pcgGraph, comp.getMatches());
		ModelUtility.storePCG(pcgPath, pcgGraph);
		CachedResourceSet.getCache().clear();
	}

	private void adjustElementsInGraph(Graph pcgGraph,  EList<Match> matches) {
		List<Vertex> toRemove = new BasicEList<Vertex>();
		List<Vertex> toAdd = new BasicEList<Vertex>();
		for(Match match: extractDirectResourceMatch(matches)){
			Resource srcRes = (Resource) match.getSrc();
			Resource tarRes = (Resource) match.getTar();
			boolean missing = true;
			for(Vertex vertex: pcgGraph.getVertices()){	
				if(vertex.getResources().get(0).getId().equals(srcRes.getId())
				&& vertex.getResources().get(1).getId().equals(tarRes.getId())){
					missing = false;
				}	
				else if(vertex.getResources().get(0).getId().equals(srcRes.getId())
				|| vertex.getResources().get(1).getId().equals(tarRes.getId())){
					toRemove.add(vertex);
				}
			}
			if(missing == true){
				toAdd.add(createMissingVertex(srcRes, matches));
			}
		}
		for(Vertex vertex: toAdd){
			pcgGraph.getVertices().add(vertex);
		}
		
		for(Vertex vertex: toRemove){
			EcoreUtil.delete(vertex);
		}
		
		List<Edge> toRemoveE = new BasicEList<Edge>();
		for(Edge edge: pcgGraph.getEdges()){
			if(edge.getTarget() == null || edge.getSource() == null){
				toRemoveE.add(edge);
			}
		}
		for(Edge edge: toRemoveE){
			EcoreUtil.delete(edge);
		}
	}
	
	private Vertex createMissingVertex(Resource oldRes, EList<Match> matches) {
		Vertex vertex = new PcgFactoryImpl().createVertex();
		Match missingMatch = getMatchFor(oldRes, matches);
		pcg.Resource oldResource = new PcgFactoryImpl().createResource();
		oldResource.setId(((Resource)missingMatch.getSrc()).getId());
		oldResource.setTitle(((Resource)missingMatch.getSrc()).getTitle());
		
		pcg.Resource newResource = new PcgFactoryImpl().createResource();
		newResource.setId(((Resource)missingMatch.getTar()).getId());
		newResource.setTitle(((Resource)missingMatch.getTar()).getTitle());
		
		vertex.setFixpointValue(1);
		vertex.setKind(oldRes.getKind().getScheme() + oldRes.getKind().getTerm());
		vertex.setTitle(oldRes.getTitle() + ", " + ((Resource) missingMatch.getTar()).getTitle());
		vertex.getResources().add(oldResource);
		vertex.getResources().add(newResource);
		return vertex;
	}

	private boolean edgeAlreadyExists(Graph pcgGraph, Vertex srcVertex, Vertex tarVertex) {
		EList<Edge> outEdges = new BasicEList<Edge>();
		for(Edge edge: pcgGraph.getEdges()){
			if(edge.getSource() == srcVertex){
				outEdges.add(edge);
			}
		}
		for(Edge outEdge: outEdges){
			if(outEdge.getTarget() == tarVertex){
				return true;
			}
		}
		return false;
	}

	private Match getMatchFor(Resource res, EList<Match> matches) {
		for(Match match: matches){
			if(match.getTar() != null && match.getSrc()!= null){
				System.out.println(match.getSrc().eClass().getName());
				if(match.getSrc().eClass().getName().equals("Resource")){
					if(res.getId().equals(((Resource) match.getSrc()).getId())){
						System.out.println(match.getSrc()+ " : " + match.getTar());
						return match;
					}
				}
			}
		}
		return null;
	}

	private Vertex correctVertex(EList<Vertex> vertices, String id) {
		for(Vertex vertex: vertices){
			if(vertex.getResources().get(0).getId().equals(id) && vertex.getResources().get(1).getId().equals(id)){
				return vertex;
			}
		}
		return null;
	}


	/**After the similarity flooding algorithm, missing and new matches are investigated for similarities,
	 * such as name, in order to match matching objects together.
	 * @param matches
	 * @param oldModel
	 * @param newModel
	 */
	private void checkNewAndMissingMatchesForSimilarities(EList<Match> matches, EList<EObject> oldModel, EList<EObject> newModel) {
		EList<Match> toRemove = new BasicEList<Match>();
		EList<Match> toAdd = new BasicEList<Match>();
		for(Match match: matches){
			if(match.getTar() == null){
				for(Match match2: matches){
					if(match2.getSrc() == null){
						if(checkIfEquivalent(match.getSrc(),match2.getTar())){
							Match fusedMatch = new Match(match.getSrc(), match2.getTar());
							toAdd.add(fusedMatch);
							toRemove.add(match);
							toRemove.add(match2);
						}
					}
				}
			}
		}
		for(Match vertex: toRemove){
			matches.remove(vertex);
		}
		for(Match vertex: toAdd){
			matches.add(vertex);
		}
	}
	
	/**Checks, whether two Objects possess identical AttributeStates.
	 * @param oldObj
	 * @param newObj
	 * @return
	 */
	private boolean checkIfEquivalent(EObject oldObj, EObject newObj) {
		Entity oldRes = (Resource) oldObj;
		Entity newRes = (Resource) newObj;
		if(oldRes.getTitle().equals(newRes.getTitle())
				&& oldRes.getKind().getTerm().equals(newRes.getKind().getTerm())
				&&oldRes.getKind().getScheme().equals(newRes.getKind().getScheme())
				&& compareMixins(oldRes, newRes)){
			return true;
		}
		return false;
		/*COMPLETE EQUIVALENT
		boolean equivalentElement = true;
		for(EObject oldContent: oldObj.eContents()){
			if(oldContent.eClass().getName().equals("AttributeState")){
				boolean equivalentAttribute = false;
				for(EObject newContent: newObj.eContents()){
					if(newContent.eClass().getName().equals("AttributeState")){
						AttributeState oldAttr = (AttributeState) oldContent;
						AttributeState newAttr = (AttributeState) newContent;
						if(oldAttr.getName().equals(newAttr.getName())){
							equivalentAttribute = true;
							if(oldAttr.getValue().equals(newAttr.getValue()) == false){
								equivalentElement = false;
							}
						}
					}
				}
				if(equivalentAttribute == false){
					equivalentElement = false;
					break;
				}		
			}
		}
		return equivalentElement;
		*/
	}

	private boolean compareMixins(Entity oldRes, Entity newRes) {
		if(oldRes.getMixins().size() != newRes.getMixins().size()){
			return false;
		}
		else{
			for(Mixin oldMix: oldRes.getMixins()){
				boolean exists = false;
				for(Mixin newMix: newRes.getMixins()){
					if(oldMix.getTerm().equals(newMix.getTerm())
							&& oldMix.getScheme().equals(newMix.getScheme())){
						exists = true;
					}
				}
				if(exists == false){
					return false;
				}
			}
			return true;
		}
	}
	
	@Override
	Vertex getSuitableFixpointValue(Map<String, List<Vertex>> map, EList<EObject> oldModel, EList<EObject> newModel) {
		Vertex maxVertex = null;
		double max = 0.0;
		for(List<Vertex> vertices: map.values()){
			sortVertices(vertices);
			logList(vertices);
		}
		System.out.println("");
		for(List<Vertex> vertices: map.values()){
			if(vertices.isEmpty() == false && vertices.get(0).getFixpointValue() > max){
				if(multipleMaxValuesExist(vertices)){
					List<Vertex> prunedVertexList = pruneVertices(vertices);
					//maxVertex=getMostFittingVertice(vertices, oldModel, newModel);
					maxVertex=mostFittingVertex(prunedVertexList, oldModel, newModel);
					max = vertices.get(0).getFixpointValue();
				}
				else{
					maxVertex=vertices.get(0);	
					max = vertices.get(0).getFixpointValue();
				}
			}
		}
		if(maxVertex != null) {
			System.out.println("First Pick: " + maxVertex.getTitle());
			List<Vertex> possibleSources = getPossibleSources(maxVertex.getResources().get(1), map);
			sortVertices(possibleSources);
			logList(possibleSources);
			maxVertex=mostFittingVertex(possibleSources, oldModel, newModel);
			System.out.println("Second Pick: " + maxVertex.getTitle()); 
			System.out.println("");
			return maxVertex;
		}
		else{
			System.out.println("NO VERTEX LEFT!");
			return null;
		}
	}
	
	private List<Vertex> pruneVertices(List<Vertex> vertices) {
		List<Vertex> prunedVertexList = new BasicEList<Vertex>();
		for(Vertex ver: vertices){
			if(ver.getFixpointValue() == vertices.get(0).getFixpointValue()){
				prunedVertexList.add(ver);
			}
		}
		return prunedVertexList;
	}

	private List<Vertex> getPossibleSources(pcg.Resource resource, Map<String, List<Vertex>> map) {
		List <Vertex> possibleSources = new BasicEList<Vertex>();
		for(List<Vertex> vertices: map.values()){
			for(Vertex ver: vertices){
				if(ver.getResources().get(1).getId().equals(resource.getId())){
					possibleSources.add(ver);
				}
			}
		}
		return possibleSources;
	}

	
	private static Vertex mostFittingVertex(List<Vertex> vertexes, EList<EObject> srcM, EList<EObject> tarM) {
		int bestFit = 0; Vertex maxVer;
		for(int i=1; i < vertexes.size(); i++){
			maxVer = compVertexes(vertexes.get(bestFit), vertexes.get(i), srcM, tarM);
			if(vertexes.get(i).equals(maxVer)){
				bestFit = i;
			}
		}
		return vertexes.get(bestFit);
	}
	
	/*
	private static Vertex getMostFittingVertice(List<Vertex> vertices, EList<EObject> oldModel, EList<EObject> newModel) {
		int bestFit = 0;
		int nextFit = 1;
		Vertex maxVertex;
		while(nextFit < vertices.size() &&
				vertices.get(bestFit).getFixpointValue() == vertices.get(nextFit).getFixpointValue()){
			maxVertex = compareVertices(vertices.get(bestFit), vertices.get(nextFit), oldModel, newModel);
			if(vertices.get(nextFit).equals(maxVertex)){
				bestFit = nextFit;
			}
			nextFit++;
		}
		return vertices.get(bestFit);
	}*/

	private static Vertex compVertexes(Vertex vertex, Vertex vertex2, EList<EObject> oldModel, EList<EObject> newModel) {
		if(vertexFit(vertex, oldModel, newModel) > vertexFit(vertex2, oldModel, newModel)){
			return vertex;
		}
		else{
			return vertex2;
		}		
	}

	private static int vertexFit(Vertex vertex, EList<EObject> oldModel, EList<EObject> newModel) {
		int count = 0;
		EObject oldOcciResource;
		EObject newOcciResource;
		oldOcciResource = getEquivalentResource(vertex.getResources().get(0).getId(), oldModel);
		newOcciResource = getEquivalentResource(vertex.getResources().get(1).getId(), newModel);
		
		for(EObject oldContent: oldOcciResource.eContents()){
			if(oldContent.eClass().getName().equals("AttributeState")){
				for(EObject newContent: newOcciResource.eContents()){
					if(newContent.eClass().getName().equals("AttributeState")){
						AttributeState oldAttr = (AttributeState) oldContent;
						AttributeState newAttr = (AttributeState) newContent;
						if(oldAttr.getName().equals(newAttr.getName()) ){
							if(oldAttr.getValue().equals(newAttr.getValue())){
								count++;
							}
						}
					}
				}
			}
		}
		return count;
	}

	private static boolean multipleMaxValuesExist(List<Vertex> vertices) {
		if(vertices.size() > 1 && vertices.get(0).getFixpointValue() == vertices.get(1).getFixpointValue()){		
			return true;
		}
		return false;
	}
}


