package leetcode.linkedlist;

//linkedList, fast/slow
//modify check 방식 (-> hash set 바로 가능. java object가 같은지 비교. 일반 object 변수를 pointer라고 생각)
public class LinkedListCycle_141 {

	public boolean hasCycle_fastslow(ListNode head) {

		ListNode fast = head;
		ListNode slow = head;

		while (fast != null) {

			if (fast.next != null)
				fast = fast.next.next;
			else
				break;

			slow = slow.next;

			if (fast == slow)
				return true;
		}

		return false;

	}

//	static final int CHECK_VAL = (int) Math.pow(10, 5) + 1;
//
//	public boolean hasCycle(ListNode head) {
//		while (head != null) {
//			if (head.val == CHECK_VAL)
//				return true;
//
//			head.val = CHECK_VAL;
//			head = head.next;
//		}
//		return false;
//	}
}
