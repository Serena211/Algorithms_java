package Class08_String2;

import java.util.ArrayList;
import java.util.List;

/*
 * Given an original string input, and two strings S and T, replace all 
 * occurrences of S in input with T.
 * 
 * Assumptions
 * input, S and T are not null, S is not empty string
 * 
 * Examples
 * input = "appledogapple", S = "apple", T = "cat", input becomes "catdogcat"
 * input = "dodododo", S = "dod", T = "a", input becomes "aoao"
 */

public class StringReplace {
	public String replace(String input, String s, String t) {
		if (input.length() == 0 || input.length() < s.length()) {
			return input;
		}
		List<Integer> sIdx = findS(input, s);
		char[] in = input.toCharArray();
		int gap = t.length() - s.length();
		if (gap > 0) {		
			return replaceLonger(in, s, t, sIdx);
		} else {
			return replaceShorter(in, s, t,sIdx);
		}
	}

	private String replaceShorter(char[] in, String s, String t, List<Integer> sIdx) {
		if (sIdx == null || sIdx.size() == 0) {
			return new String();
		}
		// TODO Auto-generated method stub
		int slow = sIdx.get(0);
		int fast = 0;
		while (fast < in.length ) {
			
		}
		return new String(in, 0, slow + t.length());
	}

	private String replaceLonger(char[] in, String s, String t, List<Integer> sIdx) {
		// TODO Auto-generated method stub
		return null;
	}

	private void replace(char[] in, List<Integer> sIdx, String t) {
		
		
	}

	private List<Integer> findS(String input, String s) {
		// TODO Auto-generated method stub
		// assumption: input is not null, input.length() > 0, s.length() <=input.length();
		List<Integer> rsl = new ArrayList<Integer>();
		for (int i = 0; i <= input.length() - s.length(); i++) {
			int j = 0;
			while (j < s.length()) {
				if (input.charAt(i + j) != s.charAt(j)) {
					break;
				}
				j++;
			}
			if (j == s.length()) {
				rsl.add(i);
			}
		}
		return rsl;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
