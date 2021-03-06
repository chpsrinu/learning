package learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class TopKFrequencyKeywordsReview {

	public static void main(String[] args) {
		int k1 = 2;
		String[] keywords1 = { "anacell", "cetracular", "betacellular" };
		String[] reviews1 = { "Anacell provides the best services in the city", "betacellular has awesome services",
				"Best services provided by anacell, everyone should use anacell", };
		int k2 = 2;
		String[] keywords2 = { "anacell", "betacellular", "cetracular", "deltacellular", "eurocell" };
		String[] reviews2 = { "I love anacell Best services; Best services provided by anacell",
				"betacellular has great services", "deltacellular provides much better services than betacellular",
				"cetracular is worse than anacell", "Betacellular is better than deltacellular.", };
		System.out.println(solve(k1, keywords1, reviews1));
		System.out.println(solve(k2, keywords2, reviews2));
	}

	private static List<String> solve(int k, String[] keywords, String[] reviews) {
		List<String> res = new ArrayList<String>(); 
		Set<String> set = new HashSet<>(Arrays.asList(keywords));
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(String s: reviews) {
			String[] split = s.split("\\W");
			Set<String> added = new HashSet<>();
			for(String s1: split) {
				s1 = s1.toLowerCase();
				if(set.contains(s1) && !added.contains(s1)) {
					map.put(s1, map.getOrDefault(s1, 0)+1);
					added.add(s1);
				}
			}
		}
		Queue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<Map.Entry<String,Integer>>((a,b)->a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue()-a.getValue());
		maxHeap.addAll(map.entrySet());
		while(!maxHeap.isEmpty() && k-->0) {
			res.add(maxHeap.poll().getKey());
		}
		return res;
	}
}
