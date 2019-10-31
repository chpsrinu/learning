package learning;

public class MaxSumArrayRotation {

	public static void main(String[] args) {
		int[] arr = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		System.out.println(maxSumArrayRotation(arr));
	}
	public static int maxSumArrayRotation(int[] arr) {
		int maxValue = 0;
		int index =0;
		for (int i =0;i<arr.length;i++) {
			if (maxValue < arr[i] ) {
				maxValue = arr[i];
				index = i;
			}
		}
		
		rotate(arr, index+1);
		int maxSum = 0;
		for (int i=0;i<arr.length;i++) {
			maxSum += i*arr[i];
		}
		return maxSum;
	}

	private static void rotate(int[] arr, int index) {
		while (index != 0) {
			rotate(arr);
			index--;
		}
	}

	private static void rotate(int[] arr) {
		int tempValue = arr[0];
		for (int i=1;i<arr.length;i++) {
			arr[i-1] = arr[i];
		}
		arr[arr.length-1] = tempValue;
	}
}
