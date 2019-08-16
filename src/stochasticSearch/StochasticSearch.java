package stochasticSearch;

import java.util.concurrent.ThreadLocalRandom;

public class StochasticSearch {
	private static final double START_X = -1;
	private static final double END_X = 2;
	
	private double f(double x) {
		return (x-1)*(x-1)-1;
	}
	
	public void stochasticSearch() {
		double startPoint = START_X;
		double min = f(startPoint);
		double minX = startPoint;
		
		for (int i=0; i<10000; i++) {
			double randomX = ThreadLocalRandom.current().nextDouble(START_X,END_X);
			
			if (f(randomX) < min) {
				min = f(randomX);
				minX = randomX;
			}
		}
		
		System.out.println("The minimum is f(x) = " + min + " and x = " + minX);
	}
}
