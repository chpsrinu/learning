package learning;

import java.util.ArrayList;
import java.util.List;

public class ArrayMedian {
	
	public static void main(String[] args) {
		int[] arr1 = {1, 3, 5};
		int[] arr2 = {2, 4, 6};
		System.out.println(median(arr1, arr2));
	}

	private static Double median(int[] arr1, int[] arr2) {
		List<Integer> tempArray = new ArrayList<Integer>();
		for (int i=0;i<arr1.length;) {
			for (int j=0;j<arr2.length;) {
				if (arr1[i] < arr2[j]) {
					tempArray.add(arr1[i]);
					i++;
				} else if (arr1[i] > arr2[j]) {
					tempArray.add(arr2[j]);
					j++;
				} else {
					tempArray.add(arr1[i]);
					i++;
					j++;
				}
			}
		}
		tempArray.forEach(e -> System.out.println(e));
		return 3.5;
	}

}
