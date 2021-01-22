package learning;

import java.util.HashMap;
import java.util.Map;

public class ConfusingNumberII {

	//Backtracking T:O(1) && S:O(1)
	static Map<Integer, Integer> map = new HashMap<>();
	static int res = 0;
	public static int confusingNumber(int N) {
		map.put(0, 0);
		map.put(1, 1);
		map.put(6, 9);
		map.put(8, 8);
		map.put(9, 6);
		helper(N,0);
		return res;
	}
	private static void helper(int N, long cur) {
		if (isConfusingNumber(cur)) {
			res++;
		}
		for(Integer i:map.keySet()) {
			long next=cur*10+i;
			if (next<=N && next!=0) {
				helper(N, next);
			}
		}
	}
	
	private static boolean isConfusingNumber(long n) {
		long src=n;
		long res=0;
		while(n>0){
			res = res*10+map.get((int)n%10);
			n /= 10;
		}
		return res!=src;
	}
	
	public static void main(String[] args) {
		System.out.println(confusingNumber(20));
	}
}
