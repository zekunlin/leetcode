package Dp;

public class LC0062_UniquePath {
    //sol1 DP: Time: O(M*n), space : O(M * n)
    public int uniquePaths(int m, int n) {
        int[][] pathMatrix = new int[m + 1][n+1];

        for(int i = 1; i < m + 1; i++){
            for(int j = 1; j < n + 1; j++){
                if(i == 1 && j == 1){
                    pathMatrix[i][j] = 1;
                }
                else{
                    pathMatrix[i][j] = pathMatrix[i - 1][j] + pathMatrix[i][j-1];
                }
            }
        }

        return pathMatrix[m][n];
    }

    //sol2 : recursion: TIME: O(2 ^ (m*n)) each position have two options, and traverse all m*n position
    // Space: O(m*n)
    public int uniquePathsII(int m, int n){
        if(m ==1 || n == 1) return 1;
        return uniquePathsII(m, n - 1) + uniquePathsII(m - 1, n);
    }
}
