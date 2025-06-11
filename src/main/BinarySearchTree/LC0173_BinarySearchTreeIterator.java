package BinarySearchTree;

import Common.TreeNode;
import java.util.*;

//Time complexity: O(1) average, Space: O(N) worst
class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        this.stack = new Stack<>();

        this.pointToLeftMostNode(root);
    }

    private void pointToLeftMostNode(TreeNode root)
    {
        if(root == null) return;

        while(root != null)
        {
            stack.push(root);
            root = root.left;
        }
    }
    
    public int next() {
        //after called pointToLeftMostNode, the stack top should be left most node
        TreeNode stackTop = stack.pop();

        if(stackTop.right != null){
            this.pointToLeftMostNode(stackTop.right);
        }

        return stackTop.val;
    }
    
    public boolean hasNext() {
        return this.stack.size() > 0;
    }
}