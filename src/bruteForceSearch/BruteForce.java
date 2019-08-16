package bruteForceSearch;
  
public class BruteForce {
	
	private static final double START_X = -1;
	private static final double END_X = 2;

	public double f(double x) { 
  		return -1*(x-1)*(x-1)+2;
	}
	
	public BruteForce(){}
	
	public void BruteForceSearch() {
		double startingPoint = START_X;
		double max = f(startingPoint);
		double maxX = startingPoint;
		double dx = 0.01;
		
		for (double i=startingPoint; i<END_X; i+=dx){
			if (f(i) > max) {
				max = f(i);
				maxX = i;
			}
		}
		
		System.out.println("the maximum value is f(x) = " + max + " and x = " + maxX);
	}
}