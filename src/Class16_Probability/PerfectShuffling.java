package Class16_Probability;

/*
 * Given an array of integers (without any duplicates), shuffle the array such 
 * that all permutations are equally likely to be generated.
 * 
 * Assumptions
 * The given array is not null
 */

public class PerfectShuffling {
	public void shuffle(int[] array) {
		if (array.length <= 1) {
			return;
		}
		int index = array.length;
		while (index > 1) {
			int cur = (int) (Math.random() * index);
			swap(array, cur, index - 1);
			index--;
		}
	}

	private void swap(int[] array, int i, int j) {
		// TODO Auto-generated method stub
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PerfectShuffling sol = new PerfectShuffling();
		int[] array = new int[]{1,2};
		sol.shuffle(array);
		System.out.println(
				);
	}

}
