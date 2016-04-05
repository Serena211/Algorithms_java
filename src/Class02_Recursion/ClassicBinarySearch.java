package Class02_Recursion;
/*
 * Given a target integer T and an integer array A sorted in 
 * ascending order, find the index i such that A[i] == T or 
 * return -1 if there is no such index.
 * 
 * Assumptions
 * There can be duplicate elements in the array, and you can 
 * return any of the indices i such that A[i] == T.
 * 
 * Examples
 * A = {1, 2, 3, 4, 5}, T = 3, return 2
 * A = {1, 2, 3, 4, 5}, T = 6, return -1
 * A = {1, 2, 2, 2, 3, 4}, T = 2, return 1 or 2 or 3
 * 
 * Corner Cases
 * What if A is null or A is of zero length?
 *  We should return -1 in this case.
 * */
public class ClassicBinarySearch {
	public static int binarySearch(int[] array, int target) {
		if(array == null || array.length == 0) {
			return -1;
		}
		int rsl = helper(array, target, 0, array.length - 1);
		return rsl;
	}
	private static int helper(int[] array, int target, int left, int right) {
		// TODO Auto-generated method stub
		// if don't find target, return -1
		if(left > right ) {
			return -1;
		}
		//base case:
		int mid = left + (right - left) / 2;
		if(array[mid] == target) {
			return mid;
		}
		//recursion rules:
		if (array[mid] < target) {
			return helper(array, target, mid + 1, right);
		} else {
			return helper(array, target, left, mid - 1);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[]{1,3,5,7,12,13,19,22};
		int rsl = binarySearch(arr, 4);
		System.out.println(rsl);
	}

}
