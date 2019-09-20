
public class StringReverseExample {

	public static void main(String[] args) {
		
		String str = "Sony is going to introduce internet TV soon";
		System.out.println("Original String: " + str);
		
		//reversed string using Stringbuffer
		String reverseStr = new StringBuffer(str).reverse().toString();
		System.out.println("Reverse String in Java using String buffer: " + reverseStr);
		
		//iterative method to reverse String in java
		reverseStr = reverse(str);
		System.out.println("Reverse String in Java using Iterative: "+ reverseStr);
		
		//recursive method to reverse string in java
		reverseStr = reverseRecursively(str);
		System.out.println("Reverse styring in java using recursive: "+ reverseStr);
	}

	private static String reverseRecursively(String str) {
		if(str.length() < 2) 
			return str;
		
		return reverseRecursively(str.substring(1))+str.charAt(0);
	}

	private static String reverse(String str) {
		StringBuilder atrBuilder = new StringBuilder();
		char[] strChars = str.toCharArray();
		
		for(int i=strChars.length-1;i>=0;i--){
			atrBuilder.append(strChars[i]);
		}
		return atrBuilder.toString();
	}
}
