package learning;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringReplace {

	public static void main(String[] args) {
		String a = "aazcvzaaabb";
		String p = "a";
		System.out.println(stringReplace(a,p));
	}

	private static String stringReplace(String a, String pattern) {
		Pattern ptn = Pattern.compile(pattern);
		Matcher mtch = ptn.matcher(a);
		String result = mtch.replaceAll("X");
		StringBuffer sb = new StringBuffer();
		int i=0;
		while(i<result.length()) {
			if(result.charAt(i) == 'X' && i+1<result.length() && result.charAt(i) == result.charAt(i+1)) {
				i++;
			} else {
				sb.append(result.charAt(i));
				i++;
			}
		}
		return sb.toString();
	}
}
