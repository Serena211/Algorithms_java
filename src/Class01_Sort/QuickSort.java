package Class01_Sort;

import java.util.Arrays;
import java.util.Random;

/*
 * Given an array of integers, sort the elements in the 
 * array in ascending order. The quick sort algorithm 
 * should be used to solve this problem.
 * */
public class QuickSort {
	public static int[] quickSort(int[] array) {
		// corner case:
		if (array == null || array.length == 0) {
			return array;
		}
		
		helper(array, 0, array.length-1);
		return array;
	}

	private static void helper(int[] array, int l, int r) {
		// base case: only have one element, so left index = right index
		if (l >= r) {
			return;
		}
		// randomly choose pivot
		Random rand = new Random();
		//[min, max] = ((max - min) + 1) + min
		int pivotIdx = rand.nextInt((r - l) + 1) + l;
		int pivot = array[pivotIdx];
		
		swap(array, r, pivotIdx);
		// the value of left element of i (not included) is less than pivot value
		int i = l;
		// the value of right element of i (not included) is greater than pivot value
		int j = r - 1;
		while (i <= j) {		
			while(i <= r && array[i] < pivot) {
				i++;
			}
			while(j >= l && array[j] >= pivot) {
				j--;
			}
			if(i < j) {
				swap(array, i, j);
				i++;
				j--;
			}
		}
		// re-put pivot in the mid
		swap(array, i, r);
		helper(array, l, j);
		helper(array, i+1, r);
		
	}
	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[]{1,5,3,1,10,4,6};
		int[] rsl = quickSort(a);
		System.out.println(Arrays.toString(rsl));
	}
}
