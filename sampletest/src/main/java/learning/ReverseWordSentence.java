package learning;

public class ReverseWordSentence {
	public static void reverseWords(char[] s) {
	    int i=0;
	    for(int j=0; j<s.length; j++){
	        if(s[j]==' '){
	            reverse(s, i, j-1);        
	            i=j+1;
	        }
	    }
	 
	    reverse(s, i, s.length-1);
	 
	    reverse(s, 0, s.length-1);
	}
	 
	public static void reverse(char[] s, int i, int j){
	    while(i<j){
	        char temp = s[i];
	        s[i]=s[j];
	        s[j]=temp;
	        i++;
	        j--;
	    }
	}
	
	public static void main(String[] args) {
		String s = "  hello world!  ";
		reverseWords(s.toCharArray());
		System.out.println(s);
		
//		String s[] = "  hello world!  ".split(" "); 
//		String ans = ""; 
//		for (int i = s.length - 1; i >= 0; i--) { 
//			ans += s[i] + " "; 
//		} 
//		System.out.println("Reversed String:"); 
//		System.out.println(ans.substring(0, ans.length() - 1));
	}
}
