package Class09_BitOperations;

public class decToBi {
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
		decToBi sol = new decToBi();
	    System.out.println(sol.intToString(5, 4));
	    System.out.println(sol.intToString(6, 4));
	}
}
