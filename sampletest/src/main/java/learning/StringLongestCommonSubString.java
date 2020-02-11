package learning;

public class StringLongestCommonSubString {

	static int getLogestCommonSubString(String a, String b) {
		int m = a.length();
		int n = b.length();
		
		int max = 0;
		
		int[][] dp = new int[m+1][n+1];
		
		for (int i =0;i<=m;i++) {
			for (int j=0;j<=n;j++) {
				if (i==0 || j==0) {
					dp[i][j] = 0;
				} else if(a.charAt(i-1)==b.charAt(j-1)) {
					dp[i][j] = dp [i-1][j-1]+1;
					max = Integer.max(max, dp[i][j]);
				}
				else {
					dp[i][j] = 0;
				}
			}
		}
		return max;
	}
	public static void main(String[] args) {
		System.out.println(getLogestCommonSubString("SHINCHAN", "NOHARAAA"));
	}
}
