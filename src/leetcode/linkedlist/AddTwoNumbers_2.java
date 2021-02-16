package leetcode.linkedlist;
//add reversed linkedlist number( carry next )
public class AddTwoNumbers_2 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = new ListNode();
		ListNode cur = head;
		int carry = 0;
		while (l1 != null || l2 != null || carry != 0) {
			int sum = 0;
			sum += (l1 != null) ? l1.val : 0;
			sum += (l2 != null) ? l2.val : 0;
			sum += carry;
			carry = sum / 10;

			cur.next = new ListNode(sum % 10);
			cur = cur.next;
			l1 = (l1 != null) ? l1.next : null;
			l2 = (l2 != null) ? l2.next : null;
		}
		return head.next;
	}

	public ListNode addTwoNumbers_modify(ListNode l1, ListNode l2) {
		ListNode ret = l1;
		int carry = 0;
		ListNode prev = null;
		while (l1 != null || l2 != null || carry == 1) {
			if (l1 == null) {
				prev.next = new ListNode();
				l1 = prev.next;
			}
			// +l2
			if (l2 != null) {
				l1.val += l2.val;
				l2 = l2.next;
			}
			// +carry
			l1.val += carry;
			carry = 0;
			// modify
			if (l1.val >= 10) {
				l1.val -= 10;
				carry = 1;
			}

			prev = l1;
			l1 = l1.next;
		}

		return ret;
	}
}
