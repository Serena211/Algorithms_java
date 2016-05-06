package Class18_Advanced1;

import java.util.HashSet;
import java.util.List;

import Class05_BFS_Graph.TreeNode;

/*
 * Given K nodes in a binary tree, find their lowest common ancestor.
 * 
 * Assumptions
 * K >= 2
 * There is no parent pointer for the nodes in the binary tree
 * 
 * The given K nodes are guaranteed to be in the binary tree
 */

public class LowestCommonAncestor4 {
	public TreeNode lowestCommonAncestor(TreeNode root, List<TreeNode> nodes) {
		HashSet<TreeNode> set = getSet(nodes);
		if (root == null) {
			return root;
		}
		if (set.contains(root)) {
			return root;
		}
		TreeNode left = lowestCommonAncestor(root.left, nodes);
		TreeNode right = lowestCommonAncestor(root.right, nodes);
		if (left != null && right != null) {
			return root;
		}
		return left == null ? right : left;
	}

	private HashSet<TreeNode> getSet(List<TreeNode> nodes) {
		HashSet<TreeNode> set = new HashSet<TreeNode>();
		for (TreeNode t : nodes) {
			set.add(t);
		}
		return set;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
