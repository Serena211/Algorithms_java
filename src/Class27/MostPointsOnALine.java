package Class27;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * Given an array of 2D coordinates of points (all the coordinates are integers), 
 * find the largest number of points that can be crossed by a single line in 2D space.
 * 
 * Assumptions
 * The given array is not null and it has at least 2 points
 * 
 * Examples
 * <0, 0>, <1, 1>, <2, 3>, <3, 3>, the maximum number of points on a line is 3
 * (<0, 0>, <1, 1>, <3, 3> are on the same line)
 */
class Point {
	public int x;
	public int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
/* Overview: 1. For each points, draw lines can fine the line with largest amount of points.
			 2. Two types line: one is perpendicular to x-axis, another one has slope.
*/
public class MostPointsOnALine {
	// How to represent a line?
	// y = ax + b (a and b decide an unique line)
	// corner case: x = k, if a line is perpendicular to x-axis, a is undefined.
	
	// Assumption: The given array is not null and it has at least 2 points
	public int most(Point[] points) {
		// Use maxNum to track the maximum number of points on a line.
		int maxNum = 2;		
		for (int i = 0; i < points.length; i++) {
			Point cur1 = points[i];
			int x1 = cur1.x;
			int y1 = cur1.y;
			int samePoint = 1;
			int sameX = 0;
			// abMap HashMap keeps slope and points belong to the slope
			HashMap<Double,Integer> abMap = new HashMap<Double, Integer>();
			int curMax = 0;
			for (int j = 0; j < points.length; j++) {
				if (i == j) {
					continue;
				}
				Point cur2 = points[j];
				int x2 = cur2.x;
				int y2 = cur2.y;
				//s1: same points
				if (x1 == x2 && y1 == y2) {
					samePoint++;
				} else if (x1 == x2) {
					//s2: x = k, perpendicular to x-axis
					sameX++;
				} else {
					//s3: y = ax + b
					double slope = ((y1 - y2) + 0.0) / (x1 - x2);
					Integer size = abMap.get(slope);
					if (size == null) {
						abMap.put(slope, 1);
					} else {
						abMap.put(slope, size + 1);
					}
					curMax = Math.max(curMax, abMap.get(slope));
				}
			}
			curMax = Math.max(sameX, curMax) + samePoint;
			maxNum = Math.max(maxNum, curMax);
		}
		return maxNum;
	}

	public static void main(String[] args) {
		MostPointsOnALine sol = new MostPointsOnALine();
		Point[] points = new Point[]{new Point(1,2), new Point(2,4),new Point(3,6),new Point(0,-2)};
		System.out.println(sol.most(points));
//		double x = 1.0/0.0;
//		System.out.println(x);
	}

}
