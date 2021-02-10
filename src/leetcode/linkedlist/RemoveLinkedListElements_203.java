package leetcode.linkedlist;
//dummy를 만들고 head 앞에 붙여서 제거 되지 않는 것만 붙이는 방식이 구현 더 쉬움.

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