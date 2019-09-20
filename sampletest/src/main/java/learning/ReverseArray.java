package learning;

public class ReverseArray {

	public static void main(String[] args) {
		int[] nums = new int[5];
		for(int i=0;i<nums.length;i++)
			nums[i] = i;
		reverseArray(nums);
		for (int i : nums) {
			System.out.println(i);
		}
	}
	
	private static int[] reverseArray(int[] nums) {
			int startIndex=0;
			int endIndex = nums.length-1;
			while(startIndex<endIndex){
				swap(startIndex,endIndex,nums);
				endIndex--;
				startIndex++;
			}
		return nums;
	}
	
	private static void swap(int i, int j, int[] nums) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
