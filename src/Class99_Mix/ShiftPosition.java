package Class99_Mix;

/*
 * Given an integer array A, A is sorted in ascending order first then shifted by an 
 * arbitrary number of positions, For Example, A = {3, 4, 5, 1, 2} (shifted left by 
 * 2 positions). Find the index of the smallest number.
 * 
 * Assumptions
 * There are no duplicate elements in the array
 * 
 * Examples
 * A = {3, 4, 5, 1, 2}, return 3
 * A = {1, 2, 3, 4, 5}, return 0
 * 
 * Corner Cases
 * What if A is null or A is of zero length? We should return -1 in this case.
 */

public class ShiftPosition {
	public int shiftPosition(int[] array) {
		if (array == null || array.length == 0) {
			return -1;
		}
		return smallest(array, 0, 0, array.length - 1);
	}

	private int smallest(int[] array, int min, int l, int r) {
		if (l > r) {
			return min;
		}
		int mid = l + (r - l) / 2;

		if (array[mid] >= array[l]) {
			if (array[l] < array[min]) {
				min = l;
			}
			return smallest(array, min, mid + 1, r);
		} else if (array[mid] < array[r]) {
			if (array[mid] < array[min]) {
				min = mid;
			}
			return smallest(array, min, l, mid - 1);
		} 
		return min;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShiftPosition sol = new ShiftPosition();
		int[] array = new int[]{1,5,6,7,0,0,0};
		System.out.println(sol.shiftPosition(array));
	}

}
