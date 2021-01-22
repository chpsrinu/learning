package learning;

public class BubbleSort {

	public static void main(String[] args) {
		int[] nums = {12,7,-5,-77,102};
		showArray(nums);
		for (int i=0;i<nums.length-1;i++) {
			for (int j=0;j<nums.length-1-i;j++) {
				if(nums[j]>nums[j+1])
					swap(nums, j);
			}
		}
		System.out.println();
		showArray(nums);
	}

	private static void swap(int[] nums, int j) {
		int temp = nums[j+1];
		nums[j+1]=nums[j];
		nums[j] = temp;
	}

	private static void showArray(int[] nums) {
		for(int i=0;i<nums.length;i++)
			System.out.print(nums[i]+" ");
	}
}
