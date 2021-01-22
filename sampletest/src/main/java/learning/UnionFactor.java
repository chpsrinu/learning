package learning;

import java.util.HashMap;
import java.util.Map;

//Union Find template. The only additional stuff is one hashmap which is used to convert factor to the node index in A for union.
//HashMap: key is the factor, val is the index in A
//Time complexity: O(N*sqrt(Max val of A[i]))
public class UnionFactor {

	static class UF {
		int[] parent;
		int[] size;
		int max;
		public UF (int N) {
			parent = new int[N];
			size = new int[N];
			max = 1;
			for (int i=0;i<N;i++) {
				parent[i] = i;
				size[i] = 1;
			}
		}
		public int find(int x) {
			if (x == parent[x]) {
				return x;
			}
			return parent[x] = find(parent[x]);
		}
		public void union(int x, int y){
			int rootX = find(x);
			int rootY = find(y);
			if (rootX != rootY) {
				parent[rootX] = rootY;
				size[rootY] += size[rootX];
				max = Math.max(max, size[rootY]);
			}
		}
	}
	
	public static int largestComponentSize(int[] A) {
		int N = A.length;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>(); //key is factor, val is the node index
		UF uf = new UF(N);
		for (int i=0;i<N;i++) {
			int a = A[i];
			for(int j =2;j*j<=a;j++) {
				if (a%j == 0) {
					if(!map.containsKey(j)) { //this means that no index has claimed the factor yet
						map.put(j, i);
					}else { //this means that one index already claimed, so union that one with current
						uf.union(i, map.get(j));
					}
					if (!map.containsKey(a/j)) {
						map.put(a/j, i);
					} else {
						uf.union(i, map.get(a/j));
					}
				}
			}
			if (!map.containsKey(a)) {//a could be factor too. Dont miss this
				map.put(a, i);
			} else {
				uf.union(i, map.get(a));
			}
		}
		return uf.max;
	}
	public static void main(String[] args) {
		int[] A = new int[]{4,6,15,35};
		int[] B = new int[]{20,50,9,63};
		int[] C = new int[]{2,3,6,7,4,12,21,39};
		System.out.println("max factor for A array: "+ largestComponentSize(A));
		System.out.println("max factor for B array: "+ largestComponentSize(B));
		System.out.println("max factor for C array: "+ largestComponentSize(C));
		
	}
}
