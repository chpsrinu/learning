package learning;

public class IntegerToWord {
	private final static String[] LV1={"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	private final static String[] LV2={"", "", "Twenty", "Thirty", "Forty","Fifty", "Sixty","Seventy", "Eighty","Ninety"};
	private final static String[] LV3={"", "Thousand", "Million","Billion"};
	
	public static String numberToWord(int num) {
		if (num ==0) return "Zero";
		StringBuilder sb = new StringBuilder();
		int comma = 0;
		int cur = num;
		
		while(cur != 0){
			int n = cur%1000;
			cur = cur / 1000;
			String word = helper(n);
			if (word.length() >0 && comma>0) {
				sb.insert(0, LV3[comma] + " ");
			}
			sb.insert(0, word);
			comma++;
		}
		return sb.toString().trim();
	}
	
	private static String helper(int n) {
		String str = "";
		if(n>99) {
			str +=LV1[n/100];
			str += " Hundred ";
			n%=100;
		}
		if (n>19) {
			str += LV2[n/10] + " ";
			n%=10;
		}
		if (n>0) {
			str += LV1[n] + " ";
		}
		return str;
	}
	public static void main(String[] args) {
		System.out.println(numberToWord(1129496728));
	}
}
