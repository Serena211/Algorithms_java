package Class99_Mix;
/*
 * Given an integer n, count the total number of digit 1 appearing in all 
 * non-negative integers less than or equal to n.
 * 
 * For example:
 * Given n = 13,
 * Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.
 */

public class NumberofDigitOne {
//    public int countDigitOne(int n) {
//        int count = 0;
//        for (int i = 1; i <= n; i++) {
//			count += count1s(i);
//		}
//        return count;
//    }
//	private int count1s(int n) {
//		char[] c = String.valueOf(n).toCharArray();
//		int count = 0;
//		for (char i : c) {
//			if (i == '1') {
//				count++;
//			}
//		}
//		return count;
//	}
    public int countDigitOne(int n) {
        int len = 0;
        while (n  > 10) {
        	n /= (10^len);
        	len++;
        }
        long[] count1s = new long[8];
        for (int i = 0; i < count1s.length; i++) {
			if (i == 0) {
				count1s[i] = 1;
			} else {
				count1s[i] = (long) (count1s[i - 1] * 10 + Math.pow(10, i));
			}
		}
        char[] c = String.valueOf(n).toCharArray();
        int count = 0;
        for (int i = 0; i < c.length; i++) {
			if (c[0] - '0' >= 2) {
//				count
			}
		}
        
        return count;
    }
	public static void main(String[] args) {
		NumberofDigitOne sol = new NumberofDigitOne();
		System.out.println(sol.countDigitOne(824883294));
	}

}
