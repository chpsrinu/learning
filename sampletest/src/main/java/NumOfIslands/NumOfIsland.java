package NumOfIslands;

public class NumOfIsland {

	public int numOfIsland(int[][] grid) {
		int count = 0;
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				if(grid[i][j] == 1) {
					count++;
					markNeighbours(grid, i, j);
				}
			}
		}
		return count;
	}

	private void markNeighbours(int[][] grid, int i, int j) {
		//System.out.println("Index value i : " + i + " j : "+j);
		if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] == 0) return;
		grid[i][j]=0;
		markNeighbours(grid, i+1, j);
		markNeighbours(grid, i-1, j);
		markNeighbours(grid, i, j+1);
		markNeighbours(grid, i, j-1);
	}
	
	// max ones in grid
	public int numOfIsland2(int[][] grid) {
		int maxCount = Integer.MIN_VALUE;
		for(int i=0;i<grid.length;i++) {
			for (int j=0;j<grid[0].length;j++) {
				if(grid[i][j] == 1) {
					int count = markNeighbours2(grid, i, j, 0);
					if(maxCount<count) maxCount = count;
				}
			}
		}
		return maxCount;
	}
	
	private int markNeighbours2(int[][] grid, int i, int j, int count) {
		if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] == 0) return count;
		grid[i][j]=0;
		count++;
		markNeighbours2(grid, i+1, j, count);
		markNeighbours2(grid, i-1, j, count);
		markNeighbours2(grid, i, j+1, count);
		markNeighbours2(grid, i, j-1, count);
		return count;
	}
}
