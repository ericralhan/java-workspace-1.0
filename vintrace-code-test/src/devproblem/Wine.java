package devproblem;

import java.util.HashSet;
import java.util.Set;

public class Wine {

	private Set<GrapeComponent> components = new HashSet<GrapeComponent>();
	private String name;
	private double volume;
	
	public Wine(String name, double volume) {
		this.name = name;
		this.volume = volume;
	}
	
	public Set<GrapeComponent> getComponents() {
		return components;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}
	
}
