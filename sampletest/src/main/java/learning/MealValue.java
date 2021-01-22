package learning;

import java.util.HashSet;
import java.util.Set;

public class MealValue {

	public static long solution(long[][] meals, long k) {
        // Type your solution here
      long result = 0;
      Set<Long> set = new HashSet<>();
      //long[] days = new long[(int) k];
      for(int i =0;i<meals.length;i++) {
        long mealValue = 0;
        long bestDay = 0;
        for(int j=0;j<meals[0].length;j++) {
          if(mealValue < meals[i][j] && !set.contains((long)j)) {
            mealValue = meals[i][j];
            bestDay = j;
          }
        }
        result += mealValue;
        set.add(bestDay);
    }
      return result;
    }
	
	public static void main(String[] args) {
		long[][] meals ={{1, 2, 3}, {5, 1, 2}, {9, 8, 6}};
		System.out.println(solution(meals, 3));
	}
}
