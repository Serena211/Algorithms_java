package Class99_Mix;

import Class05_BFS_Graph.TreeNode;

/*
 * Given a Binary Search Tree with only two nodes swapped. Try to find them and 
 * recover the binary search tree.
 */
public class RecoverBinarySearchTree {
	public TreeNode recover(TreeNode root) {
		if (root == null) {
			return root;
		}
		helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
		return root;
	}

	private void helper(TreeNode root, int minValue, int maxValue) {
		// TODO Auto-generated method stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
