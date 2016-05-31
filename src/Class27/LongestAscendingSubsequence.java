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
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
