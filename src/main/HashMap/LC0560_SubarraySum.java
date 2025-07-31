package HashMap;

import java.util.HashMap;

class SubarraySum{
    //sol1: Time: O(N^2)
    public int subarraySum(int[] nums, int k) {
        int arrrCount = 0;
        for(int i = 0; i < nums.length; i++){
            int runningSum = 0;
            for(int j = i; j < nums.length; j++){
                runningSum += nums[j];
                if(runningSum == k){
                    arrrCount++;
                }
            }
        }

        return arrrCount;
    }

    //sol2: Time: O(n)
    //[3, 4, 7, 2, -3, 1, 4, 2], k = 7
    // i  j  
    //       x
    //       14
    //       14 - 7 = 7, existed in the hashmap
    
    public int subarraySumII(int[] nums, int k) {
        HashMap<Integer, Integer> sumFrequency = new HashMap<>();
        sumFrequency.put(0, 1);
        int runningSum = 0;
        int subArryCnt = 0;

        for(int i = 0; i < nums.length; i++){
            runningSum += nums[i];
            if(sumFrequency.containsKey(runningSum - k)){
                subArryCnt += sumFrequency.get(runningSum - k);
            }
            sumFrequency.put(runningSum, sumFrequency.getOrDefault(runningSum, 0) + 1);
        }

        return subArryCnt;
    }
}