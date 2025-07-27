package BinaryTree;

import Common.TreeNode;

public class LC1644_LowestCommonAncestorofBinaryTreeII {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        
        boolean[] foundNode = new boolean[2];

        TreeNode lca = helper(root, p, q, foundNode);

        if(foundNode[0] && foundNode[1]) return lca;
        return null;
    }

    private TreeNode helper(TreeNode root, TreeNode p, TreeNode q, boolean[] foundNode){
        if(root == null) return null;

        TreeNode left = helper(root.left, p, q, foundNode);
        TreeNode right = helper(root.right, p, q, foundNode);

        if(root.val == p.val){
            foundNode[0] = true;
            return root;
        }

        if(root.val == q.val){
            foundNode[1] = true;
            return root;
        }
                
        if(left == null){
            return right;
        }
        else if(right == null){
            return left;
        }
        else{
            return root;
        }
    }
}


//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-ii/solutions/933835/java-difference-from-236-is-you-need-to-search-the-entire-tree