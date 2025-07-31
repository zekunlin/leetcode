package BinarySearchTree;

import Common.TreeNode;

public class LC0333_LargestBSTSubtree {
    //Time: O(N)
    //bottom up, need info from subtree, then evaluate root and subtree
    //need following info:
    //1. is current root and subtree be a bst? left subtree max < root.val < right subtree min
    //2. valid bst size
    int maxSize;
    public int largestBSTSubtree(TreeNode root) {
        dfsHelper(root);
        return maxSize;
    }

    private Res dfsHelper(TreeNode root){
        if(root == null){
            return new Res(0, 0, 0);
        }

        Res leftRes = dfsHelper(root.left);
        Res rightRes = dfsHelper(root.right);

        if(leftRes == null || rightRes == null){
            return null;
        }

        if((leftRes.size == 0 || leftRes.max < root.val) && (rightRes.size == 0 || rightRes.min > root.val)){
            int size = leftRes.size + rightRes.size + 1;
            int min = leftRes.size == 0 ? root.val : leftRes.min;
            int max = rightRes.size == 0 ? root.val : rightRes.max;

            maxSize = Math.max(maxSize, size);
            return new Res(max, min, size);
        }

        return null;
    }

    class Res{
        int max;
        int min;
        int size;
        public Res(int max, int min, int size){
            this.max = max;
            this.min = min;
            this.size = size;
        }
    }
}
