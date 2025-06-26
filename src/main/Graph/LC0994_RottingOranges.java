package Graph;
import java.util.*;

class RottingOranges{
    //Notes: have to push all rotten oranges at beginning, they start to rotting at the same time
    //double check if freshOrangeNum becomes 0 before return minMinutes
    //Time: O(m*n), Space: O(m * n)
    public int orangesRotting(int[][] grid) {
        int nrow = grid.length;
        int ncol = grid[0].length;
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        
        int minMinutes = 0;
        int freshOrangeNum = 0;
        
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < nrow; i++){
            for(int j = 0; j < ncol; j++){
                if(grid[i][j] == 1){
                    freshOrangeNum+= 1;
                    continue;
                }
                else if(grid[i][j] == 2){
                    q.offer(new int[]{i, j});
                }
            }
        }

        while(!q.isEmpty() && freshOrangeNum > 0){
            int size = q.size();

            for(int s = 0; s < size; s++){
                int[] cur = q.poll();
                for(int[] dir : dirs){
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];

                    if(x >= 0 && x < nrow && y >= 0 && y < ncol && grid[x][y] == 1){
                        grid[x][y] = 2;
                        freshOrangeNum-= 1;
                        q.offer(new int[]{x,  y});
                    }
                }
            }
            
            minMinutes+= 1;
        }
                
        return freshOrangeNum == 0 ? minMinutes : -1;
    }
}