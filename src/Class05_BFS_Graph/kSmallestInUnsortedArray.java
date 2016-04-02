package Class05_BFS_Graph;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/*Find the K smallest numbers in an unsorted integer array A. 
 * The returned numbers should be in ascending order.
 * 
 * Assumptions:
 * A is not null
 * K is >= 0 and smaller than or equal to size of A
 * Return an array with size K containing the K smallest numbers in ascending order
 * 
 * Examples:
 * A = {3, 4, 1, 2, 5}, K = 3, the 3 smallest numbers are {1, 2, 3}
*/

public class kSmallestInUnsortedArray {
	// use MinHeap to find K smallest numbers.
	/*
	 * Heapify the array to be MinHeap
	 * Keep poping k times to get k smallest numbers
	 * 
	 */
	public int[] kSmallest_Min(int[] array, int k) {
		if (array.length == 0 || k == 0) {
			return new int[0];
		}
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		for (int a : array) {
			minHeap.offer(a);
		}
		int[] rsl = new int[k];
		int idx = 0;
		while(idx < k) {
			rsl[idx] = minHeap.poll();
			idx++;
		}
		return rsl;
	}
	
	//use MaxHeap to find K smallest numbers
	/*
	 * Heapify the MaxHeap of size k by using first k element in the array
	 * Iterate over the rest (n - k) element, and keep updating the MaxHeap
	 * 
	 */
	public int[] kSmallest_Max(int[] array, int k) {
		if (array.length == 0 || k == 0) {
			return new int[0];
		}
		Comparator<Integer> reverseComparator = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if (o1.equals(o2)) {
					return 0;
				}
				return o1 < o2? 1 : -1;
			}
		};
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, reverseComparator);
		for (int i = 0; i < array.length; i++) {
	    	if (i < k) {
	    		maxHeap.offer(array[i]);
	    	} else if (array[i] < maxHeap.peek()) {
	    		maxHeap.poll();
	    		maxHeap.offer(array[i]);
	    	}
	    }
	    int[] result = new int[k];
	    for (int i = k - 1; i >= 0; i--) {
	    	result[i] = maxHeap.poll();
	    }
	    
	    return result;
	} 
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
