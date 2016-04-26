package Class12_DP2;

/*
 * Given an array A of non-negative integers, you are initially positioned at index 0 
 * of the array. A[i] means the maximum jump distance from index i (you can only jump 
 * towards the end of the array). Determine the minimum number of jumps you need to 
 * reach the end of array. If you can not reach the end of the array, return -1.
 * 
 * Assumptions
 * The given array is not null and has length of at least 1
 */

public class ArrayHopper2 {
	public int minJump(int[] array) {
		if (array.length <=1) {
			return 0;
		}
		// A[i] means the maximum jump distance from index i (you can only jump 
		// towards the end of the array).
		int[] A = new int[array.length];
		A[array.length - 1] = 0;
		for (int i = array.length - 2; i >= 0; i--) {
			if (array[i] >= array.length - i) {
				A[i] = 1;
			} else {
				A[i] = Integer.MAX_VALUE;
				for (int j = i+1; j <= array[i] + i; j++) {
					if (A[j] != Integer.MAX_VALUE) {
						A[i] = Math.min(A[i], 1 + A[j]);
					}
				}
			}
		}
		return A[0] == Integer.MAX_VALUE ? -1 : A[0];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayHopper2 sol = new ArrayHopper2();
		int[] array = new int[]{4,2,1,1,0,4};
		System.out.println(sol.minJump(array));
	}

}
