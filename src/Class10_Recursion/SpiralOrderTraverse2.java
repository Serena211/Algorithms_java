package Class10_Recursion;

import java.util.ArrayList;
import java.util.List;

/*
 * Traverse an M * N 2D array in spiral order clock-wise starting from the top 
 * left corner. Return the list of traversal sequence.
 * 
 * Assumptions
 * The 2D array is not null and has size of M * N where M, N >= 0
 * 
 * Examples
		{ {1,  2,  3,  4},
		
		  {5,  6,  7,  8},
		
		  {9, 10, 11, 12} }
		
		the traversal sequence is [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
 */
public class SpiralOrderTraverse2 {
	public List<Integer> spiral(int[][] matrix) {
		List<Integer> rsl = new ArrayList<Integer>();
		int row = matrix.length;
		if (row == 0) {
			return rsl;
		}
		int col = matrix[0].length;
		if (col == 0) {
			return rsl;
		}
		int offset = 0;
		helper(matrix,rsl,col,row,offset);
		return rsl;
	}

	private void helper(int[][] matrix, List<Integer> rsl, int col, int row, int offset) {
		// base case:
		if (row == 0 && col == 0) {
			return;
		}
		if (row == 1) {
			for (int i = 0; i < col; i++) {
				rsl.add(matrix[offset][offset + i]);
			}
			return;
		}
		if (col == 1) {
			for (int i = 0; i < row; i++) {
				rsl.add(matrix[offset + i][offset]);
			}
			return;
		}
		// recursion rules;
		for (int i = 0; i < col - 1; i++) {
			rsl.add(matrix[offset][offset + i]);
		}
		for (int i = 0; i < row - 1; i++) {
			rsl.add(matrix[offset + i][offset + col - 1]);
		}
		for (int i = 0; i < col - 1; i++) {
			rsl.add(matrix[offset + row - 1][offset + col - 1 - i]);
		}
		for (int i = 0; i < row - 1; i++) {
			rsl.add(matrix[offset + row - 1 - i][offset]);
		}
		helper(matrix, rsl, col - 2, row - 2, offset + 1);
	}

	public static void main(String[] args) {
		SpiralOrderTraverse2 sol = new SpiralOrderTraverse2();
		int[][] m = new int[][]{{1},{2},{3}};
		System.out.println(sol.spiral(m));
	}

}
