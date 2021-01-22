package MazeProblem;

public class MazeSolver {
	
	private int[][] mazeMap;
	private boolean[][] visited;
	private int startPositionCol;
	private int startPositionRow;
	
	public MazeSolver(int[][] mazeMap, int startPositionRow, int startPositionCol) {
		this.mazeMap = mazeMap;
		this.startPositionCol = startPositionCol;
		this.startPositionRow = startPositionRow;
		this.visited = new boolean[mazeMap.length][mazeMap.length];
	}
	
	public void findWayOut() {
		try {
			dfs(startPositionRow, startPositionCol);
			System.out.println("No solution found");
		} catch(RuntimeException e) {
			System.out.println("Route found to exit!!!");
		}
	}

	private void dfs(int rowIndex, int colIndex) {
		System.out.println("Visiting i= "+rowIndex+ ", j= "+colIndex);
		if(mazeMap[rowIndex][colIndex] == 3)
			throw new RuntimeException();
		
		int endOfMap = this.mazeMap.length-1;
		if(visited[rowIndex][colIndex]) {
			return;
		} else if(rowIndex<0 || rowIndex>=endOfMap) {
			return;
		} else if(colIndex<0 || colIndex>=endOfMap) {
			return;
		} else if(mazeMap[rowIndex][colIndex] == 1) {
			return;
		} else {
			this.visited[rowIndex][colIndex] = true;
			
			dfs(rowIndex+1, colIndex); //going down
			dfs(rowIndex, colIndex+1); //going right
			dfs(rowIndex, colIndex-1);//going left
			dfs(rowIndex-1, colIndex); //going up
		}
		
	}

}
