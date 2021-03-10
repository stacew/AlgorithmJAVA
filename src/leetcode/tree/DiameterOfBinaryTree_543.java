package leetcode.tree;

public class DiameterOfBinaryTree_543 {

	int mRetMax;

	public int diameterOfBinaryTree(TreeNode root) {
		if (root == null)
			return 0;

		diameterOfBinaryTree_recur(root);
		return mRetMax;
	}

	private int diameterOfBinaryTree_recur(TreeNode node) {
		if (node == null)
			return 0;

		int left = diameterOfBinaryTree_recur(node.left);
		int right = diameterOfBinaryTree_recur(node.right);

		int checkMax = left + right;
		mRetMax = Math.max(mRetMax, checkMax);

		return Math.max(left, right) + 1;
	}
}
