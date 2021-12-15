package LCtag.dp;

public class LC0174_dp_dungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        //cc
        if(dungeon == null || dungeon.length == 0 || dungeon[0] == null || dungeon[0].length == 0) return -1;
        int nrow = dungeon.length;
        int ncol = dungeon[0].length;
        int[][] dp = new int[nrow][ncol];
        dp[nrow - 1][ncol - 1] = Math.max(0, -dungeon[nrow - 1][ncol - 1]);
        for(int i = nrow - 1 ; i >= 0; i--){
            dp[i][ncol - 1] = Integer.MAX_VALUE;
        }
        for(int j = ncol - 1; j >= 0; j--) dp[nrow - 1][j] = Integer.MAX_VALUE;

        for(int i = nrow - 2;i >= 0; i--){
            for(int j = ncol - 2; j >= 0; j--){
                dp[i][j] = Math.max(0, Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j]);
            }
        }
        return dp[0][0] + 1;
    }
}

// int[][] dp = new int[rowSize][colSize];
// // 设置最后一个值。
// dp[rowSize - 1][colSize -1] = Math.max(0, -dungeon[rowSize - 1][colSize - 1]);

// // 设置最后一列的值
// for (int i = rowSize - 2; i >= 0; --i) {
//     int needMin = dp[i + 1][colSize - 1] - dungeon[i][colSize - 1];
//     dp[i][colSize -1] = Math.max(0, needMin);
// }

// // 设置最后一行的值
// for (int i = colSize - 2; i >= 0; --i) {
//     int needMin = dp[rowSize - 1][i + 1] - dungeon[rowSize - 1][i];
//     dp[rowSize - 1][i] = Math.max(0, needMin);
// }

// for (int i = rowSize - 2; i >= 0; --i) {
//     for (int j = colSize - 2; j >= 0; --j) {
// 		// 从右边和下边选择一个最小值，然后减去当前的 dungeon 值
//         int needMin = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
//         dp[i][j] = Math.max(0, needMin);
//     }
// }
// return dp[0][0] + 1;

