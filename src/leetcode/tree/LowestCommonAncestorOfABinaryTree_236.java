package leetcode.tree;

public class LowestCommonAncestorOfABinaryTree_236 {

	//cond : p and q will exist in the tree.
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if( root == null )
			return null;
		
		if (root.val == p.val || root.val == q.val)
			return root;
		
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);

		if (left == null && right == null)
			return null;

		if (left != null && right != null)
			return root;

		return (left != null) ? left : right;
	}

}
