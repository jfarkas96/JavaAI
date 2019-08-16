package iterativeDeepeningDepthFirstSearch;

import java.util.Stack;

public class IDDFS {

	private Vertex targetVertex;
	private boolean isTargetFound;
	
	public IDDFS(Vertex targetVertex) {
		this.targetVertex = targetVertex;
	}
	
	public void runIDDFS(Vertex root) {
		int depth = 0;
		
		while (!isTargetFound) {
			System.out.println();
			dfs(root, depth);
			depth++;
		}
	}
	
	private void dfs(Vertex root, int depthLevel) {
		Stack<Vertex> stack = new Stack<Vertex>();
		root.setDepthLevel(0);
		stack.push(root);
		while(!stack.isEmpty()) {
			Vertex v = stack.pop();
			System.out.println(v);
			if(v.getLabel().equals(this.targetVertex.getLabel())){
				System.out.println("Vertex has been found...");
				this.isTargetFound = true;
				return;
			}
			
			if(v.getDepthLevel()>=depthLevel){
				continue;
			}
			
			for (Vertex v2 : v.getNeighbors()) {
				v2.setDepthLevel(v.getDepthLevel()+1);
				stack.push(v2);
			}
		}
	}
}
