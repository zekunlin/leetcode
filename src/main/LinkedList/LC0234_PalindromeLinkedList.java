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
class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode midpoint = FindMidPoint(head);
        ListNode reversedListHead = ReverseLinkedList(midpoint);

        while(head != null && reversedListHead != null)
        {
            if(head.val != reversedListHead.val) return false;

            head = head.next;
            reversedListHead = reversedListHead.next;
        }

        return true;
    }

    private ListNode ReverseLinkedList(ListNode head){
        ListNode p1 = null;
        ListNode p2 = head;
        
        while(p2 != null)
        {
            ListNode p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
        }

        return p1;
    }
    private ListNode FindMidPoint(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        while(fast.next != null && fast.next.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}
