package leetcode.linkedlist;

//two node. fist / back(+ dummy)
//other way.
//1. two pass counter : 한 번 순회 후 길이 체크, 계산 후 이동 삭제
//2. array :  array 전부 삽입 후, index 계산 후 삭제 연결
public class RemoveNthNodeFromEndOfList_19 {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode();
		dummy.next = head;
		ListNode first = dummy;
		ListNode back = dummy;
		n = n + 1;// 삭제하려면 n+1칸의 격차.
		while (n-- != 0) {
			first = first.next;
		}

		while (first != null) {
			first = first.next;
			back = back.next;
		}

		back.next = back.next.next;
		return dummy.next;
	}
}
