package Sort;

/*
 * Given an array with n objects colored red, white or blue, sort them so that 
 * objects of the same color are adjacent, with the colors in the order red, 
 * white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, 
 * and blue respectively.
 * 
 * Note:
 * You are not suppose to use the library's sort function for this problem.
 */
public class SortColors {
	public void sortColors(int[] nums) {
		if (nums == null || nums.length < 2) {
			return;
		}
		// three pointers:
		// red: 0 - red-th are red color
		// white: red - white-th are white color
		// ** white - blue-th are unknown area
		// blue: blue - end are blue color
		int red = 0;
		int white = 0;
		int blue = nums.length - 1;
		for (int i = 0; i <= blue; i++) {
			if (nums[i] == 0) {
				swap(red, i, nums);
				red++;
				white++;
			} else if (nums[i] == 1) {
//				swap(white, i, nums);
				white++;
			} else {
				swap(blue, i, nums);
				blue--;
				i--;
			}
		}
	}

	private void swap(int i, int j, int[] array) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortColors sol = new SortColors();
		int[] nums = new int[] {0,1,1,2,1,2,0,0 };
		sol.sortColors(nums);
		System.out.println(nums.toString());
	}

}
