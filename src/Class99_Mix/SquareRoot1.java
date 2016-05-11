package Class99_Mix;

/*
 * Given an integer number n, find its integer square root.
 * 
 * Assumption:
 * n is guaranteed to be >= 0.
 * 
 * Example:
 * Input: 18, Return: 4
 * Input: 4, Return: 2
 */
public class SquareRoot1 {
	// method 1: math
	public int sqrt(int x) {
		
		return (int)Math.floor(Math.sqrt(x + 0.0));
	}
	// method 2: use dp O(n)
	// http://www.programcreek.com/2012/02/java-calculate-square-root-without-using-library-method/
	public int sqrt2(int x) {
	    if (x <= 0) {
	        return 0;
	      }
//		int[] M = new int[x + 1];
//		M[1] = 1;
//		for (int i = 2; i < M.length; i++) {
//			if (i >= Math.pow(M[i - 1],2) && i <Math.pow(M[i - 1] + 1,2)) {
//				M[i] = M[i - 1];
//			} else {
//				M[i] = M[i - 1] + 1;
//			}
//		}
//		return M[x];
		int lastSqrt = 1;
		for (int i = 2; i <= x; i++) {
			if (i >= Math.pow(lastSqrt + 1, 2)) {
				lastSqrt += 1;
			}
		}
		return lastSqrt;
	}
	// method 3: use equation
	// Equation: newSqrt = (sqrt + num/sqrt) / 2;
	// num = t^2 ==> num / t = t ==> t + num/t = 2 * t ==> (t + num / t) / 2 = t
	public static double sqrt3(int number) {
		// initial t and squareRoot with any num, t != squareRoot;
		double t = 1; 		
		double squareRoot = t / 2.0;
		while (t != squareRoot) {
			t = squareRoot;
			squareRoot = (t + (number / t)) / 2.0;
		}
	 
		return squareRoot;
	}
	public static void main(String[] args) {
		SquareRoot1 sol = new SquareRoot1();
		System.out.println(sol.sqrt3(15));
	}

}
