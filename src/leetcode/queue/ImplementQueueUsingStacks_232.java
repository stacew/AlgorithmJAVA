package leetcode.queue;

import java.util.Stack;

public class ImplementQueueUsingStacks_232 {

}

//amotized O(1) 2stack queue
class MyQueue {

	Stack<Integer> baseStack = null;
	Stack<Integer> reverseStack = null;

	/** Initialize your data structure here. */
	public MyQueue() {
		baseStack = new Stack<>();
		reverseStack = new Stack<>();
	}

	/** Push element x to the back of queue. */
	public void push(int x) {
		baseStack.push(x);
	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		checkFillReverse();
		return reverseStack.pop();
	}

	/** Get the front element. */
	public int peek() {
		checkFillReverse();
		return reverseStack.peek();
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		if (baseStack.empty() && reverseStack.empty())
			return true;

		return false;
	}

	void checkFillReverse() {
		if (reverseStack.isEmpty()) {
			while (baseStack.empty() == false) {
				reverseStack.push(baseStack.pop());
			}
		}
	}
}
