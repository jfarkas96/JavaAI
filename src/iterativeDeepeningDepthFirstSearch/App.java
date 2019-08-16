package iterativeDeepeningDepthFirstSearch;

public class App {
	public static void main(String[] args) {
		Vertex v1 = new Vertex("1");
		Vertex v2 = new Vertex("2");
		Vertex v3 = new Vertex("3");
		Vertex v4 = new Vertex("4");
		Vertex v5 = new Vertex("5");	
		
		v1.addNeighbor(v2);
		v1.addNeighbor(v3);
		v2.addNeighbor(v4);
		v4.addNeighbor(v5);
		
		IDDFS iddfs = new IDDFS(v5);
		iddfs.runIDDFS(v1);
	}
}
