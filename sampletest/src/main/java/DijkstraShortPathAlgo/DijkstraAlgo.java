package DijkstraShortPathAlgo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgo {

	public void computePaths(Vertex sourceVertex) {
		
		sourceVertex.setDistance(0);
		PriorityQueue<Vertex> queue = new PriorityQueue<>();
		queue.add(sourceVertex);
		
		while(!queue.isEmpty()) {
			Vertex actualVertex = queue.poll();
			for(Edge edge: actualVertex.getAdjacenciesList()) {
				
				Vertex v = edge.getTargetVertex();
				double newDistance = actualVertex.getDistance()+edge.getWeight();
				
				if(newDistance < v.getDistance()) {	
					queue.remove(actualVertex);
					v.setDistance(newDistance);
					v.setPredecessor(actualVertex);
					queue.add(v);
				}
			}
		}
	}
	
	public List<Vertex> getShortestPathTo(Vertex targetVertex) {
		
		List<Vertex> shortestPathToTarget = new ArrayList<Vertex>();
		
		for(Vertex vertex = targetVertex; vertex!=null;vertex = vertex.getPredecessor()) {
			shortestPathToTarget.add(vertex);
		}
		Collections.reverse(shortestPathToTarget);
		return shortestPathToTarget;
	}
}
