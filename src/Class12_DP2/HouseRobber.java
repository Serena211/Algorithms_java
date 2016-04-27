package Class12_DP2;
/*
 * You are a professional robber planning to rob houses along a street. Each house has a 
 * certain amount of money stashed, the only constraint stopping you from robbing each of 
 * them is that adjacent houses have security system connected and it will automatically 
 * contact the police if two adjacent houses were broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of each house, 
 * determine the maximum amount of money you can rob tonight without alerting the police.
 */
public class HouseRobber {	
    public int rob(int[] nums) {
        // Induction rule: dp[i] means the max money at i-th index of nums without adjacent number
    	// dp[i] = Math.max(nums[i] + dp[i-2], dp[i - 1])
    	if (nums == null || nums.length == 0) {
    		return 0;
    	}
    	if (nums.length == 1) {
    		return nums[0];
    	}
    	if (nums.length == 2) {
    		return Math.max(nums[0], nums[1]);
    	}
    	int[] M = new int[nums.length];
    	// base case:
    	M[0] = nums[0];
    	M[1] = Math.max(nums[0], nums[1]);
    	for (int i = 2; i < M.length; i++) {
			M[i] = Math.max(nums[i] + M[i - 2], M[i - 1]);
		}
    	return M[nums.length - 1];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HouseRobber sol = new HouseRobber();
		int[] nums = new int[]{5,2,3};
		System.out.println(sol.rob(nums));
	}
}
