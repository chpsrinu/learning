package learning;

public class searchRange {

	public static int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1,-1};
        int i = 0; 
        int j = nums.length-1;
        while (i<j) {
            if (nums[i]<target) i++;
            if (nums[j]>target) j--;
            if (nums[i] == target && nums[j]==target) {
                targetRange[0]=i;
                targetRange[1]=j;
            } 
        }
        return targetRange;
    }
	
	public static int[] searchRange2(int[] nums, int target) {
		int[] targetRange = {-1,-1};
		int leftIndex = extremeInsertionIndex(nums, target, true);
		
		if(leftIndex == nums.length || nums[leftIndex] != target) {
			return targetRange;
		}
		targetRange[0]=leftIndex;
		targetRange[1]= extremeInsertionIndex(nums, target, false)-1;
		return targetRange;
	}
	
	private static int extremeInsertionIndex(int[] nums, int target, boolean left) {
		int lo = 0;
		int hi = nums.length;
		
		while(lo < hi) {
			int mid = (lo+hi)/2;
			if (nums[mid] > target || (left && target == nums[mid])) {
				hi = mid;
			} else {
				lo = mid+1;
			}
		}
		return lo;
	}

	public static void main(String[] args) {
		int[] nums = {5,7,7,8,8,10};
		System.out.println(searchRange2(nums, 8)[0]);
	}
}
