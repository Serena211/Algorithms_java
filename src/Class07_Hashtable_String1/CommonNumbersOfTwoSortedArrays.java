package Class07_Hashtable_String1;

import java.util.ArrayList;
import java.util.List;

/*
 * Find all numbers that appear in both of two **sorted** arrays (the two 
 * arrays are all sorted in ascending order).
 * 
 * Assumptions
 * In each of the two sorted arrays, there could be duplicate numbers.
 * Both two arrays are not null.
 * 
 * Examples
 * A = {1, 1, 2, 2, 3}, B = {1, 1, 2, 5, 6}, common numbers are [1, 1, 2]
 */

/*
 * Solution:
 * 1. if A.size() << B.size()?		run binary search?
 * 2. if A.size() ~~ B.size()?
 */
public class CommonNumbersOfTwoSortedArrays {
	// two pointers
	public List<Integer> common(List<Integer> A, List<Integer> B) {
		List<Integer> rsl = new ArrayList<Integer>();
		int i = 0;	// pointer
		int j = 0;
		while (i < A.size() && j < B.size()) {
			int AVal = A.get(i);
			int BVal = B.get(j);
			if (AVal == BVal) {
				rsl.add(AVal);
				i++;
				j++;
			} else if (AVal < BVal) {
				i++;
			} else {
				j++;
			}
		}
		return rsl;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
