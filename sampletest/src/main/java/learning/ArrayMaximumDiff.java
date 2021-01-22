package learning;

import javax.management.RuntimeErrorException;

public class ArrayMaximumDiff {

	public static void main(String[] args) {
		int arr[] = {110, 2, 90, 10, 1};
		System.out.println(maxDiff2(arr));
	}
	
	//O(n^2)
	private static int maxDiff(int[] arr) {
		int max_diff = Integer.MAX_VALUE;
		for (int i =0;i<arr.length;i++) {
			for (int j = i+1;j<arr.length;j++) {
				if (arr[i]-arr[j] < max_diff) {
					max_diff = arr[j]-arr[i];
				}
			}
		}
		return max_diff;
	}
	//O(n)
	private static int maxDiff2(int[] arr) {
		if(arr!= null && arr.length == 1) throw new RuntimeErrorException(null, "arr size is small");
		int minVal = Integer.MAX_VALUE;
		int maxVal = Integer.MIN_VALUE;
		for (int i =0;i<arr.length;i++) {
			if (arr[i] < minVal) minVal = arr[i];
			if (arr[i] > maxVal) maxVal = arr[i]; 
		}
		return maxVal-minVal;
	}
}
