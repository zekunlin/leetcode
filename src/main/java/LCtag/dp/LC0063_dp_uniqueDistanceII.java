package LCtag.dp;

public class LC0063_dp_uniqueDistanceII {
    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            //cc
            int nrow = obstacleGrid.length;
            int ncol = obstacleGrid[0].length;
            int[][] dp = new int[nrow][ncol];
            if(obstacleGrid[0][0] == 1){
                dp[0][0] = 0;
            }else{
                dp[0][0] = 1;
            }
            for(int i = 1; i < nrow; i++){
                if(obstacleGrid[i][0] == 1){
                    dp[i][0] = 0;
                }else{
                    dp[i][0] = dp[i - 1][0];
                }
            }
            for(int j = 1; j < ncol; j++){
                if(obstacleGrid[0][j] == 1){
                    dp[0][j] = 0;
                }else{
                    dp[0][j] = dp[0][j - 1];
                }
            }

            for(int i = 1; i < nrow; i++){
                for(int j = 1; j < ncol; j++){
                    if(obstacleGrid[i][j] == 1){
                        dp[i][j] = 0;
                    }else{
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    }
                }
            }
            return dp[nrow - 1][ncol - 1];
        }
    }
}
