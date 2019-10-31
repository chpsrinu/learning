package learning;

public class FindRotationCountArray {

	public static void main(String[] args) {
		int[] arr = {4,7,9,1,2};
		System.out.println(findRotationCountArray(arr));
	}
	public static int findRotationCountArray(int[] arr) {
		int size = arr.length-1;
		int p = 0;
		while (p<size) {
			int midIndex = (size+p)/2;
			if(arr[midIndex] > arr[size]) {
				p = midIndex+1;
			} else {
				size = midIndex;
			}
		}
		return arr.length-p;
	}
}
