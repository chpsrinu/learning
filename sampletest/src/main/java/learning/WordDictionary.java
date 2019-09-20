package learning;

import java.util.HashMap;
import java.util.Map;

//https://www.programcreek.com/2014/05/leetcode-add-and-search-word-data-structure-design-java/
public class WordDictionary {

	class TrieNode {
		char c;
		HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
		boolean isLeaf;
		
		public TrieNode() {}
		
		public TrieNode(char c) {
			this.c = c;
		}
	}
	
	private TrieNode root;
	
	public WordDictionary() {
		root = new TrieNode();
	}
	
	// Add a word into the data structure.
	public void addWord(String word) {
		Map<Character, TrieNode> children = root.children;
		
		for(int i=0;i<word.length();i++) {
			char c = word.charAt(i);
			
			TrieNode t = null;
			if(children.containsKey(c)) {
				t = children.get(c);
			} else {
				t = new TrieNode(c);
				children.put(c, t);
			}
			
			children = t.children;
			
			if ( i == word.length()-1) {
				t.isLeaf = true;
			}
		}
	}
}
