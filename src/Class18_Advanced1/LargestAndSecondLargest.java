package Class18_Advanced1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Use the least number of comparisons to get the largest and 2nd largest number in 
 * the given integer array. Return the largest number and 2nd largest number.
 * 
 * Assumptions
 * The given array is not null and has length of at least 2
 * 
 * Examples
 * {2, 1, 5, 4, 3}, the largest number is 5 and 2nd largest number is 4.
 */
public class LargestAndSecondLargest {
	class Element {
		int val;
		Element compared;

		public Element(int v) {
			val = v;
			compared = null;
		}
	}

	public int[] largestAndSecond(int[] array) {
		Element[] newArr = convert(array);
		int largerLength = array.length; // larger num on the lefthand of
											// rightbound(not included)
		while (largerLength > 1) {
			compare(newArr, largerLength); // if odd, including the mid num
			largerLength = (largerLength + 1) / 2;
		}

		// The first element is the largest number,
		// the second element is the second largest number.
		return new int[] { newArr[0].val, newArr[0].compared.val };
	}

	private void compare(Element[] newArr, int r) {
		for (int i = 0; i < r / 2; i++) {
			if (newArr[i].val < newArr[r - 1 - i].val) {
				swap(newArr, i, r - 1 - i);
			}
			if (newArr[i].compared == null
					|| newArr[i].compared.val < newArr[r - 1 - i].val) {
				newArr[i].compared = newArr[r - 1 - i];
			}
		}
	}

	private void swap(Element[] arr, int i, int j) {
		// TODO Auto-generated method stub
		Element temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private Element[] convert(int[] array) {
		Element[] rsl = new Element[array.length];
		for (int i = 0; i < array.length; i++) {
			rsl[i] = new Element(array[i]);
		}
		return rsl;
	}

	public static void main(String[] args) {
		LargestAndSecondLargest sol = new LargestAndSecondLargest();
		int[] array = new int[]{7,1,1,3,2,1,2,4,1,5};
		System.out.println(Arrays.toString(sol.largestAndSecond(array)));
	}

}
