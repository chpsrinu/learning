package learning;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class ComparatorExamples {

	public static void main(String[] args) {
		SortedMap<Integer, String> sort = new TreeMap<>(Collections.reverseOrder());
		sort.put(1, "one");
		sort.put(2, "two");
		sort.put(5, "five");
		sort.put(3, "three");
		sort.put(4, "four");
		
		
		System.out.println("sorted map : " + sort);
		
		Comparator comp = sort.comparator();
		
		System.out.println("after comparator :" + comp);
		
		List<Integer> list = Arrays.asList(212, 324, 435, 566, 133, 100, 121);
		
		list.sort(Comparator.naturalOrder());
		System.out.println("list sort: " + list);
		
		String[] str = {"aman", "amar", "avik"};
		System.out.println("before sort : " + Arrays.toString(str));
		
		Comparator<String> comp2 = (String::compareTo);
		Arrays.sort(str, comp2.reversed());
		System.out.println("After sort : " + Arrays.toString(str) );
		
	}
}
