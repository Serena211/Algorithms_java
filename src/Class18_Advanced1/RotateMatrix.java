package Class18_Advanced1;

import java.util.Arrays;

/*
 * Rotate an N * N matrix clockwise 90 degrees.
 * 
 * Assumptions
 * The matrix is not null and N >= 0
 */

public class RotateMatrix {
	public void rotate(int[][] matrix) {
		if (matrix.length <= 1) {
			return;
		}
		int N = matrix.length;
		transpose(matrix, N);
		System.out.println(Arrays.deepToString(matrix));
		mirrorRow(matrix, N);
		System.out.println(Arrays.deepToString(matrix));

	}

	private void mirrorRow(int[][] matrix, int N) {
		// TODO Auto-generated method stub
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N / 2; j++) {
				swap(matrix, i, j, i, N - 1 - j);

			}
		}
	}

	private void transpose(int[][] matrix, int N) {
		// TODO Auto-generated method stub
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i < j) {
					swap(matrix, i, j, j, i);
				}
			}
		}
	}

	private void swap(int[][] matrix, int i, int j, int i2, int j2) {
		// TODO Auto-generated method stub
		int temp = matrix[i][j];
		matrix[i][j] = matrix[i2][j2];
		matrix[i2][j2] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RotateMatrix sol = new RotateMatrix();
		int[][] matrix = new int[][] { { 1, 2, 3 }, { 5, 6, 7 }, { 9, 10, 11 } };
		sol.rotate(matrix);
		System.out.println(Arrays.deepToString(matrix));
	}

}
