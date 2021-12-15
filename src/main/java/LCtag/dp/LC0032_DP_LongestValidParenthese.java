package LCtag.dp;

public class LC0032_DP_LongestValidParenthese {
    class Solution {
        public int longestValidParentheses(String s) {
            //cc
            if(s == null || s.length() == 0) return 0;
            int len = s.length();
            int dp[] = new int[len];
            int max = 0;
            for(int i = 1; i < len; i++){
                char si = s.charAt(i);
                if(si == ')'){
                    if(s.charAt(i - 1) == '('){
                        if(i - 2 >= 0){
                            dp[i] = dp[i - 2] + 2;
                        }else{
                            dp[i] = 2;
                        }

                    }else{
                        if(i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                            if(i - dp[i - 1] - 2 >= 0){
                                dp[i] = dp[i - dp[i - 1] - 2] + 2 + dp[i - 1];
                            }else{
                                dp[i] = dp[i - 1] + 2;
                            }
                        }
                    }

                }
                max = Math.max(max, dp[i]);
            }
            return max;
        }
    }
}
