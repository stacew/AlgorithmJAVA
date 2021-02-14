package leetcode.linkedlist;

import java.util.ArrayList;
import java.util.Stack;

public class ReverseLinkedList_206 {
	// prev, cur, next 0ms
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode prev = head;
		ListNode cur = head.next;
		head.next = null;//
		do {
			ListNode tempNext = cur.next;
			cur.next = prev;
			prev = cur;
			cur = tempNext;
		} while (cur != null);
		head = prev; //

		return head;
	}

	// ArrayList 0ms
	public ListNode reverseList_ArrayList(ListNode head) {
		if (head == null)
			return null;

		ArrayList<ListNode> list = new ArrayList<>();
		while (head != null) {
			list.add(head);
			head = head.next;
		}

		head = list.get(list.size() - 1);
		ListNode cur = head;
		for (int i = list.size() - 2; i >= 0; i--) {
			cur.next = list.get(i);
			cur = cur.next;
		}
		cur.next = null;

		return head;
	}

	// recursion 21ms
	public ListNode reverseList_recursion(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode rec = reverseList_recursion(head.next);
		while (rec != null && rec.next != null) {
			rec = rec.next;
		}

		rec.next = head;

		head.next = null;
		return rec;
	}

	// stack 0~1ms
	public ListNode reverseList_stack(ListNode head) {
		if (head == null)
			return null;

		Stack<ListNode> stack = new Stack<ListNode>();
		while (head != null) {
			stack.add(head);
			head = head.next;
		}

		head = stack.pop();
		ListNode cur = head;
		while (stack.isEmpty() == false) {
			cur.next = stack.pop();
			cur = cur.next;
		}
		cur.next = null;

		return head;
	}
}
