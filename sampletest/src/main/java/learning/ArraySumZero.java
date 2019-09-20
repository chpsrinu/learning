package learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class ArraySumZero {

	public static void main(String[] args) {
		int[] n = {-1, 0, 1, 2, -1, -4};
		System.out.println(threeSum(n));
	}
	
	public void findTriplets(int[] arr, int n) {
		boolean found = false;
		for (int i =0;i<arr.length-2;i++) {
			for (int j=i+1;j<arr.length-1;j++) {
				for (int k = j+1;k<arr.length;k++) {
					if(arr[i]+arr[j]+arr[k] == 0) {
						found = true;
					}
				}
			}
		}
		
		if (found)
			System.out.println("not found");
	}
	
	public static List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> listObj = new ArrayList<>();
		TreeSet<String> set = new TreeSet<String>();
		List<Integer> list = new ArrayList<>();
		for (int i=0;i<nums.length-1;i++) {
			int x = nums[i];
			int left = i+1;
			int right = nums.length-1;
			
			while(left < right) {
				
				if (x+nums[left]+nums[right] == 0) {
					String str = x+":"+nums[left]+":"+nums[right];
					if(!set.contains(str)) {
						list.add(x);
						list.add(nums[left]);
						list.add(nums[right]);
						listObj.add(list);
						set.add(str);
					}
					left ++;
					right--;
					list = new ArrayList<>();
				} else if (x+left+right <0){
					left++;
				} else {
					right--;
				}
					
			}
			
		}
		return listObj;
		
	}
}
