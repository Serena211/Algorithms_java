package Class99_Mix;

public class SearchInShiftedSortedArray1 {
	public int search(int[] array, int target) {
		int split = findSplit(array);
		if (target < array[0]) {
			return helper(array, target, split + 1, array.length - 1);
		} else {
			return helper(array, target, 0, split);
		}
	}

	private int helper(int[] array, int target, int left, int right) {
		// TODO Auto-generated method stub
		if (left > right) {
			return -1;
		}
		int mid = left + (right - left) / 2;
		if (array[mid] == target) {
			return mid;
		} else if (array[mid] < target) {
			return helper(array, target, mid + 1, right);
		} else {
			return helper(array, target, left, mid - 1);
		}
	}

	private int findSplit(int[] array) {
		for (int i = 1; i < array.length; i++) {
			if (array[i] - array[i - 1] < 0) {
				return i - 1;
			}
		}
		return array.length / 2;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchInShiftedSortedArray1 sol = new SearchInShiftedSortedArray1();
		int[] array = new int[]{5,7,8,9,1,2,3,4};
		System.out.println(sol.search(array, 10));
	}

}
