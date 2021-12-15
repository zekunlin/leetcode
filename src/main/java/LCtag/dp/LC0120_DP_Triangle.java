package LCtag.dp;

public class LC0120_DP_Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        //cc
        int len = triangle.size();
        int[][] dp = new int[len][len];//最后一行的元素个数和三角形层数是一样的
        dp[0][0] = triangle.get(0).get(0);

        for(int i = 1; i < len; i++){
            List<Integer> iList = triangle.get(i);
            dp[i][0] = dp[i - 1][0] + iList.get(0);//每行第一个初始化一下
            for(int j = 1; j < iList.size(); j++){
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + iList.get(j);
            }
            dp[i][i] = dp[i - 1][i - 1] + iList.get(i);//每行最后一个也初始化一下
        }
        int min = dp[len - 1][0];
        for(int i = 1; i < len; i++){
            min = Math.min(min, dp[len - 1][i]);
        }
        return min;
    }
}
