package CycleDetectionDFS;

import java.util.List;

public class CycleDetection {

	public void detectCycle(List<Vertex> vertexList) {
		for(Vertex v : vertexList) {
			if(!v.isVisited()) {
				dfs(v);
			}
		}
	}

	public void dfs(Vertex v) {
		System.out.println("DFS on vertex "+ v);
		v.setBeginVisited(true);
		
		for(Vertex v1: v.getAdjacenciesList()) {
			System.out.println("Visited neighbours of vertrex : "+v1);
			if(v1.isBeginVisited()) {
				System.out.println("there is backward edge, so there is cycle!!!");
				return; 
			}
			if(!v1.isVisited()) {
				System.out.println("visisted neghibour : "+ v1 + " recursively");
				v1.setVisited(true);
				dfs(v1);
			}
		}
		v.setBeginVisited(false);
		v.setVisited(true);
	}
}
