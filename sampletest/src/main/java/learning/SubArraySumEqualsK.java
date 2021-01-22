package learning;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {
	
	public static void main(String[] args) {
		int[] nums = {1,0,1,2,-1};
		System.out.println(subarraySum3(nums, 2));
	}

		//Time complexity : O(n^3)O(n3). Considering every possible subarray takes O(n^2)O(n2) time. For each of the subarray we calculate the sum taking O(n)O(n) time in the worst case, taking a total of O(n^3)O(n3) time.
	//Space complexity : O(1)O(1). Constant space is used.
	public static int subarraySum(int[] nums, int k) {
		int count = 0;
        for(int start=0;start<nums.length;start++) {
            for(int end=start+1;end<=nums.length;end++) {
                int sum =0;
                for(int i = start;i<end;i++) {
                    sum += nums[i];
                }
                if(sum == k){
                    count++;
                }
            }
        }
        return count;
	}
	
	//Cumulative sum O(n2) space O(n)
	public static int subarraySum2(int[] nums, int k) {
		int count =0;
		int[] sum = new int[nums.length];
		sum[0] = 0;
		for(int i=1;i<nums.length;i++) {
			sum[i] = sum[i-1]+nums[i-1]; 
		}
		for (int start =0;start<nums.length;start++) {
			for(int end=start+1;end<=nums.length;end++) {
				if(sum[end] - sum[start] == k) {
					count++;
				}
			}
		}
		return count;
	}
	
	//HashMap O(n) space O(n)
	public static int subarraySum3(int[] nums, int k) {
		int count =0,sum=0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, 1);
		for(int i =0;i<nums.length;i++) {
			sum += nums[i];
			if(map.containsKey(sum-k)) {
				count += map.get(sum-k);
			}
			map.put(sum, map.getOrDefault(sum, 0)+1);
		}
		return count;
	}
	
	
}
