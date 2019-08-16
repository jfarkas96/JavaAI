package tabuSearch;

import java.util.List;

public class TabuSearch {
	
	private State[][] states;
	private TabuList tabuList;
	private NeighborSolutionHandler nsh;
	
	public TabuSearch(State[][] states) {
		this.states = states;
		this.tabuList = new TabuList();
		this.nsh = new NeighborSolutionHandler();
	}
	
	public State solve(State initial){
		
		State bestState = initial;
		State currentState = initial;
		
		int iterationCounter = 0;
		
		while (iterationCounter<Constants.NUM_ITERATIONS) {
			
			List<State> possibleStates = currentState.getNeighbors();
			
			List<State> tabuStates = tabuList.getTabuItems();
			
			State bestNeighbor = nsh.getBestneighbor(states, possibleStates, tabuStates);
			
			if (bestNeighbor.getZ() < bestState.getZ()) {
				bestState = bestNeighbor;
			}
			
			tabuList.add(currentState);
			
			currentState = bestNeighbor;
			
			iterationCounter++;
		}
		
		return bestState;
	}
}
