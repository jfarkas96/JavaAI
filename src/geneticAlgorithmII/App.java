package geneticAlgorithmII;

public class App {
	public static void main(String[] args) {
		GeneticAlgorithms ga = new GeneticAlgorithms();
		
		Population pop = new Population(100);
		pop.initialize();
		
		int generationCounter = 0;
		
		while (generationCounter != Constants.SIMULATION_LENGTH) {
			generationCounter++;
			System.out.println("Generation: " + generationCounter + " - fittest is: " + pop.getFittestIndividual().getFitness());
			System.out.println(pop.getFittestIndividual()+"\n");
			pop = ga.evolvePopulation(pop);
		}
		
		System.out.println("Solution found!!!");
		System.out.println(pop.getFittestIndividual());
	}
}
