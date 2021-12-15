package LCtag.dp;

public class LC0072_DP_EditDistance {
    public int minDistance(String word1, String word2) {
        //cc
        if(word1.length() == 0) return word2.length();
        if(word2.length() == 0) return word1.length();

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        //initial dp
        for(int i = 0; i <= word1.length(); i++) dp[i][0] = i;
        for(int i = 0; i <= word2.length(); i++) dp[0][i] = i;

        for(int i = 1;i <= word1.length(); i++){
            for(int j = 1; j <= word2.length(); j++){
                char ci = word1.charAt(i - 1);
                char cj = word2.charAt(j - 1);
                if(ci == cj){
                    dp[i][j] = dp[i - 1][j - 1];
                }else{
                    dp[i][j] = Math.min(dp[i - 1][j - 1],
                            Math.min(dp[i - 1][j],
                                    dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
