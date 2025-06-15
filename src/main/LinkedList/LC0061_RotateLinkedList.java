package LinkedList;
import Common.ListNode;

class RotateLinkedList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;

        ListNode p1 = head;
        int n = 1;
        for(; p1.next != null; n++){
            p1 = p1.next;
        }

        p1.next = head;

        ListNode p2 = head;
        // k%n -> incase k > n, so k%n is absolute moves, 
        // n- k%n -> numer of moves needed to leave k node to rotate, or another way: reach the new head
        // n - k%n - 1: reach the prev node of the new head
        int moves = (n - k % n) - 1; 
        for(int i = 0; i < moves; i++) p2 = p2.next;
        
        ListNode newHead = p2.next;
        p2.next = null;
        return newHead;
    }
}
