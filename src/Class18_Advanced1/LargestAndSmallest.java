package Class18_Advanced1;

import java.util.Arrays;

/*
 * Use the least number of comparisons to get the largest and smallest number in 
 * the given integer array. Return the largest number and the smallest number.
 * 
 * Assumptions
 * The given array is not null and has length of at least 1
 * 
 * Examples
 * {2, 1, 5, 4, 3}, the largest number is 5 and smallest number is 1. return [5, 1].
 */
public class LargestAndSmallest {
	public int[] largestAndSmallest(int[] array) {
		// Write your solution here.
		// The first element is the largest number,
		// the second element is the smallest number.
		int count = 1;
		if (array.length == 1) {
			return new int[]{array[0], array[0]};
		}
		int n = array.length;
		for (int i = 0; i < n / 2; i++) {
			System.out.println(count++);
			if (array[i] < array[n - 1 -i]) {
				swap(array, i , n -1 - i);
			}
		}
		return new int[] { largest(array, 0, n / 2), smallest(array, n / 2, n - 1) };
	}
	
	private int smallest(int[] array, int l, int r) {
		// TODO Auto-generated method stub
		int smallest = array[l];
		for (int i = l+ 1; i <= r; i++) {
			smallest = Math.min(smallest, array[i]);
			System.out.println('1');
		}
		return smallest;
	}

	private int largest(int[] array, int l, int r) {
		// TODO Auto-generated method stub
		int largest = array[l];
		for (int i = l+ 1; i <= r; i++) {
			largest = Math.max(largest, array[i]);
			System.out.println('1');
		}
		return largest;
	}

	private void swap(int[] array, int i, int j) {
		// TODO Auto-generated method stub
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String[] args) {
		LargestAndSmallest sol = new LargestAndSmallest();
		int[] array = new int[]{2,3,1};
		System.out.println(Arrays.toString(sol.largestAndSmallest(array)));
	}

}
