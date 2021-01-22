package learning;

import java.util.Arrays;

public class PrimeNumbers {

	public static void main(String[] args) {
		System.out.println(ProdOfPrimes(121));
	}
	
	static long ProdOfPrimes(int n) {
		boolean prime[] = new boolean[n+1];
		
		Arrays.fill(prime, true);
		
		for (int p=2; p*p<=n;p++) {
			if(prime[p] == true) {
				for (int i=p*2;i<=n;i+=p) {
					prime[i]=false;
				}
			}
		}
		
		long prod = 1;
		for (int i=2;i<=n;i++)
			if(prime[i])
				//prod*=i;
				System.out.println(i + " ");
		
		
		return prod;
	}
}
