package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class LC0261_GraphValidTree {
    
    //sol2: Union Find
    public boolean ufValidTree(int n, int[][] edges){
        unionFind uf = new unionFind(n);

        for(int[] edge : edges){
            if(uf.sameParent(edge[0], edge[1])){
                return false;
            }
            else{
                uf.union(edge[0], edge[1]);
            }
        }

        return uf.n == 1;
    }

    class unionFind{
        int[] parent;
        int[] size;
        int n;

        public unionFind(int n){
            this.parent = new int[n];
            this.size = new int[n];
            this.n = n;
            for(int i = 0; i < n; i++){
                parent[i] = i;
            }
            Arrays.fill(size, 1);
        }

        public int getRoot(int node){
            int curNode = node;
            while(parent[curNode] != curNode){
                parent[curNode] = parent[parent[curNode]];
                curNode = parent[curNode];
            }
            parent[node] = curNode;
            return curNode;
        }

        public boolean sameParent(int node1, int node2){
            int parent1 = getRoot(node1);
            int parent2 = getRoot(node2);
            return parent1 == parent2;
        }

        public void union(int node1, int node2){
            int parent1 = getRoot(node1);
            int parent2 = getRoot(node2);

            int size1 = this.size[parent1];
            int size2 = this.size[parent2];

            if(size1 > size2){
                parent[parent2] = parent1;
                size[parent1]++;
            }
            else{
                parent[parent1] = parent2;
                size[parent2]++;
            }
            n--;
        }
    }
    
    //sol1, DFS
    // Time: O(Node + edge = N + (n - 1) = N), space: O(N)
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != (n - 1)) return false;
        //1. build graph
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        for(int i = 0; i < n; i++){
            adjMap.put(i, new ArrayList<>());
        }
        
        for(int i = 0; i < edges.length; i++){
            adjMap.get(edges[i][0]).add(edges[i][1]);
            adjMap.get(edges[i][1]).add(edges[i][0]);
        }
        //2. dfs to traversal graph and detect cycle
        HashSet<Integer> visitedSet = new HashSet<>();

        if(!dfsHelper(0, -1, visitedSet, adjMap)) return false;
        return visitedSet.size() == n;
    }

    private boolean dfsHelper(int node, int parent, HashSet<Integer> visitedSet, Map<Integer, List<Integer>> adjMap){
        if(visitedSet.contains(node)) return false;

        visitedSet.add(node);

        for(int neighbor : adjMap.get(node)){
            if(neighbor == parent) continue;
            if(!dfsHelper(neighbor, node, visitedSet, adjMap)) return false;
        }

        return true;
    }
}


