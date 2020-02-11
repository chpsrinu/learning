package learning;

public class minSortedArray {

	public static void main(String[] args) {
		int[] arr = {4,5,9,1,2,3};
		System.out.println(findMin(arr, 0, arr.length-1));
	}
	public static int findMin(int[] arr, int low, int high) {
		// if array is not rotated
		if(high < low) return arr[0];
		//if only one element left
		if(high == low) return arr[low];
		//Find mid
		int mid = (low+high)/2;
		
		if(mid<high && arr[mid+1] < arr[mid])
			return arr[mid+1];
		
		if(mid>low && arr[mid] > arr[mid-1])
			return arr[mid];
		
		//Decide whether we need to go to left or right
		if(arr[high] > arr[mid])
			return findMin(arr, low, mid-1);
		return findMin(arr, mid+1, high);
	}
}
