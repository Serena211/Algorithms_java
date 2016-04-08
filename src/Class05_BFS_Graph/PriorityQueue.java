package Class05_BFS_Graph;

//!!!!!!!!!!!!!!!!!!!!!!!!!!! check corner case!!!!!!!!!!!!!!!!!!!!!!
public class PriorityQueue {
	private int[] array;
	private int lastIdx;

	public PriorityQueue(int[] arr) {
		if (arr == null || arr.length == 0) {
			// throw exception // how to do this part?
		}
		array = arr;
		// the left-hand of lastIdx (not included) is the last index of array;
		lastIdx = array.length;
		heapify();
	}

	public PriorityQueue(int capacity) {
		if (capacity <= 0) {
			// throw exception // ????
		}
		array = new int[capacity];
		lastIdx = 0;
	}

	private void heapify() {
		for (int i = 0; i < array.length / 2 - 1; i++) {
			percolateDown(i);
		}
	}

	public int size() {
		return lastIdx;
	}

	public boolean isEmpty() {
		if (size() == 0) {
			return true;
		}
		return false;
	}

	public boolean isFull() {
		if (size() == array.length) {
			return true;
		}
		return false;
	}

	public int peek() {
		return array[0];
	}

	public int poll() {
		if (size() == 0) {
			// throw exception;
		}
		int rsl = array[0];
		array[0] = array[array.length - 1];
		lastIdx--;
		percolateDown(array[0]);
		return rsl;
	}

	public void offer(int val) {
		if (size() == array.length) {
			int[] newArray = new int[(int) 1.5 * array.length];
			copy(newArray, array);
			array = newArray;
		}
		array[size()] = val;
		percolateUp(size());
		lastIdx++;
	}

	public void update(int index, int value) {
		if (index < 0 || index >= size()) {
			// throw exception;
		}
		if (array[index] == value) {
			return;
		} else if (array[index] < value) { // new value > old value, percolate
											// down
			array[index] = value;
			percolateDown(index);
		} else { // new value < old value, percolate up
			array[index] = value;
			percolateUp(index);
		}
	}

	private void percolateUp(int index) {
		if (index == 0) {
			return;
		}
		int parent = (index - 1) / 2;
		while (index >= 0 && array[index] < array[parent]) {
			swap(array, index, parent);
			percolateUp(parent);
		}
	}

	private void percolateDown(int index) {
		int leftC = 2 * index + 1;
		int rightC = 2 * index + 1;
		if (leftC < size() && rightC < size()) {
			// get the index of smallest value
			int temp = findSmallest(array, index, leftC, rightC);
			if (temp == index) {
				return;
			} else if (temp == leftC) {
				swap(array, leftC, index);
				percolateDown(leftC);
			} else {
				swap(array, rightC, index);
				percolateDown(rightC);
			}
		} else if (leftC < size() && array[leftC] < array[index]) {
			swap(array, leftC, index);
		}
		return;
	}

	// copy the value from smaller array to larger array
	private void copy(int[] target, int[] origin) {
		if (target.length <= origin.length) {
			return;
		}
		for (int i : origin) {
			target[i] = origin[i];
		}
	}

	// swap two values of an array
	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	// find the index of smallest value
	private int findSmallest(int[] array, int p, int l, int r) {
		if (array[p] <= array[l] && array[p] <= array[r]) {
			return p;
		} else if (array[p] < array[l] && array[p] > array[r]) {
			return r;
		} else if (array[p] > array[l] && array[p] < array[r]) {
			return l;
		} else if (array[l] < array[r]) {
			return l;
		} else {
			return r;
		}
	}

}
