package Class18_Advanced1;

/*
 * Given two nodes in a binary tree (with parent pointer available), find their 
 * lowest common ancestor.
 * 
 * Assumptions
 * There is parent pointer for the nodes in the binary tree
 * 
 * The given two nodes are not guaranteed to be in the binary tree
 */
public class LowestCommonAncestor2 {
	public TreeNodeP lowestCommonAncestor(TreeNodeP one, TreeNodeP two) {
		// assumption: one && two != null
		int len1 = length(one);
		int len2 = length(two);
		if (len1 < len2) {
			return lca(one, two, len2 - len1);
		} else {
			return lca(two, one, len1 - len2);
		}
	}

	private TreeNodeP lca(TreeNodeP smaller, TreeNodeP longer, int diff) {
		// TODO Auto-generated method stub
		while (diff > 0) {
			longer = longer.parent;
			diff--;
		}
		while (longer != smaller) {
			longer = longer.parent;
			smaller = smaller.parent;
		}
		return longer;
	}

	private int length(TreeNodeP one) {
		int len = 0;
		while (one != null) {
			len++;
			one = one.parent;
		}
		return len;
	}

	public static void main(String[] args) {
		LowestCommonAncestor2 sol = new LowestCommonAncestor2();
//		sol.lowestCommonAncestor(one, two)
	}

}
