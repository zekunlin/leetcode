package BinaryTree;


public class LC0117_PopulatingNextPointerII {
    public Node connect(Node root) {
        if(root == null) return root;
        
        Node leftMost = root;
        while(leftMost != null){
            Node cur = leftMost;
            Node dummy = new Node(0);
            Node prev = dummy;

            while(cur != null){
                
                if(cur.left != null){
                    //line 19 here updated both prev and dummy. so now dummy.next point to left children of cur
                    prev.next = cur.left;
                    
                    prev = prev.next;
                    
                }
                if(cur.right != null){
                    prev.next = cur.right;
                    

                    prev = prev.next;
                    

                }
                
                cur = cur.next;
            }

            leftMost = dummy.next; // due to line 18, dummy.next is the left children(next level) of cur (this level)
            
        }
        
        return root;
    }
}
