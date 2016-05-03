package Class16_Probability;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given a list of integers representing the lengths of urls, find the 95 percentile 
 * of all lengths (95% of the urls have lengths <= returned length).
 * 
 * Assumptions
 * The maximum length of valid url is 4096
 * The list is not null and is not empty and does not contain null
 * 
 * Examples
 * [1, 2, 3, ..., 95, 96, 97, 98, 99, 100], 95 percentile of all lengths is 95.
 */
public class Percentile95 {
	public int percentile95(List<Integer> lengths) {
		int[] urlCount = new int[4097];
		for (Integer i : lengths) {
			urlCount[i]++;		// count how many urls have same length
		}
		int sum = 0;
		int targetLen = 4096;
		while (sum <= 0.05 * lengths.size()) {
			sum += urlCount[targetLen--];
		}
		return targetLen + 1;
	}

	public static void main(String[] args) {
		Percentile95 sol = new Percentile95();
		List<Integer> lengths = new ArrayList<Integer>(Arrays.asList(1,2,2,2,2,2,2,2,4,5,6,1,331,232,5,3,143,104));
		System.out.println(sol.percentile95(lengths));
	}

}
