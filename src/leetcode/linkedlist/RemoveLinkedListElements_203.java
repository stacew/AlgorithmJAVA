package leetcode.linkedlist;

public class RemoveLinkedListElements_203 {
	public ListNode removeElements(ListNode head, int val) {
		ListNode dummy = new ListNode(-1);
		dummy.next = head;

		ListNode prev = dummy;
		ListNode cur = dummy.next;
		while (cur != null) {
			if (cur.val == val) {
				prev.next = cur.next;
			} else {
				prev = cur;
			}

			cur = cur.next;
		}

		return dummy.next;
	}
}