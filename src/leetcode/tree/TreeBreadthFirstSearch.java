package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeBreadthFirstSearch {

	private void LevelOrder(TreeNode _root, int _level) {
		if (_root == null)
			return;

		int level = 0;
		q.add(_root);
		while (q.isEmpty() == false) {

			int thisLevelCount = q.size();
			for (int i = 0; i < thisLevelCount; i++) {
				TreeNode front = q.poll();

				if (level == _level || _level == -1)
					str.append(front.val);

				if (front.left != null)
					q.add(front.left);
				if (front.right != null)
					q.add(front.right);
			}

			if (level == _level)
				return;

			level++;
		}
	}

	public TreeBreadthFirstSearch() {
		q = new LinkedList<>();
		str = new StringBuilder();
		TreeNode[] arr = new TreeNode[7];
		for (int i = 0; i < arr.length; i++)
			arr[i] = new TreeNode(i + 1);
		arr[0].left = arr[1];
		arr[0].right = arr[2];
		arr[1].left = arr[3];
		arr[1].right = arr[4];
		arr[2].left = arr[5];
		arr[2].right = arr[6];

		LevelOrder(arr[0], 2);
		System.out.println(str);
		str.delete(0, str.length());

		LevelOrder(arr[0], -1);
		System.out.println(str);
		str.delete(0, str.length());
	}

	Queue<TreeNode> q = null;
	StringBuilder str = null;
}
