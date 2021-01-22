package learning;

public class ValidPalindrome {

	public static boolean isValidPalindrome(String s) {
		for(int i=0,j=s.length()-1;i<=j;i++,j--) {
			if(s.charAt(i) != s.charAt(j)) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean validPalindrome(String s) {
		StringBuilder sb = new StringBuilder(s);
		for(int i =0;i<s.length();i++) {
			char c = sb.charAt(i);
			sb.deleteCharAt(i);
			if(isValidPalindrome(sb.toString())) 
				return true;
			sb.insert(i, c);
		}
		return isValidPalindrome(s);
	}
	
	public static void main(String[] args) {
		System.out.println(validPalindrome("abcda"));
		
		String str = "abcbea";
		int idx = posiblePalinByRemoveingOneChar(str);
		if (idx == -1) System.out.println("Not possible");
		else if(idx == -2) System.out.println("Possible without removing any character");
		else System.out.println("possible by removeing character at index : " + idx);
	}
	
	static int posiblePalinByRemoveingOneChar(String str) {
		int low =0,high=str.length()-1;
		
		while(low<high) {
			if(str.charAt(low) == str.charAt(high)) {
				low++;
				high--;
			} else {
				if(isPalindrome(str, low+1, high)) {
					return low;
				}
				if(isPalindrome(str, low, high-1)) {
					return high;	
				}
				return -1;
			}
		}
		return -2;
	}
	
	static boolean isPalindrome(String s, int low, int high) {
		while(low<high) {
			if(s.charAt(low) != s.charAt(high)) {
				return false;
			}
			low++;
			high--;
		}
		
		return true;
	}
}
