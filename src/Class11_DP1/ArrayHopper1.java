package Class11_DP1;

/*
 * Given an array A of non-negative integers, you are initially positioned at 
 * index 0 of the array. A[i] means the maximum jump distance from that position 
 * (you can only jump towards the end of the array). Determine if you are able 
 * to reach the last index.
 * 
 * Assumptions
 *  The given array is not null and has length of at least 1.
 *  
 *  Examples
 *   {1, 3, 2, 0, 3}, we are able to reach the end of array(jump to index 1 then 
 *   reach the end of the array)
 *   {2, 1, 1, 0, 2}, we are not able to reach the end of array
 */
public class ArrayHopper1 {
	public boolean canJump(int[] array) {
		if (array.length == 1) {
			return true;
		}
		boolean[] dp = new boolean[array.length];
		dp[array.length - 1] = true;
		for (int i = dp.length - 2; i >= 0 ; i--) {
			if (i + array[i] >= array.length - 1) {
				dp[i] = true;
			} else {
				for(int j = array[i]; j > 0; j--) {
					if (dp[i + j]) {
						dp[i] = true;
						break;
					}
				}
			}
		}
		return dp[0];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
