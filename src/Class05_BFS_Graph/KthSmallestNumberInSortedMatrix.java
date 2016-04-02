package Class05_BFS_Graph;

import java.util.Comparator;
import java.util.PriorityQueue;

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

public class KthSmallestNumberInSortedMatrix {
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
	
	public int kthSmallest(int[][] matrix, int k) {
		// get row and col numbers of this matrix
		int row = matrix.length;
		int col = matrix[0].length;
		// if a number in matrix has been visited, the flag = true;
		boolean[][] flag = new boolean[matrix.length][matrix[0].length];
		
		// Override Comparator of Priority Queue to compare Cell.value.
		Comparator<Cell> CellComparator = new Comparator<Cell>() {

			@Override
			public int compare(Cell o1, Cell o2) {
				if (o1.value == o2.value) {
					return 0;
				}
				// the first element of heap should be the target value
				return o1.value < o2.value? -1 : 1;
			} 
			
		};
		PriorityQueue<Cell> minHeap = new PriorityQueue<Cell>(k, CellComparator);
		
		minHeap.offer(new Cell(0,0,matrix[0][0]));
		flag[0][0] = true;
		// pop k-1 elements
		while (k > 1) {
			Cell curCell = minHeap.poll();
			int curX = curCell.row;
			int curY = curCell.col;
			// if a number has not been generated, add into the minHeap
			if (curX + 1 < row && !flag[curX + 1][curY]) {
				minHeap.offer(new Cell(curX + 1, curY, matrix[curX + 1][curY]));
				flag[curX + 1][curY] = true;
			}		
			if (curY + 1 < col && !flag[curX][curY + 1]) {
				minHeap.offer(new Cell(curX, curY + 1, matrix[curX][curY + 1]));
				flag[curX][curY + 1] = true;
			}				
			k--;
		}
		// the top of minHeap should be the Kth smallest number of this matrix
		return minHeap.poll().value;
	}

	public static void main(String[] args) {
		

	}

}
