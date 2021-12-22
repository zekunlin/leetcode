package LCtag;

import java.util.ArrayList;
import java.util.List;

public class Node {
//Definition for a Node.

    public int val;
    public List<Node> children;
    public Node() {
        val = 0;
        children = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        children = _neighbors;
    }


}
