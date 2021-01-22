package learning;

import java.util.ArrayList;
import java.util.List;

public class PrintWordVertically {
	public static void main(String[] args) {
		String s = "TO BE OR NOT TO BE";
		printWordVertically(s).forEach(word -> System.out.println(word));
	}

//	private static List<String> printWordVertically2(String s) {
//		if (s != null && s.length() > 0) {
//			printWords("",s);
//		}
//		return output;
//	}

	private static List<String> printWordVertically(String s) {
		String[] words = s.split(" ");
		int max = 0;
		List<String> listString = new ArrayList<>();
		for (String word : words) {
			max = Math.max(max, word.length());
		}
		
		for (int i =0;i<max;i++) {
			StringBuilder sb = new StringBuilder();
			for (String word : words) {
				if (i<word.length())
					sb.append(word.charAt(i));
				else
					sb.append(" ");
			}
			
			while(sb.charAt(sb.length()-1) == ' ') {
				sb.deleteCharAt(sb.length()-1);
			}
			listString.add(sb.toString());
		}
		return listString;
	}
	
	
}
