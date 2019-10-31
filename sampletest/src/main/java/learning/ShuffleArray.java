package learning;

import java.util.Random;

public class ShuffleArray {

	private int[] array;
	private int[] original;
	
	Random random = new Random();
	
	private int randRange(int min, int max) {
		return random.nextInt(max-min)+min;
	}
	
	private void swapAt(int i, int j) {
		int temp = array[i];
		array[i]=array[j];
		array[j] = temp;
	}
	
	public ShuffleArray(int[] nums) {
		array = nums;
		original = nums.clone();
	}
	
	public int[] reset() {
		array = original;
		original = original.clone();
		return original;
	}
	
	public int[] shuffle() {
		for (int i=0;i<array.length;i++) {
			swapAt(i, randRange(i, array.length));
			//swapAt(i, new Random(array.length).nextInt());
		}
		return array;
	}
}
