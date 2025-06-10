package BinarySearchTree;

import java.util.*;
import Common.TreeNode;

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();

        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if(--k == 0) break;
            root = root.right;
        }

        return root.val;
    }
}