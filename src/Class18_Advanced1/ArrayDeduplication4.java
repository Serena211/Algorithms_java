package Class18_Advanced1;

import java.util.Arrays;

/*
 * Given an unsorted integer array, remove adjacent duplicate elements repeatedly, 
 * from left to right. For each group of elements with the same value do not keep 
 * any of them.
 * 
 * Do this in-place, using the left side of the original array. Return the array 
 * after deduplication.
 * 
 * Assumptions
 * The given array is not null
 * 
 * Examples
 * {1, 2, 3, 3, 3, 2, 2} → {1, 2, 2, 2} → {1}, return {1}
 */
public class ArrayDeduplication4 {
	public int[] dedup(int[] array) {
		if (array.length <= 1) {
			return array;
		}
		// use concepts of two pointers and stacks
		int slow = 0;	// track the top of this array stack
		int fast = 1;
		while (fast < array.length) {
			if (slow != -1 && array[fast] == array[slow]) {
				while (fast < array.length && array[fast] == array[slow]) {
					fast++;
				}
				slow--;
			} else {
				array[++slow] = array[fast++];
			}
		}
		return Arrays.copyOf(array, slow + 1);
	}

	public static void main(String[] args) {
		ArrayDeduplication4 sol = new ArrayDeduplication4();
		int[] array = new int[]{1,1,3,3,4,5,5,4,4};
		int[] rsl = sol.dedup(array);
		System.out.println(Arrays.toString(rsl));
	}

}
