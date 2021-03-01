package leetcode.queue;

public class QueueUsingSinglyLinkedList {
	class Node {
		int value;
		Node next = null;

		Node(int _value) {
			value = _value;
		}
	}

	Node head;
	Node tail;
	int count;

	QueueUsingSinglyLinkedList() {
		head = null;
		tail = null;
		count = 0;
	}

	void enqueue(int value) {
		if (count == 0) {
			tail = new Node(value);
			head = tail;
		} else {
			tail.next = new Node(value);
			tail = tail.next;
		}
		count++;
	}

	int dequeue() {
		if (count == 0)
			return -1;
		count--;
		int temp = head.value;
		head = head.next;
		
//		if (count == 0) //mem opti
//			tail = null;
		return temp;
	}
}

//public class QueueUsingSinglyLinkedList {
//	class Node {
//		int value;
//		Node next = null;
//
//		Node(int _value) {
//			value = _value;
//		}
//	}
//
//	Node head;
//	Node tail;
//	int count;
//
//	QueueUsingSinglyLinkedList() {
//		head = new Node(-1); //dummy
//		tail = head;
//		count = 0;
//	}
//
//	void enqueue(int value) {
//		count++;
//		tail.next = new Node(value);
//		tail = tail.next;
//	}
//
//	int dequeue() {
//		if (count == 0)
//			return -1;
//		count--;
//
//		int temp = head.next.value;
//		head.next = head.next.next;
//		return temp;
//	}
//}
