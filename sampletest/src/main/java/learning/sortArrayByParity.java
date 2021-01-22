package learning;

public class sortArrayByParity {

	public static void main(String[] args) {
		int[] num = {3,1,2,4};
		System.out.println(sortArrayByParity(num));
	}
	public static int[] sortArrayByParity(int[] A) {
		int i=0,j=A.length-1;
		while(i<A.length && i<j) {
			if(A[i]%2==0) {
				i++;
			} else {
				swap(A,i,j);
				j--;
			}
		}
		return A;
    }
	
	private static void swap(int[] A, int i, int j) {
		int temp = A[j];
		A[j] = A[i];
		A[i] = temp;
	}
}
