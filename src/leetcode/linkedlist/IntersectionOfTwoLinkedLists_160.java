package leetcode.linkedlist;
// linkedList, two Ways

//find the node at which the intersection of two singly linked lists begins.
//If the two linked lists have no intersection at all, return null.
//value range [1, 10^9].
//O(n) time, O(n) space => hashset
//O(n) time, O(1) memory => 1. modify, 2. two ways
public class IntersectionOfTwoLinkedLists_160 {
	// 2. two ways
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode nodeA = headA;
		ListNode nodeB = headB;

		while (nodeA != null || nodeB != null) {
			if (nodeA == nodeB)
				return nodeA;

			nodeA = (nodeA == null) ? headB : nodeA.next;
			nodeB = (nodeB == null) ? headA : nodeB.next;
		}

		return null;
	}

//	//1. modify
//	static final int MAX = 1000000000;
//	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//		ListNode mody = headA;
//		while (mody != null) {
//			mody.val += MAX;
//			mody = mody.next;
//		}
//
//		ListNode inter = null;
//		while (headB != null) {
//			if (headB.val > MAX && inter == null) {
//				inter = headB;
//				break;
//			}
//			headB = headB.next;
//		}
//
//		mody = headA;
//		while (mody != null) {
//			mody.val -= MAX;
//			mody = mody.next;
//		}
//
//		return inter;
//	}
}
