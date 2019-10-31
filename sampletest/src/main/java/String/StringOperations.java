package String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringOperations {

	public String revertString(String text) {
		int lengthOfText = text.length();
		StringBuilder strbuld = new StringBuilder();
		for(int i=lengthOfText-1;i>=0;i--) {
			strbuld.append(text.charAt(i));
		}
		return strbuld.toString();
	}
	
	public List<String> getSuffixes(String text) {
		int lengthOfText = text.length();
		List<String> suffixList = new ArrayList<String>();
		
		for (int i =0;i<lengthOfText;i++) {
			suffixList.add(text.substring(i, lengthOfText));
		}
		return suffixList;
	}
	
	public String longestCommonPrefix(String text1, String text2) {
		int commonLength = Math.min(text1.length(), text2.length());
		
		for (int i=0;i<commonLength;i++) {
			if(text1.charAt(i) != text2.charAt(i)) {
				return text1.substring(0,i);
			}
		}
		return text1.substring(0, commonLength);
	}
	
	public String longestRepeatedSubstring(String text) {
		int lengthOfText = text.length();
		List<String> suffixes = getSuffixes(text);
		Collections.sort(suffixes);
		String longestSubstring = "";
		for (int i=0;i<text.length()-1;i++) {
			String tempString = longestCommonPrefix(suffixes.get(i), suffixes.get(i+1));
			
			if (tempString.length() > longestSubstring.length())
				longestSubstring = tempString;
		}
		return longestSubstring;
	}
}
