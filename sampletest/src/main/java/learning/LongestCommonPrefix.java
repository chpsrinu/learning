package learning;

import java.time.chrono.IsoChronology;

import Trie.Trie;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		String[]  strs = {"leet", "leetcode", "le", "lee"};
		
		//System.out.println("leet".indexOf("leetcode"));
		System.out.println(longestCommonPrefix3(strs));
	}
//	public static String longestCommonPrefix(String[] strs) {
//		String lcp = strs[0];
//		for (int i =1; i<strs.length; i++) {
//			String word = strs[i];
//			int minLenght = Math.min(lcp.length(), word.length());
//			for (int j = 0; j<minLenght; j++) {
//				if (lcp.charAt(j) != word.charAt(j))
//					lcp = lcp.substring(0, j);
////				if(lcp.charAt(j) == word.charAt(j)) 
////					continue;
////				else
////					lcp = lcp.substring(0, j);
//			}
//		}
//		return lcp;
//	}
	//Brute force
	public static String longestCommonPrefix(String[] strs) {
	    if (strs.length == 0) return "";
	    String prefix = strs[0];
	    for (int i = 1; i < strs.length; i++)
	        while (strs[i].indexOf(prefix) != 0) {
	            prefix = prefix.substring(0, prefix.length() - 1);
	            if (prefix.isEmpty()) return "";
	        }        
	    return prefix;
	}
	//vertical scanning
	public static String longestCommonPrefix2(String[] strs) {
		if (strs == null && strs.length == 0) return "";
		for (int i =0;i<strs[0].length();i++) {
			char c = strs[0].charAt(i);
			for (int j=1;j<strs.length;j++) {
				if (i == strs[j].length() || strs[j].charAt(i) != c) {
					return strs[0].substring(0, i);
				}
			}
		}
		return strs[0];
	}
	//Divide and concur
	public static String longestCommonPrefix3(String[] strs) {
		if (strs==null || strs.length == 0) return "";
		
		return longestCommonPrefix(strs, 0, strs.length-1);
	}
	
	private static String longestCommonPrefix(String[] strs, int left, int right) {
		if (left == right) {
			return strs[left];
		} 
		else {
			int middle = (left+right)/2;
			String lcpLeft = longestCommonPrefix(strs, left, middle);
			String lcpright = longestCommonPrefix(strs, middle+1, right);
			return commonPrefix(lcpLeft, lcpright);
		}
	}
	
	static String commonPrefix(String left, String right) {
		int min = Math.min(left.length(), right.length());
		for (int i=0;i<min;i++) {
			if (left.charAt(i) != right.charAt(i))
				return left.substring(0, i);
		}
		return left.substring(0, min);
	}
	
	//Binary search
	public static String longestCommonPrefix4(String[] strs) {
		if (strs == null || strs.length == 0) return "";
		
		int minLen = Integer.MAX_VALUE;
		for (String str : strs) {
			minLen = Math.max(minLen, str.length());
		}
		int low =1;
		int high = minLen;
		while(low<high) {
			int middle = (low+high)/2;
			if (isCommonPrefix(strs, middle))
				low = middle+1;
			else 
				high = middle-1;
		}
		return strs[0].substring(0, (low+high)/2);
	}
	private static boolean isCommonPrefix(String[] strs, int len) {
		String str1 = strs[0].substring(0,len);
		for (int i=1;i<strs.length;i++) {
			if (!strs[i].startsWith(str1))
				return false;
		}
		return true;
	}
	
	
}
