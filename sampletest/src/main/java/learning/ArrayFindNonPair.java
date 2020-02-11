package learning;

public class ArrayFindNonPair {

	public static void main(String[] args) {
		int[] nums = new int[]{2,2,3,3,4,7,7,8,8,9,9};
		System.out.println(findNonPair(nums));
	}
	private static int findNonPair(int[] nums) {
		int start =0;
		int last = nums.length;
		while (start<last) {
			int mid = (start+last)/2;
			if (nums[mid-1] != nums[mid] && nums[mid+1] != nums[mid]) return nums[mid];
			if((last-mid+1)%2 != 0)
				start = mid+1;
			else
				last = mid-1;
		}
		return nums[start];
//		int result = 0;
//		for (int i=0;i<nums.length;i++) {
//			result = result ^ nums[i];
//		}
		//return result;
	}
}
