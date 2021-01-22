package learning;

public class RemovePalindromeSub {

	public static void main(String[] args) {
		
	}
	
	public static int removePalindromeSub(String s) {
		if(s.isEmpty()) return 0;
		if(isPalindrome(s)) return 1;
		else return 2;
	}

	private static boolean isPalindrome(String s) {
		int left =0, right =s.length()-1;
		while(left<right) {
			if(s.charAt(left) != s.charAt(right)) return false;
			left++;
			right--;
		}
		return true;
	}
}
