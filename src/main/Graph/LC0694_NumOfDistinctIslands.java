package Graph;

import java.util.*;

class numberOfDistinctIslands{
    int nrow;
    int ncol;
    int[][] dirs = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int numDistinctIslands(int[][] grid) {
        nrow = grid.length;
        ncol = grid[0].length;
        HashSet<String> path = new HashSet<>();

        for(int i = 0; i < nrow; i++){
            for(int j = 0; j < ncol; j++){
                if(grid[i][j] == 1){
                    StringBuilder sb = new StringBuilder();
                    dfs(i, j, i, j, grid, sb);
                    path.add(sb.toString());
                }
            }
        }

        return path.size();
    }

    public void dfs(int i, int j, int startingX, int startingY, int[][] grid, StringBuilder sb){
        if(i < 0 || i >= nrow || j < 0 || j >= ncol || grid[i][j] == 0) return;

        grid[i][j] = 0;
        sb.append(i - startingX); //we want append pattern, so append the distance from startingX
        sb.append(j - startingY); // same as above
        for(int[] dir : dirs){
            int x = i + dir[0];
            int y = j + dir[1];
            dfs(x, y, startingX, startingY, grid, sb);
        }

    }
}