package Class25;

/*
 * Find the length of longest common subsequence of two given strings.
 * 
 * Assumptions
 * The two given strings are not null
 * 
 * Examples
 * S = “abcde”, T = “cbabdfe”, the longest common subsequence of s and t 
 * is {‘a’, ‘b’, ‘d’, ‘e’}, the length is 4.
 */
public class LongestCommonSubsequence {
	public int longest(String s, String t) {
		if (s.length() == 0 || t.length() == 0) {
			return 0;
		}
		int max = 0; 
		int[][] M = new int[t.length()][s.length()];
		// base case: both s and t have one element;
		M[0][0] = t.charAt(0) == s.charAt(0) ? 1 : 0;
		
		// induction rule: M[i][j] indicates the 0-i-th of t and 0-j-th of s string, 
		//				   the longest common subsequence size
		for (int i = 0; i < t.length(); i++) {
			for (int j = 0; j < s.length(); j++) {
				if (i == 0 && j > 0 ) {
					M[i][j] = t.charAt(i) == s.charAt(j) ? 1 : M[i][j - 1];
				} else if (j == 0 && i > 0) {
					M[i][j] = t.charAt(i) == s.charAt(j) ? 1 : M[i - 1][j];
				} 
				if (i != 0 && j != 0){
					M[i][j] = t.charAt(i) == s.charAt(j) ? 1 + M[i - 1][j - 1]: Math.max(M[i][j - 1], M[i - 1][j]);
				}
				max = Math.max(max, M[i][j]);
			}
		}

		return max;
	}

	public static void main(String[] args) {
		LongestCommonSubsequence sol = new LongestCommonSubsequence();
		System.out.println(sol.longest("aaaaa", "abbaba"));
	}

}
