package learning;

import java.util.HashMap;
import java.util.Map;

public class UndergroundSystem {

	Map<Integer, String[]> recordMap; //start-->end:string[0]-->station,string[1]:start time
	Map<String, double[]> timeMap; //retrieve average time: double[0]-->avg,double[1]-->nbr times
	
	public UndergroundSystem() {
		recordMap = new HashMap<Integer, String[]>();
		timeMap = new HashMap<>();
	}
	
	public void checkIn(int id, String stationName, int t) {
		recordMap.put(id, new String[]{stationName, String.valueOf(t)});
	}
	
	public void checkOut(int id, String stationName, int t) {
		String[] tmp = recordMap.get(id);
		String key = tmp[0]+stationName; //key station1station2
		double time = (double) (t-Integer.parseInt(tmp[1])); //time station1-->station2
		if(!timeMap.containsKey(key)){
			timeMap.put(key, new double[]{time,1});
		} else {
			double[] val = timeMap.get(key);
			double newAvg = (val[0]*val[1]+time)/(val[1]+1);
			timeMap.put(key, new double[]{newAvg, val[1]+1});
		}
	}
	
//	public double getAverageTime(String startStation, String endStation) {
//		return timeMap.get(startStation+endStation)[0];
//	}
//	
//	HashMap<String, Pair<Integer, Integer>> checkoutMap = new HashMap<>(); // Route - {TotalTime, Count}
//    HashMap<Integer, Pair<String, Integer>> checkInMap = new HashMap<>();  // Uid - {StationName, Time}
//    
//	public UndergroundSystem() {}
//    
//	public void checkIn(int id, String stationName, int t) {
//        checkInMap.put(id, new Pair<>(stationName, t));
//    }
//    
//	public void checkOut(int id, String stationName, int t) {
//        Pair<String, Integer> checkIn = checkInMap.get(id);
//        String route = checkIn.getKey() + "_" + stationName;
//        int totalTime = t - checkIn.getValue();
//        Pair<Integer, Integer> checkout = checkoutMap.getOrDefault(route, new Pair<>(0, 0));
//        checkoutMap.put(route, new Pair<>(checkout.getKey() + totalTime, checkout.getValue() + 1));
//    }
//    
//	public double getAverageTime(String startStation, String endStation) {
//        String route = startStation + "_" + endStation;
//        Pair<Integer, Integer> checkout = checkoutMap.get(route);
//        return (double) checkout.getKey() / checkout.getValue();
//    }
}
