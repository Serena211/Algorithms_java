package Class05_BFS_Graph;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestNumberInSortedMatrix {
	/*
	 * Based on Dijkstra's algorithm
	 * 
	 * Given a matrix of size N x M. For each row the elements 
	 * are sorted in ascending order, and for each column the 
	 * elements are also sorted in ascending order. Find the 
	 * Kth smallest number in it.
	 * 
	 * Assumption:
	 * the matrix is not null, N > 0 and M > 0
	 * K > 0 and K <= N * M
	 */
	public int kthSmallest(int[][] matrix, int k) {
		int row = matrix.length;
		int col = matrix[0].length;
		boolean[][] flag = new boolean[matrix.length][matrix[0].length];
		Comparator<Cell> CellComparator = new Comparator<Cell>() {

			@Override
			public int compare(Cell o1, Cell o2) {
				if (o1.value == o2.value) {
					return 0;
				}
				// the first element of heap should be the target value
				return o1.value < o2.value? 1:-1;
			} 
			
		};
		PriorityQueue<Cell> maxHeap = new PriorityQueue<Cell>(k, CellComparator);
		maxHeap.offer(new Cell(0,0,matrix[0][0]));
		flag[0][0] = true;
		while (!maxHeap.isEmpty()) {
			Cell curCell = maxHeap.poll();
			int curX = curCell.row;
			int curY = curCell.col;
			if(curX + 1 < row && curY + 1< col) {
				maxHeap.offer(new Cell(curX + 1, curY, matrix[curX+1][curY]));
				flag[curX+1][curY] = true;
				maxHeap.offer(new Cell(curX + 1, curY, matrix[curX+1][curY]));
				flag[curX+1][curY] = true;
			}
		}
		
		return 0;
	}
	
	// Using Cell to store matrix's indexes and values
	static class Cell{
		int row;
		int col;
		int value;
		Cell(int row, int col, int value) {
			this.row = row;
			this.col = col;
			this.value = value;
		}
		
	}
	public static void main(String[] args) {
		/*
		 * 
		 * */

	}

}
