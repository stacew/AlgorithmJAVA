package leetcode.tree;

import java.util.Stack;

public class TreeDepthFirstSearch {
	
	public void PreOrder(TreeNode root) {
		if (root == null)
			return;
		
		stk.push(root);
		while (stk.isEmpty() == false) {

			TreeNode popTop = stk.pop();
			str.append(popTop.val);

			if (popTop.right != null)
				stk.push(popTop.right);

			if (popTop.left != null)
				stk.push(popTop.left);
		}
	}

	private void LeftPushContinue(TreeNode cur) {
		while (cur != null) {
			stk.push(cur);
			cur = cur.left;
		}
	}

	public void InOrder(TreeNode root) {
		if (root == null)
			return;

		LeftPushContinue(root);

		while (stk.isEmpty() == false) {

			TreeNode popTop = stk.pop();
			str.append(popTop.val);

			if (popTop.right != null)
				LeftPushContinue(popTop.right);
		}
	}

	public void PostOrder(TreeNode root) {
		if (root == null)
			return;

		TreeNode lastPop = null;
		LeftPushContinue(root);

		while (stk.isEmpty() == false) {

			TreeNode peekTop = stk.peek();
			if (peekTop.right == null || peekTop.right == lastPop) { // readMe의 1-1, 1-3 조건

				lastPop = stk.pop();
				str.append(lastPop.val);

			} else { // if( peekTop.right != lastPop ) {

				LeftPushContinue(stk.peek().right);
			}
		}
	}
	///
	public void PreOrder_recur(TreeNode root) {
		if (root == null)
			return;
		str.append(root.val);
		PreOrder_recur(root.left);
		PreOrder_recur(root.right);
	}

	public void InOrder_recur(TreeNode root) {
		if (root == null)
			return;
		InOrder_recur(root.left);
		str.append(root.val);
		InOrder_recur(root.right);
	}

	public void PostOrder_recur(TreeNode root) {
		if (root == null)
			return;
		PostOrder_recur(root.left);
		PostOrder_recur(root.right);
		str.append(root.val);
	}
	///
	


	public TreeDepthFirstSearch() {
		stk = new Stack<>();
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
		
		PreOrder_recur(arr[0]);
		System.out.println(str);
		str.delete(0, str.length());		
		PreOrder(arr[0]);
		System.out.println(str);
		str.delete(0, str.length());
		
		
		InOrder_recur(arr[0]);
		System.out.println(str);
		str.delete(0, str.length());
		InOrder(arr[0]);
		System.out.println(str);
		str.delete(0, str.length());
		
		
		PostOrder_recur(arr[0]);
		System.out.println(str);
		str.delete(0, str.length());
		PostOrder(arr[0]);
		System.out.println(str);
		str.delete(0, str.length());
	}
	

	Stack<TreeNode> stk = null;
	StringBuilder str = null;
}

//Post Order
//*. CheckLastPopIsRight()!!!
//	이전에 수행했던 작업이 Right Child Node 였는지 레퍼런스 체크
//	Check 작업이 없다면 무한루프
//0. stack에 root LeftPushContinue()
//1 - 1. top()의 right가 존재하지 않는다면 top() 출력, pop()
//1 - 2. top()의 right가 존재하는데 CheckLastPopIsRight() == false 라면 right를 LeftPushContinue()
//1 - 3. top()의 right가 존재하는데 CheckLastPopIsRight() == true 라면 top() 출력, pop()
//*. empty까지 1의 조건들 반복 	
