package Class99_Mix;

// Implement atoi to convert a string to an integer.
public class StringtoInteger {
	public int myAtoi(String str) {
		int index = str.length() - 1;
		int sign = 1;
		int total = 0;
		// 1. Empty string
		if (str == null || str.length() == 0) {
			return 0;
		}

		//
		int signCnt = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '+' || str.charAt(i) == '-') {
				if (signCnt == 0) {
					sign = str.charAt(i) == '+' ? 1 : -1;
					signCnt++;
				} else {
					break;
				}
			} else if (isDigit(str.charAt(i))) {
				// check overflow
				if (Integer.MAX_VALUE < total * 10
						|| Integer.MAX_VALUE / 10 == total
						&& Integer.MAX_VALUE % 10 < str.charAt(i) - '0') {
					return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
				}
				total = total * 10 + str.charAt(i) - '0';
			} else if (i>0 && (str.charAt(i) == ' ' && str.charAt(i-1) != ' ') || (str.charAt(i) != ' ' && str.charAt(i-1) != ' ') )  {
				return total * sign;
			}
		}
		return total * sign;
	}

	private boolean isDigit(char c) {
		if (c < '0' || c > '9') {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		StringtoInteger sol = new StringtoInteger();
		System.out.println(sol.myAtoi("   +1222, 123 "));
	}

}
