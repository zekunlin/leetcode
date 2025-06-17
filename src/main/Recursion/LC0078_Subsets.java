package Recursion;
import java.util.*;

class Subsets{
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if(nums.length == 0) return ret;
        ArrayList<Integer> tmpList = new ArrayList<>();
        backTrack(nums, ret, tmpList, 0);
        return ret;
    }

    private void backTrack(int[] nums, List<List<Integer>> ret, ArrayList<Integer> tmpList, int idx){
        ret.add(new ArrayList(tmpList));

        for(int i = idx; i < nums.length; i++){
            tmpList.add(nums[i]);
            backTrack(nums, ret, tmpList, i + 1);
            tmpList.remove(tmpList.size() - 1);
        }
    }
}