package Class16_Probability;

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
		// lengths is not null and size >= 1 with non null
		int[] count = new int[4097];
		int sum = 0;
		for (Integer len : lengths) {
			count[len]++;
		}
		int i = 4097;
		while (sum <= 0.05 * lengths.size()) {
			sum += count[i - 1];
			i--;
		}
		return i;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
