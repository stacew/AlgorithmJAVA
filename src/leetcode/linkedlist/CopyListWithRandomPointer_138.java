package leetcode.linkedlist;

import java.util.ArrayList;
import java.util.HashMap;
//1. old node, old r index map O(n), O(n)
//2. old node, new node map O(n), O(n)
//3. pointer swap O(n), O(1)

public class CopyListWithRandomPointer_138 {
	public Node copyRandomList3(Node head) {
		if (head == null)
			return null;
		// copy combine
		Node cur = head;
		while (cur != null) {
			Node temp = new Node(cur.val);
			temp.next = cur.next;
			cur.next = temp;
			cur = cur.next.next;
		}
		// set random
		cur = head;
		while (cur != null) {
			if (cur.random != null) {
				cur.next.random = cur.random.next;
			}
			cur = cur.next.next;
		}

		// separate
		cur = head;
		Node dHead = cur.next;
		Node dCur = dHead;
		while (cur != null) {

			cur.next = dCur.next;
			if (dCur.next != null)
				dCur.next = dCur.next.next;

			cur = cur.next;
			dCur = dCur.next;
		}
		return dHead;
	}

	public Node copyRandomList2(Node head) {
		HashMap<Node, Node> nnMap = new HashMap<Node, Node>();
		Node dHead = new Node(-1);

		Node cur = head;
		Node dCur = dHead;
		while (cur != null) {
			dCur.next = new Node(cur.val);
			dCur = dCur.next;

			nnMap.put(cur, dCur);

			cur = cur.next;
		}

		cur = head;
		dCur = dHead.next; // ***********
		while (cur != null) {
			if (cur.random != null) {
				dCur.random = nnMap.get(cur.random);
			}

			dCur = dCur.next;
			cur = cur.next;
		}

		return dHead.next;
	}

	public Node copyRandomList1(Node head) {
		if (head == null)
			return null;

		HashMap<Node, Integer> NodeIndexMap = new HashMap<Node, Integer>();
		ArrayList<Node> arr = new ArrayList<Node>();

		int i = 0;
		Node cur = head;
		while (cur != null) {
			NodeIndexMap.put(cur, i);
			arr.add(new Node(cur.val));
			if (i > 0)
				arr.get(i - 1).next = arr.get(i);

			i++;
			cur = cur.next;
		}

		i = 0;
		cur = head;
		while (cur != null) {
			if (cur.random != null) {
				int r = NodeIndexMap.get(cur.random);
				arr.get(i).random = arr.get(r);
			}
			i++;
			cur = cur.next;
		}

		return arr.get(0);
	}
}
