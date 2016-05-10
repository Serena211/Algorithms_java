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
		StringBuilder sb = new StringBuilder();
		int fromIdx = 0;
		int matchIdx = input.indexOf(s, fromIdx);
		while (matchIdx != -1) {
			sb.append(input, fromIdx, matchIdx).append(t);
			fromIdx = matchIdx + s.length();
			matchIdx = input.indexOf(s, fromIdx);
		}
		sb.append(input, fromIdx, input.length());
		return sb.toString();
	}

	public static void main(String[] args) {
		StringReplace sol = new StringReplace();
		System.out.println(sol.replace("aaa", "aa", "bbb"));
	}

}
