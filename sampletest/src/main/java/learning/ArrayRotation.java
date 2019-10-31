package learning;

import java.util.Arrays;

public class ArrayRotation {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		rotate(arr, 2);
		Arrays.stream(arr).forEach(System.out::println);
	}
	
	public static int[] rotate(int[] arr, int d) {
		while(d!=0) {
			rotate(arr);
			d--;
		}
		return arr;
	}

	private static void rotate(int[] arr) {
		int temp = arr[0];
		for (int i=1;i<arr.length;i++) {
			arr[i-1] = arr[i];
		}
		arr[arr.length-1] = temp;
	}
}
