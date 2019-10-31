package MyDS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MyDS {

	List<Integer> list;
	Map<Integer, Integer> map;
	
	public MyDS() {
		list = new ArrayList<Integer>();
		map = new HashMap<Integer, Integer>();
	}
	
	void add(int x) {
		if(!map.containsKey(x)) {
			list.add(x);
			map.put(x, list.size());
		}
	}
	
	void remove(int x) {
		Integer index = map.get(x);
		
		if (index == null) return;
		
		map.remove(x);
		
		int size = list.size();
		Integer last = list.get(size-1);
		Collections.swap(list, index, size-1);
		list.remove(size-1);
		
		map.put(last, index);
	}
	
	int getRandom() {
		Random random = new Random();
		int index = random.nextInt(list.size());
		return list.get(index);
	}
	
	Integer search(int x) {
		return map.get(x);
	}
	
	
		public static void main(String[] args) {
			MyDS ds = new MyDS();
			ds.add(10);
			ds.add(20);
			ds.add(30);
			ds.add(40);
			System.out.println(ds.search(30));
		}
}
