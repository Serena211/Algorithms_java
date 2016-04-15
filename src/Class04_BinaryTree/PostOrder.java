package Class04_BinaryTree;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import Class05_BFS_Graph.TreeNode;

public class PostOrder {
	public List<TreeNode> postOrder(TreeNode root) {
		List<TreeNode> rsl = new ArrayList<TreeNode>();
		if (root == null) {
			return rsl;
		}
		Deque<TreeNode> stack = new LinkedList<TreeNode>();// store sub trees' root
		TreeNode prev = null;
		stack.offerFirst(root);
		
		while (!stack.isEmpty()) {
			TreeNode cur = stack.peekFirst();
			if (prev == null || cur == prev.left || cur == prev.right) {
				if (cur.left != null) {
					stack.offerFirst(cur.left);
				} else if (cur.right != null) {
					stack.offerFirst(cur.right);
				} else {
					rsl.add(cur);
					stack.pollFirst();
				}
			} else if (cur.left == prev) {
				if (cur.right != null) {
					stack.offerFirst(cur.right);
				}
			} else {
				rsl.add(cur);
				stack.pollFirst();
			}
			prev = cur;
		}
		return rsl;
	}
	public List<Integer> post(TreeNode root) {
		List<Integer> rsl = new ArrayList<Integer>();
		if (root == null) {
			return rsl;
		}
		TreeNode prev = null;
		Deque<TreeNode> stack = new LinkedList<TreeNode>();
		stack.offerFirst(root);
		while (!stack.isEmpty()) {
			TreeNode cur = stack.peekFirst();
			if (prev == null || cur == prev.left || cur == prev.right) {
				if (cur.left != null) {
					stack.offerFirst(cur.left);
				} else if (cur.right != null) {
					stack.offerFirst(cur.right);
				} else {
					rsl.add(cur.val);
					stack.pollFirst();
				}
			} else if (prev == cur.left) {
				if (cur.right != null) {
					stack.offerFirst(cur.right);
				} else {
					rsl.add(cur.val);
					stack.pollFirst();
				}
			} else {
				rsl.add(cur.val);
				stack.pollFirst();
			}
			prev = cur;
		}
		return rsl;
	}
	public static void main(String[] args) {
		PostOrder sol = new PostOrder();
		TreeNode root = new TreeNode(5);
		TreeNode a = new TreeNode(3);
		TreeNode b = new TreeNode(7);
		TreeNode c = new TreeNode(1);
		root.left = a;
		root.right = b;
		a.left = c;
		for (Integer t : sol.post(root)) {
			System.out.println(t);
		}
	}

}
