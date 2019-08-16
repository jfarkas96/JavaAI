package breadthFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
	
	private String label;
	private boolean visited;
	private List<Vertex> neighbors;
	
	public Vertex(String label) {
		this.label = label;
		this.neighbors = new ArrayList<Vertex>();
	}

	public String getLabel() {
		return label;
	}

	public void setData(String label) {
		this.label = label;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public List<Vertex> getNeighbors() {
		return neighbors;
	}

	public void setNeighbors(List<Vertex> neighbors) {
		this.neighbors = neighbors;
	}
	
	public void addNeighbor(Vertex neighbor) {
		neighbors.add(neighbor);
	}
	
	@Override
	public String toString() {
		return this.label;
	}
}
