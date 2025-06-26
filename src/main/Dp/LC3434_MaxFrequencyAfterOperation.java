package Dp;

public class LC3434_MaxFrequencyAfterOperation {
    public int maxFrequency(int[] nums, int k) {
        int initialFreqOfK = 0;
        for(int num : nums){
            if(num == k) initialFreqOfK++;
        }

        int maxGain = 0;
        // each num in array is in [0, 50]
        // so looking for a sub array that can:
        // make me get a maximum the gain, 
        // where the gain +1 when in subarray when matched a number with x, this means we found a subarray, it has multiple matched numbers to x, we can (x + diff) -> k, but the same time, we are losing number of k, because in this subarray k has to + diff. so a number in subarray matched x ? +1 to gain, a number is equal to k? -1 to gain. 
        // we are looking for a subarray, it gives back maximum of gain
        // that's hwere kadain algo comes into play
        for(int x = 1; x <= 50; x++){
            if(x == k) continue;
            int curGainByMatchingX = 0;
            int maxGainByMatchingX = 0;

            for(int n : nums){
                if(n == x){
                    curGainByMatchingX += 1;
                }
                else if(n == k){
                    curGainByMatchingX -= 1;
                }

                curGainByMatchingX = Math.max(curGainByMatchingX, 0);
                maxGainByMatchingX = Math.max(maxGainByMatchingX, curGainByMatchingX);
            }

            maxGain = Math.max(maxGain, maxGainByMatchingX);
        }

        return initialFreqOfK + maxGain;
    }
}
