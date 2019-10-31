package learning;

public class SpiralMatrix {

	public static void main(String[] args) {
		spiralMatrix(4);
	}
	
	public static void spiralMatrix(int x) {
		int total = x*x;
		while (x == 0) {
			int[] array = new int[x];
			for (int i=0;i<=x;i++) {
				array[i] =total;
			}
		}
		
	}
}
