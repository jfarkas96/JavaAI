package travelingSalesmanProblem;

public class City {

	private int x;
	private int y;
	
	public City() {
		this.x = (int) (Math.random()*100);
		this.y = (int) (Math.random()*100);
	}
	
	public City(int x, int y) {
		this.x=x;
		this.y=y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public double distanceTo(City c) {
		int xDist = Math.abs(this.getX() - c.getX());
		int yDist = Math.abs(this.getY() - c.getY());
		return Math.sqrt((xDist*xDist)+(yDist*yDist));
	}
	
	@Override
	public String toString() {
		return this.x + "-" + this.y;
	}
}
