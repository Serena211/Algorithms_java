package Class99_Mix;

import java.util.ArrayList;
import java.util.List;

/*
 * Find all common elements in 3 sorted arrays.
 * 
 * Assumptions
 * The 3 given sorted arrays are not null
 * There could be duplicate elements in each of the arrays
 * 
 * Examples
 * A = {1, 2, 2, 3}, B = {2, 2, 3, 5}, C = {2, 2, 4}, the common elements are [2, 2]
 */

public class CommonElementsInThreeSortedArray {
	public List<Integer> common(int[] a, int[] b, int[] c) {
		List<Integer> rsl = new ArrayList<Integer>();
		int aIdx = 0;
		int bIdx = 0;
		int cIdx = 0;
		while (aIdx < a.length && bIdx < b.length && cIdx < c.length) {
			if (a[aIdx] == b[bIdx] && b[bIdx] == c[cIdx]) {
				rsl.add(a[aIdx]);
				aIdx++;
				bIdx++;
				cIdx++;
			} else if (a[aIdx] < b[bIdx] || a[aIdx] < c[cIdx]) {
				aIdx++;
			} else if (b[bIdx] < a[aIdx] || b[bIdx] < c[cIdx]) {
				bIdx++;
			} else {
				cIdx++;
			}
		}
		return rsl;
	}

	public static void main(String[] args) {
		CommonElementsInThreeSortedArray sol = new CommonElementsInThreeSortedArray();
		System.out.println(sol.common(new int[]{1,2,3,3},new int[]{2,3,4,4,5},new int[]{1,1,3,3}));
	}

}
