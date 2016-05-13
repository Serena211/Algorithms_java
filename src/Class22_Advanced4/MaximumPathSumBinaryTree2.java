package Class22_Advanced4;

import Class05_BFS_Graph.TreeNode;

/*
 * Given a binary tree in which each node contains an integer number. Find the 
 * maximum possible sum from any node to any node (the start node and the end 
 * node can be the same). 
 * 
 * Assumptions
 * ​The root of the given binary tree is not null
 */
public class MaximumPathSumBinaryTree2 {
	public int maxPathSum(TreeNode root) {
		int[] max = new int[]{Integer.MIN_VALUE};
		if (root == null) {
			return Integer.MIN_VALUE;
		} else {
			max[0] = root.val;
		}
		helper(root, max);
		return max[0];
	}

	private int helper(TreeNode root, int[] max) {
		// TODO Auto-generated method stub
		if (root == null) {
			return 0;
		}
		int left = helper(root.left, max);
		int right = helper(root.right, max);
		
		// largest subArray sum: dp_class15
		left = left < 0 ? 0 : left;			// check left path sum. if sum < 0, then don't add it on root
		right = right < 0? 0 : right;		// check right path sum as above
		max[0] = Math.max(max[0], root.val + left + right);	//if left == 0 && right == 0, current max == root.val
		return root.val + Math.max(left, right);	// return largest sum path.
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
