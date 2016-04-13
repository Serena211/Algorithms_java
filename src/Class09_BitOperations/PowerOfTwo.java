package Class09_BitOperations;

/*
 * Determine if a given integer is power of 2.
 */
public class PowerOfTwo {
	public boolean isPowerOfTwo(int number) {
		if (number <= 0) {
			return false;
		}
		int temp = number - 1;
		if ((number & temp) == 0) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		PowerOfTwo sol = new PowerOfTwo();
		System.out.println(sol.isPowerOfTwo(1024));
	}

}
