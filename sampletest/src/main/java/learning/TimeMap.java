package learning;
//https://leetcode.com/problems/time-based-key-value-store/
import java.util.HashMap;
import java.util.TreeMap;

public class TimeMap {

	HashMap<String, TreeMap<Integer, String>> tm;
	
	public TimeMap() {
		tm = new HashMap<>();
	}
	
	public void set(String key, String value, int timestamp) {
		if (!tm.containsKey(key)) {
			tm.put(key, new TreeMap<Integer, String>());
		}
		tm.get(key).put(timestamp, value);
	}
	
	public String get(String key, int timestamp) {
		if (!tm.containsKey(key)) {
			return "";
		}
		
		TreeMap<Integer, String> tree = tm.get(key);
		Integer t = tree.floorKey(timestamp);
		if (t== null)
			return "";
		return tree.get(t);
	}
	
	public static void main(String[] args) {
		TimeMap tm = new TimeMap();
		tm.set("love","high",10);
		tm.set("love","low",20);
		System.out.println(tm.get("love", 5));
		System.out.println(tm.get("love", 10));
		System.out.println(tm.get("love", 15));
		System.out.println(tm.get("love", 20));
		System.out.println(tm.get("love", 25));
	}
}
