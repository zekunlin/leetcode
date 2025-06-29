package Graph;
import java.util.*;

class FindPathInGraph {
    //Time: O(m + n) space: O(M + N) 
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        for(int[] edge : edges){
            if(!graph.containsKey(edge[0])){
                graph.put(edge[0], new ArrayList<>());
            }
            graph.get(edge[0]).add(edge[1]);

            if(!graph.containsKey(edge[1])){
                graph.put(edge[1], new ArrayList<>());
            }
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];

        return dfsHelper(source, destination, graph, visited);
    }
    public boolean dfsHelper(int source, int destination, HashMap<Integer, List<Integer>> graph, boolean[] visited){
        if(source == destination) return true;

        List<Integer> neighbors = graph.get(source);
        visited[source] = true;
        for(int neighbor : neighbors){
            if(!visited[neighbor]){
                if(dfsHelper(neighbor, destination, graph, visited)) return true;
            }
        }

        return false;
    }
}