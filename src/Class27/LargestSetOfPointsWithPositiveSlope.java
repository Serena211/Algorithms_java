package Class27;

import java.util.Arrays;
import java.util.Comparator;

/*
 * Given an array of 2D coordinates of points (all the coordinates are integers), 
 * find the largest number of points that can form a set such that any pair of points 
 * in the set can form a line with positive slope. Return the size of such a maximal set.
 * 
 * Assumptions
 * The given array is not null and is not empty
 * 
 * Note: if there does not even exist 2 points can form a line with positive slope, 
 * should return 0.
 * 
 * Examples
 * <0, 0>, <1, 1>, <2, 3>, <3, 3>, the maximum set of points are {<0, 0>, <1, 1>, <2, 3>}, 
 * the size is 3.
 */
public class LargestSetOfPointsWithPositiveSlope {
	public int largest(Point[] points) {
		if (points.length <= 1 ) {
			return 0;
		}
		// slope = (y2 - y1)/(x2 - x1) > 0;
		// sort points array by x-axis
		Arrays.sort(points, new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				if (o1.x == o2.x) {
					return 0;
				}
				
				return o1.x < o2.x ? -1 : 1;
			}
			
		});
		// finding longest ascending subsequence
		int[] M = new int[points.length];
		M[0] = 0;
		int longest = 0;
		for (int i = 1; i < points.length; i++) {
			for (int j = 0; j < i; j++) {
				if (points[i].y > points[j].y) {
					M[i] = Math.max(M[i], M[j] + 1);
				}
			}
			longest = Math.max(longest, M[i]);
		}
		return longest == 0? 0 : longest + 1;
	}

	public static void main(String[] args) {
		LargestSetOfPointsWithPositiveSlope sol = new LargestSetOfPointsWithPositiveSlope();
		Point[] points = new Point[]{new Point(0,0), new Point(1,1),new Point(2,3),new Point(3,-3)};
		System.out.println(sol.largest(points));
	}

}
