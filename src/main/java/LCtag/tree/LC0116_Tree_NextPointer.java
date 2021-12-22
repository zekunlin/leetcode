package LCtag.tree;
import LCtag.Node;
public class LC0116_Tree_NextPointer {
    public Node connect(Node root){
        if(root == null) return null;
        Node leftMost = root;
        while(leftMost.left != null){
            Node head = leftMost;
            while(head != null){
                head.left.next = head.right;
                if(head.next != null){
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            leftMost = leftMost.left;
        }
        return root;
    }
}
