package leetcode.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal_II_107 {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> orderTopList = new ArrayList<>();
		Queue<TreeNode> treeQ = new LinkedList<>();
		if (root != null)
			treeQ.add(root);

		while (treeQ.isEmpty() == false) {

			ArrayList<Integer> valueList = new ArrayList<Integer>();
			//1.
//			ArrayList<TreeNode> treeList = new ArrayList<TreeNode>();
//			while (treeQ.isEmpty() == false) {
//				TreeNode poll = treeQ.poll();
//				valueList.add(poll.val);
//				if (poll.left != null)
//					treeList.add(poll.left);
//				if (poll.right != null)
//					treeList.add(poll.right);
//			}
//			for (TreeNode x : treeList) {
//				treeQ.add(x);
//			}
			//2.
			int treeQloop = treeQ.size();
			for( int i = 0; i < treeQloop; i++ ) {
				TreeNode poll = treeQ.poll();
				valueList.add(poll.val);
				if( poll.left != null )
					treeQ.add(poll.left);
				if (poll.right != null)
					treeQ.add(poll.right);				
			}			
			orderTopList.add(valueList);
		}

		List<List<Integer>> orderBottomList = new ArrayList<>();
		for (int i = orderTopList.size() - 1; i >= 0; i--) {
			orderBottomList.add(orderTopList.get(i));
		}

		return orderBottomList;
	}
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