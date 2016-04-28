package Class15_DP3;

/*
 * Given an array containing only 0s and 1s, find the length of the longest subarray 
 * of consecutive 1s.
 * 
 * Assumptions
 * The given array is not null
 * 
 * Examples
 * {0, 1, 0, 1, 1, 1, 0}, the longest consecutive 1s is 3.
 */
public class LongestConsecutive1s {
	public int longest(int[] array) {
		if (array == null || array.length == 0) {
			return 0;
		}
		// base case: only have one element
		int[] M = new int[array.length];
		M[0] = array[0];
		int rsl = M[0];
		// induction rule: 
		// M[i] represents the longest consecutive 1s from 0-th to i-th elements (include i)
		for (int i = 1; i < array.length; i++) {
			if (M[i - 1] == 0) {
				M[i] = array[i];
			} else {
				if (array[i] == 1) {
					M[i] = M[i - 1] + 1;
				} else {
					M[i] = 0;
				}
			}
			rsl = Math.max(rsl, M[i]);
		}
		return rsl;
	}

	public int longestDP(int[] array) {
		if (array == null || array.length == 0) {
			return 0;
		}
		int globalMax = 0;
		int localMax = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == 1) {
				if (i == 0 || array[i - 1] == 0) {
					localMax = 1;
				} else {
					localMax++;
				}
				globalMax = Math.max(globalMax, localMax);
			}
			
		}
		return globalMax;
	}

	public static void main(String[] args) {
		LongestConsecutive1s sol = new LongestConsecutive1s();
		int[] array = new int[] { 0, 1, 1,1, 0, 1, 1, 1, 0 };
		System.out.println(sol.longestDP(array));
	}

}
