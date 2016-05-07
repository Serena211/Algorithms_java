package Class20_Advanced2;

import Class05_BFS_Graph.TreeNode;

/*
 * Given a binary tree in which each node contains an integer number. Find the 
 * maximum possible sum from one leaf node to another leaf node. If there is no 
 * such path available, return Integer.MIN_VALUE(Java)/INT_MIN (C++).
 * 
 * Examples

	 	 -15
	
	 	/    \
	
	   2      11
	
	 		/    \
	
	 	   6     14

 The maximum path sum is 6 + 11 + 14 = 31.
 */
public class MaximumPathSumBinaryTree {
	public int maxPathSum(TreeNode root) {
		int[] max = new int[]{Integer.MIN_VALUE};
		if (root == null) {
			return max[0];
		}
		maxSum(root, max);
		return max[0];
	}

	private int maxSum(TreeNode root, int[] max) {
		// TODO Auto-generated method stub
		if (root == null) {
			return 0;
		}
		int left = maxSum(root.left, max);
		int right = maxSum(root.right, max);
		if (root.left != null && root.right != null) {
			max[0] = Math.max(max[0], root.val + left + right);
			return Math.max(left, right) + root.val;
		}
		return root.right == null? root.val + left : root.val + right;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
