package learning;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SumArrayEqualTarget {

	public static void main(String[] args) {
		int[] numbers = {2, 4, 3, 5, 7, 8, 9};
		int[] numbersWithDuplicates = {2, 4, 3, 5, 6, -2, 4, 7, 8, 9};
		prettyPrint(numbers, 7);
		prettyPrint(numbersWithDuplicates, 7);
	}
	
	//O(n^2)
	public static void BruteForceSol(int[] array, int sum) {
		for(int i=0;i<array.length;i++) {
			int first = array[i];
			for (int j=i+1;j<array.length;j++) {
				int second = array[j];
				
				if(first+second == sum) {
					System.out.printf("(%d, %d) %n", first, second);
				}
			}
		}
	}
	//O(n) but extra space for storing in hash set
	public static void hashSetImpl(int[] numbers, int n) {
		if(numbers.length <2) 
			return;
		Set<Integer> set = new HashSet<>(numbers.length);
		
		for (int value : numbers) {
			int target = n-value;
			
			if(!set.contains(target)) {
				set.add(value);
			} else {
				System.out.printf("(%d, %d) %n", value, target );
			}
		}
	}
	
	//0(nlogn)
	public static void sortArray(int[] numbers, int n) {
		if(numbers.length < 2)
			return;
		
		Arrays.sort(numbers);
		
		int left =0;int right = numbers.length-1;
		while (left<right) {
			int sum = numbers[left]+numbers[right];
			if(sum == n) {
				System.out.printf("(%d, %d) %n ", numbers[left], numbers[right]);
				left += 1;
				right -= 1;
			} else if (sum < n) {
				left++;
			} else {
				right--;
			}
				
		}
	}
	
	public static void prettyPrint(int[] givenArray, int givenSum) {
		System.out.println("Given array : " + Arrays.toString(givenArray));
		System.out.println("Given sum : " + givenSum);
		System.out.println("Integer numbers, whose sum is equal to value :") ;
		//BruteForceSol(givenArray, givenSum);
		System.out.println("---------------------");
		hashSetImpl(givenArray, givenSum);
		System.out.println("---------------------");
		sortArray(givenArray, givenSum);
	}
}
