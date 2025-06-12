package BinaryTree;

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
class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        
        /* sol1: stack, T = O(N), Space = O(h = LogN) 
        Stack<TreeNode> leftStack = new Stack<>();
        Stack<TreeNode> rightStack = new Stack<>();

        leftStack.add(root.left);
        rightStack.add(root.right);
        while(!leftStack.isEmpty() && !rightStack.isEmpty())
        {
            TreeNode curLeft = leftStack.pop();
            TreeNode curRight = rightStack.pop();

            if(curLeft == null && curRight == null) continue;

            if(curLeft != null && curRight != null && curLeft.val == curRight.val)
            {
                leftStack.add(curLeft.left);
                leftStack.add(curLeft.right);

                rightStack.add(curRight.right);
                rightStack.add(curRight.left);
            }
            else
            {
                return false;
            }

        }

        return leftStack.isEmpty() && rightStack.isEmpty();
        */

        //sol2: recursion, Time: O(N), Space: O(h = LogN)
        return checkSymmetric(root.left, root.right);
        
    }

    private boolean checkSymmetric(TreeNode left, TreeNode right)
    {
        if(left != null && right != null && left.val == right.val)
        {
            return checkSymmetric(left.left, right.right) && checkSymmetric(left.right, right.left);
        }

        return left == right;
    }
}
