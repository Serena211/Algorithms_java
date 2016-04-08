package Class02_Recursion;
/*
 * Given a 2D matrix that contains integers only, which each 
 * row is sorted in an ascending order. The first element of 
 * next row is larger than (or equal to) the last element of 
 * previous row.
 * 
 * Given a target number, returning the position that the target 
 * locates within the matrix. If the target number does not exist 
 * in the matrix, return {-1, -1}.
 * 
 * Assumptions:
 * The given matrix is not null, and has size of N * M, 
 * where N >= 0 and M >= 0.
 * 
 * Examples:
 * matrix = { {1, 2, 3}, {4, 5, 7}, {8, 9, 10} }
 * target = 7, return {1, 2}
 * target = 6, return {-1, -1} to represent the target number does not exist in the matrix.
 * */

public class SearchInSortedMatrix1 {
	public int[] search(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return new int[] {-1, -1};
		}
		int row = matrix.length;
		int col = matrix[0].length;
		return helper(matrix,target, 0, row*col - 1, row, col);
	}
	private int[] helper(int[][] matrix, int target, int left, int right,
			int row, int col) {
		while (left <= right) {
			int mid = left + (right - left) / 2;
			int midX = mid / col;
			int midY = mid % col;
			if(matrix[midX][midY] == target) {
				return new int[] {midX, midY};
			} else if (matrix[midX][midY] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return new int[] {-1, -1};
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
