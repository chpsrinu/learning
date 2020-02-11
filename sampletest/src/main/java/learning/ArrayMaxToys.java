package learning;

public class ArrayMaxToys {
	
	static int maximumToys(int[] prices, int k) {
        java.util.Arrays.sort(prices);
        int count=0,sum=0;
        for ( int i =0;i<prices.length;i++) {
            if (sum+prices[i] <= k) {
                count++;
                sum += prices[i];
            } else {
                break;
            }
        }
        return count;
    }
	
	public static void main(String[] args) {
		int[] prices = {1,12,5,111,200,1000,10};
		System.out.println(maximumToys(prices, 50));
	}

}
