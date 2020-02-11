package learning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountTriplets {

	static long countTriplets(List<Long> arr, long r) {
        Map<Long, Long> t2 = new HashMap<Long, Long>();
        Map<Long, Long> t3 = new HashMap<Long, Long>();
        
        long result = 0L;
        for(Long a : arr) {
        	result += t3.getOrDefault(a, 0L);
        	if (t2.containsKey(a)) {
        		t3.put(a*r, t2.getOrDefault(a*r, 0L)+t2.get(a));
        	}
        	t2.put(a*r, t2.getOrDefault(a*r, 0L)+1);
        }
        return result;
    }
	
	public static void main(String[] args) {
		
		List<Long> arr = new ArrayList<>();
		arr.add(1L);
		arr.add(2L);
		arr.add(2L);
		arr.add(4L);
		System.out.println(countTriplets(arr, 2));
	}
}
