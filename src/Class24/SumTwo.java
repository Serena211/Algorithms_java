package Class24;

import java.util.Arrays;
import java.util.HashSet;

/*
 * Determine if there exist two elements in a given array, the sum of which is 
 * the given target number.
 * 
 * Assumptions
 * The given array is not null and has length of at least 2
 * 
 * Examples
 * A = {1, 2, 3, 4}, target = 5, return true (1 + 4 = 5)
 * A = {2, 4, 2, 1}, target = 4, return true (2 + 2 = 4)
 * A = {2, 4, 1}, target = 4, return false
 */

public class SumTwo {
	// method 1: two pointers
	public boolean existSum(int[] array, int target) {
		Arrays.sort(array);
		int start = 0;
		int end = array.length - 1;
		while (start < end) {
			int sum = array[start] + array[end];
			if (sum == target) {
				return true;
			}
			if (sum < target) {
				start++;
			} else {
				end--;
			}
		}
		return false;
	}
	
	// method 2: hashset
	public boolean existSum0(int[] array, int target) {
		HashSet<Integer> set = new HashSet<>();
		for (Integer n : array) {
			if (set.contains(target - n)) {
				return true;
			}
			set.add(n);
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
