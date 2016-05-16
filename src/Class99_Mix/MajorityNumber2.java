package Class99_Mix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * Given an integer array of length L, find all numbers that occur more 
 * than 1/3 * L times if any exist.
 * 
 * Assumptions
 * The given array is not null
 * 
 * Examples
 * A = {1, 2, 1, 2, 1}, return [1, 2]
 * A = {1, 2, 1, 2, 3, 3, 1}, return [1]
 * A = {1, 2, 2, 3, 1, 3}, return []
 */
public class MajorityNumber2 {
	// method 1: sliding window O(nlogn + n)
	public List<Integer> majority0(int[] array) {
		List<Integer> rsl = new ArrayList<Integer>();
		if (array.length == 0) {
			return rsl;
		}
		if (array.length == 1) {
			rsl.add(array[0]);
			return rsl;
		}
		if (array.length == 2) {
			rsl.add(array[0]);
			if (array[1] != array[0]) {
				rsl.add(array[1]);
			}
			return rsl;
		}

		Arrays.sort(array);
		// sliding window. the size of window is array.length / 3 + 1;
		int left = 0;
		int right = array.length / 3; // window size = left - right + 1;
		while (right < array.length) {
			if (array[left] == array[right]) {
				rsl.add(array[left]);
				while (left < array.length - 1
						&& array[left] == array[left + 1]) {
					left++;
				}
				right = left + array.length / 3;
			} else {
				right++;
				left++;
			}
			
		}
		return rsl;
	}

	// method 2: laioffer O(n)
	public List<Integer> majority(int[] array) {
		List<Integer> rsl = new ArrayList<Integer>();
		int minCount = array.length/3 + 1;
		
		return rsl;
	}

	public static void main(String[] args) {
		MajorityNumber2 sol = new MajorityNumber2();
		System.out.println(sol.majority(new int[] { 1, 2 }));
	}

}
