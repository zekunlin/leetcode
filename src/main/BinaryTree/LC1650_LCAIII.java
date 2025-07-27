package BinaryTree;

import java.util.HashSet;

public class LC1650_LCAIII {
    public Node lowestCommonAncestor(Node p, Node q) {
        HashSet<Node> seenNode = new HashSet<>();
        Node cur1 = p;
        while(cur1 != null){
            seenNode.add(cur1);
            cur1 = cur1.parent;
        }

        Node cur2 = q;
        while(cur2 != null){
            if(seenNode.contains(cur2)){
                return cur2;
            }
            cur2 = cur2.parent;
        }

        return null;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
