package LinkedList;
import Common.ListNode;

class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode p3 = p2;

        while(p2 != null && p2.next != null){
            p1.next = p2.next;
            p1 = p1.next; // p1.next already jump one node ahead over p2, so p1 = p1.next;

            p2.next = p1.next;//after above line, p1 is updated and jump over last p2, so p1.next is a new even node
            p2 = p2.next; // again, p2.next is updated by above line, so p2 = p2.next;
        }

        p1.next = p3;
        return head;
    }
}
