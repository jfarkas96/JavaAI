package hillClimbingSearch;

public class HillClimbing {
	
	private static final double START_X = -2;
	
	private double f(double x) {
		return -(x-1)*(x-1)+2;
	}
	
	public void climbHill() {
		double dx = 0.01;
		double currentPoint = START_X;
		double max = f(currentPoint);
		
		while (f(currentPoint+dx) >= max) {
			max = f(currentPoint+dx);
			System.out.println("x = " + currentPoint + " f(x) = " + f(currentPoint));
			currentPoint = currentPoint + dx;
		}
		
		System.out.println("Max with hill climbing: " + max);
	}
}
