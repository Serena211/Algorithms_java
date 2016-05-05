package Class99_Mix;

/*
 * Write a program to find the n-th ugly number.
 * 
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
 * For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * 
 * Note that 1 is typically treated as an ugly number.
 */

/*
 * only include 2,3,5 ==> 1*2 2*2 3*2 4*2 5*2 6*2 8*2 9*2...
 * 						  1*3 2*3 3*3 4*3 5*3 6*3 8*3 9*3...
 * 						  1*5 2*5 3*5 4*5 5*5 6*5 8*5 9*5...	
 */
public class UglyNumber2 {
	public int nthUglyNumber(int n) {
		int[] ugly = new int[n + 1];
		// base case: find the 1-st ugly number:M[0] = 0 M[1] = 1
		ugly[1] = 1;
		// Initialize the start factors;
		int factor2 = 2;
		int factor3 = 3;
		int factor5 = 5;
		// For each kind factor, it multiplied by the known ugly numbers from first one
		int idx2 = 1;
		int idx3 = 1;
		int idx5 = 1;
		// Induction rule: M[i] = min(factor2, factor3, factor5)
		for (int i = 2; i <= n; i++) {
			ugly[i] = Math.min(Math.min(factor2, factor3), factor5);
			if (ugly[i] == factor2) {
				idx2++;
				factor2 = 2 * ugly[idx2];
			}
			if (ugly[i] == factor3) {
				idx3++;
				factor3 = 3 * ugly[idx3];
			}
			if (ugly[i] == factor5) {
				idx5++;
				factor5 = 5 * ugly[idx5];
			}
		}
		return ugly[n];
	}

	// public int nthUglyNumber(int n) {
	// if (n <= 0) {
	// return 0;
	// }
	// if (n <= 6) {
	// return n;
	// }
	// int i = 6;
	// int num = 6;
	// while (i < n) {
	// num++;
	// if (isUgly(num)) {
	// i++;
	// }
	// }
	// return num;
	// }
	// private boolean isUgly(int num) {
	// while (num % 2 == 0) {
	// num /= 2;
	// }
	// while (num % 3 == 0) {
	// num /= 3;
	// }
	// while (num % 5 == 0) {
	// num /= 5;
	// }
	// if (num == 1) {
	// return true;
	// } else {
	// return false;
	// }
	// }
	public static void main(String[] args) {
		UglyNumber2 sol = new UglyNumber2();
		System.out.println(sol.nthUglyNumber(12));
	}

}
