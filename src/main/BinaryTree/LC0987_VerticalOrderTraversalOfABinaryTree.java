package BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Common.TreeNode;

public class LC0987_VerticalOrderTraversalOfABinaryTree {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer, ArrayList<MyTreeNode>> colMap = new HashMap<>();
        MyTreeNode myRoot = new MyTreeNode(root, 0, 0);
        int minCol = Integer.MAX_VALUE;
        int maxCol = Integer.MIN_VALUE;

        Queue<MyTreeNode> q = new LinkedList<>();
        q.offer(myRoot);

        while(!q.isEmpty()){
            MyTreeNode cur = q.poll();
            colMap.putIfAbsent(cur.ncol, new ArrayList<>());
            colMap.get(cur.ncol).add(cur);
            minCol = Math.min(minCol, cur.ncol);
            maxCol = Math.max(maxCol, cur.ncol);

            if(cur.node.left != null){
                MyTreeNode curLeft = new MyTreeNode(cur.node.left, cur.ncol - 1, cur.nrow + 1);
                q.offer(curLeft);
            }

            if(cur.node.right != null){
                MyTreeNode curRight = new MyTreeNode(cur.node.right, cur.ncol + 1, cur.nrow + 1);
                q.offer(curRight);
            }
        }

        for(int keyIdx = minCol; keyIdx <= maxCol; keyIdx++){
            List<MyTreeNode> curList = colMap.getOrDefault(keyIdx, new ArrayList<>());
            Collections.sort(curList, (n1, n2) ->{
                if(n1.nrow != n2.nrow){
                    return Integer.compare(n1.nrow, n2.nrow);
                }
                return Integer.compare(n1.node.val, n2.node.val);
            });

            ArrayList<Integer> tmpList = new ArrayList<>();
            for(MyTreeNode node : curList){
                tmpList.add(node.node.val);
            }
            ans.add(tmpList);
        }
        
        return ans;
    }

    class MyTreeNode{
        TreeNode node;
        int ncol;
        int nrow;

        public MyTreeNode(TreeNode node, int ncol, int nrow){
            this.node = node;
            this.ncol = ncol;
            this.nrow = nrow;
        }
    }
}
