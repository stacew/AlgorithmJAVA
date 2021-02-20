package leetcode.linkedlist;
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}


class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

//	@Override
//	public boolean equals(Object o) {
//		if (o instanceof ListNode)
//			return false;
//		if (this.val == ((ListNode) o).val && this.next == ((ListNode) o).next)
//			return true;
//		
//		return false;
//	}
}
