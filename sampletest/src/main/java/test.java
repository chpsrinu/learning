
public class test {
	public static void main(String[] args) {
		System.out.println(addDigits(19));
	}

	public static int addDigits(int num) {
		int result;
		while (true) {
			result = 0;
			while (num != 0) {
				int n = num % 10;
				result += n;
				num = num/10;
			}
			if (result < 10)
				break;
			num = result;
		}
		return result;
	}
}
