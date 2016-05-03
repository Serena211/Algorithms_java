package Class18_Advanced1;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import Class05_BFS_Graph.TreeNode;

/*
 * Get the list of keys in a given binary tree layer by layer in zig-zag order.
 * 
 * Corner Cases
 * What if the binary tree is null? Return an empty list in this case.
 */
public class ZigZagOrder {
	public List<Integer> zigZag(TreeNode root) {
		List<Integer> rsl = new ArrayList<Integer>();
		if (root == null) {
			return rsl;
		}
		Deque<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		int size = 1;
		int layer = 1;
		while (!queue.isEmpty()) {
			if (layer % 2 == 1) {
				for (int i = 0; i < size; i++) {
					TreeNode cur = queue.pollLast();
					rsl.add(cur.val);
					if (cur.right != null) {
						queue.offerFirst(cur.right);
					}
					if (cur.left != null) {
						queue.offerFirst(cur.left);
					}
				}
			} else {
				for (int i = 0; i < size; i++) {
					TreeNode cur = queue.pollFirst();
					rsl.add(cur.val);
					if (cur.left != null) {
						queue.offerLast(cur.left);
					}
					if (cur.right != null) {
						queue.offerLast(cur.right);
					}
				}
			}
			size = queue.size();
			layer++;

		}
		return rsl;
	}

	public static void main(String[] args) {
		ZigZagOrder sol = new ZigZagOrder();
		TreeNode root = new TreeNode(5);
		TreeNode a = new TreeNode(3);
		TreeNode b = new TreeNode(8);
		TreeNode c = new TreeNode(1);
		TreeNode d = new TreeNode(4);
		TreeNode e = new TreeNode(11);

		root.left = a;
		root.right = b;
		a.left = c;
		a.right = d;
		b.right = e;
		List<Integer> rsl = sol.zigZag(root);
		System.out.println(rsl);
	}

}
