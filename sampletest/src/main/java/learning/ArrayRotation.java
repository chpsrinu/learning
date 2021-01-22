package learning;

import java.util.Arrays;

public class ArrayRotation {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		rotateR(arr, 2);
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
	
	public static void rotateR(int[] nums, int k) {
        if(nums.length==0||nums.length==1) return ;
        for(int i=0;i<k;i++) {
            rotateRight(nums);
        }
    }
    private static void rotateRight(int[] nums) {
        int num = nums[nums.length-1];
        for(int j=nums.length-2;j>=0;j--) {
            nums[j+1]=nums[j];
        }
        nums[0]=num;
    }
}
