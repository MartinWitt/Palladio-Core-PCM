package de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import org.opt4j.core.problem.Genotype;
import org.opt4j.operator.copy.Copy;

import de.uka.ipd.sdq.dsexplore.helper.ResultsWriter;
import de.uka.ipd.sdq.dsexplore.launch.DSEWorkflowConfiguration;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEIndividual;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEIndividualBuilder;
import de.uka.ipd.sdq.dsexplore.opt4j.start.Opt4JStarter;

/**
 * 
 * @author martens, beyer
 *
 */
public class TacticOperatorsManager {

	
	/**
	 * Heuristics to be used to generate candidates
	 */
	protected Collection<ITactic> heuristics = new ArrayList<ITactic>();
	protected ResultsWriter writer;
	protected Random generator = new Random();
	
	/**
	 * @param copy Creates copy of genotypes
	 * @param individualBuilder Builds individual
	 */
	public TacticOperatorsManager(Copy<Genotype> copy, DSEIndividualBuilder individualBuilder) {
		DSEWorkflowConfiguration configuration = Opt4JStarter.getDSEWorkflowConfig();
		heuristics = TacticOperatorsFactory.getActivatedInstances(copy, individualBuilder, configuration);
		this.writer = new ResultsWriter(Opt4JStarter.getDSEWorkflowConfig().getResultFolder()+"heuristicsInfo");
		int numberOfGenes = Opt4JStarter.getProblem().getDesignDecisions().size();
		String headline = "Tactic;Solution;Candidate numeric id;Parent numeric id;Candidate genome (several cols);";
		for (int i = 0; i < numberOfGenes; i++){
			headline += ";";
		}
		headline += "Parent genome (several cols);";
		for (int i = 0; i < numberOfGenes; i++){
			headline += ";";
		}
		headline += "Utilization value and whether returned\n";
		writer.writeToLogFile(headline);
	}
	
	/**
	 * Applies registered heuristics to individual and returns candidates
	 * @param individual
	 * @return
	 */
	public List<TacticsResultCandidate> getAllCandidates(DSEIndividual individual) {
		
		//results cache for the current candidate. 
		UtilisationResultCacheAndHelper resultsCache = new UtilisationResultCacheAndHelper(); 
		
		
		List<TacticsResultCandidate> result = new ArrayList<TacticsResultCandidate>();
		Collection<TacticsResultCandidate> candidatesFromCurrentHeuristic;
		for (ITactic heuristic : heuristics) {
			candidatesFromCurrentHeuristic = heuristic.getHeuristicCandidates(individual, resultsCache);
			if (candidatesFromCurrentHeuristic.size() > 0) {
				this.writer.writeTacticCandidateInfo(heuristic, candidatesFromCurrentHeuristic);
				result.addAll(candidatesFromCurrentHeuristic);
			}
		}
		return result;
	}
	
	

	/**
	 * Applies registered heuristics to individual and returns random candidate
	 * based on candidate weight and heuristic weight. Returns null if no heuristic
	 * can be be applied.
	 * @param individual
	 * @return Random candidate from registered heuristic or null if no heuristic can be applied
	 */
	public DSEIndividual getCandidate(DSEIndividual individual) {
		Collection <TacticsResultCandidate> candidates = getAllCandidates(individual);
		double sumOfAllWeights = 0;
		for (TacticsResultCandidate c : candidates) {
			sumOfAllWeights += c.getFinalWeight();
		}
		
		double threshold = generator.nextDouble()*sumOfAllWeights;
		double currentLevel = 0;
		for (TacticsResultCandidate c : candidates) {
			currentLevel += c.getFinalWeight();
			// use spectrum of candidate weights to select candidate. The larger the
			// weight of the candidate the higher the probability of being selected
			if (currentLevel >= threshold) {
				this.writer.writeTacticManagerChoice(c);
				return c;
			}
		}
		if (candidates.size() > 0) {
			throw new RuntimeException("Random selection failed.");
		} 
		// won't be executed unless candidates list is empty
		else {
			return null;
		}
	}
	
	public Collection<ITactic> getHeuristics() {
		return heuristics;
	}
	
	
}
