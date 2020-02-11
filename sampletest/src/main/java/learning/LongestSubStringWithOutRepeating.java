package learning;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubStringWithOutRepeating {
	public static void main(String[] args) {
		System.out.println(findLongestRepeatedSubString("banana"));
	}

	public static int LengthOfLongestSubString(String str) {
		//BruteForce
		int ans = 0;
		for(int i =0;i<str.length();i++) {
			for (int j = i + 1; j < str.length(); j++) {
				if (unique(str, i, j)) {
					ans = Math.max(ans, j - i);
				} else {
					break;
				}
			}
		}
		return ans;
	}

	private static boolean unique(String str, int i, int j) {
		char[] strChar = str.toCharArray();
		Set<Character> set = new HashSet<>();
		for (int k = i;k<j;k++) {
			if(set.contains(strChar[k])) {
				return false;
			}
			set.add(strChar[k]);
		}
		return true;
	}
	
	public static String findLongestRepeatedSubString(String str) {
	    int max = 0;
	    String result = "";
	    for (int start = 0; start + max < str.length() - 1; start++) {
	        for (int shift = 1; start + shift + max < str.length() - 1; shift++) {
	                int length = 0;

	                // While characters match count the length
	                while(str.charAt(start + length) == str.charAt(start + shift + length) // matching characters
	                        && start + shift + length < str.length() - 1){ // hasn't reached the end yet
	                    length++;
	                }

	                // If the length is larger - update the new max size
	                if (length > max ) {
	                    max = length;
	                    result = str.substring(start, start + length + 1);
	                }
	        }
	    }

	    return result;
	}
	
	private static String getUnique(String input) {
		   Map<Character, Integer>  visited = new HashMap<>();
		    String result ="";
		    for(int start = 0,end = 0; end<input.length(); end++){
		     char currChar = input.charAt(end);
		      if (visited.containsKey(currChar)) {
		       start = Math.max(visited.get(currChar)+1, start); 
		      }
		      if (result.length() < end - start+1) {
		       result = input.substring(start, end+1); 
		      }
		      visited.put(currChar, end);
		    }
		    return result;
		  }
	
}
