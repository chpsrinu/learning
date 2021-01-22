package learning;

import java.util.ArrayList;
import java.util.List;

public class PermutationOfString {
//https://www.geeksforgeeks.org/distinct-permutations-string-set-2/
	static void findPermutations(char[] str, int index, int n) {
	if(index>=n) {
		System.out.println(str);
		return;
	}
	
	for(int i=index;i<n;i++) {
		boolean check = shouldSwap(str, index, i);
		if(check) {
			swap(str, index, i);
			findPermutations(str, index+1, n);
			swap(str, index, i);
		}
	}
		
	}
	
	static void swap(char[] str, int i, int j) {
		char c = str[i];
		str[i]=str[j];
		str[j]=c;
	}
	
	static boolean shouldSwap(char[] str, int start, int curr) {
		for(int i=start; i<curr;i++) {
			if (str[i] == str[curr]) {
				return false;
			}
		}
		return true;
	}
	
	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		//Arrays.sort(nums); //not necessary
		backtrack(list, new ArrayList<>(),nums);
		return list;
	}
	
	private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
		if(tempList.size() == nums.length) {
			list.add(new ArrayList<>(tempList));
		} else {
			for (int i=0;i<nums.length;i++) {
				if(tempList.contains(nums[i])) continue;//element already exits, skip
				tempList.add(nums[i]);
				backtrack(list, tempList, nums);
				tempList.remove(tempList.size()-1);
			}
		}
	}
	
	public List<List<Integer>> permuteUnique(int[] nums) {
	    List<List<Integer>> list = new ArrayList<>();
	    java.util.Arrays.sort(nums);
	    backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
	    return list;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, boolean [] used){
	    if(tempList.size() == nums.length){
	        list.add(new ArrayList<>(tempList));
	    } else{
	        for(int i = 0; i < nums.length; i++){
	            if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;
	            used[i] = true; 
	            tempList.add(nums[i]);
	            backtrack(list, tempList, nums, used);
	            used[i] = false; 
	            tempList.remove(tempList.size() - 1);
	        }
	    }
	}
	
	public static void main(String[] args) {
		char[] str = {'A','B','C','A'};
		//findPermutations(str, 0, str.length);
		System.out.println(permute(new int[]{1,2,3}));
	}
}
