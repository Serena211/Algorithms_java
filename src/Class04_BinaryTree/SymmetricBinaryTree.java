package Class04_BinaryTree;

import Class05_BFS_Graph.TreeNode;

/*
 * Check if a given binary tree is symmetric.
 */
public class SymmetricBinaryTree {
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		
		return helper(root.left, root.right);		
	}

	private boolean helper(TreeNode left, TreeNode right) {
		// TODO Auto-generated method stub
		if (left == null && right == null) {
			return true;
		} else if (left == null || right == null) {
			return false;
		}
		if (left.val != right.val) {
			return false;
		}
		
		return helper(left.left, right.right) && helper(left.right, right.left);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SymmetricBinaryTree sol = new SymmetricBinaryTree();
		TreeNode root = new TreeNode(5);
		TreeNode a = new TreeNode(3);
		TreeNode b = new TreeNode(3);
		TreeNode c = new TreeNode(1);
		TreeNode e = new TreeNode(1);
		root.left = a;
		root.right = b;
		a.left = c;
		b.right = e;
		System.out.println(sol.isSymmetric(root));
	}

}
