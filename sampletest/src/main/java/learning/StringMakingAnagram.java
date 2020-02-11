package learning;

import java.util.HashMap;
import java.util.Map;

public class StringMakingAnagram {

	static int makeAnagram(String a, String b) {
        Map<Character, Integer> map = new HashMap<>();
        int result = 0;
        for (char c : a.toCharArray()) {
            map.put(c, map.getOrDefault(map.get(c)+1, 1));
        }
        for (char c : b.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c)-1);
            }else {
                map.put(c, -1);
            }
        }
        for(Map.Entry<Character,Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) {
            	if (entry.getValue() < 0) result = result-entry.getValue();
            	else result = result+entry.getValue();
            }
        }
        return result;

    }
	
	public static void main(String[] args) {
		System.out.println(makeAnagram("fcrxzwscanmligyxyvym", "jxwtrhvujlmrpdoqbisbwhmgpmeoke"));
	}
}
