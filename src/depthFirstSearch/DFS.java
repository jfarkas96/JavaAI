package depthFirstSearch;

import java.util.List;
import java.util.Stack;

public class DFS {
	
	private Stack<Vertex> stack;
	
	public DFS(){
		this.stack = new Stack<Vertex>();
	}
	
	public void dfs(List<Vertex> vertices) {
		for (Vertex v : vertices) {
			if (!v.isVisited()) {
				v.setVisited(true);
				dfsRecursive(v);
				//dfsWithStack(v);
			}
		}
	}
	
	public void dfsRecursive(Vertex v) {
		System.out.println(v);
		
		for (Vertex v1 : v.getNeighbors()) {
			if (!v1.isVisited()) {
				v1.setVisited(true);
				dfsRecursive(v1);
			}
		}
	}

	private void dfswithStack(Vertex v) {
		this.stack.add(v);
		v.setVisited(true);
		while(!this.stack.isEmpty()){
			Vertex v2 = this.stack.pop();
			System.out.println(v2);
			
			for (Vertex v3 : v2.getNeighbors()) {
				if (!v3.isVisited()) {
					v3.setVisited(true);
					this.stack.push(v3);
				}
			}
		}
	}
}
