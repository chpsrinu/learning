package learning;

import java.util.Arrays;

public class SortedRightRotation {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int[] arr1 = rightRotation(arr, 3);
		Arrays.stream(arr1).forEach(System.out::println);
	}
	public static int[] rightRotation(int[] arr, int k) {
		while (k!=0) {
			rightRotation(arr);
			k--;
		}
		return arr;
	}

	private static void rightRotation(int[] arr) {
		int temValue = arr[arr.length-1];
		for (int i=arr.length-1;i>0;i--) {
			arr[i] = arr[i-1];
		}
		arr[0] = temValue;
	}
}
