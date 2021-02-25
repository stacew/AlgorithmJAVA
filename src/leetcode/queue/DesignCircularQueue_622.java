package leetcode.queue;

import java.util.ArrayList;
import java.util.List;

public class DesignCircularQueue_622 {

}

class MyCircularQueue {

	int[] arr;
	private int front;
	private int rear;
	// private boolean full; 써도 되는데 관리가 편하게 count.
	private int count;

	public MyCircularQueue(int k) {
		arr = new int[k];
		front = 0;
		rear = 0;
		count = 0;
	}

	private int next(int a) {
		if (a == arr.length - 1)
			return 0;
		return a - 1;
	}

	public boolean enQueue(int value) {
		if (isFull())
			return false;
		count++;
		rear = next(rear);
		arr[rear] = value;
		return true;
	}

	public boolean deQueue() {
		if (isEmpty())
			return false;
		count--;
		front = next(front);
		return true;
	}

	public int Front() {
		if (isEmpty())
			return -1;
		return arr[next(front)];
	}

	public int Rear() {
		if (isEmpty())
			return -1;
		return arr[rear];
	}

	public boolean isEmpty() {
		return count == 0;
	}

	public boolean isFull() {
		return count == arr.length;
	}
}