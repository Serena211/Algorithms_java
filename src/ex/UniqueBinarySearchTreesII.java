package ex;

import Class05_BFS_Graph.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {
	/**
	 * Definition for a binary tree node. public class TreeNode { int val;
	 * TreeNode left; TreeNode right; TreeNode(int x) { val = x; } }
	 */

	public List<TreeNode> generateTrees(int n) {
		List<TreeNode> rsl = new ArrayList<TreeNode>();
		if (n == 0) {
			return rsl;
		}
		if (n == 1) {
			rsl.add(new TreeNode(n));
			return rsl;
		}
		helper(1, n, rsl);
		return rsl;
	}

	// level: 1 - n
	private void helper(int left, int right, List<TreeNode> rsl) {
	}

	public static void main(String[] args) {
		UniqueBinarySearchTreesII sol = new UniqueBinarySearchTreesII();
		System.out.println(sol.generateTrees(3));
	}

}
