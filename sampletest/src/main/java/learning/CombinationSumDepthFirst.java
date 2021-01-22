package learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//https://leetcode.com/problems/subsets/discuss/27281/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)
public class CombinationSumDepthFirst {

	public static List<List<Integer>> combSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		if(candidates == null || candidates.length ==0) return result;
		
		Arrays.sort(candidates);
		
		List<Integer> combination = new ArrayList<>();
		toFindCombinationsToTarget(result, combination, candidates, target, 0);
		return result;
	}

	private static void toFindCombinationsToTarget(List<List<Integer>> result, List<Integer> combination, int[] candidates,
			int target, int startIndex) {
		if(target == 0) {
			result.add(new ArrayList<>(combination));
			return;
		}
		
		for (int i=startIndex; i<candidates.length;i++) {
			if(candidates[i] > target) break;
			
			combination.add(candidates[i]);
			toFindCombinationsToTarget(result, combination, candidates, target-candidates[i], i);// not i + 1 because we can reuse same elements
			combination.remove(combination.size()-1);
		}
	}
	//Combination Sum II
	public List<List<Integer>> combinationSum2(int[] nums, int target) {
	    List<List<Integer>> list = new ArrayList<>();
	    Arrays.sort(nums);
	    backtrack(list, new ArrayList<>(), nums, target, 0);
	    return list;
	    
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
	    if(remain < 0) return;
	    else if(remain == 0) list.add(new ArrayList<>(tempList));
	    else{
	        for(int i = start; i < nums.length; i++){
	            if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
	            tempList.add(nums[i]);
	            backtrack(list, tempList, nums, remain - nums[i], i + 1);
	            tempList.remove(tempList.size() - 1); 
	        }
	    }
	} 
	
	public static void main(String[] args) {
		int[] candidates = {2,3,6,7};
		
		System.out.println(combSum(candidates, 7));
	}
}
