package learning;

import java.util.LinkedList;
import java.util.List;

public class RecentCounter {

	private LinkedList<Integer> list;
	public RecentCounter() {
		this.list = new LinkedList<Integer>();
	}
	
	public int ping(int t) {
			this.list.addLast(t);
			
			while (this.list.size() > 0) {
				if (this.list.getFirst() < t-3000) {
					this.list.removeFirst();
				} else
					break;
			}
			return list.size();
	}
	
	public static void main(String[] args) {
		RecentCounter rc = new RecentCounter();
		System.out.println(rc.ping(1));
		System.out.println(rc.ping(100));
		System.out.println(rc.ping(3001));
		System.out.println(rc.ping(3002));
	}
}
