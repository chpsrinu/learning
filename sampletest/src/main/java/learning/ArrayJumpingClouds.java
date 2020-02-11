package learning;

public class ArrayJumpingClouds {

	static int jumpingOnClouds(int[] c) {
//        int jump = 0;
//        int i = 0;
//        while (i<c.length-2) {
//            if (c[i+2] == 1 && c[i+1]==0) {
//                i += 1;
//            } else {
//                i += 2;
//            }
//            jump++;
//        }
//        if (i<c.length-1) jump++;
		int count=0;
		for (int i =0 ;i<c.length;i++,count++) {
			if (i<c.length-2 && c[i+2] == 0) i++;
		}
        return count;
    }
	public static void main(String[] args) {
		int[] ar = {0, 0, 1, 0, 0, 1, 0};
		System.out.println(jumpingOnClouds(ar));
	}
}
