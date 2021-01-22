package learning;

public class PerformeStringShift {

	public static String stringShift(String s, int[][] shift) {
	       char[] c = s.toCharArray();
	       for(int i =0;i<shift.length;i++) {
	           if(shift[i][0] == 0) {
	               c = swapLeft(c,shift[i][1]);
	           } else {
	               c = swapRight(c,shift[i][1]);
	           }
	       }
	        return String.valueOf(c);
	    }
	    
	    public static char[] swapLeft(char[] c, int k) {
	        while(k!=0){
	            char c1 = c[0];
	            for(int i=1;i<c.length;i++) {
	                c[i-1]=c[i];
	            }
	            c[c.length-1] = c1;
	            k--;
	        }
	        return c;
	    }
	    
	    public static char[] swapRight(char[] c, int k) {
	        while(k!=0){
	            char c1 = c[c.length-1];
	            for(int i=c.length-1;i>0;i--) {
	                c[i]=c[i-1];
	            }
	            c[0] = c1;
	            k--;
	        }
	        return c;
	    }
	    
	    public static void main(String[] args) {
			String s = "abc";
			int[][] x = {{0,1},{1,2}};
			System.out.println(stringShift(s, x));
		}
}
