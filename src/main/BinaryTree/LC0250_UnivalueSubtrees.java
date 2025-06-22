package BinaryTree;
import Common.TreeNode;

class UnivalueSubtrees{
    int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        dfs(root);
        return count;
    }

    public boolean dfs(TreeNode root){
        if(root == null) return true;

        boolean left = dfs(root.left);
        boolean right = dfs(root.right);

        if(left && right){
            if(root.left != null && root.left.val != root.val){
                return false;
            }

            if(root.right != null && root.right.val != root.val){
                return false;
            }
            count++;
            return true;
        }

        return false;
    }
}