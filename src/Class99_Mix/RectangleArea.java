package Class99_Mix;

/*
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 * 
 * Each rectangle is defined by its bottom left corner and top right corner as 
 * shown in the figure.
 * 
 * Assumption:
 * The total area is never beyond the maximum possible value of int.
 */
public class RectangleArea {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G,
			int H) {
		int areaA = (C - A) * (D - B);
		int areaB = (G - E) * (H - F);
		if ( B >= G || C <= E || H <= A || D <= F) {
			return areaA + areaB;
		}
		
		int areaIntersect = (Math.min(H, D) - Math.max(B, F)) * (Math.min(C, G) - Math.max(A, E));
		return areaA + areaB - areaIntersect;
	}

	public static void main(String[] args) {
		RectangleArea sol = new RectangleArea();
		System.out.println(sol.computeArea(-3, -3, 3, 3, -5, -5, -4, 0));
		
	}

}
