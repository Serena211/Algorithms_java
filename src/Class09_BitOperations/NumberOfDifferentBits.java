package Class09_BitOperations;

/*
 * Determine the number of bits that are different for two given integers.
 * 
 * Examples
 * 5(“0101”) and 8(“1000”) has 3 different bits
 */

public class NumberOfDifferentBits {
	public int diffBits(int a, int b) {
		int temp = (a ^ b);
//		System.out.println(intToString(temp, 4));
		int count = 0;
		if (temp < 0) {
			temp = (temp ^ (1 << 31));
//			System.out.println(intToString(temp, 4));
			return helper(temp,count + 1);
		} else {
			return helper(temp, count);
		}

	}

	private int helper(long xor, int cnt) {
		// TODO Auto-generated method stub
		while (xor > 0) {

			if ((xor & 1) == 1) {
				cnt += 1;
			}
			xor = (xor >> 1);
		}
		return cnt;
	}
	/**
	 * Converts an integer to a 32-bit binary string
	 * @param number
	 *      The number to convert
	 * @param groupSize
	 *      The number of bits in a group
	 * @return
	 *      The 32-bit long bit string
	 */
	public String intToString(int number, int groupSize) {
	    StringBuilder result = new StringBuilder();

	    for(int i = 31; i >= 0 ; i--) {
	        int mask = 1 << i;
	        result.append((number & mask) != 0 ? "1" : "0");

	        if (i % groupSize == 0)
	            result.append(" ");
	    }
	    result.replace(result.length() - 1, result.length(), "");

	    return result.toString();
	}

	public static void main(String[] args) {
		NumberOfDifferentBits sol = new NumberOfDifferentBits();
	    System.out.println(sol.intToString(4096, 4));
//	    System.out.println(sol.intToString(-2, 4));
		System.out.println(sol.diffBits(2147483647,-2147483648));
	}

}
