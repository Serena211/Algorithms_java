package Class99_Mix;
/*
 * Given a target integer T and an integer array A, A is sorted in ascending order first, 
 * then shifted by an arbitrary number of positions.
 * 
 * For Example, A = {3, 4, 5, 1, 2} (shifted left by 2 positions). Find the index i such 
 * that A[i] == T or return -1 if there is no such index.
 * 
 * Assumptions
 * There are no duplicate elements in the array.
 * 
 * Corner Cases
 * What if A is null or A is of zero length? We should return -1 in this case.
 */

public class SearchInShiftedSortedArray1 {
	public int search(int[] array, int target) {
		if (array == null || array.length == 0) {
			return -1;
		}
		return search(array, target, 0, array.length - 1 );
	}
	private int search(int[] array, int target, int l, int r) {
		// TODO Auto-generated method stub
		if (l > r) {
			return -1;
		}
		int mid = l + (r- l)/2;
		if (array[mid] == target) {
			return mid;
		} else if (array[mid] >= array[l]) {
			if (target < array[mid] && target >= array[l]) {
				return search(array, target, l, mid - 1);
			} else {
				return search(array, target, mid + 1, r);
			}
			
		} else {
			if (target > array[mid] && target <= array[r]) {
				return search(array, target, mid + 1, r);
			} else {
				return search(array, target, l, mid - 1);
			}
		}
	}	
//	public int search(int[] array, int target) {
//		if (array == null || array.length == 0) {
//			return -1;
//		}
//		int split = findSplit(array);
//		if (target < array[0]) {
//			return helper(array, target, split + 1, array.length - 1);
//		} else {
//			return helper(array, target, 0, split);
//		}
//	}
//
//	private int helper(int[] array, int target, int left, int right) {
//		// TODO Auto-generated method stub
//		if (left > right) {
//			return -1;
//		}
//		int mid = left + (right - left) / 2;
//		if (array[mid] == target) {
//			return mid;
//		} else if (array[mid] < target) {
//			return helper(array, target, mid + 1, right);
//		} else {
//			return helper(array, target, left, mid - 1);
//		}
//	}
//
//	private int findSplit(int[] array) {
//		for (int i = 1; i < array.length; i++) {
//			if (array[i] - array[i - 1] < 0) {
//				return i - 1;
//			}
//		}
//		return array.length / 2;
//	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchInShiftedSortedArray1 sol = new SearchInShiftedSortedArray1();
		int[] array = new int[]{15,1,3,6,10};
		System.out.println(sol.search(array, 1));
	}

}
