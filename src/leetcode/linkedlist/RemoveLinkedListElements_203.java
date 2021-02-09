package leetcode.linkedlist;

public class RemoveLinkedListElements_203 {
    public ListNode removeElements(ListNode head, int val) {
        if( head == null )
            return head;

        while( head != null && head.val == val ){
            head = head.next;
        }        
        
        ListNode prev = head;    
        ListNode current = head.next;
        while( current != null ) {
            if( current.val == val ){
                prev.next = current.next;
            }else{
                prev = current;
            }
            
            current = current.next;
        }
        
        return head;
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
}