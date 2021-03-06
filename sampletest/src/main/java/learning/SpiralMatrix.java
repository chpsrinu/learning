package learning;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public static void main(String[] args) {
		//spiralMatrix(4);
		int[][] matrix = {
		                  {1,2,3},
		                  {4,5,6},
		                  {7,8,9}};
		System.out.println(spiralOrder(matrix));
	}

	public static void spiralMatrix(int x) {
		int[][] array = new int[x][x];

		for (int i = 0; i < x; i++) {
			for (int j = 0; j < x; j++)
				array[i][j] = 1;
		}
		System.out.println("complete");
	}
	
	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> ans = new ArrayList<Integer>();
		if(matrix.length == 0) return ans;
		int R = matrix.length;
		int C = matrix[0].length;
		boolean[][] seen = new boolean[R][C];
		int[] dr = {0,1,0,-1};
		int[] dc = {1,0,-1,0};
		int r = 0, c=0, di=0;
		for(int i=0;i<R*C;i++) {
			ans.add(matrix[r][c]);
			seen[r][c] = true;
			int cr = r + dr[di];
			int cc = c + dc[di];
			if (0 <= cr && cr < R && 0<= cc && cc < C && !seen[cr][cc]) {
				r= cr;
				c=cc;
			} else {
				di = (di+1)%4;
				r += dr[di];
				c += dc[di];
			}
		}
		return ans;	
	}
}










