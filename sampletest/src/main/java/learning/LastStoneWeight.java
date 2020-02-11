package learning;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {

	public int getLastStoneWeight(int[] stones) {
		int n = stones.length;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		for (int x : stones) {
			pq.add(x);
		}
		
		int a, b;
		while(pq.size()>1) {
			a = pq.poll();
			b = pq.poll();
			
			a = Math.abs(a-b);
			if (a!=0)
				pq.add(a);
		}
		pq.add(0);
		return pq.poll();
	}
	
	
}
