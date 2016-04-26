package Class12_DP2;
/*
 * Find the contiguous subarray within an array (containing at least one number) which 
 * has the largest sum.
 * 
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 * the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int largestSum = max;
        for(int i = 1; i < nums.length; i++) {

            largestSum = Math.max(largestSum, Math.max(nums[i] + max, nums[i]));
        }
        return largestSum;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
