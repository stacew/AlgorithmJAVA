package leetcode.queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaxQueue {
	Queue<Integer> q;
	Deque<Integer> deq;

	MaxQueue() {
		q = new LinkedList<Integer>();
		deq = new LinkedList<Integer>();
	}

	void add(int k) {
		q.add(k);
		while (deq.isEmpty() == false && deq.getLast() < k)
			deq.pollLast();
		deq.addLast(k);
	}

	int poll() {
		int ret = q.poll();
		if (ret == deq.getFirst())
			deq.pollFirst();
		return ret;
	}

	int GetMax() {
		return deq.getFirst();
	}
}
