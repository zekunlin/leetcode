package BinaryTree;

import java.util.LinkedList;
import java.util.List;

import Common.TreeNode;

public class LC0199_BinaryTreeRightSightView {
    public List<Integer> rightSideView(TreeNode root) {
        //BFS:
        //travese every level
        //add the last one to result List
        
        List<Integer> res = new LinkedList<>();
        if(root == null) return res;
        /*
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();

            while(size > 0){
                if(size == 1) res.add(q.peek().val);
                TreeNode node = q.poll();
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
                size--;
            }
        }

        return res;*/

        //DFS:
        //pre-order traversal, add first node seen for each level
        //note: level = result.size() 
        //means the new level hasn't added anything yet, so add the first seen node to res
        dfsHelper(root, 0, res);
        return res;
    }

    public void dfsHelper(TreeNode root, int level, List<Integer> res){
        if(root == null) return;

        if(res.size() == level) res.add(root.val);

        dfsHelper(root.right, level + 1, res); //right first, then left
        dfsHelper(root.left, level + 1, res);
    }
}
