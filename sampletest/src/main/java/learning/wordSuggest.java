package learning;

import java.util.*;
import java.util.stream.Collectors;

public class wordSuggest {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		wordSuggest sug = new wordSuggest();
		List<String> list = new ArrayList<>();
		list.add("cloth");
		list.add("banner");
		list.add("bagge");
		list.add("baaaaa");
		List<List<String>> res = sug.maxThreeSuggestion(2, list, "ba");
		for(List<String> res1 : res) {
			for(String res2 : res1) {
				System.out.println(res2);
			}
			System.out.println("next suggestion list :");
		}
	}
	class TrieNode {
		char c;
		HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
		TreeSet<String> suggestionSet = new TreeSet<>();
		boolean isLeaf;

		public TrieNode() {
		}

		public TrieNode(char c) {
			this.c = c;
		}
	}

	HashMap<Character, TrieNode> charMap = new HashMap<>();
	private TrieNode root = new TrieNode();

	public List<List<String>> maxThreeSuggestion(int numProducts, List<String> suggestions, String input) {
		for (String suggest : suggestions) {
			insert(suggest);
		}

		List<List<String>> out = new ArrayList<>();
		for (int i = 1; i <= input.length(); i++) {
			TrieNode t = searchNode(input.substring(0, i));
			if (t != null) {
				out.add(t.suggestionSet.stream().limit(numProducts).collect(Collectors.toList()));
			}
		}
		return out;
	}

	public void insert(String word) {
		HashMap<Character, TrieNode> children = root.children;

		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);

			TrieNode t;
			if (children.containsKey(c)) {
				t = children.get(c);
			} else {
				t = new TrieNode(c);
				children.put(c, t);
			}
			t.suggestionSet.add(word);
			children = t.children;

			// set leaf node
			if (i == word.length() - 1)
				t.isLeaf = true;
		}
	}

	public TrieNode searchNode(String str) {
		Map<Character, TrieNode> children = root.children;
		TrieNode t = null;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (children.containsKey(c)) {
				t = children.get(c);
				children = t.children;
			} else {
				return null;
			}
		}
		return t;
	}
}
