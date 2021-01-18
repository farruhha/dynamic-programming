package easy;

public class MaxSubArray {

    /**Optimal solutions, brute force solution would be to check all subarrays*/
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = nums[0];
        for(int index = 1; index < nums.length; index++){
            sum = Math.max(sum + nums[index], nums[index]);
            max = Math.max(sum, max);
        }
        return max;
    }
}
