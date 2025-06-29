package BinaryTree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import Common.TreeNode;

public class LC2385_AmountOfTimeNodeWillBeInfected {

    public int amountOfTime(TreeNode root, int start) {
        Map<Integer, HashSet<Integer>> graph = new HashMap<>();
        buildGraph(root, 0, graph);

        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        int min = 0;
        q.offer(start);
        visited.add(start);

        while(!q.isEmpty()){
            int qSize = q.size();

            for(int i = 0; i < qSize; i++){
                int cur = q.poll();
                HashSet<Integer> curNeighbor = graph.get(cur);
                for(int key : curNeighbor){
                    if(!visited.contains(key)){
                        visited.add(key);
                        q.offer(key);
                    }
                }
            }

            min++;
        }

        return min - 1;
    }

    public void buildGraph(TreeNode root, int parent, Map<Integer, HashSet<Integer>> graph){
        if(root == null) return;

        if(!graph.containsKey(root.val)){
            graph.put(root.val, new HashSet<Integer>());
        }

        HashSet<Integer> neighbors = graph.get(root.val);

        if(root.left!= null) neighbors.add(root.left.val);
        if(root.right != null) neighbors.add(root.right.val);
        if(parent != 0) neighbors.add(parent);

        buildGraph(root.left, root.val, graph);
        buildGraph(root.right, root.val, graph);
    }
}
