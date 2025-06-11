

package BinaryTree;
import java.util.*;

import Common.Pair;
import Common.TreeNode;

public class LC0314_BinaryTreeVerticalOrderTraversal {

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null) return ret;

        Map<Integer, ArrayList<Integer>> columnElements = new HashMap<>();

        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        
        queue.offer(new Pair<TreeNode, Integer>(root, 0));

        while(!queue.isEmpty())
        {
            Pair<TreeNode, Integer> curPair = queue.poll();
            TreeNode curNode = curPair.getKey();
            int ncol = curPair.getValue();

            if(curNode != null)
            {
                if(!columnElements.containsKey(ncol))
                {
                    columnElements.put(ncol, new ArrayList<Integer>());
                }
                columnElements.get(ncol).add(curNode.val);
            }

            if(curNode.left != null) queue.offer(new Pair<TreeNode, Integer>(curNode.left, ncol - 1));
            if(curNode.right != null) queue.offer(new Pair<TreeNode, Integer>(curNode.right, ncol + 1));
        }

        List<Integer> columnNums = new ArrayList<>(columnElements.keySet());
        Collections.sort(columnNums);
        for(int i : columnNums)
        {
            ret.add(columnElements.get(i));
        }

        return ret;
    }
}