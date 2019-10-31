package RunLengthEncoding;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
	
	public static String encode(String source) {
	
		StringBuilder strBuld = new StringBuilder();
		
		for (int i=0;i<source.length();i++) {
			int runLength = 1;
			while(i+1<source.length() && source.charAt(i) == source.charAt(i+1)) {
				runLength++;
				i++;
			}
			strBuld.append(runLength);
			strBuld.append(source.charAt(i));
		}
		return strBuld.toString();
	}
	
	public static String decode(String compressedText) {
		StringBuilder strBuilder = new StringBuilder();
		Pattern pattern = Pattern.compile("[0-9]+|[a-zA-Z]");
		Matcher matcher = pattern.matcher(compressedText);
		
		while(matcher.find()) {
			int runLength = Integer.parseInt(matcher.group());
			matcher.find();
			
			while(runLength-- != 0 ) {
				strBuilder.append(matcher.group());
			}
		}
		return strBuilder.toString();
	}
	
	
	public static void main(String[] args) {
		System.out.println(encode("aaabcccc"));
	}

}
