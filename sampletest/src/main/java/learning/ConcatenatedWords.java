package learning;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ConcatenatedWords {

	static class Node {
		Node[] children;
		boolean isWordEnd;
		
		public Node() {
			children = new Node[26];
			isWordEnd = false;
		}
	}
	
	private static Node root;
	
	public static List<String> findAllConcaternatedWordsInDict(String[] words) {
		if (words == null || words.length == 0)
			return new ArrayList<>();
		
		root = new Node();
		buildTrie(words);
		
		List<String> result = new LinkedList<String>();
		for (String word: words) {
			if(isConcatenated(word, 0, 0)) {
				result.add(word);
			}
		}
		return result;
	}
	
	private static boolean isConcatenated(String word, int index, int countConcatenatedWords) {
		if(index == word.length())
			return countConcatenatedWords >= 2;
			
		Node ptr = root;
		for(int i=index;i<word.length();i++) {
			if(ptr.children[word.charAt(i)-'a'] == null)
				return false;
			ptr = ptr.children[word.charAt(i)-'a'];
			
			if(ptr.isWordEnd)
				if(isConcatenated(word, i+1, countConcatenatedWords+1))
					return true;
		}
		
		return false;
	}

	private static void buildTrie(String[] words) {
		Node ptr;
		for(String word : words) {
			ptr = root;
			for(char c: word.toCharArray()) {
				int order = c-'a';
				if(ptr.children[order] == null) {
					ptr.children[order] = new Node();
				}
				ptr = ptr.children[order];
			}
			ptr.isWordEnd = true;
		}
	}
	
	public static void main(String[] args) {
		String[] input = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
		findAllConcaternatedWordsInDict(input).forEach(list->System.out.println(list));
	}
}
