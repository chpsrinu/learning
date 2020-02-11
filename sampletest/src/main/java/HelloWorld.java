import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class HelloWorld {

	public static void main(String[] args) {
		
		System.out.println(sampleEnum.WhoisRIR.AFRINIC.url());
		
		String[] str = "a##c".split("#");
		System.out.println("a##c".indexOf('#'));
		Arrays.stream(str).forEach(System.out::println);
//		System.out.println("Hello!!!");
//		List<String> l1 = new ArrayList<String>();
//		List<String> l2 = new ArrayList<>();
//		
//		l1.add("pydi");
//		l2.add("swathi");
//		
//		l1.add("swathi");
//		l2.add("pydi");
//		
//		Collections.sort(l1);
//		Collections.sort(l2);
//		
//		System.out.println(l1.equals(l2));
		
//		System.out.println(123/10);
//		System.out.println(123%10);
//		int[] arr = {10, 20, 30, 40, 50};
//		System.out.println(new Random().nextInt(arr.length));
//		int A = 123456;
//		int target=0;
//		int n;
//		List<Integer> list = new ArrayList<>();
//		List<Integer> outputList = new ArrayList<>();
//		while(A!= 0) {
//			//n = i/10;
//			list.add(A%10);
//			A = A/10;
//		}
//		int j;
//		for(j=0;j<(list.size()-1)/2;j++) {
//			outputList.add(list.get(list.size()-1-j));
//			outputList.add((list.get(j)));
//		}
//		if(list.size()%2 !=0){
//			outputList.add((list.get(j)));
//		} else{
//			outputList.add(list.get(j+1));
//			outputList.add(list.get(j));
//		}
//		for (int l : outputList) {
//			target = (target*10)+l;
//		}
//		System.out.println(target);
//		SnapshotArray ss = new SnapshotArray(3);
//		ss.set(0, 5);
//		ss.snap();
//		ss.set(0, 6);
//		System.out.println(ss.get(0, 0));
		String test = "pydi";
//		int[] A = {1, 12, 42, 70, 36 , -1, 43, 15};
//		int[] B = {5, 15, 44, 72, 36, 2, 69, 24};
//		//int[] T = {2, -3,3,1,10,8,2,5,13,-5,3,-18};
//		int[] T = {2,1,1,10,2,13,3,-8};
//		System.out.println(solution(T));
		StringBuffer sb = new StringBuffer();
		int k = 3;
		String s = "abc";
        for (int i =0;i<s.length();i++) {
            int charInt = s.charAt(i);
            char c = (char) (charInt+k);
            sb.append(c);
        }
        System.out.println(sb.toString());
	}
	public static int solution(int[] A, int[] B) {
		int counter =0;
		for (int i=0;i<B.length-1;i++) {
			for(int j=0;i<A.length-1;j++) {
				if(i != j && B[i] >= A[j] && B[j]>=A[i]) {
					counter++;
					break;
				}
			}
			
		}
		return counter;
	}
	
//	public enum SEASONS {
//		WINTER(0), SPRING(1), SUMMER(2), AUTUMN(3);
//		private String season;
//		SEASONS(String season) {
//			this.season = season;
//		}
//		
//		public String getSeason() {
//			return this.season;
//		}
//		
//	}
	public static  String solution(int[] T) {
		List<String> seasonList = new ArrayList<>();
		seasonList.add("WINTER");
		seasonList.add("SPRINT");
		seasonList.add("SUMMER");
		seasonList.add("AUTUMN");
		String returnSeason = null;
		Map<Integer, int[]> map = new HashMap<>();
		int slot = T.length/4;
		for (int i=0,k=0;i<T.length;) {
			int[] subArray = new int[slot];
			for(int j=0;j<slot;j++) {
				subArray[j] = T[i];
				i++;
			}
			map.put(k, subArray);
			k++;
		}
		
		for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
			Arrays.sort(entry.getValue());
			//Arrays.stream(entry.getValue()).forEach(v->System.out.println(v));
		}
		int MaxValue =0;
		for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
			
			int[] sub = entry.getValue();
			int value = sub[sub.length-1]-sub[0];
			if (MaxValue < value) {
				MaxValue = value;
				returnSeason = seasonList.get(entry.getKey());
			}
		}
		
		return returnSeason;
	}
	
	
	
}
