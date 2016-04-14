package Class07_Hashtable_String1;
/*
 * Given an integer array of size N - 1, containing all the numbers 
 * from 1 to N except one, find the missing number.
 * 
 * Assumptions
 * The given array is not null, and N >= 1
 * 
 * Examples
 * A = {2, 1, 4}, the missing number is 3
 * A = {1, 2, 3}, the missing number is 4
 * A = {}, the missing number is 1
 */
public class MissingNumber1 {
	// method 1: xor
	public int missing(int[] array) {
		int n = array.length + 1;
		int xorPredict = 0;
		for (int i = 0; i <= n; i++) {
			xorPredict ^= i;
		}
		int xorActual = 0;
		for (int num : array) {
			xorActual ^= num;
		}
		
		return xorActual ^ xorPredict;
	}
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int xorA = 0;
        for (int i = 0; i <= n; i++) {
            xorA ^= i;
        }
        int xorB = 0;
        for (int ele : nums) {
            xorB ^= ele;
        }
        return xorA ^ xorB;
    }
	public static void main(String[] args) {
		MissingNumber1 sol = new MissingNumber1();
		System.out.println(sol.missingNumber(new int[]{0}));
	}

}
