package Class99_Mix;

class TreeNode {
	public TreeNode left;
	public TreeNode right;
	public int value;
	public int height;
	public TreeNode(int v) {
		value = v;
	}
}
public class HeightofBinaryTree {
	public int findHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = findHeight(root.left);
		int right = findHeight(root.right);
		return Math.max(left, right) + 1;
	} 
	public int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftHeight = getHeight(root.left);
		int rightHeight = getHeight(root.right);
		return Math.max(leftHeight, rightHeight) + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
