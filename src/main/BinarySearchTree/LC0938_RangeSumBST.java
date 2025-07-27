package BinarySearchTree;

import Common.TreeNode;

public class LC0938_RangeSumBST {
    int sum;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) return -1;
        
        dfsHelper(root, low, high);
        return sum;
    }

    private void dfsHelper(TreeNode root, int low, int high){
        if(root == null) return;

        if(root.val <= high && root.val >= low) sum += root.val;

        if(low < root.val){
            dfsHelper(root.left, low, high);
        }
        if(high > root.val){
            dfsHelper(root.right, low, high);
        }
    }
}
