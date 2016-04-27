package Class99_Mix;
/*
 * Given an integer, write a function to determine if it is a power of three.
 * 
 * Follow up:
 * Could you do it without using any loop / recursion?
 * 
 * Trick: maxPowerOfThree = 1162261467
 */
public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        // 3 ^ x = n ==> x = log3(n) ==> x = log10(n) / log10(3);
    	return Math.log10(n) / Math.log10(3) % 1 == 0;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//
		System.out.println(3.33 % 1);
	}

}
