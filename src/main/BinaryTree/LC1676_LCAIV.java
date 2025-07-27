package BinaryTree;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import Common.TreeNode;

public class LC1676_LCAIV {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
       Set<TreeNode> seenSet = new HashSet<>();

       seenSet.addAll(Arrays.asList(nodes));
    
        TreeNode lca = this.helper(root, seenSet);
        return lca;
    }

    private TreeNode helper(TreeNode root, Set<TreeNode> seenSet){
        if(root == null) return null;

        if(seenSet.contains(root)){
            return root;
        }

        TreeNode left = helper(root.left, seenSet);
        TreeNode right = helper(root.right, seenSet);

        if(left == null && right == null){
            return null;
        }
        else if(left != null && right != null){
            return root;
        }
        else if(left == null){
            return right;
        }
        else{
            return left;
        }
    }
}
