package Class26;
/*
 * Given two sorted arrays of integers, find the Kth smallest number.
 * 
 * Assumptions
 * The two given arrays are not null and at least one of them is not empty
 * K >= 1, K <= total lengths of the two sorted arrays
 * 
 * Examples
 * A = {1, 4, 6}, B = {2, 3}, the 3rd smallest number is 3.
 * A = {1, 2, 3, 4}, B = {}, the 2nd smallest number is 2.
 */
public class KthSmallestInTwoSortedArrays {
	// method1: use two pointers. O(k); O(1);
	public int twoPointers(int[] a, int[] b, int k) {
		// corner case: one array is empty
		if (a.length == 0 || b.length == 0) {
			return a.length == 0? b[k - 1] : a[k - 1];
		}
		
		int pnt1 = 0;
		int pnt2 = 0;
		while (k > 1) {
			if (a[pnt1] > b[pnt2]) {
				pnt2++;
			} else {
				pnt1++;
			} 
			k--;
		}
		
		return a[pnt1] > b[pnt2] ?  b[pnt2] : a[pnt1];
	}

	public static void main(String[] args) {
		KthSmallestInTwoSortedArrays sol = new KthSmallestInTwoSortedArrays();
		int[] a = new int[]{1,2,5,7,9};
		int[] b = new int[]{2,3,5,6};
		System.out.println(sol.twoPointers(a, b, 7));
	}

}
