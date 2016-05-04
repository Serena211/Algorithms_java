package Class26;

import java.util.Arrays;

/*
 * Given an integer array of length L, find the number that occurs more than 0.5 * L times.
 * 
 * Assumptions
 * The given array is not null or empty
 * It is guaranteed there exists such a majority number
 * 
 * Examples
 * A = {1, 2, 1, 2, 1}, return 1
 */

public class MajorityNumber1 {
	public int majority(int[] array) {
		Arrays.sort(array);
		int mid = (array.length - 1)/2;
		return array[mid];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
