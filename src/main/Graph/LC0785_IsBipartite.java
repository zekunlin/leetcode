package Graph;
import java.util.*;

class Bipartite {
    public boolean isBipartite(int[][] graph) {
        Boolean[] colored = new Boolean[graph.length];

        for(int i = 0; i < graph.length; i++){
            if(colored[i] == null){
                Stack<Integer> stack = new Stack<>();
                stack.push(i);
                colored[i] = true;

                while(!stack.isEmpty()){
                    int curNode = stack.pop();
                    int[] edges = graph[curNode];

                    for(int edge: edges){
                        if(colored[edge] == null)
                        {
                            colored[edge] = !colored[curNode];
                            stack.push(edge);
                        }
                        else if(colored[curNode] == colored[edge])
                        {
                            return false;
                        }
                    }
                }
            }
        }
        
        
        return true;
    }
    
    private boolean checkBipartite(int[][] graph, int idx, Boolean[] colored){
        if(colored[idx] != null) return true;

        int[] neighbors = graph[idx];
        if(colored[idx] == null) colored[idx] = true;

        for(int edge : neighbors){
            if(colored[edge] == null){
                colored[edge] = !colored[idx];
                checkBipartite(graph, edge, colored);
            }
            else if(colored[edge] == colored[idx]){
                return false;
            }
        }

        return true;
    }
}