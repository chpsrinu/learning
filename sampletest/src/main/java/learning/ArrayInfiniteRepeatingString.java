package learning;

import sun.applet.Main;

public class ArrayInfiniteRepeatingString {

	// Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        if (s.length() == 0 || s.length() > n) return 0;
        if (s.length() ==1)return n;
        int count = 0;
        //int pointer = s.length();
        for (char c: s.toCharArray()) {
            if(c=='a') {
                count++;
            }
        }
        int modCount = (int) (n%s.length());
        int reminderCount = (int) (n/s.length());
        if(reminderCount >0) {
            count = count*reminderCount;
            //pointer = pointer*reminderCount;
        }
        if (modCount > 0) {
            for (int i =0;i<modCount;i++) {
                if (s.charAt(i)=='a') {
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
		System.out.println(repeatedString("bbbba1", 10));
		
	}
}
