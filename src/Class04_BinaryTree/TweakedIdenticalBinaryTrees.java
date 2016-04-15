package Class04_BinaryTree;

import Class05_BFS_Graph.TreeNode;

/*
 * Determine whether two given binary trees are identical assuming any number of 
 * ‘tweak’s are allowed. A tweak is defined as a swap of the children of one node 
 * in the tree.
 */

public class TweakedIdenticalBinaryTrees {
	public boolean isTweakedIdentical(TreeNode one, TreeNode two) {
		if (one == null && two == null) {
			return true;
		} else if (one == null || two == null) {
			return false;
		}
		if (one.val != two.val) {
			return false;
		}
		
		return (isTweakedIdentical(one.left, two.left) && isTweakedIdentical(one.right, two.right)) 
				|| (isTweakedIdentical(one.right, two.left) && isTweakedIdentical(one.left, two.right));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
