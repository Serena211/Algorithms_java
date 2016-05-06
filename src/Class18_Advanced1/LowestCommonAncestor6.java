package Class18_Advanced1;

import java.util.List;

/*
 * Given 2 nodes in a k-nary tree, find their lowest common ancestor.
 * 
 * Assumptions
 * K >= 2
 * There is no parent pointer for the nodes in the k-nary tree
 * The given K nodes are not guaranteed to be in the k-nary tree
 * 
 * Return
 * If there is only one node in subtree, return the node
 * If there is two nodes in the subtree, return lca
 * Otherwise, return null
 */
public class LowestCommonAncestor6 {
	class TreeNode {
		int val;
		List<TreeNode> Children;
	}
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode a, TreeNode b) {
		if (root == null || root == a || root == b) {
			return root;
		}
		TreeNode last = null;
		int count = 0;
		for (int i = 0; i < root.Children.size(); i++) {
			TreeNode temp = lowestCommonAncestor(root.Children.get(i), a, b);
			if (temp != null) {
				last = temp;
				count += 1;
			}
		}
		if (count == 2) {
			return root;
		}
		if (count == 1) {
			return last;	//If there is only one node in subtree, return the node
		}
		return null;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
