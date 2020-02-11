package learning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DuplicateCharString {

	public static void main(String[] args) {
		duplicateCharFromString("banana");
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
		
		//Set<Map.Entry<Character, Integer>> set = map.entrySet();
		System.out.println("List duplciate chars");
		for(Map.Entry<Character, Integer> entry : map.entrySet()) {
			//if(entry.getValue()>1) {
				System.out.println("Char : " + entry.getKey() + " value : " + entry.getValue());
			//}
		}
	}
	
	public static List FirstTwoItemsWithoutPair(List<Integer> list)
    {
        Map<Integer, Integer> map = new HashMap();
        List<Integer> list2 = new ArrayList();
        int count = 0;
        for (int ele : list) {
            if (map.containsKey(ele)) {
                map.put(ele, map.get(ele)+1);
            } else {
                map.put(ele, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() ==1 && count <3) {
                list2.add(entry.getKey());
            }

        }
        return list2;
    }
}
