package Class15_DP3;

/*
 * Given an unsorted integer array, find the subarray that has the greatest sum. 
 * Return the sum.
 * 
 * Assumptions
 * The given array is not null and has length of at least 1.
 * 
 * Examples
 * {2, -1, 4, -2, 1}, the largest subarray sum is 2 + (-1) + 4 = 5
 * {-2, -1, -3}, the largest subarray sum is -1
 */

public class LargestSubArraySum {
	public int largestSum(int[] array) {
		if (array == null || array.length == 0) {
			return 0;
		}
		// Induction rule: M[i] represents the local sum at i-th index
		int largestSum = array[0];
		int[] M = new int[array.length];
		// base case: array only have one element
		M[0] = array[0];
		for (int i = 1; i < array.length; i++) {
			if (M[i - 1] > 0) {
				M[i] = M[i - 1] + array[i];
			} else {
				M[i] = array[i];
			}
			largestSum = Math.max(largestSum, M[i]);
		}
		return largestSum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
