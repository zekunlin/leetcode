package Array;
import java.util.*;

class ThreeSum{
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i = 0; i < nums.length && nums[i] <= 0; i++){
            if(i == 0 || nums[i -1] != nums[i]){
                Set<Integer> valSet = new HashSet<>();
                
                for(int j = i + 1; j < nums.length; j++){
                    int iRemain = 0 - nums[i] - nums[j];

                    if(valSet.contains(iRemain)){
                        ans.add(Arrays.asList(nums[i], nums[j], iRemain));
                        while(j + 1 < nums.length && nums[j] == nums[j + 1]) j++;
                    }
                    
                    valSet.add(nums[j]);
                }
            }
        }
        return ans;
    }
}