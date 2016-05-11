package Class99_Mix;

/*
 * Given a sequence of number: 1, 11, 21, 1211, 111221, …
 * The rule of generating the number in the sequence is as follow:
 * 1 is "one 1" so 11.
 * 11 is "two 1s" so 21.
 * 21 is "one 2 followed by one 1" so 1211.
 * 
 * Find the nth number in this sequence.
 * 
 * Assumptions:
 * n starts from 1, the first number is "1".
 */
public class CountAndSay {
	public String countAndSay(int n) {
		if (n <= 0) {
			return "";
		}
		String input = String.valueOf(n);
		int slow = 0;
		int fast = 1;
		int count = 1;
		StringBuilder sb = new StringBuilder();
		while (fast < input.length()) {
			if (input.charAt(slow) == input.charAt(fast)) {
				while (fast < input.length() && input.charAt(slow) == input.charAt(fast)) {
					count++;
					fast++;
				}
				sb.append(String.valueOf(count)).append(input.charAt(slow));
			} else {
				if (count == 1) {
					sb.append(String.valueOf(count)).append(input.charAt(slow));
				}
				slow = fast++;
				count = 1;
			}
		}
		if (slow == input.length() - 1) {
			sb.append(String.valueOf(1)).append(input.charAt(slow));
		}
		return sb.toString();
	}
	public String countAndSay2(int n) {
		if (n <= 0) {
			return "";
		}
		String res = "1";
		int index = 1;
		while (index < n) {
			StringBuilder temp = new StringBuilder();
			int count = 1;
			for (int i = 1; i < res.length(); i++) {
				if (res.charAt(i) == res.charAt(i - 1)) {
					count++;
				} else {
					temp.append(count).append(res.charAt(i - 1));
					count = 1;
				}
			}
			temp.append(count).append(res.charAt(res.length() - 1));
			res = temp.toString();
			index++;
		}
		return res;
	}
	public static void main(String[] args) {
		CountAndSay sol = new CountAndSay();
		System.out.println(sol.countAndSay2(6));
	}

}
