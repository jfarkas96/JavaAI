package geneticAlgorithmII;

public class Population {

	private Individual[] individuals;
	
	public Population(int popSize) {
		individuals = new Individual[popSize];
	}
	
	public void initialize() {
		for (int i=0; i<individuals.length; i++) {
			Individual newInd = new Individual();
			newInd.generateIndividual();
			saveIndividual(i, newInd);
		}
	}
	
	public Individual getIndividual(int index) {
		return this.individuals[index];
	}
	
	public Individual getFittestIndividual() {
		Individual fittest = individuals[0];
		
		for (int i=1; i<individuals.length; i++) {
			if (getIndividual(i).getFitness() >= fittest.getFitness()) {
				fittest = getIndividual(i);
			}
		}
		
		return fittest;
	}
	
	public int size() {
		return this.individuals.length;
	}
	
	public void saveIndividual(int index, Individual i) {
		this.individuals[index] = i;
	}
}
