package learning;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

//https://leetcode.com/problems/kth-largest-element-in-an-array/discuss/60294/Solution-explained
public class findKthLargest {
	
	public static void main(String[] args) {
		int[] nums = {3,2,1,5,6,4};
		System.out.println(findKthLargetst2(nums, 2));
	}
	// O(N logN) running time+O(1) memory
	public static int findKthLargest(int[] nums, int k) {
		Arrays.sort(nums);
		return nums[nums.length-k];
		
	}
	
	// O(N logK) running time+O(k) memory
	public static int findKthLargetst2(int[] nums, int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (int i: nums) {
			queue.offer(i);
			
			if (queue.size() > k)
				queue.poll();
		}
		return queue.peek();
	}

	//O(N) running time + O(1) memory
	
	
}
