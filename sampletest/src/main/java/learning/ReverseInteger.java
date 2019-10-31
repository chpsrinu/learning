package learning;

public class ReverseInteger {

	public static void main(String[] args) {
		System.out.println(reverseInt(-123));
	}

	private static int reverseInt(int i) {
		boolean flag = false;
		if(i<0) {
			flag=true;
			i = 0-i;
		}
		int ans = 0;
		while (i!=0) {
			ans = (ans*10)+i%10;
			i = i/10;
		}
		if(flag)
			ans = 0- ans;
		return ans;
	}
}
