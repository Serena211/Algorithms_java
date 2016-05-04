package Class26;

import java.util.Arrays;

/*
 * Given two arrays of integers, find the median value.
 * 
 * Assumptions
 * The two given array are not null and at least one of them is not empty
 * The two given array are not guranteed to be sorted
 * 
 * Examples
 * A = {4, 1, 6}, B = {2, 3}, median is 3
 * A = {1, 4}, B = {3, 2}, median is 2.5
 */
public class MedianOfTwoArrays {
	public double median(int[] a, int[] b) {
		if (a.length == 0 && b.length == 0) {
			return 0;
		} else if (a.length == 0) {
			Arrays.sort(b);
			return findMedian(b);
		} else if (b.length == 0) {
			Arrays.sort(a);
			return findMedian(a);
		} else {
			Arrays.sort(a);
			Arrays.sort(b);
			return findMedian(a,b);
		}
	}

	private double findMedian(int[] a, int[] b) {
		int pointerA = 0;
		int pointerB = 0;
		int size = a.length + b.length;
		if (size % 2 == 0) {
			
		}
		return 0;
		
	}

	private double findMedian(int[] arr) {
		if (arr.length % 2 == 0) {
			int mid = (arr.length - 1) / 2;
			return (arr[mid] + arr[mid + 1]) / 2;
		} else {
			return arr[arr.length / 2];
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
