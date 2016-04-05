package Class02_Recursion;
/*
 * Given a target integer T and an integer array A sorted 
 * in ascending order, find the index of the first occurrence 
 * of T in A or return -1 if there is no such index.
 * 
 * Assumptions
 * There can be duplicate elements in the array.
 * 
 * Examples
 * A = {1, 2, 3}, T = 2, return 1
 * A = {1, 2, 3}, T = 4, return -1
 * A = {1, 2, 2, 2, 3}, T = 2, return 1
 * 
 * Corner Cases
 * What if A is null or A of zero length? 
 * 	We should return -1 in this case.
 * */
public class FirstOccurrence {
	public static int firstOccur(int[] array, int target) {
		//corner case:
		if(array == null || array.length == 0) {
			return -1;
		}
		
		return helper(array, target, 0, array.length - 1, -1);
	}
	private static int helper(int[] array, int target, int left, int right, int tempRsl) {
		// TODO Auto-generated method stub
		if(left > right) {
			return tempRsl;
		}
		int mid = left + (right - left) / 2;
		if (array[mid] == target) {
			tempRsl = mid;
			return helper(array, target, left, mid - 1, tempRsl);
		} else if (array[mid] < target) {
			return helper(array, target, mid + 1, right, tempRsl);
		} else {
			return helper(array, target, left, mid - 1, tempRsl);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[]{1};
		int rsl = firstOccur(arr, 2);
		System.out.println(rsl);
	}

}
