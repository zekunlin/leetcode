package Graph;
import java.util.*;


class PacificAtlanticWaterFlow {
    int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        List<List<Integer>> ret = new ArrayList<>();

        int nrow = heights.length;
        int ncol = heights[0].length;

        boolean[][] pacificBoard = new boolean[nrow][ncol];
        boolean[][] atlanticBoard = new boolean[nrow][ncol];

        for(int i = 0; i < nrow; i++){
            dfs(i, 0, pacificBoard, heights);
            dfs(i, ncol - 1, atlanticBoard, heights);
        }

        for(int j = 0; j < ncol; j++){
            dfs(0, j, pacificBoard, heights);
            dfs(nrow - 1, j, atlanticBoard, heights);
        }

        for(int x = 0; x < nrow; x++){
            for(int y = 0; y < ncol; y++){
                if(pacificBoard[x][y] && atlanticBoard[x][y]){
                    ret.add(Arrays.asList(x, y));
                }
            }
        }

        return ret;
    }

    private void dfs(int x, int y, boolean[][] oceanBoard, int[][] heights){
        oceanBoard[x][y] = true;

        for(int[] dir: dirs){
            int a = x + dir[0];
            int b = y + dir[1];
        
            if(a < 0 || a >= heights.length || b < 0 || b >= heights[0].length)
            {
                continue;
            }

            if(oceanBoard[a][b]) continue;

            if(heights[a][b] < heights[x][y]){
                continue;
            }

            dfs(a, b, oceanBoard, heights);
        } 
    }
}
