package learning;

public class FirstMissingPositiveNumber {

	public static int firstMissingPositive(int[] nums) {
		int n = nums.length;
		
		// 1. mark numbers (num < 0) and (num>n) with a special marker number (n+1)
		// (we can ignore those because if all number are > n then we'll simply return 1)
		for (int i=0;i<n;i++) {
			if (nums[i] <=0 || nums[i]>n) {
				nums[i] = n+1;
			}
		}
		//note: all number in the array are now positive, and on the range 1...n+1
		
		//2.mark each cell appearing in the array, by converting the index for that number to negative
		for (int i=0;i<n;i++) {
			int num = Math.abs(nums[i]);
			if (num > n){
				continue;
			}
			num--; //-1 for zero index based array
			if (nums[num] >0) { // prevents double negative operations
				nums[num] = -1*nums[num];
			}
		}
		
		// 3. find the first cell which isn't negative (doesn't appear in the array)
		for (int i=0;i<n;i++) {
			if (nums[i] >= 0) {
				return i+1;
			}
		}
		
		//4. no positive numbers were found, which means the array contains all numbers 1...n
		return n+1;
	}
	
	public static void main(String[] args) {
		int[] num1 = {1,2,0};
		int[] num2 = {3,4,-1,1};
		int[] num3 = {7,8,9,11,12};
		
		System.out.println(firstMissingPositive(num2));
	}
}
