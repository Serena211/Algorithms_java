package Class08_String2;

import java.util.Arrays;
// assumption: The given array is not null.
public class ReOrderArray {
	public int[] reorder(int[] array) {
		if (array.length <= 3) {
			return array;
		}
		if (array.length % 2 == 0) {
			helper(array, 0, array.length - 1);
		} else {
			helper(array, 0, array.length - 2);
		}		
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
			int temp = str[left];
			str[left] = str[right];
			str[right] = temp;
			left++;
			right--;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReOrderArray sol = new ReOrderArray();
		int[] t = new int[]{1,2,3,4,5,6,7};
		int[] rsl = sol.reorder(t);
		System.out.println(Arrays.toString(rsl));
	}

}
