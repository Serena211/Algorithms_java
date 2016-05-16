package Class99_Mix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given an integer array of length L, find all numbers that occur more than 
 * 1/K * L times if any exist.
 * 
 * Assumptions
 * The given array is not null or empty
 * K >= 2
 * 
 * Examples
 * A = {1, 2, 1, 2, 1}, K = 3, return [1, 2]
 * A = {1, 2, 1, 2, 3, 3, 1}, K = 4, return [1, 2, 3]
 * A = {2, 1}, K = 2, return []
 */
public class MajorityNumber3 {
	// method 1: sliding window O(nlogn + n)
	public List<Integer> majority(int[] array, int k) {
		List<Integer> rsl = new ArrayList<Integer>();
		if (array.length == 0) {
			return rsl;
		}
		Arrays.sort(array);
		if (array.length < k) {
			for (int i = 0; i < array.length; i++) {
				if (i > 0 && array[i] == array[i - 1]) {
					continue;
				}
				rsl.add(array[i]);
			}
			return rsl;
		}
		int window = array.length/k;
		int left = 0;
		int right = window;
		while (right < array.length) {
			if (array[left] == array[right]) {
				rsl.add(array[left]);
				while (left < array.length - 1
						&& array[left] == array[left + 1]) {
					left++;
				}
				right = left + window;
			} else {
				right++;
				left++;
			}
		}
		return rsl;
	}

	public static void main(String[] args) {
		MajorityNumber3 sol = new MajorityNumber3();
		System.out.println(sol.majority(new int[] { 1, 2,3,3,4,4,5 }, 5));

	}

}
