package aStar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class AStar {
	private Node[][] searchSpace;
	private Node startNode;
	private Node finalNode;
	private List<Node> closedNodes;
	private Queue<Node> openNodes;

	public AStar() {
		this.searchSpace = new Node[Constants.NUM_ROWS][Constants.NUM_COLS];
		this.openNodes = new PriorityQueue<Node>(new NodeComparator());
		this.closedNodes = new ArrayList<Node>();
		initializeSearchSpace();
	}

	private void initializeSearchSpace() {
		for (int rowIndex=0; rowIndex<Constants.NUM_ROWS; rowIndex++) {
			for (int colIndex=0; colIndex<Constants.NUM_COLS; colIndex++) {
				Node node = new Node(rowIndex,colIndex);
				this.searchSpace[rowIndex][colIndex] = node;
			}
		}

		this.searchSpace[1][7].setBlock(true);
		this.searchSpace[2][3].setBlock(true);
		this.searchSpace[2][4].setBlock(true);
		this.searchSpace[2][5].setBlock(true);
		this.searchSpace[2][6].setBlock(true);
		this.searchSpace[2][7].setBlock(true);

		this.startNode = this.searchSpace[3][3];
		this.finalNode = this.searchSpace[1][6];
	}

	public void search() {
		startNode.setH(manhattanHeuristic(startNode,finalNode));
		openNodes.add(startNode);
		
		while(!openNodes.isEmpty()) {
			
			Node current = openNodes.poll();
			System.out.println(current + " Predecessor is: " + current.getPredecessor());
			
			if (current.equals(finalNode)) return;
			
			openNodes.remove(current);
			closedNodes.add(current);
			
			for (Node neighbor : getAllNeighbors(current)) {
				if(closedNodes.contains(neighbor)) continue;
				
				if(!openNodes.contains(neighbor)) openNodes.add(neighbor);
				
				neighbor.setPredecessor(current);
			}
		}
	}

	private List<Node> getAllNeighbors(Node node) {
		List<Node> neighbors = new ArrayList<Node>();
		
		int row = node.getRowIndex();
		int col = node.getColIndex();
		
		if (row-1>=0 && !this.searchSpace[row-1][col].isBlock()) {
			searchSpace[row-1][col].setG(node.getG()+Constants.HORIZONTAL_VERTICAL_COST);
			searchSpace[row-1][col].setH(manhattanHeuristic(searchSpace[row-1][col], finalNode));
			neighbors.add(this.searchSpace[row-1][col]);
		}
		
		if (row+1<Constants.NUM_ROWS && !this.searchSpace[row+1][col].isBlock()) {
			searchSpace[row+1][col].setG(node.getG()+Constants.HORIZONTAL_VERTICAL_COST);
			searchSpace[row+1][col].setH(manhattanHeuristic(searchSpace[row+1][col], finalNode));
			neighbors.add(this.searchSpace[row+1][col]);
		}
		
		if (col-1>=0 && !this.searchSpace[row][col-1].isBlock()) {
			searchSpace[row][col-1].setG(node.getG()+Constants.HORIZONTAL_VERTICAL_COST);
			searchSpace[row][col-1].setH(manhattanHeuristic(searchSpace[row][col-1], finalNode));
			neighbors.add(this.searchSpace[row][col-1]);	
		}
		
		if (col+1<Constants.NUM_COLS && !this.searchSpace[row][col+1].isBlock()) {
			searchSpace[row][col+1].setG(node.getG()+Constants.HORIZONTAL_VERTICAL_COST);
			searchSpace[row][col+1].setH(manhattanHeuristic(searchSpace[row][col+1], finalNode));
			neighbors.add(this.searchSpace[row][col+1]);			
		}
		
		return neighbors;
	}

	private int manhattanHeuristic(Node startNode, Node finalNode) {
		return (Math.abs(startNode.getRowIndex()-finalNode.getRowIndex()) + Math.abs(startNode.getColIndex()-finalNode.getColIndex()));
	}

	public void showPath() {
		System.out.println("SHORTEST PATH WITH A* SEARCH:");

		Node node = this.finalNode;
		ArrayList<Node> path = new ArrayList<Node>();
		while(node!=null) {
			path.add(node);
			node = node.getPredecessor();
		}

		Collections.reverse(path);
		for (Node n : path) {
			System.out.println(n);
		}
	}
}
