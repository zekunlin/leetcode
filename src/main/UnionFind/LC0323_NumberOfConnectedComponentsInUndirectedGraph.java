package UnionFind;

import java.util.ArrayList;

public class LC0323_NumberOfConnectedComponentsInUndirectedGraph {
    //sol1: union find
    // Time: O()
    // Space: O(V)
    public int countComponents(int n, int[][] edges) {
        int connectedNum = n;

        int[] roots = new int[n];
        for(int i = 0; i < n; i++){
            roots[i] = i;
        }

        for(int[] edge : edges){
            int root1 = findRoots(roots, edge[0]);
            int root2 = findRoots(roots, edge[1]);

            if(root1 != root2){
                roots[root1] = root2;
                connectedNum--;
            }
        }

        return connectedNum;
    }

    public int findRoots(int[] roots, int node){
        while(roots[node] != node){
            roots[node] = roots[roots[node]];
            node = roots[node];
        }

        return node;
    }


    //sol2: dfs
    //Time: O(V + E), Space: O(V + E)
    public int countComponents2(int n, int[][] edges) {
        int components = 0;
        int len = edges.length;
        if(len==0) return components;
        boolean[] visited = new boolean[n];

        ArrayList<Integer>[] adjList = new ArrayList[n];
        for(int i = 0; i < n; i++){
            adjList[i] = new ArrayList<>();
        }

        for(int i = 0; i < len; i++){
            adjList[edges[i][0]].add(edges[i][1]);//add edges[i][1] to edges[i][0] adj list
            adjList[edges[i][1]].add(edges[i][0]);//add edges[i][0] to edges[i][1] adj adjList
        }

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                components+= 1;
                dfs(adjList, visited, i);
            }
        }

        return components;
    }

    public void dfs(ArrayList<Integer>[] adjList, boolean[] visited, int idx){
        if(idx >= adjList.length || visited[idx]) return;
        visited[idx] = true;
        for(int edge : adjList[idx]){
            dfs(adjList, visited, edge);
        }
    }
}
