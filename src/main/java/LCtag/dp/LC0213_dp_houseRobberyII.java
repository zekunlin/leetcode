package LCtag.dp;

public class LC0213_dp_houseRobberyII {
    public int rob(int[] nums) {
        //cc
        int len = nums.length;
        if(len == 1){
            return nums[0];
        }else if(len == 2){
            return Math.max(nums[0], nums[1]);
        }

        return Math.max(robRange(nums, 0, len - 2), robRange(nums, 1, len - 1));
    }
    private int robRange(int[] nums, int startIdx, int endIdx){
        int prev = nums[startIdx];
        int secd = Math.max(nums[startIdx], nums[startIdx + 1]);
        for(int i = startIdx + 2; i <= endIdx; i++){
            int tmp = secd;
            secd = Math.max(prev + nums[i], secd);
            prev = tmp;
        }
        return secd;
    }
}
// public int rob(int[] nums) {
//         int length = nums.length;
//         if (length == 1) {
//             return nums[0];
//         } else if (length == 2) {
//             return Math.max(nums[0], nums[1]);
//         }
//         return Math.max(robRange(nums, 0, length - 2), robRange(nums, 1, length - 1));
//     }

//     public int robRange(int[] nums, int start, int end) {
//         int first = nums[start], second = Math.max(nums[start], nums[start + 1]);
//         for (int i = start + 2; i <= end; i++) {
//             int temp = second;
//             second = Math.max(first + nums[i], second);
//             first = temp;
//         }
//         return second;
//     }

