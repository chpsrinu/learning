package learning;

public class RecursiveSample {

	public static void main(String[] args) {
		System.out.println("sum : " + factorial(3));
	}
	
	public static int sum(int n) {
		if (n == 0) return 0;
		
		return n + sum(n-1);
	}
	
	public static boolean Sym(int left, int right, int[] arr) {
		if(left >= right) return true;
		if(arr[left] != arr[right]) return false;
		return Sym(left+1, right-1, arr);
	}
	
	public static int factorial(int n) {
		if(n == 1) return n;
		return n * factorial(n-1);
	}
}
