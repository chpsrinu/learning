package learning;

public class StringDivideEqual {

	public static void main(String[] args) {
		String str = "chakresh";
		divideStr(str,4);
	}
	
	private static  void divideStr(String s, int n) {
		int size = s.length();
		if (size % n != 0) return ;
		
		int parts = size/n;
		for (int i=0;i<size;) {
			System.out.println("output : "+ s.substring(i,i+parts));
			i += parts;
		}
	}
}
