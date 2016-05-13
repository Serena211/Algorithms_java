package Class22_Advanced4;

import Class05_BFS_Graph.TreeNode;

/*
 * Given a binary tree in which each node contains an integer number. Find the 
 * maximum possible subpath sum(both the starting and ending node of the subpath 
 * should be on the same path from root to one of the leaf nodes, and the subpath 
 * is allowed to contain only one node).
 * 
 * Assumptions
 * The root of given binary tree is not null
 */
public class MaximumPathSumBinaryTree3 {
	public int maxPathSum(TreeNode root) {
		int[] max = new int[]{Integer.MIN_VALUE};
		if (root == null) {
			return max[0];
		} else {
			max[0] = root.val;
		}
		helper(root, max);
		return max[0];
	}

	private int helper(TreeNode root, int[] max) {
		if (root == null) {
			return 0;
		}
		int left = helper(root.left, max);
		int right = helper(root.right, max);
		left = left < 0? 0 : left;
		right = right < 0? 0: right;
		
		max[0] = Math.max(Math.max(left, right) + root.val, max[0]);
		return root.val + Math.max(left, right);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
