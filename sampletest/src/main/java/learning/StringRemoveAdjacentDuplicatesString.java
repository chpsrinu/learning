package learning;

public class StringRemoveAdjacentDuplicatesString {

	public static String removeDuplicates(String S) {
		while (true) {
			String s1 = S;
			for (int i = 0; i < s1.length(); i++) {
				int start = i;
				while (i + 1 < s1.length() && s1.charAt(i) == s1.charAt(i + 1)) {
					i++;
				}
				if (start != i) {
					s1 = s1.substring(0, start).concat(s1.substring(i + 1, s1.length()));
				}
			}
			if (S.length() == s1.length()) {
				S = s1;
				break;
			} else {
				S = s1;
			}
		}
		return S;
	}

	// string builder
	public String removeDuplicates2(String S) {

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < S.length(); i++) {
			sb.append(S.charAt(i) + "");
		}

		String result = "";
		while (true) {
			int lengthOld = sb.length();
			for (int i = 0; i < sb.length() - 1; i++) {
				if (sb.charAt(i) == sb.charAt(i + 1)) {
					sb.delete(i, i + 2);
				}
			}
			int lengthNew = sb.length();
			// if no character got deleted, so lengthOld == lengthNew, return
			// the result as a String
			if (lengthOld == lengthNew) {
				return sb.toString();
			}
		}

	}

	public static void main(String[] args) {
		System.out.println(removeDuplicates("abbaca"));
	}
}
