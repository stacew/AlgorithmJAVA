package leetcode.tree;

import java.util.Stack;

public class SymmetricTree_101 {
	private boolean checkLeftRight(TreeNode left, TreeNode right) {
		if (left != null && right != null && left.val == right.val)
			return true;

		return false;
	}

	private boolean isSymmetric_recur(TreeNode left, TreeNode right) {
		if (left == null && right == null)
			return true;

		if (checkLeftRight(left, right) == false)
			return false;
		if (isSymmetric_recur(left.left, right.right) == false)
			return false;
		if (isSymmetric_recur(right.left, left.right) == false)
			return false;

		return true;
	}

	// preOrder recursive // 0ms
	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;

		if (isSymmetric_recur(root.left, root.right) == false)
			return false;

		return true;
	}

	// preOrder iterative // 1ms
	public boolean isSymmetric_(TreeNode root) {
		if (root == null)
			return true;

		if (root.left == null && root.right == null)
			return true;
		if (checkLeftRight(root.left, root.right) == false)
			return false;

		// pre order iterative
		Stack<TreeNode> lStk = new Stack<>();
		Stack<TreeNode> rStk = new Stack<>();
		lStk.push(root.left);
		rStk.push(root.right);
		while (lStk.isEmpty() == false) {
			TreeNode lPop = lStk.pop();
			TreeNode rPop = rStk.pop();

			if (lPop == null && rPop == null)
				continue;
			if (checkLeftRight(lPop, rPop) == false)
				return false;
			
			lStk.push(lPop.left);
			lStk.push(lPop.right);
			rStk.push(rPop.right);
			rStk.push(rPop.left);
		}

		return true;
	}
}
