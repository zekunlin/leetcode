package Graph;

import java.util.*;

class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        //1. build graph
        course[] courses = new course[n + 1];

        for(int i = 1; i < n + 1; i++){
            courses[i] = new course(i);
        }

        for(int j = 0; j < relations.length; j++){
            int prev = relations[j][0];
            int next = relations[j][1];
            courses[prev].nexts.add(next);
        }

        int[] memo = new int[n + 1];
        int minSemesters = 1;
        for(int k = 1; k < n + 1; k++){
            int curDep = dfsHelper(k, memo, courses);
            if(curDep == -1) return -1;
            minSemesters = Math.max(curDep, minSemesters);
        }   

        return minSemesters;
    }

    private int dfsHelper(int idx, int[] memo, course[] courses){
        course curCourse = courses[idx];

        if(curCourse.status == 1) return -1;
        
        if(curCourse.status == 2) return memo[idx];

        curCourse.status = 1;
        int maxDepth = 0;
        for(int next : curCourse.nexts){
            int depth = dfsHelper(next, memo, courses);
            if (depth == -1) return -1;
            maxDepth = Math.max(maxDepth, depth);
        }

        curCourse.status = 2;
        memo[idx] = maxDepth + 1;
        return memo[idx];
    }
}

class course{
    int val;
    List<Integer> nexts;
    int status;

    public course(int val){
        this.val = val;
        this.nexts = new ArrayList<>();
        status = 0;//0-initial, 1-visiting, 2-visited;
    }
}