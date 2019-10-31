package learning;

import java.util.HashMap;
import java.util.Map;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
//https://www.lavivienpost.com/autocomplete-with-trie-code/
class TrieNode {
    char data;     
    LinkedList children; 
    TrieNode parent;
    boolean isEnd;
 
    public TrieNode(char c) {
    	data = c;
        children = new LinkedList();
        isEnd = false;        
    }  
    
    public TrieNode getChild(char c) {
        if (children != null)
            for (TrieNode eachChild : children)
                if (eachChild.data == c)
                    return eachChild;
        return null;
    }
    
    protected List getWords() {
       List list = new ArrayList();      
       if (isEnd) {
    	   list.add(toString());
       }
       
       if (children != null) {
	       for (int i=0; i< children.size(); i++) {
	          if (children.get(i) != null) {
	             list.addAll(children.get(i).getWords());
	          }
	       }
       }       
       return list; 
    }
    
	public String toString() {
		if (parent == null) {
		     return "";
		} else {
		     return parent.toString() + new String(new char[] {data});
		}
	}
}
 
class Trie {
    private TrieNode root;
 
    public Trie() {
        root = new TrieNode(' '); 
    }
 
    public void insert(String word) {
        if (search(word) == true) 
            return;    
        
        TrieNode current = root; 
        TrieNode pre ;
        for (char ch : word.toCharArray()) {
        	pre = current;
            TrieNode child = current.getChild(ch);
            if (child != null) {
                current = child;
                child.parent = pre;
            } else {
                 current.children.add(new TrieNode(ch));
                 current = current.getChild(ch);
                 current.parent = pre;
            }
        }
        current.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode current = root;      
        for (char ch : word.toCharArray()) {
            if (current.getChild(ch) == null)
                return false;
            else {
                current = current.getChild(ch);    
            }
        }      
        if (current.isEnd == true) {       
            return true;
        }
        return false;
    }
    
    public List autocomplete(String prefix) {     
       TrieNode lastNode = root;
       for (int i = 0; i< prefix.length(); i++) {
	       lastNode = lastNode.getChild(prefix.charAt(i));	     
	       if (lastNode == null) 
	    	   return new ArrayList();      
       }
       
       return lastNode.getWords();
    }
}    

public class AutocompleteWithTrie {
	 public static void main(String[] args) {            
            Trie t = new Trie();            
            t.insert("amazon"); 
            t.insert("amazon prime"); 
			t.insert("amazing"); 			 
            t.insert("amazing spider man"); 
            t.insert("amazed");
            t.insert("alibaba");
            t.insert("ali express");
            t.insert("ebay");
            t.insert("walmart");          
			List a= t.autocomplete("amaz");
			for (int i = 0; i < a.size(); i++) {
				System.out.println(a.get(i));
			}
	  }
}


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



class TrieNode{
    TrieNode[] arr;
    boolean isLeaf;
 
    public TrieNode(){
        arr = new TrieNode[26];
    }    
}
 
public class WordDictionary {
    TrieNode root;
 
    public WordDictionary(){
        root = new TrieNode();
    }
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode p= root;
        for(int i=0; i<word.length(); i++){
            char c=word.charAt(i);
            int index = c-'a';
            if(p.arr[index]==null){
                TrieNode temp = new TrieNode();
                p.arr[index]=temp;
                p=temp;
            }else{
                p=p.arr[index];
            }
        }
 
        p.isLeaf=true;
    }
 
    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return dfsSearch(root, word, 0);     
    }
 
   public boolean dfsSearch(TrieNode p, String word, int start) {
		if (p.isLeaf && start == word.length())
			return true;
 
		if (start >= word.length())
			return false;
 
		char c = word.charAt(start);
 
		if (c == '.') {
			boolean tResult = false;
			for (int j = 0; j < 26; j++) {
				if (p.arr[j] != null) {
					if (dfsSearch(p.arr[j], word, start + 1)) {
						tResult = true;
						break;
					}
				}
			}
 
			if (tResult)
				return true;
		} else {
			int index = c - 'a';
 
			if (p.arr[index] != null) {
				return dfsSearch(p.arr[index], word, start + 1);
			} else {
				return false;
			}
		}
 
		return false;
	}
}

