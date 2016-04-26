package Class12_DP2;
/*
 * Find the contiguous subarray within an array (containing at least one number) which 
 * has the largest product.
 * 
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 */

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int maxProduct = max;
        for (int i = 1; i < nums.length; i++) {
            int curMax = max;
            int curMin = min;
            max = Math.max(Math.max(nums[i]*max, nums[i]), nums[i] * curMin);
            min = Math.min(Math.min(nums[i]*min, nums[i]), nums[i] * curMax);
            maxProduct = Math.max(maxProduct, max);
        }
        return maxProduct;
    }
	public static void main(String[] args) {
		MaximumProductSubarray sol = new MaximumProductSubarray();
		int[] nums = new int[]{0,2,4,-1,-3,-5,10};
		System.out.println(sol.maxProduct(nums));
	}

}
