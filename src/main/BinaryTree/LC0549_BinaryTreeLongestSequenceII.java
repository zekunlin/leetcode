package BinaryTree;

import Common.TreeNode;

public class LC0549_BinaryTreeLongestSequenceII {
    int maxLen;
    public int longestConsecutive(TreeNode root) {
        dfsHelper(root);
        return maxLen;
    }

    private int[] dfsHelper(TreeNode root){
        if (root == null) return new int[]{0, 0};

        int[] leftLen = dfsHelper(root.left);
        int[] rightLen = dfsHelper(root.right);
        
        int[] curLen = new int[]{1, 1};

        if(root.left != null){
            if(root.left.val == root.val + 1){
                curLen[0] = Math.max(curLen[0], leftLen[0] + 1);//from root to child: incre
            }
            else if(root.left.val == root.val - 1){
                curLen[1] = Math.max(curLen[1], leftLen[1] + 1);//from root to child: decre
            }
        }

        if(root.right != null){
            if(root.right.val == root.val + 1){
                curLen[0] = Math.max(curLen[0], rightLen[0] + 1);//from root to child: incre
            }
            else if(root.right.val == root.val - 1){
                curLen[1] = Math.max(curLen[1], rightLen[1] + 1);//from root to child: decre
            }
        }

        maxLen = Math.max(maxLen, curLen[0] + curLen[1] - 1);
        return curLen;
    }
}
