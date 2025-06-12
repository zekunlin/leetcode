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

// for this recursive solution, imagine a call stack
// 1. firstly we go all the way to the end of the linkedlist
// if(curNode != null) { if(!recursiveCheck(curNode.next)) return false; ...}

// 2. after we reach the end of the linked list, compare the right-most node with the left, here at this point is the left most node
// if(curNode.val != leftNode.val) return false;

// 3. then if value are the same, 
class PalindromeLinkedListSol2 {
    ListNode leftNode;

    public boolean isPalindrome(ListNode head) {
        leftNode = head;
        return recursiveCheck(head);
    }

    private boolean recursiveCheck(ListNode curNode)
    {
        if(curNode != null) // right node
        {
            if(!recursiveCheck(curNode.next)) return false;
            if(curNode.val != leftNode.val) return false;
            leftNode = leftNode.next;
        }

        return true;
    }
}
