package leetcode.stack;

import java.util.Stack;

public class MinStack_155 {

}

class MinStack {
	class pair {
		int value;
		int index;

		pair(int _v, int _i) {
			value = _v;
			index = _i;
		}
	}

	Stack<Integer> stk = null;
	Stack<pair> minStk = null;

	public MinStack() {
		stk = new Stack<>();
		minStk = new Stack<pair>();
	}

	public void push(int x) {
		if (minStk.empty() || x < minStk.peek().value)
			minStk.push(new pair(x, stk.size()));
		stk.push(x);
	}

	public void pop() {
		stk.pop();
		if (stk.size() == minStk.peek().index)
			minStk.pop();
	}

	public int top() {
		return stk.peek();
	}

	public int getMin() {
		return minStk.peek().value;
	}
}
