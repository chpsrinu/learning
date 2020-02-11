package learning;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class StringCharFrequencies {

	static String isValid(String s) {
        if(s == null || s.equals("")) return "NO";
        
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        Iterator<Integer> itr = map.values().iterator();
        
        boolean first = true, second = true;
        int val1=0, val2 =0;
        int countOfVal1 = 0,countOfVal2=0;
        
        while(itr.hasNext()) {
        	int i = itr.next();
        	
        	//if first is true than coutOfVal1 increase
        	if (first) {
        		val1 = i;
        		first = false;
        		countOfVal1++;
        		continue;
        	}
        	if(i==val1) {
        		countOfVal1++;
        		continue;
        	}
        	//if second is true than countOfVal2 increase
        	if (second)   {
        		val2 = i;
        		countOfVal2++;
        		second=false;
        		continue;
        	}
        	if (i==val2) {
        		countOfVal2++;
        		continue;
        	}
        	return "NO";
        }
        
        if(countOfVal1 >1 && countOfVal2 > 1)
        	return "NO";
        else 
        	return "YES";

    }
	public static void main(String[] args) {
		System.out.println(isValid("aaaabbccccdddd"));
	}
	
}
