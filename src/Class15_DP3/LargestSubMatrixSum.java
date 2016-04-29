package Class15_DP3;

/*
 * Given a matrix that contains integers, find the submatrix with the largest sum.
 * Return the sum of the submatrix.
 * 
 * Assumptions
 * The given matrix is not null and has size of M * N, where M >= 1 and N >= 1
 */

public class LargestSubMatrixSum {
	public int largest(int[][] matrix) {
		int M = matrix.length;
		int N = matrix[0].length;
		// step 1: for each column, calculate the sum from 0-th to i-th and store in an new matrix
		int[][] sum = new int[M][N];
		addCol(matrix, sum);
		// step 2: for any two rows of sum[][], calculate the sum of submatrix, and find largest submatrix sum;
		int[] subSum = new int[N];
//		int largest = matrix[0][0];
		int largest = subSum(sum, subSum, matrix[0][0]);
		return largest;
	}

	private int subSum(int[][] sum, int[] subSum, int largest) {
		int row = sum.length;
		int col = sum[0].length;
		for (int r1 = 0; r1 < row; r1++) {
			for (int r2 = r1; r2 < row; r2++) {
				if (r1 == 0) {
					int cur = Integer.MIN_VALUE;
					for (int c = 0; c < col; c++) {
						subSum[c] = sum[r2][c];
//						largest = curLargestSum(subSum[c], largest, cur);
						if (c == 0) {
							cur = subSum[c];
						} else {
							cur = Math.max(subSum[c], cur + subSum[c]);
						}
						largest = Math.max(largest, cur);
					}
//					return largest;
				} else {
					int cur = Integer.MIN_VALUE;
					for (int c = 0; c < col; c++) {
						subSum[c] = sum[r2][c] - sum[r1 - 1][c];
						if (c == 0) {
							cur = subSum[c];
						} else {
							cur = Math.max(subSum[c], cur + subSum[c]);
						}
						largest = Math.max(largest, cur);
					}
//					return largest;
				}
			}
		}
		return largest;
	}



	private void addCol(int[][] matrix, int[][] sum) {
		int row = matrix.length;
		int col = matrix[0].length;
		for (int c = 0; c < col; c++) {
			for (int r = 0; r < row; r++) {
				if ( r == 0) {
					sum[r][c] = matrix[r][c];
				} else {
					sum[r][c] = sum[r - 1][c] + matrix[r][c];
				}
			}
		}
	}

	public static void main(String[] args) {
		LargestSubMatrixSum sol = new LargestSubMatrixSum();
		int[][] matrix = new int[][]{{1},{1},{-4},{5}};
		System.out.println(sol.largest(matrix));
		
	}

}
