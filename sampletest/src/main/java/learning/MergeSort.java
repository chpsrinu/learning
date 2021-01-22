package learning;

import java.util.Random;

public class MergeSort {

	private int[] nums;
	private int[] tempArray;
	
	public MergeSort(int[] nums) {
		this.nums = nums;
		tempArray = new int[nums.length];
	}
	
	public void mergeSort(int low, int high) {
		if (low>=high) {
			return;
		}
		int middle = (low+high)/2;
		
		mergeSort(low, middle);
		mergeSort(middle+1, high);
		merge(low, middle, high);
	}
	
	public void showResult() {
		for (int i=0;i<nums.length;i++) {
			System.out.println(nums[i]+" ");
		}
	}
	
	private void merge(int low, int middle, int high) {
		// copy nums[i] -> temp[i]
		for (int i=low;i<=high;i++) {
			tempArray[i] = nums[i];
		}
		
		int i = low;
		int j = middle+1;
		int k = low;
		//copy the smallest values from either the left or the right side back to the original array
		while((i<= middle) && (j<=high)) {
			if (tempArray[i] <= tempArray[j]) {
				nums[k] = tempArray[i];
				i++;
			} else {
				nums[k] = tempArray[j];
				j++;
			}
			k++;
		}
		
		while(i<=middle) {
			nums[k]=tempArray[i];
			k++;
			i++; 
		}
		
		while(j<=high) {
			nums[k]=tempArray[j];
			k++;
			j++;
		}
	}
	
	public static void main(String[] args) {
		Random random = new Random();
		int[] nums = new int[30];
		
		for(int j=0;j<nums.length;j++) {
			nums[j] = random.nextInt(1000)- 500;
		}
		MergeSort sort = new MergeSort(nums);
		sort.mergeSort(0, nums.length-1);
		sort.showResult();
	}
}
