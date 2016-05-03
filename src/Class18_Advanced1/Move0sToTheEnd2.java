package Class18_Advanced1;

import java.util.Arrays;

/*
 * Given an array of integers, move all the 0s to the right end of the array.
 * The relative order of the elements in the original array need to be maintained.
 * 
 * Assumptions:
 * The given array is not null.
 * 
 * Examples:
 * {1} --> {1}
 * {1, 0, 3, 0, 1} --> {1, 3, 1, 0, 0}
 */

public class Move0sToTheEnd2 {
	public int[] moveZero(int[] array) {
		if (array.length <= 1) {
			return array;
		}
		int slow = -1;
		int fast = 0;
		while (fast < array.length) {
			if (array[fast] != 0) {
				swap(array, ++slow, fast);
			} 
			fast++;
		}
		return array;
	}

	private void swap(int[] array, int i, int j) {
		// TODO Auto-generated method stub
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Move0sToTheEnd2 sol = new Move0sToTheEnd2();
		int[] array = new int[]{1,0,0,7,0,3};
		int[] rsl = sol.moveZero(array);
		System.out.println(Arrays.toString(rsl));
	}

}
