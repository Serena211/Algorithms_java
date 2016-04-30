package Class12_DP2;

/*
 * Determine the largest square of 1s in a binary matrix (a binary matrix only 
 * contains 0 and 1), return the length of the largest square.
 * 
 * Assumptions
 * The given matrix is not null and guaranteed to be of size N * N, N >= 0
 */

public class largestSquareOf1s {
	public int largest(int[][] matrix) {
		if (matrix.length == 0) {
			return 0;
		}
		int N = matrix.length;
		// induction rule: M[i][j] represents the largest 1s square which bottomright corner is (i,j)
		int[][] M = new int[N][N];
		int largest = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == 0 || j == 0) {
					M[i][j] = matrix[i][j];
				} else {
					M[i][j] = matrix[i][j] == 0 ? 0 : 
						1 + Math.min(M[i - 1][j - 1], Math.min(M[i - 1][j], M[i][j - 1]));
				}
				largest = Math.max(largest, M[i][j]);
			}
		}
		return largest;
	}

	public static void main(String[] args) {
		largestSquareOf1s sol = new largestSquareOf1s();
		int[][] matrix = new int[][]{{1,1,1,1,1},
									{1,0,1,1,1},
									{1,1,1,1,1},
									{1,1,1,1,0},
									{0,0,0,1,1}};
		System.out.println(sol.largest(matrix));
	}
}
