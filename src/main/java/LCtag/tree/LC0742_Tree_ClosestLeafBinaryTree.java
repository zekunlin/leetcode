package LCtag.tree;

import LCtag.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LC0742_Tree_ClosestLeafBinaryTree {
    //1）通过dfs 建图
    //2）通过bfs ，从target 出发，搜索到leafnode，直接返回答案；
    private class Node{
        int val;
        Node parent;
        Node left;
        Node right;
        boolean visited;
        Node(int val){
            this.val = val;
            this.visited = false;
        }
    }

    private Node target;

    public int findClosestLeaf(TreeNode root, int k) {
        //basecase
        if(root == null) return 0;
        buildGraph(root, k);
        Queue<Node> que = new LinkedList<>();
        que.offer(target);

        while(!que.isEmpty()){
            Node cur = que.poll();
            if(cur.left == null && cur.right == null) return cur.val;
            if(cur.left != null && !cur.left.visited){
                que.offer(cur.left);
                cur.left.visited = true;
            }
            if(cur.right != null && !cur.right.visited){
                que.offer(cur.right);
                cur.right.visited = true;
            }
            if(cur.parent != null && !cur.parent.visited){
                que.offer(cur.parent);
                cur.parent.visited = true;
            }
        }
        return 0;
    }
    private Node buildGraph(TreeNode root, int k){
        Node node = new Node(root.val);
        if(root.val == k) target = node;
        if(root.left != null){
            Node left = buildGraph(root.left, k);
            left.parent = node;
            node.left = left;
        }
        if(root.right != null){
            Node right = buildGraph(root.right, k);
            right.parent = node;
            node.right = right;
        }
        return node;
    }
}
