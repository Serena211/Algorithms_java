package Class99_Mix;

/*
 * Given an integer array of length L, find the number that occurs more than 0.5 * L times.
 * 
 * Assumptions
 * The given array is not null or empty.
 * It is guaranteed there exists such a majority number
 * 
 * Examples
 * A = {1, 2, 1, 2, 1}, return 1
 */
public class MajorityNumber1 {
	// method 2: if a number occurs more than 0.5*L times ==> must have two
	// connect.
	public int majority(int[] array) {
		if (array.length == 1) {
			return array[0];
		}
		int count = 1;
		int candidate = array[0];
		for (int i = 1; i < array.length; i++) {
			if (count == 0) {
				candidate = array[i];
				count++;
			} else {
				if (array[i] == candidate) {
					count++;
				} else {
					count--;
				}
			}
		}
		return candidate;
	}

	public static void main(String[] args) {
		MajorityNumber1 sol = new MajorityNumber1();
		System.out.println(sol.majority(new int[] { 1, 2, 2 }));
	}

}
