package Class01_Sort;
/*
 * Given an array of integers, sort the elements in the 
 * array in ascending order. The merge sort algorithm 
 * should be used to solve this problem.
 * 
 * Examples
 * {1} is sorted to {1}
 * {1, 2, 3} is sorted to {1, 2, 3}
 * {3, 2, 1} is sorted to {1, 2, 3}
 * {4, 2, -3, 6, 1} is sorted to {-3, 1, 2, 4, 6}
 * 
 * Corner Cases
 * 1. What if the given array is null? 
 * In this case, we do not need to do anything.
 * 2. What if the given array is of length zero? 
 * In this case, we do not need to do anything.
 * */
public class MergeSort {

	public int[] mergeSort(int[] array) {
		if(array == null || array.length == 0) {
			return array;
		}
		int[] rsl = helper(array, 0, array.length - 1);
		return rsl;
	}
	private int[] helper(int[] array, int left, int right) {
		// corner case: at the leaf node
		if(left == right) {
			return new int[]{array[left]};
		}
		int mid = left + (right- left)/2;
		int[] leftArr = helper(array, left, mid);
		int[] rightArr = helper(array, mid + 1, right);
		int[] rsl = merge(leftArr, rightArr);
		return rsl;
		
	}
	private int[] merge(int[] left, int[] right) {
		int[] rsl = new int[left.length + right.length];
		int leftIdx = 0;
		int rightIdx = 0;
		int rslIdx = 0;
		while(leftIdx < left.length && rightIdx < right.length) {
			if(left[leftIdx] < right[rightIdx]) {
				rsl[rslIdx++] = left[leftIdx++];
			} else {
				rsl[rslIdx++] = right[rightIdx++];
			}
		}
		while(leftIdx < left.length) {
			rsl[rslIdx++] = left[leftIdx++];
		}
		while(rightIdx < right.length) {
			rsl[rslIdx++] = right[rightIdx++];
		}
		return rsl;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
