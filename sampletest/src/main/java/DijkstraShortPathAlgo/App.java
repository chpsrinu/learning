package DijkstraShortPathAlgo;

public class App {
	
	public static void main(String[] args) {
		
//		Vertex vertex0 = new Vertex("A");
//		Vertex vertex1 = new Vertex("B");
//		Vertex vertex2 = new Vertex("C");
//		
//		vertex0.addNeighbour(new Edge(1, vertex0, vertex1));
//		vertex0.addNeighbour(new Edge(3, vertex0, vertex2));
//		vertex1.addNeighbour(new Edge(1, vertex1, vertex2));
		
		Vertex vertex0 = new Vertex("A");
		Vertex vertex1 = new Vertex("B");
		Vertex vertex2 = new Vertex("C");
		Vertex vertex3 = new Vertex("D");
		Vertex vertex4 = new Vertex("E");
		Vertex vertex5 = new Vertex("F");
		Vertex vertex6 = new Vertex("G");
		
		vertex0.addNeighbour(new Edge(1, vertex0, vertex1));
		vertex0.addNeighbour(new Edge(2, vertex0, vertex2));
		vertex0.addNeighbour(new Edge(3, vertex0, vertex3));
		
		vertex1.addNeighbour(new Edge(2, vertex1, vertex4));
		
		vertex2.addNeighbour(new Edge(3, vertex2, vertex5));
		vertex2.addNeighbour(new Edge(4, vertex2, vertex6));
		
		vertex3.addNeighbour(new Edge(5, vertex3, vertex6));
		
		vertex4.addNeighbour(new Edge(6, vertex4, vertex5));
		
		vertex5.addNeighbour(new Edge(7, vertex5, vertex6));
		
		DijkstraAlgo algo = new DijkstraAlgo();
		algo.computePaths(vertex0);
		System.out.println(algo.getShortestPathTo(vertex6));
	}

}
