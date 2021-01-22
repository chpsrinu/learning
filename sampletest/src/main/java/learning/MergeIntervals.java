package learning;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
//https://leetcode.com/problems/merge-intervals/solution/
public class MergeIntervals {

	private static class IntervalComparator implements Comparator<int[]> {
		public int compare(int[] a, int[] b) {
			return a[0] <b[0] ? -1:a[0]==b[0]?0:1;
		}
	}
	
	public static int[][] merge(int[][] intervals) {
		Collections.sort(Arrays.asList(intervals), new IntervalComparator());
		
		LinkedList<int[]> merged = new LinkedList<>();
		for (int[] interval: intervals) {
			// if the list of merged intervals is empty or if the current
			// interval does not overlap with the previous, simply append it.
			if(merged.isEmpty() || merged.getLast()[1] < interval[0]) {
				merged.add(interval);
			}
			//otherwise, there is overlap, so we merge the current and previous intervals.
			else {
				merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
			}
		}
		return merged.toArray(new int[merged.size()][]);
	}
	
	public static void main(String[] args) {
		int[][] intervals = new int[][]{{1,9},{2,5},{19,20},{10,11},{12,20},{0,3},{0,1},{0,2}};
		int[][] result = merge(intervals);
		for(int[] re: result)
			System.out.println(re[0]+" "+re[1]);
	}
}
