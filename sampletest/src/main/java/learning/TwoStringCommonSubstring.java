package learning;

import java.util.Arrays;

public class TwoStringCommonSubstring {

	static int MAX_VALUE = 26;
	static boolean twoCommonSubString(String s1, String s2) {
		boolean[] v = new boolean[MAX_VALUE];
		Arrays.fill(v, false);
		
		for (char c: s1.toCharArray()) {
			v[c-'a'] = true;
		}
		
		for (char c2 : s2.toCharArray()) {
			if(v[c2-'a'] == true) return true; 
		}
		return false;
	}
	public static void main(String[] args) {
		System.out.println(twoCommonSubString("hello", "world"));
	}
}
