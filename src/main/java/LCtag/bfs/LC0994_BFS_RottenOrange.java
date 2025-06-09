package java.LCtag.bfs;

import java.util.*;
public class LC0994_BFS_RottenOrange {
    class Solution {
        private final int[][] DIRS = {{1,0},{-1,0},{0,1},{0,-1}};
        public int orangesRotting(int[][] grid) {
            //cc
            int nrow = grid.length;
            int ncol = grid[0].length;
            //boolean[][] visited = new boolean[nrow][ncol];
            Queue<Integer> queue = new LinkedList<>();
            int freshNum = 0;
            for(int i = 0; i < nrow; i++){
                for(int j = 0; j < ncol; j++){
                    if(grid[i][j] == 2){
                        queue.offer(i * ncol + j);
                    }else if(grid[i][j] == 1){
                        freshNum++;
                    }
                }
            }
            if(freshNum == 0) return 0;

            int minTime = 0;
            while(!queue.isEmpty() && freshNum > 0 ){
                int size = queue.size();
                minTime++;
                while(size-- > 0){
                    int cur = queue.poll();
                    int i = cur / ncol;
                    int j = cur % ncol;
                    for(int[] dir : DIRS){
                        int ii = i + dir[0];
                        int jj = j + dir[1];
                        if(ii >= 0 && ii < nrow && jj >= 0 && jj < ncol && grid[ii][jj] == 1){
                            grid[ii][jj] = 2;
                            freshNum--;
                            queue.offer(ii * ncol + jj);

                        }
                    }
                }
            }
            return freshNum == 0 ? minTime : -1;
        }
    }
}
