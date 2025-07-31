package BinaryTree;

import Common.TreeNode;

public class LC0298_BinaryTreeLongestConsecutiveSequence {
    int maxLen;
    public int longestConsecutive(TreeNode root) {
       dfsHelper(root);
       return maxLen;
    }

    private int dfsHelper(TreeNode root){
        if(root == null) return 0;

        int leftLen = dfsHelper(root.left);
        int rightLen = dfsHelper(root.right);
        int len = 1;
        if(root.left != null && root.left.val == root.val + 1){
            len = Math.max(leftLen + 1, len);
        }

        if(root.right != null && root.right.val == root.val + 1){
            len = Math.max(rightLen + 1, len);
        }

        maxLen = Math.max(len, maxLen);
        
        return len;
    }
}
