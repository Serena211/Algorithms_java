package Class99_Mix;

/*
 * Given a target integer T and an integer array A, A is sorted in ascending order 
 * first, then shifted by an arbitrary number of positions.
 * 
 * For Example, A = {3, 4, 5, 1, 2} (shifted left by 2 positions). Find the index 
 * i such that A[i] == T or return -1 if there is no such index.
 * 
 * Assumptions
 * There could be duplicate elements in the array.
 * 
 * ​Corner Cases
 * What if A is null or A is of zero length? We should return -1 in this case.
 */

public class SearchInShiftedSortedArray2 {
	public int search(int[] array, int target) {
		
		if (array == null || array.length == 0) {
			return -1;
		}	
		return helper(array, target, 0, array.length - 1);
	}
	private int helper(int[] array, int target, int l, int r) {
		if (l > r) {
			return -1;
		}
//		while (r < array.length && l >=0 && array[r] == array[l]) {
//			if (array[r] == target) {
//				return r;
//			}
//			l++;
//			r--;
//		}
		int mid = l + (r - l) / 2;
		if (array[mid] == target) {
			return mid;
		} 

		if (array[r] == array[mid] && array[l]== array[mid]) {

			return helper(array, target, l + 1, r - 1);
		} else if (array[mid] >= array[l]) {
			if (target < array[mid] && target >= array[l]) {
				return helper(array, target, l, mid - 1);
			} else {
				return helper(array, target, mid + 1, r);
			}
		} else {
			if (target <= array[r] && target > array[mid]) {
				return helper(array, target, mid + 1, r);
			} else {
				return helper(array, target, l, mid - 1);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchInShiftedSortedArray2 sol = new SearchInShiftedSortedArray2();
		int[] a = new int[]{3,3,3,8,8,9,9,1,3,3,3,3,3,3};
		System.out.println(sol.search(a, 1));
	}

}
