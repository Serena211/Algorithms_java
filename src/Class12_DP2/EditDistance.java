package Class12_DP2;

/*
 * Given two strings of alphanumeric characters, determine the minimum number of 
 * Replace, Delete, and Insert operations needed to transform one string into the other.
 * 
 * Assumptions
 * Both strings are not null
 * 
 * Examples
 * string one: “sigh”, string two : “asith”
 * the edit distance between one and two is 2 (one insert “a” at front then replace “g” with “t”).
 */
public class EditDistance {
	public int editDistance(String one, String two) {
		if (one.length() == 0 && two.length() == 0) {
			return 0;
		} else if (one.length() == 0 || two.length() == 0) {
			return one.length() == 0? two.length():one.length();
		}
		int len1 = one.length() + 1;
		int len2 = two.length() + 1;
		int[][] M = new int[len1][len2];
		for (int i = 0; i < len1; i++) {
			for (int j = 0; j < len2; j++) {
				// base case: if one of string is empty, then edit distance equals the length of another string
				if (i == 0) {
					M[i][j] = j;
				} else if (j == 0) {
					M[i][j] = i;
				} else if (one.charAt(i - 1) == two.charAt(j - 1)) {
					M[i][j] = M[i - 1][j - 1];
				} else {
					M[i][j] = 1 + Math.min(Math.min(M[i - 1][j], M[i][j - 1]), M[i - 1][j - 1]);
				}
				
			}
		}
		return M[len1 - 1][len2 - 1];
	}

	public static void main(String[] args) {
		EditDistance sol = new EditDistance();
		System.out.println(sol.editDistance("addadfa4bbcc","abbccc"));
	}

}
