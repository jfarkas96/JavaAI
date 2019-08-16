package travelingSalesmanProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SingleTour {

	private List<City> tour = new ArrayList<City>();
	private double distance = 0;
	
	public SingleTour() {
		for (int i=0; i<Repository.getNumberOfCities();i++) {
			tour.add(null);
		}
	}
	
	public SingleTour(List<City> tour) {
		
		List<City> currentTour = new ArrayList<City>();
		
		for (int i=0; i<tour.size(); i++) {
			currentTour.add(null);
		}
		
		for (int i=0; i<tour.size(); i++) {
			currentTour.set(i, tour.get(i));
		}
		
		this.tour = currentTour;
	}
	
	public double getDistance() {
		
		if (distance == 0) {
			
			int tourDistance = 0;
			
			for (int cityIndex=0; cityIndex<getTourSize(); cityIndex++) {
				City fromCity = getCity(cityIndex);
				City destCity;
				
				if (cityIndex+1 < getTourSize())
					destCity = getCity(cityIndex+1);
				else
					destCity = getCity(0);
				
				tourDistance += fromCity.distanceTo(destCity);
			}
			
			this.distance = tourDistance;
		}
		
		return this.distance;
	}
	
	public List<City> getTour() {
		return this.tour;
	}
	
	
	public void generateIndividual() {
		for (int cityIndex=0; cityIndex<Repository.getNumberOfCities(); cityIndex++) {
			setCity(cityIndex, Repository.getCity(cityIndex));
		}
		
		Collections.shuffle(tour);
	}
	
	public void setCity(int cityIndex, City c) {
		this.tour.set(cityIndex, c);
		this.distance=0;
	}
	
	public City getCity(int tourPosition) {
		return tour.get(tourPosition);
	}
	
	public int getTourSize() {
		return this.tour.size();
	}
	
	@Override
	public String toString() {
		String s = "";
		
		for (int i=0; i<getTourSize(); i++) {
			s += getCity(i) + " -> ";
		}
		
		return s;
	}
}
