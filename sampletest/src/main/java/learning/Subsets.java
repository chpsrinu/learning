package learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
	//Cascading
	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> output = new ArrayList();
		output.add(new ArrayList<Integer>());
		
		for (int num: nums) {
			List<List<Integer>> newSubsets = new ArrayList();
			for (List<Integer> curr: output) {
				newSubsets.add(new ArrayList<Integer>(curr){{add(num);}});
			}
			for (List<Integer> curr: newSubsets) {
				output.add(curr);
			}
		}
		return output;
	}
	
	//backtracking TC: O(N*2^N) SC: O(N*2^N)
	static List<List<Integer>> output = new ArrayList<>();
	static int n,k;
	
	public static void backtrack(int first, ArrayList<Integer> curr, int[] nums) {
		// if the combination is done
		//if (curr.size() == k)
			output.add(new ArrayList<>(curr));
		
		for(int i=first;i<n;++i) {
			// add i into the current combination
			curr.add(nums[i]);
			// use next integers to complete the combination
			backtrack(i+1, curr, nums);
			//backtrack
			curr.remove(curr.size()-1);
		}
	}
	public static List<List<Integer>> subsets2(int[] nums) {
		n = nums.length;
		//for (k=0;k<n+1;++k) {
			backtrack(0, new ArrayList<Integer>(), nums);
		//}
		return output;
	}
	
	//subsetII
	public static List<List<Integer>> subsetsWithDup(int[] nums) {
	    List<List<Integer>> list = new ArrayList<>();
	    Arrays.sort(nums);
	    backtrack(list, new ArrayList<>(), nums, 0);
	    return list;
	}

	private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int start){
	    list.add(new ArrayList<>(tempList));
	    for(int i = start; i < nums.length; i++){
	        if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
	        tempList.add(nums[i]);
	        backtrack(list, tempList, nums, i + 1);
	        tempList.remove(tempList.size() - 1);
	    }
	} 
	
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		int[] num2 = {1,2,2};
		System.out.println(subsets2(nums));
		System.out.println(subsetsWithDup(num2));
	}
}
