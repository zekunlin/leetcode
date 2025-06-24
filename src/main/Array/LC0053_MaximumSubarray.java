package Array;

public class LC0053_MaximumSubarray {
    //sol1: brutal force, two pointers O(N^2);
    //pointer1 track each element in array
    //pointer2 go explore the potential maximum subarray sum based on pointer1
    //when pointer1 move forward, it rules out itself in sum(potential max subarray)
    public int maxSubArrayI(int[] nums) {
        int totalMax = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            int curMax = 0;
            for(int j = i; j < nums.length; j++){
                curMax += nums[j];
                totalMax = Math.max(totalMax, curMax);
            }
        }
        return totalMax;
    }

    public int maxSubArrayII(int[] nums) {
        int curSubSum = nums[0];
        int totalMaxSum = nums[0];

        for(int i = 1; i < nums.length; i++){
            int num = nums[i];
            
            //we compare current num with curSubSum everytime
            //if cur num > curSubSum, reset curSubSum to cur num,
            //as subarray before this num would only lower the curSubSum when adding cur sum
            curSubSum = Math.max(num, curSubSum + num);
            totalMaxSum = Math.max(totalMaxSum, curSubSum);
        }

        return totalMaxSum;
    }
}
