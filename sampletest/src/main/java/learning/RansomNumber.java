package learning;

import java.util.HashMap;
import java.util.Map;

public class RansomNumber {

	public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c: magazine.toCharArray()) {
            map.put(c, map.getOrDefault(c,0)+1);
        }
        for(char c: ransomNote.toCharArray()) {
            if(map.containsKey(c) && map.get(c) >0) {
                map.put(c, map.get(c)-1);
            } else {
                return false;
            }
        }
        return true;
    }
	
	public static void main(String[] args) {
		System.out.println(canConstruct("aa", "aab"));
	}
}
