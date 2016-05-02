package Class18_Advanced1;

import java.util.Arrays;

/*
 * Given a sorted integer array, remove duplicate elements. For each group of 
 * elements with the same value keep only one of them. Do this in-place, using 
 * the left side of the original array and maintain the relative order of the 
 * elements of the array. Return the array after deduplication.
 * 
 * Assumptions
 * The array is not null
 * 
 * Examples
 * {1, 2, 2, 3, 3, 3} → {1, 2, 3}
 */

public class ArrayDeduplication1 {
	public int[] dedup(int[] array) {
		if (array.length == 0) {
			return array;
		}
		// sorted array ==> adjacent duplicated integer.
		int slow = 0;
		int fast = 0;
		while (fast < array.length) {
			if (fast == 0 || array[fast] == array[slow]) {
				fast++;
			} else {
				array[++slow] = array[fast++];
			}
		}
		return Arrays.copyOf(array, slow + 1);
	}

	public static void main(String[] args) {
		ArrayDeduplication1 sol = new ArrayDeduplication1();
		int[] array	= new int[]{1,1,1,2,3};
		int[] rsl = sol.dedup(array);
		System.out.println(rsl);
		
	}

}
