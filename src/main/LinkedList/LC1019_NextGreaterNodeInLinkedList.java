package LinkedList;
import Common.ListNode;
import java.util.*;

class NextGreaterListNode{

    //sol1: 2 passes, Time: O(N), Space: O(N)
    public int[] nextLargerNodes(ListNode head) {
        if(head == null) return new int[0];
        ArrayList<ListNode> nodeArray = new ArrayList<>();
        ListNode p = head;
        while(p != null){
            nodeArray.add(p);
            p = p.next;
        }

        int size = nodeArray.size();
        int[] ans = new int[size];
        
        // stack store idx mapped to arrayList node idx
        Stack<Integer> stack = new Stack<>();

        for(int idx = 0; idx < size; idx++){
            ListNode idxNode = nodeArray.get(idx);
            
            // in arraylist, 
            // if idx node value is greater than stack top idx pointing to ListNode value
            //      -means found next greater value for the stack top idx ListNode
            //      -stack pop, add to ans array.
            // if not
            //      - just add the idx to stack
            while(!stack.isEmpty() && idxNode.val > nodeArray.get(stack.peek()).val){
                //ans[idx] = next greater list node's val
                ans[stack.peek()] = nodeArray.get(idx).val;
                stack.pop();
            }
            stack.push(idx);
        }

        return ans;
    }
}
