package Trie;

import java.util.List;

public class App {

	public static void main(String[] args) {
		Trie trie = new Trie();
//		trie.insert("joe",1);
//		trie.insert("joea",2);
//		trie.insert("ada");
//		trie.insert("hello");
		
		trie.insert("ada", 1);
		trie.insert("addaa", 2);
		trie.insert("addddddd", 3);
//		trie.insert("swathi", 4);
//		trie.insert("pydi", 5);
		
		
//		List<String> allWords = trie.allWordsWithPrefix(""); 
//		allWords.forEach(word->System.out.println(word));
		//System.out.println(trie.searchAsMap("joea"));
		System.out.println(trie.longestCommonPrefix());
		
	}
	
	
}
