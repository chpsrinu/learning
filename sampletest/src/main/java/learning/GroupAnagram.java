package learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GroupAnagram {

	public static void main(String[] args) {
		String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> result = groupAnagrams(str);
		for(List list : result) {
			list.forEach(s->System.out.println(s));
			System.out.println("********");
		}
	}
	//sort
	public static List<List<String>> groupAnagrams(String[] str) {
		if(str.length == 0) return new ArrayList();
		Map<String, List> ans = new HashMap<>();
		for(String s: str) {
			char[] ca = s.toCharArray();
			Arrays.sort(ca);
			String key = String.valueOf(ca);
			if(!ans.containsKey(key)) ans.put(key, new ArrayList<>());
			ans.get(key).add(s);
		}
		return new ArrayList(ans.values());
	}
	
	//by count
	// Time Complexity: O(NK)O(NK), where NN is the length of strs, and KK is the maximum length of a string in strs. Counting each string is linear in the size of the string, and we count every string.
	// Space Complexity: O(NK)O(NK), the total information content stored in ans.
	public List<List<String>> groupAnagrams2(String[] str) {
		if(str.length == 0) return new ArrayList<>();
		Map<String, List> ans = new HashMap();
		int[] count = new int[26];
		for(String s:str){
			Arrays.fill(count, 0);
			for(char c: s.toCharArray()) count[c-'a']++;
			
			StringBuilder sb = new StringBuilder("");
			for(int i=0;i<26;i++) {
				sb.append("#");
				sb.append(count[i]);
			}
			String key = sb.toString();
			if(!ans.containsKey(key)) ans.put(key, new ArrayList<>());
			ans.get(key).add(s);
		}
		return new ArrayList(ans.values());
	}
	
}
