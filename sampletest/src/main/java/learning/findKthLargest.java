package learning;

import java.util.Arrays;
import java.util.Collections;

public class findKthLargest {
	
	public static void main(String[] args) {
		int[] nums = {3,2,1,5,6,4};
		System.out.println(findKthLargest(nums, 2));
	}
	public static int findKthLargest(int[] nums, int k) {
		Arrays.sort(nums);
		return nums[nums.length-k];
		
	}

}
