package leetcode.linkedlist;
//1. list counting,  2. array, 3. fast/slow
import java.util.ArrayList;
import java.util.List;

//Non-empty singly linked list, return a middle node of linked list.
//If there are two middle nodes, return the second middle node.
public class MiddleOfTheLinkedList_876 {
	//1
	public ListNode middleNode(ListNode head) {
		int count = 0;
		ListNode cur = head;
		while (cur != null) {
			cur = cur.next;
			count++;
		}

		count /= 2; // mid index
		while (--count >= 0) {
			head = head.next;
		}

		return head;
	}
	//2
	public ListNode middleNode_Array(ListNode head) {
		List<ListNode> arr = new ArrayList<>();
		arr.add(head);
		ListNode prev = null;
		while ((prev = arr.get(arr.size() - 1)).next != null) {
			arr.add(prev.next);
		}

		return arr.get(arr.size() / 2);
	}
	//3
	public ListNode middleNode_FastSlow(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;

		while (fast.next != null) {
            slow = slow.next;
			
            if (fast.next.next == null)               
				break;
			fast = fast.next.next;
		}
		
		return slow;
	}
}
