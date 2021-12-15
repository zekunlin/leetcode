package LCtag.tree;
import LCtag.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class LC0173_BST_Iterator {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class BSTIterator {
        Deque<TreeNode> stk = new LinkedList<TreeNode>();

        public BSTIterator(TreeNode root) {
            TreeNode node = root;
            while(node != null){
                stk.push(node);
                node = node.left;
            }
        }

        public int next() {
            TreeNode top = stk.pop();
            if(top.right != null){
                TreeNode r = top.right;
                while(r != null){
                    stk.push(r);
                    r = r.left;
                }
            }
            return top.val;
        }

        public boolean hasNext() {
            return !stk.isEmpty();
        }
    }
}
