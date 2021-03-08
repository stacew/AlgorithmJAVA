package leetcode.linkedlist;

//0. two node, one pass : fist / back(+ dummy)
//other way.
//1. two pass counter : 한 번 순회 후 길이 체크, 계산 후 이동 삭제
//2. array :  array 전부 삽입 후, index 계산 후 삭제 연결
public class RemoveNthNodeFromEndOfList_19 {

	public ListNode removeNthFromEnd(ListNode head, int n) {

		ListNode dummy = new ListNode(-1);
		dummy.next = head;

		ListNode first = dummy;
		while (n-- != 0) // first와 back을 n만큼 격차를 만든다.
			first = first.next;
		first = first.next; // 삭제 작업을 위해 한 칸 더 격차를 만를기.

		ListNode back = dummy;

		while (first != null) { // first가 null이 나올 때 까지, n + 1의 격차를 두고 같이 진행
			first = first.next;
			back = back.next;
		}

		back.next = back.next.next; // 삭제

		return dummy.next;
	}
}
