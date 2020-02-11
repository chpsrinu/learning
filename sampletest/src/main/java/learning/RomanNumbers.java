package learning;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RomanNumbers {

	public static void main(String[] args) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		System.out.println(romanToInt("MCMIV", map));
	}

	private static int romanToInt(String s, Map<Character, Integer> map) {
		int result =0;
		for (int i =0;i<s.length();i++) {
			char c = s.charAt(i);
			int value = map.get(c);
			
			if(i+1 < s.length()) {
				int value2 = map.get(s.charAt(i+1));
				if (value >= value2) {
					result = result+value;
				}
				else {
					result = result+value2-value;
					i++;
				}
			}
			else {
				result = result +value;
				i++;
			}
		}
		return result;
	}
}
