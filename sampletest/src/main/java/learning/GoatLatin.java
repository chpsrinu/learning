package learning;

import java.util.ArrayList;
import java.util.List;

public class GoatLatin {

	public static void main(String[] args) {
		System.out.println(getGoatLatin("I speak Goat Latin"));
	}

	private static String getGoatLatin(String string) {
		List<Character> list = new ArrayList<>();
		list.add('a');
		list.add('e');
		list.add('i');
		list.add('o');
		list.add('u');
		list.add('A');
		list.add('E');
		list.add('I');
		list.add('O');
		list.add('U');
		int t=1;
		StringBuilder ans = new StringBuilder();
		for(String word: string.split(" ")) {
			char first = word.charAt(0);
			if(list.contains(first)) {
				ans.append(word);
			} else {
				ans.append(word.substring(1));
				ans.append(first);
			}
			ans.append("ma");
			for(int i=0;i<t;i++) {
				ans.append('a');
			}
			t++;
			ans.append(" ");
		}
		ans.deleteCharAt(ans.length()-1);
		return ans.toString();
	}
}
