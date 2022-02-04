package LCtag.string_array;
import java.util.HashMap;
public class LC0525_ContinuesArray {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        //init
        map.put(0, -1);

        int delta = 0;
        int res = 0;
        for(int j = 0; j < n; j++){
            if(nums[j] == 1) delta++;
            else delta--;
            if(map.containsKey(delta)) res = Math.max(res, j - map.get(delta));
            else map.put(delta, j);
        }
        return res;
    }
}
