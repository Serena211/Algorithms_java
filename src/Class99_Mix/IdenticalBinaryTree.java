package Class99_Mix;

import Class05_BFS_Graph.TreeNode;

/*
 * Check if two given binary trees are identical. Identical means the equal valued 
 * keys are at the same position in the two binary trees.
 */
public class IdenticalBinaryTree {
	public boolean isIdentical(TreeNode one, TreeNode two) {
		if (one == null && two == null) {
			return true;
		} else if (one == null || two == null) {
			return false;
		}
		if (one.val != two.val) {
			return false;
		}
		return isIdentical(one.left, two.left) && isIdentical(one.right, two.right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
