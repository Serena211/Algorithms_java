package Class18_Advanced1;

import java.util.Arrays;

/*
 * Given a sorted integer array, remove duplicate elements. For each group of 
 * elements with the same value keep at most two of them. Do this in-place, 
 * using the left side of the original array and maintain the relative order 
 * of the elements of the array. Return the array after deduplication.
 * 
 * Assumptions
 * The given array is not null
 * 
 * Examples
 * {1, 2, 2, 2, 2, 2,3, 3, 3} → {1, 2, 2, 3, 3}
 */
public class ArrayDeduplication2 {
	public int[] dedup(int[] array) {
		if (array.length <= 2) {
			return array;
		}
		int slow = 0;
		int fast = 1;
		int count;
		if (array[fast] == array[slow]) {
			count = 1;
		} else {
			count = 0;
		}

		while (fast < array.length) {
			if (count < 2) {
				if (array[fast] == array[slow]) {
					count++;
				} else {
					count = 1;
				}
				array[++slow] = array[fast++];

			} else {
				if (array[slow] == array[fast]) {
					fast++;
				} else {
					count = 0;
				}
			}
		}
		return Arrays.copyOf(array, slow + 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayDeduplication2 sol = new ArrayDeduplication2();
		int[] array = new int[]{1,1,2,2,2};
		int[] rsl = sol.dedup(array);
		System.out.println(rsl);
	}

}
