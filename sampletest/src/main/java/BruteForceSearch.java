
public class BruteForceSearch {
	
	public static void main(String[] args) {
		System.out.println(search("this is a text", "text"));
	}
	//O(m*(n-m+1))
	public static int search(String text, String pattern) {
		int lengthOfText = text.length();
		int lengthOfPattern = pattern.length();
		
		for(int i=0;i<=lengthOfText-lengthOfPattern;i++) {
			int j;
			for (j=0;j<lengthOfPattern;j++) {
				if (text.charAt(i+j) != pattern.charAt(j)) {
					break;
				}
			}
			if(j == lengthOfPattern) return i;
			
		}
		return lengthOfText;
	}

}
