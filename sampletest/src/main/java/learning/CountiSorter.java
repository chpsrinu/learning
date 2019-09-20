package learning;

import java.util.Arrays;

/*
 * Java Program sort an integer array using counting sort algorithm.
 * input: [60, 40, 30, 20, 10, 40, 30, 60, 60, 20, 40, 30, 40]
 * output: [10, 20, 20, 30, 30, 30, 40, 40, 40, 40, 60, 60, 60]
 * 
 * Time Complexity of Counting Sort Algorithm:
 *   Best Case O(n+k); Average Case O(n+k); Worst Case O(n+k),
 *   where n is the size of the input array and k means the
 *   values range from 0 to k.
 * 
 * https://www.java67.com/2017/06/counting-sort-in-java-example.html?fbclid=IwAR0tAF9ptQQ0_2IsCyTYVQ15fBOrxAQ790TzgGpUeZTb0s1A8srDMdymVEg
 */
public class CountiSorter {
	
	public static void main(String[] args) {
		System.out.println("Counting sort in Java");
		int[] input ={60,40,30,20,10,40,30,60,60,20,40,30,40};
		int k=60;
		
		System.out.println("integer array before sorting");
		System.out.println(Arrays.toString(input));
		
		//sorting array using Counting Sort Algorithm
		countingSort(input, k);
		
		System.out.println("integer array after sorting using counting sort algorithm");
		System.out.println(Arrays.toString(input));
	}
	
	public static void countingSort(int[] input, int k) {
		// create buckets
		int counter[] = new int[k+1];
		
		//fill buckets
		for (int i : input) {
			counter[i]++;
		}
		
		// sort array
		int ndx = 0;
		for (int i = 0 ; i< counter.length;i++) {
			while(0<counter[i]) {
				input[ndx++] = i;
				counter[i]--;
			}
		}
	}

}
