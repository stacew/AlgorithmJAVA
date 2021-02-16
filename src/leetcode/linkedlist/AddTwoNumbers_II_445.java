package leetcode.linkedlist;
//add linkedlist number, reverse, stack 
import java.util.Stack;

public class AddTwoNumbers_II_445 {
	//stack
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		Stack<ListNode> st1 = new Stack<>();
		Stack<ListNode> st2 = new Stack<>();
		while (l1 != null) {
			st1.add(l1);
			l1 = l1.next;
		}
		while (l2 != null) {
			st2.add(l2);
			l2 = l2.next;
		}

		int carry = 0;
		ListNode head = null;
		while (st1.isEmpty() == false || st2.isEmpty() == false || carry != 0) {
			int sum = carry;
			sum += (st1.isEmpty()) ? 0 : st1.pop().val;
			sum += (st2.isEmpty()) ? 0 : st2.pop().val;
			carry = sum / 10;

			ListNode temp = head;
			head = new ListNode(sum % 10);
			head.next = temp;
		}
		return head;
	}

//		// reverse
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ReverseLinkedList_206 sol206 = new ReverseLinkedList_206();
//			AddTwoNumbers_2 sol2 = new AddTwoNumbers_2();
//
//        l1 = sol206.reverseList(l1);
//        l2 = sol206.reverseList(l2);
//        
//        ListNode ret = sol2.addTwoNumbers(l1, l2);
//
//        ret = sol206.reverseList(ret);
//        return ret;
//    }
}
