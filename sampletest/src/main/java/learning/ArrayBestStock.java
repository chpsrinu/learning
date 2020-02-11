package learning;

public class ArrayBestStock {

	public static void main(String[] args) {
		int[] stock = {7,1,5,3,6,4};
		System.out.println(maxProfit2(stock));
	}

	private static int maxProfit(int[] stock) {
		int maxProfit = 0;
		for (int i=0;i<stock.length-1;i++) {
			for (int j=i+1;j<stock.length;j++) {
				int profit = stock[j]-stock[i];
				if (maxProfit< profit) maxProfit = profit;
			}
		}
		return maxProfit;
	}
	
	private static int maxProfit2(int[] stock) {
		int min = Integer.MAX_VALUE;
		int maxProfit = 0;
		for (int i =0;i<stock.length;i++) {
			if(stock[i] < min) {
				min = stock[i];
			} else if (maxProfit < stock[i] - min) {
				maxProfit = stock[i]-min;
			}
			
		}
		return maxProfit;
	}
}
