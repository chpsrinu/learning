package learning;

public class StringReduce {

	static String superReducedString(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<s.length();i++) {
            int count =1;
            while (i+1<s.length() && s.charAt(i) == s.charAt(i+1)) {
                count++;
                i++;
            }
            if (count ==2) continue;
            if (count >2 || count ==1) {
                sb.append(s.charAt(i));
            } 
        }
        
        return sb.length()>1?sb.toString(): "";
    }
	
	public static void main(String[] args) {
		System.out.println(superReducedString("aa"));
	}
}
