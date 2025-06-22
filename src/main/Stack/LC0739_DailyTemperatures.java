package Stack;

import java.util.Stack;

public class LC0739_DailyTemperatures {
    //Time: O(N), Space: O(N)
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] ans = new int[len];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < len; i++){
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                int coolerDay = stack.pop();
                ans[coolerDay] = i - coolerDay;
            }

            stack.push(i);
        }

        return ans;
    }
}
