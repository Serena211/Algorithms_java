package Class02_Recursion;
/*
 * Get the Kth number in the Fibonacci Sequence. 
 * (K is 0-indexed, the 0th Fibonacci number is 
 * 0 and the 1st Fibonacci number is 1).
 * 
 * Examples
 * 0th fibonacci number is 0
 * 1st fibonacci number is 1
 * 2nd fibonacci number is 1
 * 6th fibonacci number is 8
 * 
 * Corner Cases
 * 1. What if K < 0? in this case, we should always return 0.
 * 2. Is it possible the result fibonacci number is overflowed? 
 * 	We can assume it will not be overflowed when we solve this 
 * 	problem on this online judge, but we should also know that 
 * 	it is possible to get an overflowed number, and sometimes we 
 * 	will need to use something like BigInteger.
 * */
public class Fibonacci {
	public static long fibonacci(int K) {
		if (K <= 0) {
			return 0;
		}
		long[] fn = new long[3];
		for (int i = 0; i <= K; i++) {
			if (i == 0) {
				fn[0] = 0;
			} else if(i == 1) {
				fn[1] = 1;
			} else {
				fn[2] = fn[0] + fn[1];
				fn[0] = fn[1];
				fn[1] = fn[2];
			}
		}
		return fn[1];
	}
	public static void main(String[] args) {
		long rsl = fibonacci(50);
		System.out.println(rsl);
	}

}
