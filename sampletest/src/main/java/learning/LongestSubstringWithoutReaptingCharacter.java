package learning;

import java.util.HashSet;
import java.util.Set;
//https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubstringWithoutReaptingCharacter {

	public static int longestSubStringWithoutReapting(String s) {
		int n = s.length();
		Set<Character> set = new HashSet<>();
		int ans=0,i=0,j=0;
		while(i<n&&j<n) {
			if(!set.contains(s.charAt(j))) {
				set.add(s.charAt(j++));
				ans = Math.max(ans, j-i);
			} else {
				set.remove(s.charAt(i++));
			}
		}
		return ans;
		
	}
	public static void main(String[] args) {
		System.out.println(longestSubStringWithoutReapting("bbbbb"));
	}
}
