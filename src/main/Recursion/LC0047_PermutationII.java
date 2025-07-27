package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC0047_PermutationII {
    //Time: without duplicated num O(n*n!)
    // with duplicates: O()
    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] used = new boolean[len];
        Arrays.sort(nums);
        backtrack(nums, ans, used, new ArrayList<Integer>());
        return ans;
    }

    //the used array is useful for duplicated number:
    /*for [1, 1, 2]

        cur = []
        used = [false, false, false]

        Try i = 0: nums[0] = 1 → OK
        → cur = [1], used = [true, false, false]

        Then i = 1: nums[1] = 1
        → nums[1] == nums[0] && used[0] = true → OK ✅

        cur = []
        used = [false, false, false]

        Try i = 1: nums[1] = 1
        → nums[1] == nums[0] && used[0] = false → SKIP 🚫

     */
    private void backtrack(int[] nums, List<List<Integer>> ans, boolean[] used, ArrayList<Integer> cur){
        if(cur.size() == nums.length){
            ans.add(new ArrayList<Integer>(cur));
            return;
        } 

        for(int i = 0; i < nums.length; i++){
            if(used[i]) continue;
            if(i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) continue;
            used[i] = true;
            cur.add(nums[i]);
            backtrack(nums, ans, used, cur);
            used[i] = false;
            cur.remove(cur.size() - 1);
        }
    }
}
