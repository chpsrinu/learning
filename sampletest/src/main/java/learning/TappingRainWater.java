package learning;

public class TappingRainWater {

	public static void main(String[] args) {
		int arr[] = {0, 1, 2};
		System.out.println(getMaxRainWaterBetweenTowers(arr));
	}
	
	private static int getMaxRainWaterBetweenTowers(int[] towerHeight) {
		int[] maxSeenSoFarFromRight = new int[towerHeight.length];
		maxSeenSoFarFromRight[towerHeight.length-1] = towerHeight[towerHeight.length-1];
		for (int i = towerHeight.length-2; i >=0; i--) {
			maxSeenSoFarFromRight[i] = Math.max(maxSeenSoFarFromRight[i+1], towerHeight[i]);
		}
		
		int totalWaterCollected = 0;
		
		int maxSeenSoFarFromLeft = 0;
		for (int i=0;i<towerHeight.length;i++) {
			if (maxSeenSoFarFromLeft < towerHeight[i]) {
				maxSeenSoFarFromLeft = towerHeight[i];
			}
			int minFromLeftRight = Math.min(maxSeenSoFarFromLeft, maxSeenSoFarFromRight[i]);
			totalWaterCollected += (minFromLeftRight-towerHeight[i]);
		}
		return totalWaterCollected;
		
	}
}
