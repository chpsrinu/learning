package learning;

import java.util.HashSet;
import java.util.Set;

public class WordBreakDP {

	private static Set<String> dictionary = new HashSet<>();
	public static boolean wordBreakDP(String str) {
		int size = str.length();
		
		if( size ==0 ) return true;
		
		for (int i =1;i<=size;i++) {
			if (dictionary.contains(str.substring(0, i)) && wordBreakDP(str.substring(i, size)))
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		String temp_dictionary[] = {"mobile","samsung","sam","sung",  
                "man","mango","icecream","and",  
                "go","i","like","ice","cream"};
//		for (String word: temp_dictionary) {
//			dictionary.add(word);
//		}
//		System.out.println(wordBreakDP("ilikeicecream"));
		
		String temp_dictionary2[] = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
		for (String word: temp_dictionary2) {
			dictionary.add(word);
		}
		
		System.out.println(wordBreakDP("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"));
		
	}
}
