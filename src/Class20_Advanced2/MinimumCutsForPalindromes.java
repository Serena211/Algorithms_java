package Class20_Advanced2;

/*
 * Given a string, a partitioning of the string is a palindrome partitioning if 
 * every substring of the partition is a palindrome. Determine the fewest cuts 
 * needed for a palindrome partitioning of a given string.
 * 
 * Assumptions
 * The given string is not null
 * 
 * Examples
 * “a | babbbab | bab | aba” is a palindrome partitioning of “ababbbabbababa”.
 * The minimum number of cuts needed is 3.
 */
public class MinimumCutsForPalindromes {
	public int minCuts(String input) {
		if (input.length() == 0) {
			return 0;
		}
		char[] str = input.toCharArray();
		int[] minCuts = new int[str.length + 1];
		boolean[][] isPalindrome = new boolean[str.length + 1][str.length + 1];
		// base case: string.length() == 1 ==> minCuts[1] = 0;
		for (int i = 1; i <= str.length; i++) {
			// induction rule: minCuts[i] indicates min cut numbers at (i-1)-th
			// of input
			minCuts[i] = i; // max cutting times
			for (int j = i; j >= 1; j--) {
				if (str[j - 1] == str[i - 1]) {
					isPalindrome[j][i] = i - j < 2
							|| isPalindrome[j + 1][i - 1];
				}
				if (isPalindrome[j][i]) {
					minCuts[i] = Math.min(minCuts[i], 1 + minCuts[j - 1]);
				}
			}
		}
		return minCuts[str.length] - 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumCutsForPalindromes sol = new MinimumCutsForPalindromes();
		System.out.println(sol.minCuts("abbb"));
	}

}
