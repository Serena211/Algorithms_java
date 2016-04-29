package Class15_DP3;

/*
 * Given a matrix that contains only 1s and 0s, find the largest X shape which 
 * contains only 1s, with the same arm lengths and the four arms joining at the 
 * central point.
 * 
 * Return the arm length of the largest X shape.
 * 
 * Assumptions
 * The given matrix is not null, has size of N * M, N >= 0 and M >= 0.
 */

public class LargestXOf1s {
	public int largest(int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int row = matrix.length;
		int col = matrix[0].length;
		int[][] topLeftToRightBottom = topLeftToRightBottom(matrix, row, col);
		int[][] topRightToLeftBottom = topRightToLeftBottom(matrix, row, col);
		int[][] bottomLeftToTopRight = bottomLeftToTopRight(matrix, row, col);
		int[][] bottomRightToTopLeft = bottomRightToTopLeft(matrix, row, col);

		int[][] M = new int[row][col];
		int largest = 0;
		
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				M[r][c] = Math.min(
						Math.min(topLeftToRightBottom[r][c], topRightToLeftBottom[r][c]),
						Math.min(bottomLeftToTopRight[r][c], bottomRightToTopLeft[r][c]));
				largest = Math.max(largest, M[r][c]);
			}
		}
		return largest;
	}

	private int[][] topRightToLeftBottom(int[][] matrix, int row, int col) {
		int[][] rsl = new int[row][col];
		for (int r = 0; r < row; r++) {
			for (int c = col - 1; c >= 0; c--) {
				if (r == 0 || c == col - 1) {
					rsl[r][c] = matrix[r][c];
				} else {
					if (rsl[r - 1][c + 1] == 0) {
						rsl[r][c] = matrix[r][c];
					} else {
						rsl[r][c] = matrix[r][c] == 1? rsl[r - 1][c + 1] + 1 : 0;
					}
				}
			}
		}
		return rsl;
	}

	private int[][] bottomLeftToTopRight(int[][] matrix, int row, int col) {
		int[][] rsl = new int[row][col];
		for (int r = row - 1; r >= 0; r--) {
			for (int c = 0; c < col; c++) {
				if (r == row -1 || c == 0) {		
					rsl[r][c] = matrix[r][c];
				} else {
					if (rsl[r + 1][c - 1] == 0) {
						rsl[r][c] = matrix[r][c];
					} else {
						rsl[r][c] = matrix[r][c] == 1? rsl[r + 1][c - 1] + 1 : 0;
					}
				}
			}
		}		
		return rsl;
	}

	private int[][] bottomRightToTopLeft(int[][] matrix, int row, int col) {
		int[][] rsl = new int[row][col];
		for (int r = row - 1; r >= 0; r--) {
			for (int c = col - 1; c >= 0; c--) {
				if (r == row -1 || c == col - 1) {
					rsl[r][c] = matrix[r][c];
				} else {
					if (rsl[r + 1][c + 1] == 0) {
						rsl[r][c] = matrix[r][c];
					} else {
						rsl[r][c] = matrix[r][c] == 1? rsl[r + 1][c + 1] + 1 : 0;
					}
				}
			}
		}
		return rsl;
	}

	private int[][] topLeftToRightBottom(int[][] matrix, int row, int col) {
		int[][] rsl = new int[row][col];
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				if (r == 0 || c == 0) {
					rsl[r][c] = matrix[r][c];
				} else {
					if (rsl[r-1][c-1] == 0) {
						rsl[r][c] = matrix[r][c];
					} else {
						rsl[r][c] = matrix[r][c] == 1 ? rsl[r-1][c-1] + 1 : 0;
					}
				}
			}
		}
		return rsl;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LargestXOf1s sol = new LargestXOf1s();
		int[][] matrix = new int[][]{{1,1,1,1,1},{1,0,0,1,1},{1,1,1,1,1},{1,1,1,1,0},{0,0,0,1,1}};
		System.out.println(sol.largest(matrix));
	}

}
