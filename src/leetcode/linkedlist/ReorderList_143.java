package leetcode.linkedlist;

//1. middle + split +  back reverse + combine ( 1ms )
//2. ArrayList ( 2ms )
import java.util.ArrayList;

public class ReorderList_143 {

	public void reorderList(ListNode head) {
		if (head == null)
			return;

		// middle
		MiddleOfTheLinkedList_876 sol876 = new MiddleOfTheLinkedList_876();
		ListNode middle = sol876.middleNode_FastSlow(head);

		// split
		ListNode head2 = middle.next;
		middle.next = null;

		// right reverse
		ReverseLinkedList_206 sol206 = new ReverseLinkedList_206();
		head2 = sol206.reverseList(head2);

		ListNode head1 = head;
		// reorder
		ListNode dummy = new ListNode();
		ListNode cur = dummy;
		while (head1 != null) {

			cur.next = head1;

			head1 = head1.next;
			cur = cur.next;

			if (head2 == null)
				break;

			cur.next = head2;

			head2 = head2.next;
			cur = cur.next;
		}

		head = dummy.next;
	}

	public void reorderList_ArrayList(ListNode head) {

		ArrayList<ListNode> arr = new ArrayList<>();
		while (head != null) {
			arr.add(head);
			head = head.next;
		}

		int l = 0;
		int r = arr.size() - 1;
		head = new ListNode();
		ListNode cur = head;
		while (l <= r) {
			cur.next = arr.get(l++);
			cur = cur.next;
			if (l > r)
				break;
			cur.next = arr.get(r--);
			cur = cur.next;
		}
		cur.next = null;

		head = head.next;
	}
}
