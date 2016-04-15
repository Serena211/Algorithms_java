package Class04_BinaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import Class05_BFS_Graph.TreeNode;

public class PreOrder {
	public List<Integer> preOrderItr(TreeNode root) {
		List<Integer> rsl = new ArrayList<Integer>();
		if (root == null) {
			return rsl;
		}
		Deque<TreeNode> stack = new LinkedList<TreeNode>();
		stack.offerFirst(root);
		while (!stack.isEmpty()) {
			TreeNode cur = stack.pollFirst();
			rsl.add(cur.val);
			if (cur.right != null) {
				stack.offerFirst(cur.right);
			} 
			if (cur.left != null) {
				stack.offerFirst(cur.left);
			} 
		}
		return rsl;
	}
	public List<TreeNode> preOrderRcur(TreeNode root) {
		List<TreeNode> rsl = new ArrayList<TreeNode>();
		return rsl;
	}
	public static void main(String[] args) {
		PreOrder sol = new PreOrder();
		TreeNode root = new TreeNode(5);
		TreeNode a = new TreeNode(3);
		TreeNode b = new TreeNode(7);
		TreeNode c = new TreeNode(1);
		root.left = a;
		root.right = b;
		a.left = c;
		System.out.println(sol.preOrderItr(root));
	}

}
