package BoyerMoore;

public class App {

	public static void main(String[] args) {
		String text = "My name is joe!";
		String pattern = "ame";
		
		BoyerMoore boyerMoore = new BoyerMoore(text, pattern);
		boyerMoore.precomputeShifts();
		System.out.println(boyerMoore.search());
	}
}
