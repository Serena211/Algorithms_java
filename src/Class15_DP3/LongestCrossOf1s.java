package Class15_DP3;

/*
 * Given a matrix that contains only 1s and 0s, find the largest cross which 
 * contains only 1s, with the same arm lengths and the four arms joining at 
 * the central point.
 * 
 * Return the arm length of the largest cross.
 * 
 * Assumptions
 * The given matrix is not null, has size of N * M, N >= 0 and M >= 0.
 */

public class LongestCrossOf1s {
	public int largest(int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int row = matrix.length;
		int col = matrix[0].length;
		int[][] leftToRight = lf(matrix, row, col);
		int[][] topToBottom = tb(matrix, row, col);
		int[][] rightToLeft = rl(matrix, row, col);
		int[][] bottomToTop = bt(matrix, row, col);
		int[][] M = new int[row][col];
		int largest = 0;
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
//				if (r == 0 || c == 0) {
//					M[r][c] = matrix[r][c];
//				} else {
					M[r][c] = Math.min(Math.min(leftToRight[r][c], topToBottom[r][c]), 
							Math.min(rightToLeft[r][c], bottomToTop[r][c]));
//				}
				largest = Math.max(largest, M[r][c]);
			}
		}
		return largest;
	}

	private int[][] bt(int[][] matrix, int row, int col) {
		int[][] rsl = new int[row][col];
		for (int c = 0; c < col; c++) {
			rsl[row - 1][c] = matrix[row - 1][c];
			for (int r = row - 2; r >= 0; r--) {
				if (rsl[r + 1][c] == 0) {
					rsl[r][c] = matrix[r][c];
				} else {
					rsl[r][c] = matrix[r][c] == 1? rsl[r + 1][c] + 1 : 0;
				}
			}
		}
		return rsl;
	}

	private int[][] rl(int[][] matrix, int row, int col) {
		int[][] rsl = new int[row][col];
		for (int r = 0; r < row; r++) {
			rsl[r][col - 1] = matrix[r][col - 1];
			for (int c = col - 2; c >= 0; c--) {
				if (rsl[r][c + 1] == 0) {
					rsl[r][c] = matrix[r][c];
				} else {
					rsl[r][c] = matrix[r][c] == 1? rsl[r][c + 1] + 1: 0;
				}
			}
		}
		return rsl;
	}

	private int[][] tb(int[][] matrix, int row, int col) {
		int[][] rsl = new int[row][col];
		for (int c = 0; c < col; c++) {
			rsl[0][c] = matrix[0][c];
			for (int r = 1; r < row; r++) {
				if (rsl[r - 1][c] == 0) {
					rsl[r][c] = matrix[r][c];
				} else {
					rsl[r][c] = matrix[r][c] == 1? rsl[r - 1][c] + 1: 0;
				}
			}
		}
		return rsl;
	}

	private int[][] lf(int[][] matrix, int row, int col) {
		int[][] rsl = new int[row][col];
		for (int r = 0; r < row; r++) {
			rsl[r][0] = matrix[r][0];
			for (int c = 1; c < col; c++) {
				if (rsl[r][c - 1] == 0) {
					rsl[r][c] = matrix[r][c];
				} else {
					rsl[r][c] = matrix[r][c] == 1? rsl[r][c - 1] + 1: 0;
				}
			}
		}
		return rsl;
	}

	public static void main(String[] args) {
		LongestCrossOf1s sol = new LongestCrossOf1s();
		
		int[][] matrix = new int[][]{{1,1,1,1,1},{1,0,0,1,1},{1,1,1,1,1},{1,1,1,1,0},{0,0,0,1,1}};
		System.out.println(sol.largest(matrix));
	}

}
