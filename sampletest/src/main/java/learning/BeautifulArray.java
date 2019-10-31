package learning;

import java.util.HashMap;
import java.util.Map;

public class BeautifulArray {

	public static void main(String[] args) {
		int[] result = beautifulArray(5);
		System.out.println("test");
	}
	
	static Map<Integer, int[]> memo;
    public static int[] beautifulArray(int N) {
        memo = new HashMap<Integer, int[]>();
        return f(N);
    }
    
    public static int[] f(int N) {
        if (memo.containsKey(N)) 
            return memo.get(N);
        
        int[] ans = new int[N];
        if (N ==1) {
            ans[0] =1;
        } else {
            int t =0;
            for (int x : f((N+1)/2))
                ans[t++] = 2*x-1;
            for (int x:f(N/2)) 
                ans[t++] = 2*x;
        }
        memo.put(N, ans);
        return ans;
    }
}
