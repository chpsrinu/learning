/**
 * TwoSum : TwoSum
 *
 * @author : pydi chowdada (pchowdad@cisco.com)
 * @version : 1.0 (Oct 02, 2018)
 * @since : 1.0 (Oct 02, 2018)
 */
public class TwoSum {
    // Given nums = [2,7,11,15], target = 9, return [0,1] because nums[0]+nums[1] =9
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        twoSums(nums, 9);
    }

    private static int[] twoSums(int[] nums, int target) {
        for(int i=0;i<nums.length; i++) {
            for(int j=i;j<nums.length;j++) {
                if(nums[i] < target && nums[j] < nums[j]) {
                    if(nums[i]+nums[j]==target)
                        return new int[] {i,j};
                }
                break;
            }
        }
        return null;
    }
}
