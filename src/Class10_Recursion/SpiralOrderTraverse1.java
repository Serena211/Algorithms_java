package Class10_Recursion;

import java.util.ArrayList;
import java.util.List;

/*
 * Traverse an N * N 2D array in spiral order clock-wise starting from the top 
 * left corner. Return the list of traversal sequence.
 * 
 * Assumptions
 * The 2D array is not null and has size of N * N where N >= 0
 * 
 * Examples
		
		 { {1,  2,  3},
		
		 {4,  5,  6},
		
		 {7,  8,  9} }
		
		 the traversal sequence is [1, 2, 3, 6, 9, 8, 7, 4, 5]
 */

public class SpiralOrderTraverse1 {
	public List<Integer> spiral(int[][] matrix) {
		List<Integer> rsl = new ArrayList<Integer>();
		if (matrix.length == 0) {
			return rsl;
		}

		int size = matrix.length;
		helper(rsl, 0, size, matrix);
		return rsl;
	}

	private void helper(List<Integer> rsl, int offset, int size, int[][] matrix) {
		// TODO Auto-generated method stub
		if (size == 0) {
			return;
		}
		if (size == 1) {
			rsl.add(matrix[offset][offset]);
			return;
		}
		// top row left to right
		for (int i = 0; i < size - 1; i++) {
			rsl.add(matrix[offset][offset + i]);
		}
		// rightmost col up to down
		for (int i = 0; i < size - 1; i++) {
			rsl.add(matrix[offset + i][offset + size - 1]);
		}
		// bottom row right to left 
		for (int i = 0; i < size - 1; i++) {
			rsl.add(matrix[offset+ size - 1][offset + size - 1 - i]);
		}
		// leftmost col down to up
		for (int i = 0; i < size - 1; i++) {
			rsl.add(matrix[offset+ size - 1 - i][offset]);
		}
		helper(rsl, offset + 1, size - 2, matrix);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpiralOrderTraverse1 sol = new SpiralOrderTraverse1();
		System.out.println();
	}

}
