package learning;

public class ArrayCountingValley {

	static int countingValleys(int n, String s) {
        int count=0;
        int result =0;
        for (char c :s.toCharArray()) {
            if (c == 'D') {
                count--;
            } else if (c == 'U') {
                count++;
            }
            //if (result < count) result++;
            if (count == 0 && c == 'U') result++;
        }
        return result;
    }
	public static void main(String[] args) {
		System.out.println(countingValleys(8, "UUDD"));
	}
}
