package learning;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DuplicateArray {

	public static void main(String[] args) {
		int[] nums = {3,2,4,5,3,4,1,2,1};
		solve2(nums);
	}
	public static void solve(int[] array) {
		
		//this is why it is an O(N) running time algorithm
		for (int i=0;i<array.length;i++) {
			//if the valueis positive we have to flip
			if(array[Math.abs(array[i])] >0) {
				array[Math.abs(array[i])] = -array[Math.abs(array[i])];
			} else {
				System.out.println(Math.abs(array[i])+ " is a repetation.");
			}
		}
	}
	public static void solve2(int[] array) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i =0;i<array.length;i++) {
			if(map.containsKey(array[i])) {
				map.put(array[i], map.get(array[i])+1);
			} else {
				map.put(array[i], 1);
			}
			
		}
		for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
			if (entry.getValue() >1) {
				System.out.println(entry.getKey() + " is a repetation.");
			}
		}
	}
}
