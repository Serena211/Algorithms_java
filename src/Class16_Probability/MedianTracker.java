package Class16_Probability;

import java.util.Collections;
import java.util.PriorityQueue;

/*
 * Given an unlimited flow of numbers, keep track of the median of all elements seen so far.
 * You will have to implement the following two methods for the class
 * 
 * read(int value) - read one value from the flow
 * median() - return the median at any time, return null if there is no value read so far
 * 
 * Examples
 * read(1), median is 1
 * read(2), median is 1.5
 */

public class MedianTracker {
	PriorityQueue<Integer> max;
	PriorityQueue<Integer> min;
	public final int DEFAULT_MAXHEAP_CAPACITY = 1000;
	public MedianTracker() {
		// add new fields and complete the constructor if necessary.
		max = new PriorityQueue<Integer>(DEFAULT_MAXHEAP_CAPACITY, Collections.reverseOrder());
		min = new PriorityQueue<Integer>();
	}

	public void read(int value) {
		if (min.isEmpty() || value >= min.peek()) {
			min.offer(value);
		} else {
			max.offer(value);
		}
		while (min.size() - max.size() > 1) {
			max.offer(min.peek());
			min.poll();
		}
		while (max.size() > min.size()) {
			min.offer(max.peek());
			max.poll();
		}
	}

	public Double median() {
		int size = max.size() + min.size();
		Double rsl = null;
		if (size == 0) {
			return rsl;
		}
		if (size % 2 == 0) {
			rsl =( max.peek() + min.peek()) / 2.0;
		} else {
			rsl = min.peek() / 1.0;
		}
		return rsl;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MedianTracker sol = new MedianTracker();
		sol.read(0);
		sol.read(1);
		sol.read(1);
		sol.read(3);
		sol.read(4);
//		int rsl = sol.DEFAULT_MAXHEAP_CAPACITY;
//		System.out.println(rsl);
		System.out.println(sol.median());
	}

}
