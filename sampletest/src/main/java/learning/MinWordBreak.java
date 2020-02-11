package learning;

public class MinWordBreak {

	TrieNode root = new TrieNode();
	int minWordBreak = Integer.MAX_VALUE;
	
	class TrieNode {
		boolean endOfTree;
		TrieNode children[] = new TrieNode[26];
		public TrieNode() {
			endOfTree = false;
			for (int i =0;i<26;i++) {
				children[i]=null;
			}
		}
	}
	
	public void insert(String key) {
		int length = key.length();
		int index;
		TrieNode pcrawl = root;
		
		for (int i =0;i<length;i++) {
			index = key.charAt(i)-'a';
			if (pcrawl.children[index] == null) {
				pcrawl.children[index] = new TrieNode();
			}
			pcrawl = pcrawl.children[index];
		}
		pcrawl.endOfTree = true;
	}
	
	public void minWordBreak(String key) {
		minWordBreak = Integer.MAX_VALUE;
		minWordBreakUtil(root, key, 0, Integer.MAX_VALUE, 0);
	}
	
	private void minWordBreakUtil(TrieNode node, String key, int start, int min_break, int level) {
		TrieNode pCrawl = node;
		//base case, update min break
		if (start == key.length()) {
			min_break = Math.min(min_break, level-1);
			if (min_break < minWordBreak) {
				minWordBreak = min_break;
			}
			return;
		}
		
		
		//traverse given key
		for (int i=start;i<key.length();i++) {
			int index = key.charAt(i)-'a';
			if (pCrawl.children[index] == null)
				return;
			//if we find condition were we can move to the next word in a trie dictonary
			if (pCrawl.children[index].endOfTree) {
				minWordBreakUtil(root, key, i+1, min_break, level+1);
			}
			pCrawl = pCrawl.children[index];
		}
	}
	
	public static void main(String[] args) {
		String keys[] = {"cat", "mat", "ca", "ma","at", "c", "dog", "og", "do" };
		MinWordBreak trie = new MinWordBreak();
		
		int i;
		for (i=0;i<keys.length;i++)
			trie.insert(keys[i]);
		trie.minWordBreak("catmatma");
		System.out.println(trie.minWordBreak);
	}
}
