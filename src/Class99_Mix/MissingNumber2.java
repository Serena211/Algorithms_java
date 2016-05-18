package Class99_Mix;

/*
 * Given an integer array of size N - 1 sorted by ascending order, containing all 
 * the numbers from 1 to N except one, find the missing number.
 * 
 * Assumptions
 * The given array is not null, and N >= 1
 * 
 * Examples
 * A = {1, 2, 4}, the missing number is 3
 * A = {1, 2, 3}, the missing number is 4
 * A = {}, the missing number is 1
 */


public class MissingNumber2 {
	// method1: similar like binary search. Find the mid, then judge the missing # at mid left or right. Recursive.
	public int missing(int[] array) {
		// 	N - 1 == array.length
		if (array.length == 0) {
			return 1;
		}
		int[] miss = new int[]{-1};
		helper(array, 0, array.length - 1, miss);
		return miss[0];
	}

	private void helper(int[] array, int l, int r, int[] miss) {
		if (l >= r - 1) {
			if (array[l] == l + 1 && array[r] == r + 2) {
				miss[0] = array[r] - 1;
			} else if (array[l] == l + 2 && array[r] == r + 2) {
				miss[0] = array[l] - 1;
			} else if (array[l] == l + 1 && array[r] == r + 1) {
				miss[0] = array[r] + 1;
			}
			return;
		}
		int mid = l + (r - l) / 2;
		if (array[mid] == mid + 1) {
			helper(array, mid + 1, r, miss); 
		}
		if (array[mid] > mid + 1) {
			helper(array, l, mid - 1, miss);
		}		
	}

	public static void main(String[] args) {
		MissingNumber2 sol = new MissingNumber2();
		System.out.println(sol.missing(new int[]{2,3,4,5,6}));
		System.out.println(sol.missing(new int[]{1,3,4,5,6}));
		System.out.println(sol.missing(new int[]{1,2,4,5,6}));
		System.out.println(sol.missing(new int[]{1,2,3,4,5}));
		System.out.println(sol.missing(new int[]{1,2,3,4,6}));
	}

}
