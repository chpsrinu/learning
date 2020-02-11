package learning;

public class ArrayQueuePositionSwap {

	static void minimumSwaps(int[] q) {
        int result = 0;
        for(int i =q.length-1;i>=0;i--) {
            if (q[i] -(i+1) > 2) {
                System.out.println("Too chaotic");
                return;
            } 
            for(int j = Math.max(0,q[i]-2);j<i;j++ ) {
                if (q[j] > q[i]) result++;
            }   
            
        }
        System.out.println(result); 
    }
	
	public static void main(String[] args) {
		int[] arr = {5, 1, 2, 3, 7, 8, 6, 4};
		minimumSwaps(arr);
	}
}
