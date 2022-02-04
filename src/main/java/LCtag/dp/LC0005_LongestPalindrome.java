package LCtag.dp;

public class LC0005_LongestPalindrome {
    public String longestPalindrome(String s){
        int len = s.length();
        if(len < 2){
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        boolean[][] dp = new boolean[len][len];
        for(int i = 0; i < len; i++){
            dp[i][i] = true;
        }
        char[] schars = s.toCharArray();
        for(int L = 2; L <= len; L++){//start from palindrome length = 2
            for(int i = 0; i < len; i++){
                int j = i + L - 1;
                if(j >= len) break;

                if(j - i < 3){
                    dp[i][j] = schars[i] == schars[j];
                }else{
                    dp[i][j] = dp[i + 1][j - 1] && schars[i] == schars[j];
                }

                if(dp[i][j] && L > maxLen){
                    maxLen = L;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
