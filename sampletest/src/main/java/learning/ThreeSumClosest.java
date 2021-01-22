package learning;

import java.util.Arrays;

public class ThreeSumClosest {

	public static int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int result = 0;
		int minDiff = Integer.MAX_VALUE;
		for(int i=0;i<nums.length;i++) {
			int low = i+1;
			int high = nums.length-1;
			int currentTarget = target-nums[i];
			while(low<high) {
				int sum = nums[low]+nums[high]+nums[i];
				int diff = Math.abs(target-sum);
				if(diff<minDiff) {
					minDiff = diff;
					result = sum;
				}
				if(nums[low] + nums[high] > currentTarget) high--;
				else low++;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] nums = {-1,2,1,-4};
		System.out.println(threeSumClosest(nums, 1));
	}
}
