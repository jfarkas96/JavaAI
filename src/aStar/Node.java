package aStar;

public class Node {
	private int g;
	private int h;
	private int rowIndex;
	private int colIndex;
	private Node predecessor;
	private boolean isBlock;
	
	public Node(int rowIndex, int colIndex) {
		this.rowIndex = rowIndex;
		this.colIndex = colIndex;
	}
	
	public boolean isBlock() {
		return isBlock;
	}
	
	public int getG() {
		return g;
	}
	
	public void setG(int g) {
		this.g = g;
	}
	
	public int getH() {
		return h;
	}
	
	public void setH(int h) {
		this.h = h;
	}
	
	public int getRowIndex() {
		return rowIndex;
	}
	
	public void setRowIndex(int rowIndex) {
		this.rowIndex = rowIndex;
	}
	
	public int getColIndex() {
		return colIndex;
	}
	
	public void setColIndex(int colIndex) {
		this.colIndex = colIndex;
	}
	
	public Node getPredecessor() {
		return predecessor;
	}
	
	public void setPredecessor(Node predecessor) {
		this.predecessor = predecessor;
	}
	
	public void setBlock(boolean isBlock) {
		this.isBlock = isBlock;
	}
	
	public int getF() {
		return this.h+this.g;
	}
	
	@Override
	public boolean equals(Object obj) {
		Node node2 = (Node) obj;
		return this.rowIndex == node2.getRowIndex() && this.colIndex == node2.getColIndex();
	}
	
	@Override
	public String toString() {
		return "Node (" + this.rowIndex + ";" + this.colIndex + ") h:" + this.h + " - g:" + this.g + " - f=" + this.getF();
	}
}

