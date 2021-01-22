package learning;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequency {

	public static List<String> topKFrequency(String[] words, int k) {
		Map<String, Integer> count = new HashMap<>();
		for(String word: words)
			count.put(word, count.getOrDefault(word,0)+1);
		List<String> candidates = new ArrayList<>(count.keySet());
		Collections.sort(candidates, (w1,w2)-> count.get(w1).equals(count.get(w2)) ? w1.compareTo(w2): count.get(w2)-count.get(w1));
		return candidates.subList(0, k);
	}
	
	public List<String> topKFrequency2(String[] words, int k) {
		Map<String, Integer> count = new HashMap();
		for(String word: words) 
			count.put(word, count.getOrDefault(word, 0)+1);
		PriorityQueue<String> heap = new PriorityQueue<>(
				(w1,w2) -> count.get(w1).equals(count.get(w2)) ?
						w2.compareTo(w1) : count.get(w1)-count.get(w2));
		
		for(String word: count.keySet()) {
			heap.offer(word);
			if(heap.size()>k) heap.poll();
		}
		
		List<String> ans = new ArrayList();
		while( !heap.isEmpty()) ans.add(heap.poll());
		Collections.reverse(ans);
		return ans;
	}
	
	public static void main(String[] args) {
		String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
		System.out.println(topKFrequency(words, 2));
	}
}
