package learning;

public class MaxSubArray {

	public static void main(String[] args) {
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(nums));
	}
	
	private static int maxSubArray2(int[] nums) {
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for (int i=0;i<nums.length;i++) {
				sum += nums[i];
				max = Math.max(sum, max);
				sum = Math.max(sum, 0);
		}
		
		return max;
	}
	
	private static int maxSubArray(int[] nums) {
		return maxSum(0,nums.length,nums);
	}
	
	private static int maxSum(int left,int right, int[] nums) {
		if(left==right)
			return nums[left];
		int mid = (left+right)/2;
		int left_sum = maxSum(left, mid, nums);
		int right_sum = maxSum(mid+1,right, nums);
		int cross_sum = crossSum(left, mid, right, nums);
		return Math.max(Math.max(left_sum, right_sum), cross_sum);
	}
	
	private static int crossSum(int left, int mid, int right, int nums[]) {
		int left_sum = nums[mid];
		int curr_sum=nums[mid];
		for(int i=mid-1;i>=left;i--) {
			curr_sum += nums[i];
			if(curr_sum>left_sum)
				left_sum = curr_sum;
		}
		curr_sum = nums[mid+1];
		int right_sum = nums[mid+1];
		for(int i=mid+2;i<=right;i++) {
			curr_sum +=nums[i];
			if(curr_sum>right_sum)
				right_sum=curr_sum;
		}
		return left_sum+right_sum;
	}
}
