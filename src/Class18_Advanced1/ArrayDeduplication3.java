package Class18_Advanced1;

import java.util.Arrays;

/*
 * Given a sorted integer array, remove duplicate elements. For each group of 
 * elements with the same value do not keep any of them. Do this in-place, using 
 * the left side of the original array and and maintain the relative order of 
 * the elements of the array. Return the array after deduplication.
 * 
 * Assumptions
 * The given array is not null
 * 
 * Examples
 * {1, 2, 2, 3, 3, 3} → {1}
 */

public class ArrayDeduplication3 {
	public int[] dedup(int[] array) {
		if (array.length <= 1) {
			return array;
		}
		// use stack concept
		int slow = 0;
		int fast = 1;
		int top = array[0];
//		int count = 1;
		while (fast < array.length) {
			if (slow != -1 && array[fast] == array[slow]) {
				slow--;
				while (fast < array.length && array[fast] == top) {
					fast++;
				}
			} else {
				top = array[fast];
				array[++slow] = array[fast++];
			}
		}
		return Arrays.copyOf(array, slow + 1);
	}

	public static void main(String[] args) {
		ArrayDeduplication3 sol = new ArrayDeduplication3();
		int[] array = new int[]{1,1,1,2,2,2};
		int[] rsl = sol.dedup(array);
		System.out.println(rsl);
	}

}
