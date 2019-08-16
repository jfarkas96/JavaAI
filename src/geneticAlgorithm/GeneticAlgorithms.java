package geneticAlgorithm;

import java.util.Random;

public class GeneticAlgorithms {
	
	private Random randomGenerator;
	
	public GeneticAlgorithms() {
		this.randomGenerator = new Random();
	}
	
	public Population evolvePopulation(Population pop) {
		Population newPop = new Population(pop.size());
		
		for (int i=0; i<pop.size(); i++) {
			Individual firstInd = randomSelection(pop);
			Individual secondInd = randomSelection(pop);
			Individual newInd = crossover(firstInd, secondInd);
			newPop.saveIndividual(i,newInd);
		}
		
		for (int i=0; i<pop.size(); i++) {
			mutate(newPop.getIndividual(i));
		}
		
		return newPop;
	}
	
	private Individual mutate(Individual ind) {
		for (int i=0; i<Constants.CHROMOSOME_LENGTH; i++) {
			if (Math.random() <= Constants.MUTATION_RATE) {
				int gene = randomGenerator.nextInt(10);
				ind.setGene(i, gene);
			}
		}
		
		return ind;
	}
	
	private Individual crossover(Individual one, Individual two) {
		Individual newInd = new Individual();
		
		for (int i=0; i<Constants.CHROMOSOME_LENGTH; i++) {
			if (Math.random() <= Constants.CROSSOVER_RATE) {
				newInd.setGene(i, one.getGene(i));
			} else {
				newInd.setGene(i, two.getGene(i));
			}
		}
		
		return newInd;
	}
	
	private Individual randomSelection(Population pop) {
		Population newPop = new Population(Constants.TOURNAMENT_SIZE);
		
		for (int i=0; i<Constants.TOURNAMENT_SIZE; i++) {
			int randomIndex = (int) (Math.random() * pop.size());
			newPop.saveIndividual(i, pop.getIndividual(randomIndex));
		}
		
		Individual fittestIndividual = newPop.getFittestIndividual();
		
		return fittestIndividual;
	}
}
