package learning;

import java.util.Arrays;

public class MoveZeroes {

	public static void main(String[] args) {
		int[] arr = {0,1,0,3,12};
		moveZeroes(arr);
		Arrays.stream(arr).forEach(ar->System.out.println(ar));
	}
	
	private static void moveZeroes(int[] arr) {
		int zeroCount = 0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i] == 0)
				zeroCount++;
			else {
				arr[i-zeroCount] = arr[i];
				arr[i]=0;
			}
		}
		
	}
}
