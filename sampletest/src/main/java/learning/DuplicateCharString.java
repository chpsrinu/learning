package learning;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DuplicateCharString {

	public static void main(String[] args) {
		duplicateCharFromString("PYDI SRINIVASA RAO CHOWDADA");
	}

	private static void duplicateCharFromString(String string) {
		char[] str = string.toCharArray();
		Map<Character, Integer> map = new HashMap<>();
		for (int i=0;i<str.length-1;i++) {
			if(map.containsKey(str[i])) {
				map.put(str[i],map.get(str[i])+1);
			} else {
				map.put(str[i], 1);
			}
		}
		
		Set<Map.Entry<Character, Integer>> set = map.entrySet();
		System.out.println("List duplciate chars");
		for(Map.Entry<Character, Integer> entry : set) {
			if(entry.getValue()>1) {
				System.out.println("Char : " + entry.getKey() + " value : " + entry.getValue());
			}
		}
	}
}
