package learning;

public class AddBinary {

	public static String addBinary(String a, String b) {
		StringBuilder sb = new StringBuilder();
		int i=a.length()-1,j=b.length()-1, carry=0;
		while(i>=0 || j>=0) {
			int sum = carry; // if there is a carry from the last addition, add it to carry
			if (j>=0) sum += b.charAt(j--)-'0'; // we substract '0' to get the int value of the char from the ascii
			if (i>=0) sum += a.charAt(i--)-'0';
			sb.append(sum%2);
			carry = sum/2;
		}
		if (carry!=0) sb.append(carry);
		return sb.reverse().toString();
	}
	
	public static void main(String[] args) {
		System.out.println(addBinary("11", "1"));
	}
	
}
