package LCtag.dp;

public class LC0221_dp_maximalSquare {
    public int maximalSquare(char[][] matrix) {
        //cc
        int nrow = matrix.length;
        int ncol = matrix[0].length;
        int[][] dp = new int[nrow][ncol];
        int max = 0;

        for(int i = 0; i < nrow; i++){
            for(int j = 0; j < ncol; j++){
                if(matrix[i][j] == '1'){
                    if( i == 0 || j == 0){
                        dp[i][j] = 1;
                    }else{
                        dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;

    }
}
