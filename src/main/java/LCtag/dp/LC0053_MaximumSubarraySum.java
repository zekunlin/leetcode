package LCtag.dp;

public class LC0053_MaximumSubarraySum {
    class Solution {
        public int maxSubArray(int[] nums) {
            int curSum = 0;
            int max = nums[0];
            for(int num : nums){
                if(curSum > 0){
                    curSum += num;
                }else{
                    curSum = num;
                }
                max = Math.max(curSum, max);
            }
            return max;
        }
    }
}
