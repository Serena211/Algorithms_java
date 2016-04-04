package Class01_Sort;

import java.util.Arrays;

/*
 * Given an array of balls, where the color of the balls 
 * can only be Red, Green or Blue, sort the balls such 
 * that all the Red balls are grouped on the left side, 
 * all the Green balls are grouped in the middle and all 
 * the Blue balls are grouped on the right side. (Red is 
 * denoted by -1, Green is denoted by 0, and Blue is 
 * denoted by 1).
 * 
 * Examples
 * {0} is sorted to {0}
 * {1, 0} is sorted to {0, 1}
 * {1, 0, 1, -1, 0} is sorted to {-1, 0, 0, 1, 1}
 * 
 * Assumptions
 * The input array is not null.
 * 
 * Corner Cases
 * What if the input array is of length zero? 
 * In this case, we should not do anything as well.
 * */
public class RainbowSort {
	public static int[] rainbowSort(int[] array) {
		//corner case:
		if(array == null || array.length == 0) {
			return array;
		}
		int blue = array.length - 1;	//(blue,array.length - 1] are blue balls
		int green = 0;	//[red,green) are green balls
		int red = 0;	//[0,red) are red balls
		for (int i = 0; i <= blue; i++) {
			if(array[i] == -1) {
				swap(array, red, i);
				red++;
				green++;
			} else if(array[i] == 0) {
				green++;
			} else {
				swap(array, i, blue);
				blue--;
				i--;	// after swap, it need to judge array[i] again
			}
		}
		return array;
	}
	private static void swap(int[] array, int i, int j) {
		// TODO Auto-generated method stub
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[]{1,0,-1,-1,1,0};
		int[] rsl = rainbowSort(a);
		System.out.println(Arrays.toString(rsl));
	}

}
