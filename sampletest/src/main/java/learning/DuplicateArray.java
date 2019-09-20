package learning;

public class DuplicateArray {

	public static void main(String[] args) {
		int[] nums = {3,2,4,5,3,4,1,2,1};
		solve(nums);
	}
	public static void solve(int[] array) {
		
		//this is why it is an O(N) running time algorithm
		for (int i=0;i<array.length;i++) {
			//if the valueis positive we have to flip
			if(array[Math.abs(array[i])] >0) {
				array[Math.abs(array[i])] = -array[Math.abs(array[i])];
			} else {
				System.out.println(Math.abs(array[i])+ " is a repetation.");
			}
		}
	}
}
