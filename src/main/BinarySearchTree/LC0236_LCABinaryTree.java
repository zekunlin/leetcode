package BinarySearchTree;

import Common.TreeNode;
import java.util.*;

// Time: O(N), Space: O(N)
class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;

        if(root.val == p.val || root.val == q.val) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null) return root;

        return left != null ? left : right;

        /*
 * 
 *The second if statement checks if both l and r are not None. If this condition is true, it means that we have found both p and q in different subtrees of the current root, and therefore the current root is the lowest common ancestor. We return the current root.

If the second if statement is not satisfied, we return either l or r, depending on which one is not None. This is because if only one of l and r is not None, it means that the other node is not in the subtree of the current root, so we return the node that is in the subtree.

If none of the previous conditions is satisfied, it means that both l and r are None, so we return None. This happens when we have reached the end of a branch of the binary tree without finding either p or q.
 */

 //sol2:

        
    }
}

class Solution2 {
    public TreeNode lca(TreeNode root, TreeNode p, TreeNode q){
        Deque<TreeNode> stack = new ArrayDeque<>();

        Map<TreeNode, TreeNode> nodeParentMap = new HashMap<>();
        stack.push(root);
        nodeParentMap.put(root, null);

        while(!nodeParentMap.containsKey(p) || !nodeParentMap.containsKey(q))
        {
            TreeNode curNode = stack.pop();

            if(curNode.left != null)
            {
                nodeParentMap.put(curNode.left, curNode);
                stack.push(curNode.left);
            }

            if(curNode.right != null)
            {
                nodeParentMap.put(curNode.right, curNode);
                stack.push(curNode.right);
            }
        }

        Set<TreeNode> ancestor = new HashSet<>();

        while(p != null)
        {
            ancestor.add(p);
            p = nodeParentMap.get(p);
        }

        while (!ancestor.contains(q)) {
            q = nodeParentMap.get(q);
        }

        return q;
    }
}




// sol2:
