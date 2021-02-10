package leetcode.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leaf_SimilarTrees_872 {

	void makeArray(List<TreeNode> arr, TreeNode root) {
		if (root != null)
			mStack.add(root);

		while (mStack.empty() == false) {
			TreeNode popNode = mStack.pop();
			if (popNode.left == null && popNode.right == null)
				arr.add(popNode);
			else {
				if (popNode.right != null)
					mStack.add(popNode.right);
				if (popNode.left != null)
					mStack.add(popNode.left);
			}
		}

	}

	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
		ArrayList<TreeNode> arr1 = new ArrayList<TreeNode>();
		ArrayList<TreeNode> arr2 = new ArrayList<TreeNode>();
		mStack = new Stack<>();

		makeArray(arr1, root1);
		makeArray(arr2, root2);

		if (arr1.size() != arr2.size())
			return false;
		for (int i = 0; i < arr1.size(); i++)
			if (arr1.get(i).val != arr2.get(i).val)
				return false;

		return true;
	}

	Stack<TreeNode> mStack;
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}