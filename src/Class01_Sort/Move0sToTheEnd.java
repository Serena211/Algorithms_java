package Class01_Sort;
/*
 * Given an array of integers, move all the 0s to the 
 * right end of the array.
 * The relative order of the elements in the original 
 * array does not need to be maintained.
 * 
 * Assumptions:
 * The given array is not null.
 * 
 * Examples:
 * {1} --> {1}
 * {1, 0, 3, 0, 1} --> {1, 3, 1, 0, 0} or {1, 1, 3, 0, 0} or {3, 1, 1, 0, 0}
 * */
public class Move0sToTheEnd {
	public static int[] moveZero(int[] array) {
		// Write your solution here.
		if(array == null || array.length == 0) {
			return array;
		}
		int start = 0;
		int end = array.length - 1;
		while(start < end) {
			while (array[end] == 0 && end > start) {
				end--;
			}
			if(array[start] == 0) {
				swap(start,end,array);
				end--;
			}
			start++;
		}
		return array;
	}

	private static void swap(int start, int end, int[] array) {
		// TODO Auto-generated method stub
		int temp = array[start];
		array[start] = array[end];
		array[end] = temp;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[]{1,1,0,0,1,1};
		moveZero(a);
	}
	

}
