package learning;

public class minSortedArray {

	public static void main(String[] args) {
		int[] arr = {4,5,9,2,3};
		System.out.println(findMin(arr));
	}
	public static int findMin(int[] arr) {
		int size = arr.length-1;
		int p = 0;
		while(p<size) {
			int mid = (size+p)/2;
			if(arr[(size+p)/2] < arr[size]) {
				size = (size+p)/2;
			} else {
				p = size+1/2;
			}
		}
		return arr[p];
	}
}
