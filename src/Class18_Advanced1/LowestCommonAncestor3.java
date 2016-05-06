package Class18_Advanced1;

import Class05_BFS_Graph.TreeNode;

/*
 * Given two nodes in a binary tree, find their lowest common ancestor (the given 
 * two nodes are not guaranteed to be in the binary tree).
 * 
 * Return null If any of the nodes is not in the tree.
 * 
 * Assumptions
 * There is no parent pointer for the nodes in the binary tree
 * 
 * The given two nodes are not guaranteed to be in the binary tree
 */
public class LowestCommonAncestor3 {
	  public TreeNode lowestCommonAncestor(TreeNode root,
		      TreeNode one, TreeNode two) {
		    TreeNode tempAncester = helper(root,one,two);
		    if (tempAncester == one || tempAncester == two) {
		    	if(helper(tempAncester.left,one,two) != null || helper(tempAncester.right,one,two) != null) {
		    		return tempAncester;
		    	}
		    	return null;
		    }
		    return tempAncester;
		  }
	private TreeNode helper (TreeNode root,
		      TreeNode one, TreeNode two) {
		if (root == null || root == one || root == two) {
		      return root;
		    }

		    TreeNode left = helper(root.left, one, two);
		    TreeNode right = helper(root.right, one, two);
		    if (left != null && right != null) {
				return root;
			} else 
				return left == null? right:left;
	}

	public static void main(String[] args) {
		Integer[] arr = new Integer[]{1,3,5,2,6,3,null};
		TreeNode root = new TreeBuilder(arr).builder();
		LowestCommonAncestor3 sol = new LowestCommonAncestor3();
		TreeNode one = new TreeNode(6);
		TreeNode two = new TreeNode(2);
		System.out.println(sol.lowestCommonAncestor(root, one, two));
	}

}
