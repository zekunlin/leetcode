package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC0090_SubsetII {
    //Time: O(2^n)
    //Space: O(N) for recursion, O(n * 2^n) to store the all subsets
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        backtrack(nums, ans, new ArrayList<Integer>(), 0);

        return ans;
    }

    public void backtrack(int[] nums, List<List<Integer>> ans, ArrayList<Integer> cur, int idx){
        ans.add(new ArrayList<Integer>(cur));

        for(int i = idx; i < nums.length; i++){
            if(i > idx && nums[i] == nums[i - 1]) continue;
            cur.add(nums[i]);
            backtrack(nums, ans, cur, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}


/*https://leetcode.com/problems/subsets-ii/solutions/169226/Java-Two-Way-of-Recursive-thinking */