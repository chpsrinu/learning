package learning;

import java.util.Stack;

//https://leetcode.com/problems/decode-string/discuss/926113/Java-2-Stack-Solution-with-Explanation-(Beats-100-)
public class StringDecode {

	public static String decodeString(String s) {
		StringBuilder sb = new StringBuilder();
		
		Stack<String> st = new Stack<>();
		Stack<Integer> number = new Stack<>();
		
		int i=0;
		while(i<s.length()) {
			int count=0;
			
			while(Character.isDigit(s.charAt(i))) {
				count = count*10+s.charAt(i)-'0';
				i++;
			}
			if (count!=0) number.push(count);
			if(s.charAt(i)==']') {
				StringBuilder in = new StringBuilder();
				
				while(!st.isEmpty() && !st.peek().equals("[")) {
					in.append(st.pop());
				}
				st.pop();
				int multiper = number.pop();
				String inter = in.toString();
				in = new StringBuilder();
				while(multiper>0) {
					in.append(inter);
					multiper--;
				}
				st.push(in.toString());
			} else {
				st.push(String.valueOf(s.charAt(i)));
			}
			i++;
		}
		
		sb= new StringBuilder();
		while(!st.isEmpty()) {
			sb.append(st.pop());	
		}
		
		return sb.reverse().toString();
	}
	
	public static void main(String[] args) {
		String s1 = "3[a]2[bc]";
		String s2 = "3[a2[c]]";
		String s3 = "2[abc]3[cd]ef";
		System.out.println(decodeString(s2));
	}
}
