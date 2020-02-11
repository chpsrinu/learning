package learning;

public class StringCommonChild {

	static int commonChild(String s1, String s2) {
        boolean[] common = new boolean[256];
        java.util.Arrays.fill(common, false);
        int result = 0;
        for (char c : s1.toCharArray()) {
            common[c] = true;
        }
        for (char c : s2.toCharArray()) {
            if (common[c] == true) result++;

        }
        return result;

    }
	
	public static void main(String[] args) {
		System.out.println(commonChild("SHINCHAN", "NOHARAAA"));
	}
}
