package Class18_Advanced1;

import Class05_BFS_Graph.TreeNode;
/*
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given 
 * nodes in the BST.
 * 
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined 
 * between two nodes v and w as the lowest node in T that has both v and w as descendants 
 * (where we allow a node to be a descendant of itself).”
 */
public class LowestCommonAncestor5 {
//	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//		if (root == null || root == p || root == q) {
//			return root;
//		}
//		if (root.val < p.val && root.val < q.val) {
//			return lowestCommonAncestor(root.right, p, q);
//		}
//		if (root.val > p.val && root.val > q.val) {
//			return lowestCommonAncestor(root.left, p, q);
//		}
//		if (root.val >= Math.min(p.val, q.val) && root.val <= Math.max(p.val, q.val)) {
//			return root;
//		}
//		return root;
//	}
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
        	return null;
        }
        while (root != null) {
        	if (root.val < p.val && root.val < q.val) {
        		root = root.right;
        	} else if (root.val > p.val && root.val > q.val) {
        		root = root.left;
        	} else {
        		return root;
        	}
        }
		return root;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
