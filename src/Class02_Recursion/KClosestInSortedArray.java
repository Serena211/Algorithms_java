package Class02_Recursion;
/*
 * Given a target integer T, a non-negative integer K and an 
 * integer array A sorted in ascending order, find the K closest 
 * numbers to T in A.
 * 
 * Assumptions
 * A is not null
 * K is guranteed to be >= 0 and K is guranteed to be <= A.length
 * 
 * Return
 * A size K integer array containing the K closest numbers(not 
 * indices) in A, sorted in ascending order by the difference 
 * between the number and T. 
 * 
 * Examples
 * A = {1, 2, 3}, T = 2, K = 3, return {2, 1, 3} or {2, 3, 1}
 * A = {1, 4, 6, 8}, T = 3, K = 3, return {4, 1, 6}
 * */
public class KClosestInSortedArray {
	public static int[] kClosest(int[] array, int target, int k) {
		if(array == null || array.length == 0 || k == 0) {
			return new int[0];
		}
		int targetIdx = findClosest(array, target, 0, array.length-1, -1, Integer.MAX_VALUE);
		int[] rsl = getKClosest(array, target, k, targetIdx);
		return rsl;
	}

	private static int findClosest(int[] array, int target, int left, int right, int tempIdx,
			int gap) {
		if(left > right) {
			return tempIdx;
		}
		int mid = left + (right - left) / 2;
		if(array[mid] == target) {
			tempIdx = mid;
			return tempIdx;
		} else if(array[mid] < target) {
			int tempGap = Math.abs(target - array[mid]);
			if(tempGap < gap) {
				tempIdx = mid;
				gap = tempGap;
			}
			return findClosest(array, target, mid + 1, right, tempIdx, tempGap);
		} else {
			int tempGap = Math.abs(target - array[mid]);
			if(tempGap < gap) {
				tempIdx = mid;
				gap = tempGap;
			}
			return findClosest(array, target, left, mid - 1, tempIdx, tempGap);
		}
	}
	
	private static int[] getKClosest(int[] array, int target, int k, int targetIdx) {
		int[] rsl = new int[k];
		int i = targetIdx;
		int j = targetIdx + 1;
		int idx = 0;
		while (idx < k) {
			int gap1 = Integer.MAX_VALUE;
			int gap2 = Integer.MAX_VALUE;
			if (i >= 0) {
				gap1 = Math.abs(target - array[i]);
			}
			if (j < array.length) {
				gap2 = Math.abs(target - array[j]);
			}
			if(gap1 < gap2) {
				rsl[idx++] = array[i--];
			} else {
				rsl[idx++] = array[j++];
			}
		}
		return rsl;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] rsl = kClosest(new int[]{1,5},10,2);
		System.out.println(rsl.toString());
	}

}
