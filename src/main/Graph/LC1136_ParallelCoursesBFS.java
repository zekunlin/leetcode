package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC1136_ParallelCoursesBFS {
    public int minimumSemesters(int n, int[][] relations) {
        int[] inDegree = new int[n + 1];
        List<List<Integer>> graph = new ArrayList<>(n + 1);

        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] relation : relations){
            graph.get(relation[0]).add(relation[1]);
            inDegree[relation[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        
        for(int node = 1; node <= n; node++){
            if(inDegree[node] == 0){
                q.add(node);
            }
        }

        int semester = 0;
        int visitedNum = 0;

        while(!q.isEmpty()){
            semester++;
            int qSize = q.size();
            for(int j = 0; j < qSize; j++){
                visitedNum++;
                int curCourse = q.poll();
                List<Integer> nexts = graph.get(curCourse);
                for(int next : nexts){
                    inDegree[next]--;
                    if(inDegree[next] == 0){
                        q.add(next);
                    }
                }
            }
        }

        return visitedNum == n ? semester : -1;
    }
}
