package LinkedList;

import java.util.HashSet;

import Common.ListNode;

public class LC0160_IntesectionOfLinkedList {
    //Time: O(m + n), space: O(1)
    //list A length: a + c; shorter
    //lsit B length: b + c;
    // both start at head, p1 = headA, p2 = headB
    //when shorter list finish, put p1 to longer list head
    //then when longer list p2 reach end, p1 is at (b - a).
    //then put p2 at shorter list head, move together. they will intersect
    // because now they will travel the same length toward the end  
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        
        while(p1 != p2){
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }
        
        return p1;
    }

    //sol2: time: O(m + n), space:O(m)
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB){
        HashSet<ListNode> set = new HashSet<>();
        ListNode p1 = headA;
        while(p1 != null){
            set.add(p1);
            p1 = p1.next;
        }

        ListNode p2 = headB;
        while(p2 != null){
            if(set.contains(p2)) return p2;
            p2 = p2.next;
        }
        return null;
    }
}
