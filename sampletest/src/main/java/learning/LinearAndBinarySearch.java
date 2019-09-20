package learning;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class LinearAndBinarySearch {

	private int[] array;
	
	public LinearAndBinarySearch(int[] array) {
		this.array = array;
	}
	
	public int binarySearch(int startIndex, int endIndex, int item) {
		
		if (endIndex < startIndex) {
			System.out.println("This item not present in the array...");
			return -1;
		}
		
		int middleIndex = (startIndex+endIndex)/2;
		if(array[middleIndex] == item) {
			return middleIndex;
		} else if(array[middleIndex] < item) {
			return binarySearch(middleIndex+1, endIndex, item);
		} else {
			return binarySearch(startIndex, middleIndex-1, item);
		}
	}
}
