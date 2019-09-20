package learning;

import java.util.Arrays;

public class ArrayMaxMin {

	public static void main(String[] args) {
		//normal case testing
		int[] primes = {31,37,41,43,47,59};
		System.out.printf("Array: %s Maximum: %d, Minimum: %d %n", Arrays.toString(primes), max(primes), min(primes));
		int[] even = {2,4,14,16,18,20};
		System.out.printf("Array: %s, Maximum: %d, Minimum: %d %n", Arrays.toString(even), max(even), min(even)); 
		int[] odd = { 1, 3, 11, 15, 18, 21 }; 
		System.out.printf("Array: %s, Maximum: %d, Minimum: %d %n", Arrays.toString(odd), max(odd), min(odd));
		
		
		//testing for empty array
		try { 
			int[] empty = {}; 
			System.out.printf("Array: %s, Largest: %d, Smallest: %d %n", Arrays.toString(empty), max(empty), min(empty));
		} catch (Exception e) 
		{ 
			System.out.println(e.getMessage()); 
		}
	}
public static int max(int[] numbers) {
	if (numbers == null||numbers.length==0) {
		throw new IllegalArgumentException("Invalid input: " + Arrays.toString(numbers));
	}
	
	int max = numbers[0];
	for(int i=1;i<numbers.length;i++) {
		if(max > numbers[i]) {
			max = numbers[i];
		}
	}
	return max;
}

public static int min(int[] numbers) {
	if (numbers == null||numbers.length==0) {
		throw new IllegalArgumentException("Invalid input: " + Arrays.toString(numbers));
	}
	
	int max = numbers[0];
	for(int i=1;i<numbers.length;i++) {
		if(max < numbers[i]) {
			max = numbers[i];
		}
	}
	return max;
}
}
