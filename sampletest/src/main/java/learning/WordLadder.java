package learning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javafx.util.Pair;
import sun.security.provider.certpath.AdjacencyList;
//https://leetcode.com/problems/word-ladder/solution/
public class WordLadder {
	
	public static void main(String[] args) {
		String beginWord = "hit";
		String endWord = "cog";
		List<String> list = new ArrayList<>();
		list.add("hot");
		list.add("dot");
		list.add("dog");
		list.add("lot");
		list.add("log");
		list.add("cog");
		System.out.println(ladderLength(beginWord, endWord, list));
	}
	
//	beginWord = "hit",
//	endWord = "cog",
//	wordList = ["hot","dot","dog","lot","log","cog"]
	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		
		//since all words of same length
		int L = beginWord.length();
		
		//Dictionary to hold combination of words that can be formed, from any given word. By changing one letter at a time.
		HashMap<String, ArrayList<String>> allComboDict = new HashMap<String, ArrayList<String>>();
		
		wordList.forEach(
				word -> {
					for (int i=0;i<L;i++) {
						// key is the generic word value is a list of words which have the same intermediate generic word.
						String newWord = word.substring(0,i)+"*"+word.substring(i+1, L);
						ArrayList<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<String>());
						transformations.add(word);
						allComboDict.put(newWord, transformations);
					}
				});
		
		//Queue for BFS
		Queue<Pair<String, Integer>> Q = new LinkedList<Pair<String, Integer>>();
		Q.add(new Pair(beginWord, 1));
		
		// Visisted to make sure we dont repeat processing same word.
		HashMap<String, Boolean> visited = new HashMap<>();
		visited.put(beginWord, true);
		
		while (!Q.isEmpty()) {
			Pair<String, Integer> node = Q.remove();
			String word = node.getKey();
			int level = node.getValue();
			for (int i=0;i<L;i++) {
				// Intermediate words for current word
				String newWord = word.substring(0,i)+"*"+word.substring(i+1,L);
				
				// Next states are all the words which share the same intermediate state.
				for(String adjacenWord: allComboDict.getOrDefault(newWord, new ArrayList<>())){
					// If at any point if we find what we are looking for i.e. the end word - we can return with the answer.
					if(adjacenWord.equals(endWord)) {
						return level+1;
					}
					//otherwise, add it to the BFS queue. Also mark it visited.
					if (!visited.containsKey(adjacenWord)) {
						visited.put(adjacenWord, true);
						Q.add(new Pair<String, Integer>(adjacenWord, level+1));
					}
				}
				
			}
		}
		return 0;
	}

}
