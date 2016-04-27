package Class12_DP2;

public class HouseRobber2 {
    public int rob(int[] nums) {
        // Induction rule: dp[i] means the max money at i-th index of nums without adjacent number
    	// dp[i] = Math.max(nums[i] + dp[i-2] - nums[0], dp[i - 1])
    	int len = nums.length;
    	if (nums == null || len == 0) {
    		return 0;
    	}
    	if (len == 1) {
    		return nums[0];
    	}
    	if (len == 2) {
    		return Math.max(nums[0], nums[1]);
    	}
    	int[] M = new int[len];
    	int[] N = new int[len];
    	// base case:
    	M[0] = nums[0];
    	M[1] = Math.max(nums[0], nums[1]);
    	N[1] = nums[1];
    	N[2] = Math.max(nums[2], nums[1]);
    	for (int i = 2; i < len; i++) {
			M[i] = Math.max(nums[i] + M[i - 2], M[i - 1]);
    		if (i >= 3) {
    			N[i] = Math.max(nums[i] + N[i - 2], N[i - 1]);
    		}
		}		
    	return Math.max(M[nums.length - 2], N[nums.length - 1]);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HouseRobber2 sol = new HouseRobber2();
		int[] nums = new int[]{1,2,1,1,1,1};
		System.out.println(sol.rob(nums));
	}

}
