package ex;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 N is an integer within the range [1..100,000];
 each element of array A is an integer within the range [0..1,000,000,000];
 each element of array B is an integer that can have one of the following values: 0, 1;
 the elements of A are all distinct.

 */

public class Fish {
	public int fishAlive(int[] A, int[] B) {
		int alive = A.length;
		List<Integer> upstream = new ArrayList<Integer>();
		List<Integer> downstream = new ArrayList<Integer>();
		for (int i = 0; i < B.length; i++) {
			if (B[i] == 0) {
				upstream.add(i);
			} else {
				downstream.add(i);
			}
		}

		int up = 0;
		int down = 0;
		while (up < upstream.size() && down < downstream.size()) {
			if (A[upstream.get(up)] > A[downstream.get(down)]) {
				down++;
			} else {
				up++;
			}
		}
		if (up == upstream.size()) {
			alive = downstream.size() - down;
		} else {
			alive = upstream.size() - up;
		}
		return alive;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fish f = new Fish();
		System.out.println(f.fishAlive(new int[]{4,5,2,1,3}, new int[]{0,1,0,0,0}));
	}

}
