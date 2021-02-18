package leetcode.linkedlist;
//2 dummy node 
public class PartitionList_86 {
	public ListNode partition(ListNode head, int x) {
		ListNode f_head = new ListNode();
		ListNode f_cur = f_head;
		ListNode b_head = new ListNode();
		ListNode b_cur = b_head;

		while (head != null) {
			if (head.val < x) {
				f_cur.next = head;
				f_cur = f_cur.next;
			} else {
				b_cur.next = head;
				b_cur = b_cur.next;
			}
			head = head.next;
		}

		b_cur.next = null;
		f_cur.next = b_head.next;

		return f_head.next;
	}
}
