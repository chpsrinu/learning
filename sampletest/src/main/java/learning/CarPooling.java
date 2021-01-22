package learning;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class CarPooling {

	public static boolean carPooling(int[][] trips, int capacity) {
		Map<Integer, Integer> timestamp = new TreeMap<Integer, Integer>();
		for (int[] trip: trips) {
			int start_passenger = timestamp.getOrDefault(trip[1], 0)+trip[0];
			timestamp.put(trip[1], start_passenger);
			
			int end_passenger = timestamp.getOrDefault(trip[2], 0)-trip[0];
			timestamp.put(trip[2], end_passenger);
		}
		
		int ued_capacity = 0;
		for (int passenger_change: timestamp.values()) {
			ued_capacity += passenger_change;
			if(ued_capacity > capacity){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		int[][] trips = {{2,1,5}, {3,3,7}};
		System.out.println(carPooling(trips, 4));
		
		int[][] trips1 = {{2,1,5}, {3,3,7}};
		System.out.println(carPooling(trips1, 5));
		
		int[][] trips2 = {{2,1,5}, {3,5,7}};
		System.out.println(carPooling(trips2, 3));
		
		int[][] trips3 = {{3,2,7},{3,7,9},{8,3,9}};
		System.out.println(carPooling(trips3, 11));
	}
}

//using priority queues
class Solution {
    private class Leg implements Comparable<Leg> {
        public int location;
        public int numPassengers;
        
        public Leg(int location, int numPassengers) {
            this.location = location;
            this.numPassengers = numPassengers;
        }
        
        public int compareTo(Leg that) {
            if (this.location == that.location) {
                return this.numPassengers - that.numPassengers;
            }

            return this.location - that.location;
        }
    }

    public boolean carPooling(int[][] trips, int capacity) {
        if (trips.length == 0) {
            return false;
        }

        PriorityQueue<Leg> pq = new PriorityQueue();
    
        for (int[] trip : trips) {
            pq.add(new Leg(trip[1], trip[0]));
            pq.add(new Leg(trip[2], -trip[0]));
        }
        
        int rem = capacity;
        while (pq.size() > 0) {
            rem = rem - pq.poll().numPassengers;

            if (rem  < 0) {
                return false;
            }
        }
        
        return true;
    }
}
