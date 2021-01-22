package learning;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class FindRightInterval {

	public static int[] findRightInterval(int[][] intervals) {
		int[] result = new int[intervals.length];
		NavigableMap<Integer, Integer> intervalMap = new TreeMap<>();
		
		for(int i=0;i<intervals.length;i++) {
			intervalMap.put(intervals[i][0], i);
		}
		for(int i=0;i<intervals.length;i++) {
			Map.Entry<Integer, Integer> entry = intervalMap.ceilingEntry(intervals[i][1]);
			result[i] = (entry!=null)?entry.getValue():-1;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int[][] intervals = {{1,4}, {2,3}, {3,4}};
		System.out.println(findRightInterval(intervals)[0]);
	}
}
