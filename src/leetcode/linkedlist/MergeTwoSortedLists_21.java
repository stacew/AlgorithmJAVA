package leetcode.linkedlist;

public class MergeTwoSortedLists_21 {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode();
		ListNode cur = dummy;
		while (l1 != null || l2 != null) {
			if (l2 == null || (l1 != null && l1.val < l2.val)) {
				cur.next = l1;
				l1 = l1.next;
			} else {
				cur.next = l2;
				l2 = l2.next;
			}
			cur = cur.next;
		}

		return dummy.next;
	}
}