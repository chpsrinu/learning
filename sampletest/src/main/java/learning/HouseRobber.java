package learning;

public class HouseRobber {

	public static int rob(int[] nums) {
		int ifRobbedPrevious = 0; //max money can get if rob current house
		int ifDidntRobPrevious = 0; //max money can get if not rob current house
		
		// we go through all the values, we maintain two counts, 1) if we rob this cell, 2) if we didn't rob this cell
		for (int i=0;i<nums.length;i++) {
			// if we rob current cell, previous cell shouldn't be robbed. So, add the current value to previous one.
			int currRobbed = ifDidntRobPrevious + nums[i];
			
			// if we don't rob current cell, then the count should be max of the previous cell robbed and not robbed
			int currNotRobbed = Math.max(ifDidntRobPrevious, ifRobbedPrevious);
			
			//update values for the next round
			ifDidntRobPrevious = currNotRobbed;
			ifRobbedPrevious = currRobbed;
		}
		return Math.max(ifRobbedPrevious, ifDidntRobPrevious);
	}
	public static void main(String[] args) {
		int[] nums = {2,1,1,2};
		System.out.println(rob(nums));
	}
}
