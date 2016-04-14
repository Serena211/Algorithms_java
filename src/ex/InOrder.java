package ex;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import Class05_BFS_Graph.TreeNode;

public class InOrder {
	public List<TreeNode> inOrder(TreeNode root) {
		List<TreeNode> rsl = new ArrayList<TreeNode>();
		if (root == null) {
			return rsl;
		}
		Deque<TreeNode> stack = new LinkedList<TreeNode>();// store sub trees' root
		TreeNode helper = root;
		while (!stack.isEmpty() || helper != null) {
			if (helper != null) {
				stack.offerFirst(helper);
				helper = helper.left;
			} else {
				helper = stack.pollFirst();
				rsl.add(helper);
				helper = helper.right;
			}
		}
		return rsl;
	}
	public static void main(String[] args) {
		InOrder sol = new InOrder();
		TreeNode root = new TreeNode(5);
		TreeNode a = new TreeNode(3);
		TreeNode b = new TreeNode(7);
		TreeNode c = new TreeNode(1);
		root.left = a;
		root.right = b;
		a.left = c;
		System.out.println(sol.inOrder(root));

		
	}

}
