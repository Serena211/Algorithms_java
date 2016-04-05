package Class02_Recursion;
/*
 * Given a target integer T and an integer array A sorted 
 * in ascending order, find the index i in A such that A[i] 
 * is closest to T.
 * 
 * Assumptions
 * There can be duplicate elements in the array, and we can 
 * return any of the indices with same value.
 * 
 * Examples
 * A = {1, 2, 3}, T = 2, return 1
 * A = {1, 4, 6}, T = 3, return 1
 * A = {1, 4, 6}, T = 5, return 1 or 2
 * A = {1, 3, 3, 4}, T = 2, return 0 or 1 or 2
 * 
 * Corner Cases
 * What if A is null or A is of zero length? 
 * 	We should return -1 in this case.
 * */
public class ClosestInSortedArray {
	public static int closest(int[] array, int target) {
		//corner case:
		if(array == null || array.length == 0) {
			return -1;
		}
		return helper(array, target, 0, array.length - 1, -1, Integer.MAX_VALUE);
	}
	private static int helper(int[] array, int target, int left, int right, int tempRsl, int gap) {
		if (left > right) {
			return tempRsl;
		}
		int mid = left + (right - right) / 2;
		if(array[mid] == target) {
			tempRsl = mid;
			return tempRsl;
		} else if(array[mid] < target) {
			int tempGap = Math.abs(target - array[mid]);
			if(tempGap < gap) {
				gap = tempGap;
				tempRsl = mid;
			}
			return helper(array, target, mid + 1, right, tempRsl,gap);
		} else {
			int tempGap = Math.abs(target - array[mid]);
			if(tempGap < gap) {
				gap = tempGap;
				tempRsl = mid;
			}
			return helper(array, target, left, mid - 1, tempRsl, tempGap);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[]{0};
		int rsl = closest(arr, 0);
		System.out.println(rsl);
	}

}
