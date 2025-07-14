package Array;

import java.util.Arrays;

public class LC0072_EditDistance {
    class Solution {
    public int minDistance(String word1, String word2) {
        int[][] memo = new int[word1.length()][word2.length()];
        for(int[] row : memo){
            Arrays.fill(row, -1);
        }
        return recursionHelper(word1, word2, word1.length() - 1, word2.length() - 1, memo);
    }

    public int recursionHelper(String word1, String word2, int idx1, int idx2, int[][] memo){
        if(idx1 < 0){
            return idx2 + 1; //means 1 has reached the end, check if 2 still have chars, if so, those cost 'idx2' times to insert to word1
        }

        if(idx2 < 0){
            return idx1 + 1;
        }
        if(memo[idx1][idx2] != -1) return memo[idx1][idx2];
        
        if(word1.charAt(idx1) == word2.charAt(idx2)){
            memo[idx1][idx2] = recursionHelper(word1, word2, idx1 - 1, idx2 - 1, memo);
        }
        else{
            int insertOp = recursionHelper(word1, word2, idx1, idx2 - 1, memo);
            int deleteOp = recursionHelper(word1, word2, idx1 - 1, idx2, memo);
            int replaceOp = recursionHelper(word1, word2, idx1 - 1,  idx2 - 1, memo);
            memo[idx1][idx2] = Math.min(insertOp, Math.min( deleteOp, replaceOp)) + 1; 
        }

        return memo[idx1][idx2];
    }
}
}
