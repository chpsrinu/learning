package learning;

import java.util.HashSet;
import java.util.Set;

public class CardFlipping {

	public int flipGame(int[] fronts, int[] backs) {
		Set<Integer> same = new HashSet<>();
		
		for (int i =0;i<fronts.length;i++) {
			if (fronts[i] == backs[i]) {
				same.add(fronts[i]);
			}
		}
		
		int ans = 9999;
		for (int x : fronts) {
			if (!same.contains(x)) {
				ans = Math.min(ans, x);
			}
		}
		
		for (int y : backs) {
			if(!same.contains(y)) {
				ans = Math.min(ans, y);
			}
		}
		return ans%9999;
	}
}
