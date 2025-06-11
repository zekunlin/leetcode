package BinarySearchTree;

import Common.TreeNode;
import java.util.*;

public class AE_RepairBST {
    TreeNode node1;
    TreeNode node2;
    TreeNode prevNode;

    public TreeNode repairBst(TreeNode root)
    {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;

        while(!stack.isEmpty() || cur != null)
        {
            while(cur != null)
            {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();

            prevNode = cur;

            if(prevNode != null && prevNode.val > cur.val )
            {
                if(node1 == null) node1 = prevNode;

                node2 = cur;
            }

            prevNode = cur;
            cur = cur.right;
        }

        int tmp = node1.val;
        node1.val = node2.val;
        node2.val = tmp;

        return root;
    }
}
