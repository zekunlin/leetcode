package LinkedList;

import Common.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        /* sol1: note- remember that have a dummy start at null, and a cur pointing to head.
        ListNode p1 = null;
        ListNode p2 = head;

        while(p2 != null)
        {
            ListNode p3 = p2.next; // capture the next node incase it's lost after reversed;
            p2.next = p1;// revert cur node
            p1 = p2;//move dummy forward to next node
            p2 = p3;//move cur forward to next node
        }
        return p1;
        */
        
        /* sol2: recursion */
        // explaination video: https://youtu.be/S92RuTtt9EE
        // basically what recursion doing here is, process cur.next if cur node has next and next is not null.
        // A->B->C
        /* reverse(A)
            → reverse(B)
                → reverse(C)
                    → return C 
                → B.next.next = B  A->B->C->B
                → B.next = null    A->B C->B
                → return C
            → A.next.next = A      A->B->A C->B->A
            → A.next = null        A C->B->A
            → return C
        */

        if (head == null || head.next == null) return head;
        
        ListNode ln = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return ln;

        /*
        On Node 4
        Node for head.next is 5
        Setting node 5.next = 4 (head.next.next = head)
        4->5->4
        Setting 4-> to null to remove. (head.next = None)
        5->4

        On Node 3
        Node for head.next is 4
        Setting node 4.next = 3 (head.next.next = head)
        3->4->3
        Setting 3-> to null to remove. (head.next = None)
        4->3

        On Node 2
        Node for head.next is 3
        Setting node 3.next = 2 (head.next.next = head)
        2->3->2
        Setting 2-> to null to remove. (head.next = None)
        3->2

        On Node 1
        Node for head.next is 2
        Setting node 2.next = 1 (head.next.next = head)
        1->2->1
        Setting 1-> to null to remove. (head.next = None)
        2->1
        */
    }
}
