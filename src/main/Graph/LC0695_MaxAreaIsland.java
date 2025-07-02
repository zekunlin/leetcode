package Graph;

public class LC0695_MaxAreaIsland {
    int nrow;
    int ncol;
    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    boolean[][] visited;
    int maxArea = 0;
    public int maxAreaOfIsland(int[][] grid) {
        nrow = grid.length;
        ncol = grid[0].length;
        visited = new boolean[nrow][ncol];

        for(int i = 0; i < nrow; i++){
            for(int j = 0; j < ncol; j++){
                if(grid[i][j] == 1){
                    dfs(i, j, grid);
                }
            }
        }

        return maxArea;
    }

    public int dfs(int i, int j, int[][] grid){
        if(i < 0 || i >= nrow || j < 0 || j >= ncol || grid[i][j] == 0 || visited[i][j]) return 0;

        visited[i][j] = true;
        int curArea = 1;

        for(int[] dir : dirs){
            int x = i + dir[0];
            int y = j + dir[1];
            curArea += dfs(x, y, grid);
        }

        maxArea = Math.max(maxArea, curArea);
        return curArea;
    }
}
