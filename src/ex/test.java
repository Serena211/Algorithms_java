package ex;

/*
 * Given an integer n, count the total number of digit 1 appearing in all 
 * non-negative integers less than or equal to n.
 * 
 * For example:
 * Given n = 13,
 * Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.
 */

public class test {
    public int countDigitOne(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
			count += count1s(i);
		}
        return count;
    }
	private int count1s(int n) {
		char[] c = String.valueOf(n).toCharArray();
		int count = 0;
		for (char i : c) {
			if (i == '1') {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		test sol = new test();
		System.out.println(sol.countDigitOne(8130));
	}

}

