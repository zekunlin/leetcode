package Recursion;
import java.util.*;

class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();

        if(nums.length == 0) return ret;

        
        backTrack(new ArrayList<Integer>(), nums, ret);

        return ret;
    }

    private void backTrack(ArrayList<Integer> tmpList, int[] nums, List<List<Integer>> retList){
        if(tmpList.size() == nums.length){
            retList.add(new ArrayList<>(tmpList)); // hard copy
            return;
        }
        else{
            for(int i : nums){
                if(tmpList.contains(i)) continue;
                tmpList.add(i);
                backTrack(tmpList, nums, retList);
                tmpList.remove(tmpList.size() - 1);
            }
        }
    }
}
