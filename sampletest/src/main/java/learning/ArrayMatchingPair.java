package learning;

import java.util.HashMap;
import java.util.Map;

public class ArrayMatchingPair {

	public static int numberPairs(int n, int[] ar) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int count = 0;
        for (int i =0;i<ar.length;i++) {
            if (map.containsKey(ar[i])) {
                map.put(ar[i], map.get(ar[i])+1);
            } else {
                map.put(ar[i], 1);
            }
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int val = entry.getValue()/2;
            count = count+val;
        }

        return count;
    }
	
	public static void main(String[] args) {
		int[] arr = {1,2,1,2,1,3,2};
		System.out.println(numberPairs(arr.length, arr));
	}
}
