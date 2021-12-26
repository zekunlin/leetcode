package LCtag.tree;
import LCtag.TreeNode;
public class LC0951_Tree_FlipEquivalentBinaryTree {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        //c.c
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        if(root1.val == root2.val){
            return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) || (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
        }
        return false;
    }
}
