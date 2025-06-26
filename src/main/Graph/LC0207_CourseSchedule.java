package Graph;
import java.util.*;
//TopoLogical Sort/check cycle
// Time: O(N), Space: O(N)
class CourseSchedule {
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0) return false;

        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        HashMap<Integer, Integer> statusMap = new HashMap<>(); //0, 1, 2 -> initial, visiting, visited
        this.buildGraph(prerequisites, graph, numCourses);
        
        for(int key : graph.keySet()){
            if(!checkCycle(key, graph, statusMap)) return false;
        }
        return true;
    }

    private void buildGraph(int[][] edges, HashMap<Integer, List<Integer>> graph, int numCourses){
        for(int i = 0; i < numCourses; i++){
            graph.put(i, new ArrayList<>());
        }

        for(int[] edge : edges){
            graph.get(edge[1]).add(edge[0]);
        }
    }

    private boolean checkCycle(int target, HashMap<Integer, List<Integer>> graph, HashMap<Integer, Integer> statusMap){
        if(statusMap.containsKey(target)){
            if(statusMap.get(target) == 1) return false;

            if(statusMap.get(target) == 2) return true;
        }

        statusMap.put(target, 1);
        List<Integer> nexts = graph.get(target);
        for(int edge : nexts){
            if(!checkCycle(edge, graph, statusMap)) return false;
        }
        statusMap.put(target, 2);
        return true;
    }
}
