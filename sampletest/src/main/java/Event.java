import java.util.Arrays;
import java.util.PriorityQueue;

//https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/discuss/510263/JavaC%2B%2BPython-Priority-Queue
public class Event {
//Time O(nlogn), where D is the range of A[i][1], Space O(N)
	public int maxEvents(int[][] A) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        Arrays.sort(A, (a, b) -> Integer.compare(a[0], b[0]));
        int i = 0, res = 0, d = 0, n = A.length;
        while (!pq.isEmpty() || i < n) {
            if (pq.isEmpty())
                d = A[i][0];
            while (i < n && A[i][0] <= d)
                pq.offer(A[i++][1]);
            pq.poll();
            ++res; ++d;
            while (!pq.isEmpty() && pq.peek() < d)
                pq.poll();
        }
        return res;
    }
}
