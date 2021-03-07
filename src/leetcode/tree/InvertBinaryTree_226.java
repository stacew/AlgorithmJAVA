package leetcode.tree;

import java.util.Stack;

public class InvertBinaryTree_226 {
	private void swapChild(TreeNode p) {
		TreeNode temp = p.left;
		p.left = p.right;
		p.right = temp;
	}

	public TreeNode invertTree(TreeNode root) {
		Stack<TreeNode> stk = new Stack<>();
		stk.push(root);
		while (stk.isEmpty() == false) {
			TreeNode pop = stk.pop();
			if (pop == null)
				continue;
			swapChild(pop);
			stk.push(pop.left);
			stk.push(pop.right);
		}

		return root;
	}
}
