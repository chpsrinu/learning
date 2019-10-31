package learning;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithOutRepeating {
	public static void main(String[] args) {
		System.out.println(LengthOfLongestSubString("abcabcbb"));
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
}
