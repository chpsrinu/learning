package learning;

import java.util.*;

import LinkedList.Person;

class Solution {
	  public static void main(String[] args) {
	    System.out.println(stringCompress("zeeeebbbba"));
	  }
	  public static String stringCompress(String input) {
	    Map<Character, Integer> map = new  TreeMap<>();
	    Map<Person, String> map2 = new TreeMap<>();
	    StringBuilder sf = new StringBuilder();
	    char[] characters = input.toCharArray();
	    for (Character c : characters) {
	      if (map.containsKey(c)) {
	          map.put(c, map.get(c)+1);
	      } else {
	          map.put(c, 1);
	      }
	  }
	    List<Map.Entry<Character,Integer>> list = new ArrayList<Map.Entry<Character,Integer>>(map.entrySet());
	    Collections.sort(list, new Comparator<Map.Entry<Character,Integer>>() {
	      public int compare(Map.Entry<Character,Integer> o1, Map.Entry<Character,Integer> o2) {
	        return (o1.getValue()).compareTo(o2.getValue());
	    }
	   });
	    
	    for (Map.Entry<Character, Integer> entry : list) {
	    	sf.append(entry.getKey());
	    }
	    return sf.toString();
	  }
	  
	  
	  
	  class MyCompTest implements Comparator<Person> {
		  public int compare(Person s1, Person s2) {
			  return s1.compareTo(s2);
		  }
	  }
	  
	  public List<String> topKFrequent(String[] words, int k) {
	        Map<String, Integer> count = new HashMap();
	        for (String word: words) {
	            count.put(word, count.getOrDefault(word, 0) + 1);
	        }
	        List<String> candidates = new ArrayList(count.keySet());
	        Collections.sort(candidates, (w1, w2) -> count.get(w1).equals(count.get(w2)) ?
	                w1.compareTo(w2) : count.get(w2) - count.get(w1));

	        return candidates.subList(0, k);
	  }
	  
	  
}
class MyComp implements Comparator<Map.Entry<Person, Integer>> {
	  public int compare(Map.Entry<Person, Integer> o1, Map.Entry<Person, Integer> o2) {
		  return (o1.getKey()).compareTo(o2.getKey());
	  }
}