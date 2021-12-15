package LCtag.dp;

public class LC0064_DP_MinimumPathSum {
    public int minPathSum(int[][] grid) {
        //cc
        int nrow = grid.length;
        int ncol = grid[0].length;
        int[][] dp = new int[nrow][ncol];
        dp[0][0] = grid[0][0];
        for(int i = 1; i < nrow; i++){
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
        for(int j = 1; j < ncol; j++){
            dp[0][j] = grid[0][j] + dp[0][j - 1];
        }

        for(int i = 1; i < nrow; i++){
            for(int j = 1; j < ncol; j++){
                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[nrow - 1][ncol - 1];
    }
}
