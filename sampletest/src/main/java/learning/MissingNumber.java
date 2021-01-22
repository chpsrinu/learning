package learning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MissingNumber {

	public static void main(String[] args) {
		int[] arr = {203, 204, 205, 206, 207, 208, 203, 204, 205, 206};
		int[] brr = {203, 204, 204, 205, 206, 207, 205, 208, 203, 206, 205, 206, 204};
		System.out.println(missingNumbers(arr, brr));
	}
	static int[] missingNumbers(int[] arr, int[] brr) {
        Map<Integer, Integer> resultMap = new HashMap<>();
        for(int b: brr) {
            resultMap.put(b,resultMap.getOrDefault(b,0)+1);
        }
        for(int a: arr) {
            if(resultMap.containsKey(a)) {
                resultMap.put(a, resultMap.get(a)-1);
            }
        }
        List<Integer> list = new ArrayList<Integer>();
        for(Map.Entry<Integer,Integer> entry: resultMap.entrySet()) {
            if(entry.getValue()>0) {
                list.add(entry.getKey());
            }
        }
        int[] missingArray = new int[list.size()];
        for(int i=0;i<list.size();i++) {
            missingArray[i] = list.get(i);
        }
        return missingArray;
    }
}
