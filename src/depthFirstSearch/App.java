package depthFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class App {
	public static void main(String[] args) {
		Vertex v1 = new Vertex("1");
		Vertex v2 = new Vertex("2");
		Vertex v3 = new Vertex("3");
		Vertex v4 = new Vertex("4");
		Vertex v5 = new Vertex("5");
		
		List<Vertex> vertices = new ArrayList<Vertex>();
		
		v1.addNeighbor(v2);
		v1.addNeighbor(v3);
		v3.addNeighbor(v4);
		v4.addNeighbor(v5);
		
		vertices.add(v1);
		vertices.add(v2);
		vertices.add(v3);
		vertices.add(v4);
		vertices.add(v5);
		
		DFS dfs = new DFS();
		dfs.dfs(vertices);
	}
}
