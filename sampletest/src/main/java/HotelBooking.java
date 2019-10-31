import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

//Inputs:
//- arrivals = [1, 3, 5]
//- departures = [2, 6, 10]
public class HotelBooking {
	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<>();
		list1.add(1);
		list1.add(3);
		list1.add(5);
		List<Integer> list2 = new ArrayList<>();
		list2.add(2);
		list2.add(6);
		list2.add(10);
		System.out.println(hotelBooking(list1, list2, 1));
	}
	
	public static boolean hotelBooking(List<Integer> arrivals, List<Integer> departures, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		//if(arrivals.size() != departures.size()) return false;
		
		for (int i=0;i<arrivals.size();i++) {
			int arrival = arrivals.get(i);
			int dep = departures.get(i);
			
			Integer current = map.get(arrival);
			map.put(arrival, current == null? 1 : map.get(i)+1);
			
			current = map.get(dep);
			map.put(dep, current == null?-1:map.get(dep)-1);
		}
		
		//sort map
		Map<Integer, Integer> sortedEvents = new TreeMap<>(map);
		int count = 0;
		for(Map.Entry<Integer, Integer> entry : sortedEvents.entrySet()) {
			count += entry.getValue();
			
			while(count > k) {
				return false;
			}
			
		}
		return true;
		
	}
	

}
