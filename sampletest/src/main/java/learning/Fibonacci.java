package learning;

public class Fibonacci {

	public static void main(String[] args) {
		System.out.println("recursive : " + recursive(3));
		System.out.println("memo : " + memo(5, new int[5]));
		
	}
	
	//1,1,2,3,5
	public static int recursive(int n) {
		int result = 0;
		if(n ==1 || n == 2) 
			result = 1;
		else {
			result = recursive(n-1) + recursive(n-2);
		}
		return result;
		
	}
	
	public static int memo(int n, int[] memo) {
		int result;
		if (memo[n] != 0)
			return memo[n];
		if (n==1 || n==2) 
			result = 1;
		else {
			result = memo(n-1, memo) + memo(n-2, memo);
			memo[n] = result;
			
		}
		return result;
	}
	
	public static int bottom_up(int n) {
		if(n==1 || n==2)
			return 1;
		int[] bottom_up = new int[n-1];
		bottom_up[1] = 1;
		bottom_up[2] = 1;
		for (int i=3;i<n;i++) {
			bottom_up[i] = bottom_up(i-1) + bottom_up(i-2);
		}
		return bottom_up(n);
	}
}
