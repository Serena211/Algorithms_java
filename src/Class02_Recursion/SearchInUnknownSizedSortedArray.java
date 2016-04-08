package Class02_Recursion;
/*
 * Given a integer dictionary A of unknown size, where the numbers 
 * in the dictionary are sorted in ascending order, determine if a 
 * given target integer T is in the dictionary. Return the index of 
 * T in A, return -1 if T is not in A.
 * 
 * Assumptions
 * dictionary A is not null
 * dictionary.get(i) will return null if index i is out of bounds
 * 
 * Examples
 * A = {1, 2, 5, 9, ......}, T = 5, return 2
 * A = {1, 2, 5, 9, 12, ......}, T = 7, return -1
 * */


interface Dictionary {
	public Integer get(int index);
}
// Solution:
// Step1: keep jumping out until array[2^k] >= target || array[2^k] == null
// Step2: left = 2^(k - 1); right = 2^k; do binary search.
public class SearchInUnknownSizedSortedArray {
	public int search(Dictionary dict, int target) {
		if(dict == null || dict.get(0) == null) {
			return -1;
		}
		if (dict.get(0) == target) {
			return 0;
		}
		int index = 1;		
		while(dict.get(index) != null && dict.get(index) < target) {
			index = index * 2;
		}
		return BST(dict, target, (int)Math.sqrt(index),index);
		}
	private int BST(Dictionary dict, int target, int l, int r) {
		
		while (l <= r) {
			int mid = l + (l + r) / 2;
			if (dict.get(mid) == null) {
				r = mid - 1;
			} else if (dict.get(mid) == target) {
				return mid;
			} else if(dict.get(mid) < target) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return -1;
	}
	public static void main(String[] args) {

	}

}
