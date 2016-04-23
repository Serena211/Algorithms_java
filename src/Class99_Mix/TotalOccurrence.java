package Class99_Mix;

/*
 * Given a target integer T and an integer array A sorted in ascending order, 
 * Find the total number of occurrences of T in A.
 * 
 * Corner Cases
 * What if A is null? We should return 0 in this case.
 */
public class TotalOccurrence {
	public int totalOccurrence(int[] array, int target) {
		if (array == null || array.length == 0) {
			return 0;
		}
		int firstOccu = findFirst(array, target, 0, array.length - 1);
		int lastOccu = findLast(array, target, 0, array.length - 1);
		if (firstOccu == -1 || lastOccu == -1) {
			return 0;
		}
		return lastOccu - firstOccu + 1;
	}

	private int findLast(int[] array, int target, int l, int r) {
		while (l < r - 1) {
			int mid = l + (r - l) / 2;
			if (array[mid] == target) {
				l = mid;
			} else if (array[mid] < target) {
				l = mid;
			} else {
				r = mid;
			}
		}
		if (array[r] == target) {
			return r;
		}
		if (array[l] == target) {
			return l;
		}
		return -1;
	}

	private int findFirst(int[] array, int target, int l, int r) {
		while (l < r - 1) {
			int mid = l + (r - l) / 2;
			if (array[mid] == target) {
				r = mid;
			} else if (array[mid] < target) {
				l = mid;
			} else {
				r = mid;
			}
		}
		if (array[l] == target) {
			return l;
		}
		if (array[r] == target) {
			return r;
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TotalOccurrence sol = new TotalOccurrence();
		System.out.println(sol.totalOccurrence(new int[]{1,2,2,2,4,5,8,13,13}, 13));
	}

}
