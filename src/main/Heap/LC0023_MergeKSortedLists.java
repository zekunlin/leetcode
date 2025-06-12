package Heap;
import Common.ListNode;
import java.util.*;


class MergeKSortedLists{
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> pq = new PriorityQueue<>(
            (a, b) -> a.val - b.val
        );

        for(ListNode node : lists)
        {
            if(node != null) pq.add(node);
        }

        ListNode head = new ListNode(0);
        ListNode cur = head;
        while(!pq.isEmpty()){
            cur.next = pq.poll();
            cur = cur.next;

            if(cur.next != null)
            {
                pq.add(cur.next);
            }
            else continue;
        }

        return head.next;
    }
}