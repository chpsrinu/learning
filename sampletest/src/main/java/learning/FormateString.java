package learning;

public class FormateString {

	public static String solution(String format, String[] replacements) {
		// Type your solution here
		String[] split = format.split(" ");
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < split.length; i++) {
			if (split[i].charAt(0) == '{') {
				split[i] = replaceString(split[i], replacements);
			}
			if(split[i] == "") return "";
			sb.append(split[i]);
			sb.append(" ");
		}
		return sb.toString().trim();
	}

	public static String replaceString(String word, String[] replacements) {
		int count = 1;
		while(true) {
			if(word.charAt(count) == '{') {
				count++;
			} else {
				break;
			}
		}
		int index = Character.digit(word.charAt(count),10);
		
		if(index == -1) return "";
		int n = count%2;
		StringBuffer sb = new StringBuffer();
		while(n!=0) {
			sb.append('{');
			n--;
		}
		sb.append(replacements[index]);
		return sb.toString();
	}

	public static void main(String[] args) {
		String str = "A {{{0}} {2}} with {0} {1}.";
		String[] rep = {"fun", "activities", "party"};
		System.out.println(solution(str, rep));
	}
}
