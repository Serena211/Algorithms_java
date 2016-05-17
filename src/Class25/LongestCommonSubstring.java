package Class25;

/*
 * Find the longest common substring of two given strings.
 * 
 * Assumptions
 * The two given strings are not null
 * 
 * Examples
 * S = “abcde”, T = “cdf”, the longest common substring of S and T is “cd”
 */
public class LongestCommonSubstring {
	public String longestCommon(String s, String t) {
		if (s.length() == 0 || t.length() == 0) {
			return "";
		}
		int[] max = new int[]{-1,-1, -1}; 	// stores the end of longest common substring index and value
		int[][] M = new int[t.length()][s.length()];
		// base case: both s and t have one element;
		M[0][0] = t.charAt(0) == s.charAt(0) ? 1 : 0;
		
		// induction rule: M[i][j] indicates the 0-i-th of t and 0-j-th of s string, 
		//				   the longest common substring size
		for (int i = 0; i < t.length(); i++) {
			for (int j = 0; j < s.length(); j++) {
				if (i == 0 || j == 0) {
					M[i][j] = t.charAt(i) == s.charAt(j) ? 1 : 0;
				} else {
					M[i][j] = t.charAt(i) == s.charAt(j) ? 1 + M[i - 1][j - 1]: 0;
				}
				if (M[i][j] != 0 && M[i][j] > max[2]) {
					max = new int[]{i,j,M[i][j]};
				}
			}
		}
		int fromIdx = max[0] - max[2] + 1;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < max[2]; i++) {
			sb.append(t.charAt(fromIdx++));
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		LongestCommonSubstring sol = new LongestCommonSubstring();
		System.out.println(sol.longestCommon("abcde", "xcdf"));
	}
}
