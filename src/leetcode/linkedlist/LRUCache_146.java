package leetcode.linkedlist;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

//LRU Cache O(1) time Bidirectional Linkedlist, HashMap

//LRUNode head, tail; // 13ms
public class LRUCache_146 {

	private class LRUNode {
		int key, val;
		LRUNode prev, next;

		public LRUNode(int key, int val) {
			this.key = key;
			this.val = val;
			this.prev = this.next = null;
		}
	}

	LRUNode head, tail;
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

	public void put(int key, int value) {
		if (m_hm.containsKey(key)) {
			LRUNode node = m_hm.get(key);
			moveToBack(node);
			node.val = value;
			return;
		}

		if (m_hm.size() == m_capacity)
			deleteFirst();

		insertNewBack(key, value);
	}

	public int get(int key) {
		if (m_hm.containsKey(key) == false)
			return -1;

		LRUNode node = m_hm.get(key);
		moveToBack(node);
		return node.val;
	}

	private void pop(LRUNode a_Node) {
		a_Node.prev.next = a_Node.next;
		a_Node.next.prev = a_Node.prev;
	}
	private void addBack(LRUNode a_Node) {
		a_Node.prev = tail.prev;
		a_Node.next = tail;
		a_Node.prev.next = a_Node;
		tail.prev = a_Node;
	}
	private void moveToBack(LRUNode a_Node) {
		pop(a_Node);
		addBack(a_Node);
	}

	private void deleteFirst() {
		int deleteKey = head.next.key;
		head.next = head.next.next;
		head.next.prev = head;
		m_hm.remove(deleteKey);
	}

	private void insertNewBack(int key, int value) {
		LRUNode newNode = new LRUNode(key, value);

		m_hm.put(key, newNode);
		addBack(newNode);
	}
}

//List<LRUNode> m_DList; // 120 ms
class LRUCache_DList {
	private class LRUNode {
		int key, val;

		public LRUNode(int key, int val) {
			this.key = key;
			this.val = val;
		}
	}

	List<LRUNode> m_DList;
	private HashMap<Integer, LRUNode> m_hm;// key, value
	private int m_capacity;

	public LRUCache_DList(int capacity) {
		m_DList = new LinkedList<>();
		m_hm = new HashMap<>();
		m_capacity = capacity;
	}

	public void put(int key, int value) {
		if (m_hm.containsKey(key)) {
			LRUNode node = m_hm.get(key);
			moveToBack(node);
			node.val = value;
			return;
		}

		if (m_hm.size() == m_capacity)
			deleteFirst();

		insertNewBack(key, value);
	}

	public int get(int key) {
		if (m_hm.containsKey(key) == false)
			return -1;

		LRUNode node = m_hm.get(key);
		moveToBack(node);
		return node.val;
	}

	private void moveToBack(LRUNode a_Node) {
		m_DList.remove(a_Node); 	//시작부터 object의 값을 비교하여 찾은 후 제거 O(n)
		m_DList.add(a_Node);		// O(1)
	}

	private void deleteFirst() {
		LRUNode first = m_DList.remove(0); //O(1)
		m_hm.remove(first.key);
	}

	private void insertNewBack(int key, int value) {
		LRUNode newNode = new LRUNode(key, value);

		m_hm.put(key, newNode);
		m_DList.add(newNode);
	}
}