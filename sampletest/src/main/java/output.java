import java.util.List;

public class output {

	public static void main(String[] args) {
		
		int[] a ={1};
		output t = new output();
		t.increment(a);
		System.out.println(a[a.length-1]);
//		double d = 10.0/-0;
//		if(d==Double.POSITIVE_INFINITY) {
//			System.out.println("Posi");
//		} else
//			System.out.println("ex");
		//System.out.println(divide(4, 0));
//		try {
//			badMethod();
//			System.out.println("A");
//		} catch (Exception ex) {
//			System.out.println("B");
//		} finally {
//			System.out.println("C");
//		}
//		System.out.println("D");
	}
	
	void increment(int[] i) {
		i[i.length-1]++;
	}

	private static void badMethod() {
		
	}
	
	public static int divide(int a, int b) {
		int c = -1;
		
		try {
			c = a/b;
		} catch(Exception ex) {
			System.err.print("Exception ");
		} finally {
			System.err.println("Finally");
		}
		return c;
	}
	
	public static List<Integer> mergeArrays(List<Integer> a, List<Integer> b) {
	    // Write your code here

	    int i = a.size()-1, j=b.size()-1, k=j+j+1;
	    while(i>=0 && j>=0) {
	     if(a.get(i)>b.get(j)){
	    	 a.set(k--, i--)
	         a.get(k--)=a.get(i--);
	     } else {
	         a.get(k--)= b.get(j--);
	     }
	    }
	    while(j>=0) {
	        a.get(k--)= b.get(j--);
	    } 

	    return a;
	    }
	
	
}
