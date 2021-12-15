package LCtag.dp;

public class LC0132_DP_PalindromePartioningII {
    public int minCut(String s) {
        //cc
        int len = s.length();
        int[] dp = new int[len + 1];//want empty string so len + 1;
        dp[0] = 0;
        for(int i = 0; i < len; i++){
            for(int j = 0; j <= i; j++){
                String word = s.substring(j, i + 1);//[j,i]
                if(isP(word)){
                    int dpIdxi = i + 1;//i,j都是string idx，转化成dp idx都要+1；
                    int dpIdxj = j + 1;
                    dp[dpIdxi] = Math.min(dp[dpIdxi], dp[dpIdxj] + 1);
                }
            }
        }
        return dp[len] - 1;
    }
    private boolean isP(String word){
        int j = word.length() - 1;
        int i = 0;
        while(i <= j){
            if(word.charAt(i) != word.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
