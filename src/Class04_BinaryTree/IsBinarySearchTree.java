package Class04_BinaryTree;

import Class05_BFS_Graph.TreeNode;

/*
 * Determine if a given binary tree is binary search tree.
 * 
 * Assumptions
 * There are no duplicate keys in binary search tree.
 * You can assume the keys stored in the binary search tree can not be 
 * Integer.MIN_VALUE or Integer.MAX_VALUE.
 * 
 * Corner Cases
 * What if the binary tree is null? Return true in this case.
 */
public class IsBinarySearchTree {
	public boolean isBST(TreeNode root) {
		return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isBST(TreeNode root, int minValue, int maxValue) {
		if (root == null) {
			return true;
		}
		if (root.val < minValue || root.val > maxValue) {
			return false;
		} else {
			return isBST(root.left, minValue, root.val - 1) 
					&& isBST(root.right, root.val + 1, maxValue);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
