import java.util.ArrayList;
import java.util.List;

public class ArrayReductor {

	public static void main(String[] args) {
//		List<Integer> a = new ArrayList<Integer>();
//		List<Integer> b = new ArrayList<Integer>();
//		a.add(3);
//		a.add(1);
//		a.add(5);
//		b.add(5);
//		b.add(6);
//		b.add(7);
//		System.out.println(comparatorValue(a, b, 2));
		List<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(1);
		a.add(1);
		a.add(1);
		a.add(1);
		a.add(1);
		a.add(1);
		a.add(1);
		a.add(1);
		a.add(1);
		System.out.println(minSum(a, 50));
	}
	
	public static int comparatorValue(List<Integer> a, List<Integer> b, int d) {
        int result = 0;
        for ( int x : a) {
        	int count = 0;
            for (int j : b) {
                int val = Math.abs(x-j);
                if(val<=d) {
                    break;
                }
                count++;
                
            }
            if (count==b.size()) result++;
        }
        return result;
    }
	
	public static int minSum(List<Integer> num, int k) {
	    // Write your code here
	    double[] arr = new double[num.size()];
	    int count =0 ;
	    while(k!=0) {
	        if(count<num.size()) {
	        	num.set(count, (int)Math.ceil((double)num.get(count)/2));
	        	count++;
	        } else {
	            count=0;
	            num.set(count, (int)Math.ceil((double)num.get(count)/2));
	        }
	        k--;
	    }
	    int result=0;
	    for(int i =0;i<num.size();i++) {
	        result += num.get(i);
	    }
	    return result;
	    }
}
