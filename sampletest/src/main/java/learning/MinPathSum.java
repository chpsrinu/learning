package learning;

public class MinPathSum {

	public static void main(String[] args) {
		int[][] grid = {
				{1,3,1},
				{1,5,1},
				{4,2,1}
		};
		System.out.println(minPathSum(grid));
	}
	//recursive
	public static int minPathSum(int[][] grid) {
		int height = grid.length;
		int width = grid[0].length;
		return min(grid, height-1, width-1);
	}
	
	public static int min(int[][] grid, int row, int col) {
		System.out.println("row : "+ row + "col : "+col);
		if(row == 0 && col == 0) return grid[row][col];
		if(row == 0) return grid[row][col] + min(grid, row, col-1);
		if(col == 0) return grid[row][col] + min(grid, row-1, col);
		return grid[row][col] + Math.min(min(grid,row-1,col), min(grid, row, col-1));
	}
	
	//DP
	public static int minPathSum2(int[][] grid) {
		int height = grid.length;
		int width = grid[0].length;
		for(int row=0;row<height;row++) {
			for(int col=0;col<width;col++) {
				if(row == 0 && col == 0) grid[row][col] = grid[row][col];
				else if(row==0 && col != 0) grid[row][col] = grid[row][col] +grid[row][col-1];
				else if(col==0 && row != 0) grid[row][col] = grid[row][col]+grid[row-1][col];
				else grid[row][col] = grid[row][col] + Math.min(grid[row-1][col], grid[row][col-1]);
			}
		}
		return grid[height-1][width-1];
	}
}
