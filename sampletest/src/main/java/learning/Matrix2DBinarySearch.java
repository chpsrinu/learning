package learning;

public class Matrix2DBinarySearch {
//https://leetcode.com/problems/search-a-2d-matrix/
	public static boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length==0) return false;
		
		int start=0,rows=matrix.length,cols=matrix[0].length;
		int end=rows*cols-1;
		while(start<=end) {
			int mid = (start+end)/2;
			if(matrix[mid/cols][mid%cols] == target) return true;
			if (matrix[mid/cols][mid%cols] <target) {
				start = mid+1;
			} else {
				end = mid-1;
			}
		}
		return false;
	}
	
	//matrix II
	public static boolean searchMatrixII(int[][] matrix, int target) {
		if(matrix == null || matrix.length<0||matrix[0].length<0) return false;
		
		int col = matrix[0].length-1;
		int row = 0;
		while (col >=0 && row<= matrix.length-1) {
			if(target == matrix[row][col]) {
				return true;
			} else if(target<matrix[row][col]) {
				col--;
			} else if(target>matrix[row][col]) {
				row++;
			}
			
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
		System.out.println(searchMatrix(matrix, 3));
	}
}
