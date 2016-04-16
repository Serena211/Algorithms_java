package Class08_String2;

public class ReOrderArray {
	public int[] reorder(int[] array) {
		if (array.length <= 3) {
			return array;
		}
		helper(array, 0, array.length - 1);
		return array;
	}

	private void helper(int[] array, int l, int r) {
		// TODO Auto-generated method stub
		
		if (r -l <= 1) {
			return;
		}
		int size = r - l + 1;
		int mid = l + size / 2;
		int lMid = l + size / 4;
		int rMid = l + 3 * size / 4;
		reverse(array, lMid, mid - 1);
		reverse(array, mid, rMid - 1);
		reverse(array, lMid, rMid - 1);
		
		helper(array, l, l + 2 * (lMid - l) - 1);
		helper(array, l + 2 * (lMid - l), r);
	}
	private void reverse(int[] str, int left, int right) {
		// TODO Auto-generated method stub
		if (left >= right) {
			return;
		}
		while (left < right) {
			swap(str, left, right);
			left++;
			right--;
		}
	}
	private void swap(int[] arr, int i, int j) {
		// TODO Auto-generated method stub
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReOrderArray sol = new ReOrderArray();
		System.out.println(sol.reorder(new int[]{1,2,3,4,5,6,7}));
	}

}
