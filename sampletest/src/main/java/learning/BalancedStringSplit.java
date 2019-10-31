package learning;

public class BalancedStringSplit {

	public static void main(String[] args) {
		System.out.println(balancedStringSplit("RLRRLLRLRL"));
		System.out.println(balancedStringSplitGreedy("RLRRLLRLRL"));
	}
	
	public static int balancedStringSplit(String s) {
		int Lnum = 0;
		int Rnum =0;
		int splitCount =0;
		for (Character c : s.toCharArray()) {
			if(c == 'L') {
				Lnum++;
			} if (c == 'R') {
				Rnum++;
			}
			if (Lnum == Rnum) {
				splitCount++;
			}
		}
		return splitCount;
	}
	
	public static int balancedStringSplitGreedy(String s) {
		int count =0, m=0;
		for (Character c : s.toCharArray()) {
			m += c=='L'? 1: -1;
			if ( m ==0) count++;
		}
		return count;
	}
}
