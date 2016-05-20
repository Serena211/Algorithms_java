package Class99_Mix;

/*
 * In URL encoding, whenever we see an space " ", we need to replace it with "20%". 
 * Provide a method that performs this encoding for a given string.
 * 
 * Examples
 * "google/q?flo wer market" → "google/q?flo20%wer20%market"
 * 
 * Corner Cases
 * If the given string is null, we do not need to do anything.
 */
public class EncodeSpace {
	public String encode(String input) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == ' ') {
				sb.append("20%");
			} else {
				sb.append(input.charAt(i));
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		EncodeSpace sol = new EncodeSpace();
		System.out.println(sol.encode("I love yahoo!"));
	}

}
