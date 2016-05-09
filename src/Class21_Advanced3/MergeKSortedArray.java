package Class21_Advanced3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * Merge K sorted array into one big sorted array in ascending order.
 * 
 * Assumptions
 * The input arrayOfArrays is not null, none of the arrays is null either.
 */
class Element {
	public int val;
	public int rowNum;
	public int colNum;

	public Element(int v, int r, int c) {
		val = v;
		rowNum = r;
		colNum = c;
	}
}

public class MergeKSortedArray {

	public int[] merge(int[][] arrayOfArrays) {
		int N = arrayOfArrays.length;
		if (N == 0) {
			return new int[0];
		}
		int[] M = new int[N];
		int length = 0;
		for (int i = 0; i < N; i++) {
			M[i] = arrayOfArrays[i].length;
			length += M[i];
		}

		int[] rsl = new int[length];

		Comparator<Element> ElementComparator = new Comparator<Element>() {

			@Override
			public int compare(Element o1, Element o2) {
				if (o1.val == o2.val) {
					return 0;
				}
				return o1.val < o2.val ? -1 : 1;
			}
		};
		PriorityQueue<Element> min = new PriorityQueue<Element>(N,
				ElementComparator);

		for (int r = 0; r < N; r++) {	
			if (M[r] != 0) {
				min.offer(new Element(arrayOfArrays[r][0], r, 0));
			}
		}
		for (int i = 0; i < rsl.length; i++) {
			Element temp = min.peek();
			rsl[i] = temp.val;
			min.poll();

			// add next element of corresponding sorted array
			if (temp.colNum + 1 < M[temp.rowNum]) {
				min.offer(new Element(
						arrayOfArrays[temp.rowNum][temp.colNum + 1],
						temp.rowNum, temp.colNum + 1));
			}
		}
		return rsl;
	}

	public static void main(String[] args) {
		MergeKSortedArray sol = new MergeKSortedArray();
		int[][] array = new int[][]{{4,5},{},{1,2,5,9}};
		System.out.println(Arrays.toString(sol.merge(array)));
	}

}
