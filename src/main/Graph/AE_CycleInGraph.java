package Graph;

class CycleInGraph {
    public boolean cycleInGraph(int[][] edges) {
    // Write your code here.
    boolean[] visited = new boolean[edges.length];
    boolean[] inRecursionStack = new boolean[edges.length];
            
    for(int i = 0; i < edges.length; i++){
      if(visited[i]) continue;
      
      boolean foundCycle = checkCycle(i, visited, inRecursionStack, edges);

      if(foundCycle) return true;
    }
    
    return false;
  }

  private boolean checkCycle(int node, boolean[] visited, boolean[] inRecursionStack, int[][] edges){
    visited[node] = true;
    inRecursionStack[node] = true;
    int[] neighbors = edges[node];

    for(int i : neighbors){
      if(!visited[i]){
        if(checkCycle(i, visited, inRecursionStack, edges)) return true;
      }
      else if(inRecursionStack[i]){
        return true;
      }
    }

    inRecursionStack[node] = false;
    return false;
  }
}
