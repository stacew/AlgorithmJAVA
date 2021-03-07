package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class PathSumII_113 {

	List<List<Integer>> mRet = null;

	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		mRet = new ArrayList<List<Integer>>();
		
		if (root != null) {
			List<Integer> list = new ArrayList<Integer>();			
			pathSum_recur(root, list, targetSum);
		}

		return mRet;
	}

	private void pathSum_recur(TreeNode cur, List<Integer> list, int target) {

		list.add(cur.val);

		target -= cur.val;

		if (cur.left == null && cur.right == null) { //exit cond leaf
			if (target == 0)
				mRet.add(new ArrayList<>(list));
		} else {
			if (cur.left != null) {
				pathSum_recur(cur.left, list, target);
			}
			if (cur.right != null) {
				pathSum_recur(cur.right, list, target);
			}
		}

		list.remove(list.size() - 1);
	}
}
