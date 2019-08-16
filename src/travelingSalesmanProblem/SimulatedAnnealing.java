package travelingSalesmanProblem;

public class SimulatedAnnealing {
	
	private SingleTour best;
	
	public void simulation() {
		
		double temp = 10000;
		double coolRate = 0.003;
		
		SingleTour currentSolution = new SingleTour();
		currentSolution.generateIndividual();
		
		System.out.println("Initial solution distance: " + currentSolution.getDistance());
		
		best = new SingleTour(currentSolution.getTour());
		
		while (temp > 1) {
			SingleTour newSolution = new SingleTour(currentSolution.getTour());
			
			int randomIndex1 = (int) (newSolution.getTourSize() * Math.random());
			City c1 = newSolution.getCity(randomIndex1);
			
			int randomIndex2 = (int) (newSolution.getTourSize() * Math.random());
			City c2 = newSolution.getCity(randomIndex2);
			
			newSolution.setCity(randomIndex2, c1);
			newSolution.setCity(randomIndex1, c2);
			
			double currentEnergy = currentSolution.getDistance();
			double newEnergy = newSolution.getDistance();
			
			if (acceptanceProbability(currentEnergy, newEnergy, temp) > Math.random()) 
				currentSolution = new SingleTour(newSolution.getTour());
			
			if (currentSolution.getDistance() < best.getDistance())
				best = new SingleTour(currentSolution.getTour());
			
			temp *= 1-coolRate;
		}
	}
	
	private double acceptanceProbability(double currentEnergy, double newEnergy, double temp) {
		if (newEnergy < currentEnergy) 
			return 1;
		
		return Math.exp((currentEnergy-newEnergy)/temp);
	}

	public SingleTour getBest() {
		return best;
	}
}
