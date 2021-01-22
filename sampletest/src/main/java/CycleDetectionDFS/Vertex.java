package CycleDetectionDFS;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

	private String name;
	private boolean visited;
	private boolean beginVisited;
	private List<Vertex> adjacenciesList;

	public Vertex(String name) {
		this.name = name;
		this.adjacenciesList = new ArrayList<Vertex>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public boolean isBeginVisited() {
		return beginVisited;
	}

	public void setBeginVisited(boolean beginVisited) {
		this.beginVisited = beginVisited;
	}

	public List<Vertex> getAdjacenciesList() {
		return adjacenciesList;
	}

	public void setAdjacenciesList(List<Vertex> adjacenciesList) {
		this.adjacenciesList = adjacenciesList;
	}

	public void addNeighbour(Vertex vertex) {
		this.adjacenciesList.add(vertex);
	}

	@Override
	public String toString() {
		return name;
	}

}
