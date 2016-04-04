package Class01_Sort;
/*
 * Given an array of integers, sort the elements in the 
 * array in ascending order. The selection sort algorithm 
 * should be used to solve this problem.
 * 
 * Time Complexity:
 * Outer loop: 0 - n
 * Inner loop: 1 - n, 2 - n, 3 - n,... , n-1 - n
 * O(n^2)
 * */
public class SelectionSort {
	public int[] sort(int[] array) {
		if (array == null || array.length == 0) {
			return array;
		}
		int smallest;
		for (int i = 0; i < array.length - 1; i++) {
			smallest = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[smallest] > array[j]) {
					smallest = j;
				}
			}
			swap(smallest, i, array);
		}
		return array;
	}

	private void swap(int a, int b, int[] arr) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
