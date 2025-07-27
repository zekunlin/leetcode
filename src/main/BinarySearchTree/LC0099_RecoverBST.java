package BinarySearchTree;

import Common.TreeNode;

public class LC0099_RecoverBST {
    TreeNode prev;
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        TreeNode[] mistake = new TreeNode[2];
        dfs(root, mistake);
        int tmp = mistake[0].val;
        mistake[0].val = mistake[1].val;
        mistake[1].val = tmp;
    }

    public void dfs(TreeNode root, TreeNode[] mistake){
        if(root == null) return;

        dfs(root.left, mistake);
        if(prev != null && prev.val > root.val){
            if(mistake[0] == null)
            {
                mistake[0] = prev;
            }
            mistake[1] = root;
        }
        prev = root;
        dfs(root.right, mistake);
    }
}
