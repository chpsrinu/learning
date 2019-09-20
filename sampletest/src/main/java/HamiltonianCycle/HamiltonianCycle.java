package HamiltonianCycle;

public class HamiltonianCycle {

	private int numOfVertexes;
	private int[] hamiltonianPath;
	private int[][] adjacencyMatrix;

	public HamiltonianCycle(int[][] adjacencyMatrix) {
		this.adjacencyMatrix = adjacencyMatrix;
		this.hamiltonianPath = new int[adjacencyMatrix.length];
		this.numOfVertexes = adjacencyMatrix.length;

		this.hamiltonianPath[0] = 0;

	}

	public void solve() {
		if (findFeasibleSolution(1)) {
			showHamiltonianPath();
		} else {
			System.out.println("No feasible soultion...");
		}
	}

	private boolean findFeasibleSolution(int position) {

		if (position == numOfVertexes) {
			if (adjacencyMatrix[hamiltonianPath[position - 1]][hamiltonianPath[0]] == 1) {
				return true;
			} else {
				return false;
			}
		}

		for (int vertexIndex = 1; vertexIndex < numOfVertexes; vertexIndex++) {
			if (isFeasible(vertexIndex, position)) {
				hamiltonianPath[position] = vertexIndex;

				if (findFeasibleSolution(position + 1)) {
					return true;
				}

				// Backtracking

			}
		}

		return false;
	}

	private boolean isFeasible(int vertexIndex, int actualPosition) {

		// first criterion: whether two nodes are connected?
		if (adjacencyMatrix[hamiltonianPath[actualPosition - 1]][vertexIndex] == 0) {
			return false;
		}

		// second crierion: whether we have visited it or not
		for (int i = 0; i < actualPosition; i++) {
			if (hamiltonianPath[i] == vertexIndex) {
				return false;
			}
		}
		return true;
	}

	private void showHamiltonianPath() {
		System.out.print("Hamiltonian cycle:");
		for (int i = 0; i < hamiltonianPath.length; i++) {
			System.out.print(hamiltonianPath[i] + " ");
		}
		System.out.print(hamiltonianPath[0]);
	}

}
