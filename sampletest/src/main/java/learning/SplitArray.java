package learning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Counter extends HashMap<Integer, Integer> {
	public int get(int k) {
		return containsKey(k) ? super.get(k) : 0;
	}
	
	public void add(int k, int v) {
		put(k, get(k)+v);
	}
}
//https://leetcode.com/problems/split-array-into-consecutive-subsequences/
public class SplitArray {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,4,5};
		System.out.println(splitArray2(nums));
	}
	
	private static boolean splitArray2(int[] nums) {
		Integer prev = null;
		int prevCount = 0;
		Queue<Integer> starts = new LinkedList<Integer>();
		int anchor = 0;
		for (int i=0;i<nums.length;++i) {
			int t = nums[i];
			if(i == nums.length-1 || nums[i+1] != t) {
				int count = i-anchor+1;
				if(prev != null && t-prev !=1) {
					while(prevCount-->0)
						if(prev<starts.poll()+2) return false;
					prev = null;
				}
				if(prev == null || t-prev == 1) {
					while(prevCount > count) {
						prevCount--;
						if(t-1<starts.poll()+2)
							return false;
					}
					while(prevCount++ < count)
						starts.add(t);
				}
				prev = t;
				prevCount = count;
				anchor = i+1;
			}
		}
		while(prevCount-->0) {
			if(nums[nums.length-1] < starts.poll() +2) 
				return false;
			
		}
		return true;
	}
	
	private static boolean splitArray(int[] nums) {
		Counter count = new Counter();
		Counter tails = new Counter();
		
		for (int x : nums) count.add(x, 1);
		
		for(int x: nums) {
			if(count.get(x) == 0) {
				continue;
			} else if(tails.get(x) > 0) {
				tails.add(x, -1);
				tails.add(x+1, 1);
			} else if(count.get(x+1) > 0 && count.get(x+2) >0) {
				count.add(x+1, -1);
				count.add(x+2, -1);
				tails.add(x+3, 1);
			} else {
				return false;
			}
			count.add(x, -1);
		}
		return true;
	}
	
	
	
//	private static boolean splitArray(int[] nums) {
//		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//		for(int num : nums) {
//			map.put(num, map.getOrDefault(num, 0)+1);
//		}
//		
//		int prevValue = 0;
//		List<Integer> list = new ArrayList<>();
//		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
//			if(entry.getValue() >0 && prevValue <= entry.getValue()) {
//				list.add(entry.getKey());
//				prevValue = entry.getValue();
//				map.put(entry.getKey(), entry.getValue()-1);
//			} else {
//				if (list.size() >= 3) {
//					prevValue = 0;
//					list.clear();
//				} else {
//					return false;
//				}
//				
//			}
//		}
//		return true;
//	}
}
