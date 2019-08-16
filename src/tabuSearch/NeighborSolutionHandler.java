package tabuSearch;

import java.util.List;

public class NeighborSolutionHandler {
	
	public State getBestneighbor(State[][] states, List<State> neighborStates, List<State> tabuStates) {
		neighborStates.removeAll(tabuStates);
		
		if (neighborStates.size()==0) return states[100][100];

		State bestSolution = neighborStates.get(0);
		
		for (int i=1; i<neighborStates.size(); i++) {
			if (neighborStates.get(i).getZ() < bestSolution.getZ()){
				bestSolution = neighborStates.get(i);
			}
		}
		
		System.out.println("Best Solution is: " + bestSolution);
		
		return bestSolution;
	}
}
