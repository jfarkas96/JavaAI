package tabuSearch;

import java.util.ArrayList;
import java.util.List;

public class State {
	private double x;
	private double y;
	private double z;
	private List<State> neighbors;
		
	public State(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.neighbors = new ArrayList<State>();
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getZ() {
		return z;
	}
	public void setZ(double z) {
		this.z = z;
	}
	public List<State> getNeighbors() {
		return neighbors;
	}
	public void addNeighbor(State neighbor) {
		this.neighbors.add(neighbor);
	}
	
	@Override
	public String toString() {
		return "(" + this.x + ";" + this.y + ";" + this.z + ")";
	}
}
