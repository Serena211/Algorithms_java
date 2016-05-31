package Class27;
/*
 * Given an array A[0]...A[n-1] of integers, find out the length of the longest 
 * ascending subsequence.
 * 
 * Assumptions
 * A is not null
 * 
 * Examples
 * Input: A = {5, 2, 6, 3, 4, 7, 5}
 * Output: 4
 * Because [2, 3, 4, 5] is the longest ascending subsequence.
 */
public class LongestAscendingSubsequence {
	// definition: M[i] represents the longest ascending sub-sequence at A[i]
	// induction rule: M[i] = max(M[i], M[k]) when A[i] > A[k]
	public int longest(int[] array) {
		if (array.length <= 1) {
			return array.length;
		}
		int[] M = new int[array.length + 1];
		M[0] = 0;
		M[1] = 1;
		int longest = 1;
		for (int i = 2; i <= array.length; i++) {
			M[i] = 1;
			for (int k = 1; k < i; k++) {
				if (array[i - 1] > array[k - 1]) {
					M[i] = Math.max(M[i], M[k] + 1);
				}
			}
			longest = Math.max(longest, M[i]);
		}
		return longest;
	}

	public static void main(String[] args) {
		LongestAscendingSubsequence sol = new LongestAscendingSubsequence();
		System.out.println(sol.longest(new int[]{1,5,3,2,6,4,3,2,8,4,9,5,5,3,1,6,4,2,7,6,3,8}));
	}

}
