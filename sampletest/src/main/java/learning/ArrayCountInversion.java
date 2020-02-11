package learning;

public class ArrayCountInversion {

	public static void main(String[] args) {
		int[] arr = {1, 20, 6,4,5};
		System.out.println(getInvCount(arr));
	}
	
	private static int getInvCount(int[] arr) {
		int count = 0;
		for (int i=0;i<arr.length-1;i++) {
			for (int j=i;j<arr.length;j++) {
				if (arr[i] < arr[j]) {
					count++;
				}
			}
		}
		return count;
	}
}
