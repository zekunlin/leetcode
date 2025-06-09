package BinarySearchTree;
import Common.TreeNode;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        
        return validBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);

          //sol2:
          /*
           * if(root == null) return true;

            Stack<TreeNode> stack = new Stack<>();
            TreeNode prevNode = null;
            while(root != null || !stack.isEmpty()){
                while(root != null)
                {
                    stack.push(root);
                    root = root.left;
                }

                root = stack.pop();
                if(prevNode != null && root.val <= prevNode.val) return false;

                prevNode = root;
                root = root.right;
            }

            return true;
           */
        
    }

    public boolean validBST(TreeNode node, Integer lowerBound, Integer upperBound)
    {
        if(node == null) return true;
        
        if(node.val <= lowerBound || node.val >= upperBound) return false;

        boolean isLeftValid = validBST(node.left, lowerBound, node.val);
        return isLeftValid && validBST(node.right, node.val, upperBound); 
    }
}


 


//https://leetcode.com/problems/validate-binary-search-tree/solutions/32112/learn-one-iterative-inorder-traversal-apply-it-to-multiple-tree-questions-java-solution