package Class04_BinaryTree;

import Class05_BFS_Graph.TreeNode;

/*
 * Check if a given binary tree is balanced. A balanced binary tree is one in which 
 * the depths of every node’s left and right subtree differ by at most 1.
 * 
 * Corner Cases
 * What if the binary tree is null? Return true in this case.
 */

public class CheckIfBinaryTreeIsBalanced {
	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		
		return height(root) != -1;
	}

	private int height(TreeNode root) {
		// TODO Auto-generated method stub
		if (root == null) {
			return 0;
		}
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		if (leftHeight == -1) {
			return -1;
		}
		if (rightHeight == -1) {
			return -1;
		}
		if (Math.abs(rightHeight - leftHeight) >1) {
			return - 1;
		}
		
		return Math.max(rightHeight, leftHeight) + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CheckIfBinaryTreeIsBalanced sol = new CheckIfBinaryTreeIsBalanced();
		TreeNode root = new TreeNode(5);
		TreeNode a = new TreeNode(3);
		TreeNode b = new TreeNode(7);
		TreeNode c = new TreeNode(1);
		root.left = a;
		root.right = b;
		a.left = c;
		System.out.println(sol.isBalanced(root));
	}

}
