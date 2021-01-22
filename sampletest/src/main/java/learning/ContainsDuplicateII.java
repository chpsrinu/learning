package learning;

import java.util.TreeSet;

//O(log k)
public class ContainsDuplicateII {
	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (nums == null || nums.length == 0 || k <= 0) return false;
		
		final TreeSet<Long> values = new TreeSet<>();
		for (int ind =0;ind<nums.length;ind++) {
			final Long floor = values.floor((long)nums[ind] +t);
			final Long ceil = values.ceiling((long)nums[ind] -t);
			if ((floor != null && floor >= nums[ind]) || (ceil != null && ceil <= nums[ind])) {
				return true;
			}
			
			values.add((long)nums[ind]);
			if (ind >= k) {
				values.remove(nums[ind-k]);
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] nums = {1,2,3,1};
		System.out.println(containsNearbyAlmostDuplicate(nums, 3, 0));
	}
}
