package learning;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class findKthLargest {
	
	public static void main(String[] args) {
		int[] nums = {3,2,1,5,6,4};
		System.out.println(findKthLargetst2(nums, 2));
	}
	public static int findKthLargest(int[] nums, int k) {
		Arrays.sort(nums);
		return nums[nums.length-k];
		
	}
	
	public static int findKthLargetst2(int[] nums, int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<>(k);
		for ( int i : nums) {
			queue.offer(i);
		
			if (queue.size() > k) {
				queue.poll();
			}
		}
		return queue.peek();
	}

}
