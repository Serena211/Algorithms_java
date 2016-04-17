package Class10_Recursion;

/*
 * Generate an M * N 2D array in spiral order clock-wise starting from the top 
 * left corner, using the numbers of 1, 2, 3, …, M * N in increasing order.
 */

public class SpiralOrderGenerate {
	public int[][] spiralGenerate(int m, int n) {
		if (m == 0 || n == 0) {
			return new int[m][n];
		}
		int[][] rsl = new int[m][n];
		generator(rsl,m, n, 1, 0);

		return rsl;
	}

	private void generator(int[][] rsl, int m, int n, int counter, int offset) {
		// TODO Auto-generated method stub
		// base case:
		if (m == 0 && n == 0) {
			return;
		}
		if (m == 1) {
			for (int i = 0; i < n; i++) {
				rsl[offset][offset + i] = counter++;
			}
			return;
		}
		if (n == 1) {
			for (int i = 0; i < m; i++) {
				rsl[offset + i][offset] = counter++;
			}
			return;
		}
		
		for (int i = 0; i < n - 1; i++) {
			rsl[offset][offset + i] =  counter++;
		}
		for (int i = 0; i < m - 1; i++) {
			rsl[offset + i][offset + n - 1] = counter++;
		}
		for (int i = 0; i < n - 1; i++) {
			rsl[offset + m - 1][offset + n - 1 - i] = counter++;
		}
		for (int i = 0; i < m - 1; i++) {
			rsl[offset + m - 1 - i][offset] = counter++;
		}
		generator(rsl, m - 2, n - 2, counter, offset + 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpiralOrderGenerate sol = new SpiralOrderGenerate();
		System.out.println(sol.spiralGenerate(0, 0));

	}

}
