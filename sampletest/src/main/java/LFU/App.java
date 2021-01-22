package LFU;

public class App {
	public static void main(String[] args) {
		System.out.println("Going to test the LFU cache imple");
		LFUCache cache = new LFUCache(5);
		cache.put(1l, 10);
		cache.put(2l, 20);
		cache.put(3l, 30);
		cache.put(4l, 40);
		cache.put(5l, 50);
		
		System.out.println("Value for the key: 1 is " + cache.get(1));
		
		cache.put(6l, 60);
		System.out.println("Value for the key: 2 is " + cache.get(2));
		cache.put(7l, 70);
		
		System.out.println("Value for the key: 3 is " + cache.get(3));
		System.out.println("Value for the key 4 is " + cache.get(4));
		System.out.println("Value for the key 5 is " + cache.get(5));
	}

}
