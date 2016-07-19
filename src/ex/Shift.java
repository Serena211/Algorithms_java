package ex;

import java.util.Arrays;

public class Shift {
	// right shift K times;
	// Assumeption: N and K are integers within the range [0..100];
    //				each element of array A is an integer within the range [−1,000..1,000].

	public int[] shift(int A[], int N, int K) {
		if (A == null ||A.length == 0 || N == 0 || K < 0) {
			return new int[0];
		}
		int[] rsl = new int[A.length];
		for (int i = 0; i < rsl.length; i++) {
			int index = i + K;
			if (index >= A.length) {
				index = index - A.length;
			}
			rsl[index] = A[i];
		}
		return rsl;
	}
	public static void main(String[] args) {
		int[] t = new int[]{3, 8, 9, 7, 6};
		Shift sol = new Shift();
		System.out.println(Arrays.toString(sol.shift(t, 5, 3)));
	}
}

