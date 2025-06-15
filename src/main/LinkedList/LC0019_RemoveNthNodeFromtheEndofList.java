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
class RemoveNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;

        int ind = 0;
        while(ind <= n)
        {
            fast = fast.next;
            ind += 1;
        }

        if(fast == null)
        {
            head.val = head.next.val;
            head.next = head.next.next;
        }
        //check fast.next not fast !=null
        // so when break the while here, the slow is 
        // at exactly one node before (N-1th) of the node want to remove(Nth node);
        while(fast.next!=null)
        {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return head;
    }
}
