package iterativeDeepeningDepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
	
	private String label;
	private int depthLevel = 0;
	private List<Vertex> neighbors;
	
	public Vertex(String label){
		this.label = label;
		this.neighbors = new ArrayList<Vertex>();
	}
	
	@Override
	public String toString() {
		return label;
	}
	
	public void addNeighbor(Vertex neighbor) {
		this.neighbors.add(neighbor);
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public List<Vertex> getNeighbors() {
		return neighbors;
	}

	public void setNeighbors(List<Vertex> neighbors) {
		this.neighbors = neighbors;
	}
	
	public int getDepthLevel() {
		return depthLevel;
	}
	
	public void setDepthLevel(int depthLevel) {
		this.depthLevel = depthLevel;
	}
	
}

