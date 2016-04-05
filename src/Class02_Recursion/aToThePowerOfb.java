package Class02_Recursion;

/*
 * Evaluate a to the power of b, assuming both a and 
 * b are integers and b is non-negative. 
 * 
 * Examples
 * power(2, 0) = 1
 * power(2, 3) = 8
 * power(0, 10) = 0
 * power(-2, 5) = -32
 * power(0,0) = 0
 * 
 * Corner Cases
 * What if the result is overflowed? 
 * 	We can assume the result will not be overflowed when 
 * 	we solve this problem on this online judge.
 * */

public class aToThePowerOfb {
	public static int power1(int a, int b) {
		// base case:
		if (a == 0) {
			return 0;
		}
		if (b / 2 == 0) {
			return b == 1 ? a : 1;
		}
		// recursion rule: a^b --> a^(tempB) * a^(b-tempB)
		int tempB = b / 2;
		int leftRsl = power1(a, tempB);
		int rightRsl = power1(a, b - tempB);
		return leftRsl * rightRsl;
	}

	public static long power2(long a, long b) {
		// base case:
		if (a == 0) {
			return 0;
		}
		if (b / 2 == 0) {
			return b == 1 ? a : 1;
		}
		// recursion rule:
		long temp = power2(a, b / 2);
		if (b % 2 == 0) {
			return temp * temp;
		} else {
			return a * temp * temp;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long rsl = power2(11, 0);
		System.out.println(rsl);
	}

}
