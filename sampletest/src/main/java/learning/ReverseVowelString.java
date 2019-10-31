package learning;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReverseVowelString {
	public static void main(String[] args) {
		System.out.println(reverseVowelString("leetcode"));
	}
	
	static boolean isVowel(char c) { 
		return (c == 'a' || c == 'A' || c == 'e'
				|| c == 'E' || c == 'i' || c == 'I'
				|| c == 'o' || c == 'O' || c == 'u'
				|| c == 'U'); 
	} 
	
	static String reverseVowel(String str) { 
		// Start two indexes from two corners 
		// and move toward each other 
		int i = 0; 
		int j = str.length()-1; 
		char[] str1 = str.toCharArray(); 
		while (i < j) 
		{ 
			if (!isVowel(str1[i])) 
			{ 
				i++; 
				continue; 
			} 
			if (!isVowel(str1[j])) 
			{ 
				j--; 
				continue; 
			} 

			// swapping 
			char t = str1[i]; 
			str1[i]= str1[j]; 
			str1[j]= t; 
			

			i++; 
			j--; 
		} 
		String str2 = String.copyValueOf(str1); 
		return str2; 
	} 

	public static String reverseVowelString(String str) {
		List<Character> vowelList = new ArrayList<Character>();
		vowelList.add('a');
		vowelList.add('e');
		vowelList.add('i');
		vowelList.add('o');
		vowelList.add('u');
		char[] strChar = str.toCharArray();
		int i=0,j=strChar.length-1;
		while (i<j) {
			if(!vowelList.contains(strChar[i])) {
				i++;
				continue;
			} 
			if(!vowelList.contains(strChar[j])) {
				j--;
				continue;
			}
			swap(strChar, i, j);
			i++;j--;
		}
		return new String(strChar);
	}

	private static void swap(char[] strChar, int i, int j) {
		char tempChar = strChar[i];
		strChar[i] = strChar[j];
		strChar[j] = tempChar;
	}
}
