package leetcode.linkedlist;

import java.util.HashMap;

//LRU Cache O(1) time Bidirectional Linkedlist, HashMap
public class LRUCache_146 {
	private class LRUNode {
		int key;
		int val;
		LRUNode prev;
		LRUNode next;

		public LRUNode(int key, int val) {
			this.key = key;
			this.val = val;
			this.prev = null;
			this.next = null;
		}
	}

	LRUNode head;
	LRUNode tail;
	private HashMap<Integer, LRUNode> m_hm;// key, value
	private int m_capacity;

	public LRUCache_146(int capacity) {
		head = new LRUNode(-1, -1);
		tail = new LRUNode(-1, -1);
		head.next = tail;
		tail.prev = head;
		m_hm = new HashMap<>();
		m_capacity = capacity;
	}

	public int get(int key) {
		if (m_hm.containsKey(key) == false)
			return -1;

		return deleteAndMoveToBack(m_hm.get(key)).val;
	}

	public void put(int key, int value) {
		if (m_hm.containsKey(key)) {
			deleteAndMoveToBack(m_hm.get(key)).val = value;
			return;
		}

		if (m_hm.size() == m_capacity)
			deleteFirst();

		insertNewBack(key, value);
	}

	private LRUNode deleteAndMoveToBack(LRUNode a_Node) {
		a_Node.prev.next = a_Node.next;
		a_Node.next.prev = a_Node.prev;
		return MoveToBack(a_Node);
	}

	private LRUNode MoveToBack(LRUNode a_Node) {
		a_Node.prev = tail.prev;
		a_Node.next = tail;
		a_Node.prev.next = a_Node;
		tail.prev = a_Node;
		return a_Node;
	}

	private void deleteFirst() {
		int deleteKey = head.next.key;
		head.next = head.next.next;
		head.next.prev = head;
		m_hm.remove(deleteKey);
	}

	private void insertNewBack(int key, int value) {
		LRUNode newNode = new LRUNode(key, value);
		m_hm.put(key, MoveToBack(newNode));
	}
}