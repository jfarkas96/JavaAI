package simulatedAnnealing;

import java.util.Random;

public class SimulatedAnnealing {
	
	private Random randomGenerator;
	private double currentCoordinate;
	private double nextCoordinate;
	private double bestCoordinate;
	
	public void findOptimum() {
		double temperature = Constants.MAX_TEMP;
		while (temperature > Constants.MIN_TEMP) {
			nextCoordinate = getRandomX();
			double currentEnergy = getEnergy(currentCoordinate);
			double newEnergy = getEnergy(nextCoordinate);
			
			if (acceptanceProbability(currentEnergy, newEnergy, temperature) > Math.random() ) {
				currentCoordinate = nextCoordinate;
			}
			
			if (f(currentCoordinate) < f(bestCoordinate) ) {
				bestCoordinate = currentCoordinate;
			}
			
			temperature*=1-Constants.COOL_RATE;
		}
		
		System.out.println("Global extremum guess: x = " + bestCoordinate +" and f(x) = " +f(bestCoordinate));
	}
	
	private double getRandomX() {
		return randomGenerator.nextDouble()*(Constants.MAX_COORD - Constants.MIN_COORD) + Constants.MIN_COORD;
	}
	
	public SimulatedAnnealing() {
		this.randomGenerator = new Random();
	}
	
	public double getEnergy(double x) {
		return f(x);
	}
	
	public double f(double x){
		return (x-0.3)*(x-0.3)*(x-0.3)-5*x+x*x-2;
	}
	
	public double acceptanceProbability(double energy, double newEnergy, double temperature) {
		
		if (newEnergy < energy ) {
			return 1;
		}
		
		return Math.exp((energy-newEnergy)/temperature);
	}
}
