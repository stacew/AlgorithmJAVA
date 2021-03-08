package leetcode.linkedlist;

import java.util.ArrayList;
import java.util.HashMap;

//1. old node, old r index map O(n), O(n)
//2. old node, new node map O(n), O(n)
//3. pointer swap O(n), O(1)
public class CopyListWithRandomPointer_138 {
	class Node {
		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}

	public Node copyRandomList3(Node head) {
		if (head == null)
			return null;
		
		// copy combine : copied node를 기존 node 뒤에 삽입한다.
		Node cur = head;
		while (cur != null) {
			Node copiedNode = new Node(cur.val);
			copiedNode.next = cur.next;
			cur.next = copiedNode;
			cur = cur.next.next;
		}
		
		// set random
		cur = head;
		while (cur != null) {
			
			if (cur.random != null) {
				//cur.next.random : copiedNode의 random pointer
				//cur.random.next : 기존 랜덤 node의 copiedNode 
				cur.next.random = cur.random.next;
			}
			
			cur = cur.next.next;
		}

		// separate
		cur = head;
		Node copiedHead = cur.next;
		Node cCur = copiedHead;
		while (cur != null) {

			cur.next = cCur.next;
			if (cCur.next != null)
				cCur.next = cCur.next.next;

			cur = cur.next;
			cCur = cCur.next;
		}
		
		return copiedHead;
	}
	
	

	public Node copyRandomList2(Node head) {
		HashMap<Node, Node> nnMap = new HashMap<Node, Node>();
		Node dHead = new Node(-1);

		Node cur = head;
		Node dCur = dHead;
		while (cur != null) {

			Node copiedNode = new Node(cur.val);
			nnMap.put(cur, copiedNode);

			dCur.next = copiedNode;

			dCur = dCur.next;
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
		ArrayList<Node> arrCopiedNode = new ArrayList<Node>();

		int index = 0;
		Node cur = head;
		while (cur != null) {
			NodeIndexMap.put(cur, index++);
			arrCopiedNode.add(new Node(cur.val));
			cur = cur.next;
		}

		for (int i = 0; i < arrCopiedNode.size() - 1; i++)
			arrCopiedNode.get(i).next = arrCopiedNode.get(i + 1);

		index = 0;
		cur = head;
		while (cur != null) {
			if (cur.random != null) {
				int randomIndex = NodeIndexMap.get(cur.random);
				arrCopiedNode.get(index).random = arrCopiedNode.get(randomIndex);
			}
			index++;
			cur = cur.next;
		}

		return arrCopiedNode.get(0);
	}
}
