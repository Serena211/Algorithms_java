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

public class MostPointsOnALine {
	// How to represent a line?
	// y = ax + b (a and b decide an unique line)
	// corner case: x = k, if a line is perpendicular to x-axis, a is undefined.
	public int most(Point[] points) {
		HashMap<Point, List<Point>> ab = new HashMap<Point, List<Point>>();
		HashMap<Integer, List<Point>> vertical = new HashMap<Integer, List<Point>>();
		int maxNum = 2;
		for (int i = 0; i < points.length - 1; i++) {
			for (int j = i; j < points.length; j++) {
				if (points[i].x == points[j].x) {
					int k = points[i].x;
					List<Point> cur = ab.get(k);
					if (cur == null) {
						cur = new ArrayList<Point>();
					}
					cur.add(points[i]);
					cur.add(points[j]);
					maxNum = Math.max(maxNum, cur.size());
				} else {
					int a = (points[i].y - points[j].y)/(points[i].x - points[j].x);
					int b = points[i].y - a * points[i].x;
					Point newAB = new Point(a, b);
					List<Point> cur = ab.get(newAB);
					if (cur == null) {
						cur = new ArrayList<Point>();
					}
					cur.add(points[i]);
					cur.add(points[j]);
					maxNum = Math.max(maxNum, cur.size());
				}
			}
		}
		return maxNum;
	}

	public static void main(String[] args) {
		MostPointsOnALine sol = new MostPointsOnALine();
		Point[] points = new Point[]{new Point(1,2), new Point(3,4),new Point(3,6),new Point(0,-2), };
		System.out.println(sol.most(points));;
	}

}
