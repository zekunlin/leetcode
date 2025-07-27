package BinaryTree;

import Common.TreeNode;

public class LC2265_CountNodesEqualToSubTreeAverage {
    int count;
    public int averageOfSubtree(TreeNode root) {
        dfsHelper(root);
        return count;
    }

    private int[] dfsHelper(TreeNode root){
        if(root == null) return new int[]{0,0};

        int[] left = dfsHelper(root.left);
        int[] right = dfsHelper(root.right);
        
        int sum = left[0]  + right[0] + root.val;
        int nodesNum = left[1] + right[1] + 1;
        int curAve = sum / nodesNum;
        if(curAve == root.val) count++;
        return new int[]{sum, nodesNum};
    }
}
