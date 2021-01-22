package NumOfIslands;

public class App {
	public static void main(String[] args) {
		int[][] nums = {{1,1,1,1,0},{1,1,0,1,0},{1,1,0,0,0},{0,0,0,0,0}};
		int[][] nums2 = {{1,1,0,0,0},
						{1,1,0,0,0},
						{0,0,1,0,0},
						{0,0,0,1,1}};
		int[][] nums3 = {{1,0,0,0,0,0,0},{0,1,0,0,0,0,0},{0,0,1,0,0,0,0},{0,0,0,1,0,0,0},{0,0,0,0,1,0,0},{0,0,0,0,0,1,0},{0,0,0,0,0,0,1}};
		NumOfIsland island = new NumOfIsland();
		//System.out.println(island.numOfIsland(nums));
		//System.out.println(island.numOfIsland(nums3));
		System.out.println(island.numOfIsland(nums2));
	}
}
