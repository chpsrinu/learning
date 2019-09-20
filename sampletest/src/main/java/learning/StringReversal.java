package learning;

public class StringReversal {

	
	public static void main(String[] args) {
		System.out.println(reverse("JAIWANTH"));
		System.out.println(reverse("IDYP"));
		System.out.println(reverse("HSERKAHC"));
		System.out.println(reverse("SWATHI"));
	}

	private static String reverse(String str) {
		if (str == null || str.isEmpty())
			return str;
		char[] strChar = str.toCharArray();
		for (int i=0,j=strChar.length-1;i<strChar.length/2;i++,j--) {
			swap(i,j,strChar);
		}
		return new String(strChar);
		
		
	}

	private static void swap(int i, int j, char[] strChar) {
		char temp = strChar[i];
		strChar[i]=strChar[j];
		strChar[j] = temp;
		
	}
}
