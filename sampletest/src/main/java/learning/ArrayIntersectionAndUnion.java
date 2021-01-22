package learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a list of sorted list of elements over a type Integer,
 * write an algorithm that efficiently identifies all elements
 * common to the lists.
 * 
 * Example: 
 * 
 * and let the following input be given:
 * 
 * Input:
 * A := 
 * [
 *   [ 1, 2, 4, 5, 8 ],
 *   [ 2, 4, 5, 6, 8 ],
 *   [ 2, 4, 6, 8 ]
 * ]
 *
 * Expected Output:
 * B := [ 2, 4, 8 ]
 */
public class ArrayIntersectionAndUnion {

	public static void main(String[] args) {
		List<ArrayList<Integer>> newList = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list1 = new ArrayList<>();
		list1.add(1);
		list1.add(2);
		list1.add(4);
		list1.add(5);
		list1.add(8);
		
		ArrayList<Integer> list2 = new ArrayList<>();
		list2.add(2);
		list2.add(4);
		list2.add(5);
		list2.add(6);
		list2.add(8);
		
		ArrayList<Integer> list3 = new ArrayList<>();
		list3.add(2);
		list3.add(4);
		list3.add(6);
		list3.add(8);
		newList.add(list1);
		newList.add(list2);
		newList.add(list3);
		
		System.out.println(getIntersection(newList));
		//System.out.println(getUnion(list1, list2));
		//System.out.println(getIntersection(new ArrayList<>()));
	}
	
	public static List<Integer> getIntersection(List<ArrayList<Integer>> list) {
		ArrayList<Integer> result = new ArrayList<>();
		if (list.size() == 0) throw new IllegalArgumentException("array is empty");
		if (list.size() == 1) return list.get(0);
		result = getUnion(list.get(0), list.get(1));
		for (int i=2;i<list.size();i++) {
			result = getUnion(result, list.get(i));
		}
		return result;
	}

	private static ArrayList<Integer> getIntersection(ArrayList<Integer> arrayList, ArrayList<Integer> arrayList2) {
		ArrayList<Integer> result = new ArrayList<>(); 
		int i =0,j=0;
		while (i<arrayList.size() && j<arrayList2.size()) {
			if (arrayList.get(i) < arrayList2.get(j)) {
				i++;
			} else if(arrayList.get(i) > arrayList2.get(j)) {
				j++;
			} else {
				result.add(arrayList.get(i));
				i++;
				j++;
			}
			
		}
		return result;
	}
	
	private static ArrayList<Integer> getUnion(ArrayList<Integer> list1, ArrayList<Integer> list2) {
		ArrayList<Integer> result = new ArrayList<>();
		int i =0,j=0;
		while(i<list1.size() && j<list2.size()) {
			if (list1.get(i) < list2.get(j)) {
				result.add(list1.get(i));
				i++;
			} else if(list1.get(i) > list2.get(j)) {
				result.add(list2.get(j));
				j++;
			} else {
				result.add(list2.get(j));
				i++;
				j++;
			}
		}
		return result;
	}
	
}
