package aStar;

import java.util.Comparator;

public class NodeComparator implements Comparator<Node> {
	
	@Override
	public int compare(Node arg0, Node arg1) {
		if(arg0.getF()<arg1.getF()) return -1;
		if(arg0.getF()>arg1.getF()) return 1;
		return 0;
	}
}
