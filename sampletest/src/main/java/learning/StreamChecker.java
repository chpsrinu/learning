package learning;

public class StreamChecker {

	class TrieNode {
		boolean isWord;
		TrieNode[] next = new TrieNode[26];
	}
	
	TrieNode root = new TrieNode();
	StringBuilder sb = new StringBuilder();
	
	public StreamChecker(String[] words) {
		createTrie(words);
	}
	
	private void createTrie(String[] words) {
        for (String s : words) {
            TrieNode node = root;
            int len = s.length();
            for (int i = len - 1; i >= 0; i--) {
                char c = s.charAt(i);
                if (node.next[c - 'a'] == null) {
                    node.next[c - 'a'] = new TrieNode();
                }
                node = node.next[c - 'a'];
            }
            node.isWord = true;
        }
    }
	
	public boolean query(char letter) {
        sb.append(letter);
        TrieNode node = root;
        for (int i = sb.length() - 1; i >= 0 && node != null; i--) {
            char c = sb.charAt(i);
            node = node.next[c - 'a'];
            if (node != null && node.isWord) {
                return true;
            }
        }
        return false;
    }
	
	public static void main(String[] args) {
		String[] words = {"cd","f","kl"};
		StreamChecker streamChecker = new StreamChecker(words);
		System.out.println(streamChecker.query('a'));
		System.out.println(streamChecker.query('b'));
		System.out.println(streamChecker.query('c'));
		System.out.println(streamChecker.query('d'));
		System.out.println(streamChecker.query('e'));
		System.out.println(streamChecker.query('f'));
		System.out.println(streamChecker.query('g'));
		System.out.println(streamChecker.query('h'));
		System.out.println(streamChecker.query('i'));
		System.out.println(streamChecker.query('j'));
		System.out.println(streamChecker.query('k'));
		System.out.println(streamChecker.query('l'));
	}
}
