package Stack;

import java.util.*;

class LongestValidParentheses{
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int maxLen = 0;
        stack.push(-1); //-1 serves as a left boundary/base idx to calculate valid parentheses from -1 to the right

        for(int i = 0; i < s.length(); i++){
            char curChar = s.charAt(i);
            if(curChar == '('){
                stack.push(i);
            }
            else{
                stack.pop();
                if(stack.isEmpty()){
                    // push a new unmatched ')' idx to stack, 
                    // let it be a new start point of counting valid parentheses
                    stack.push(i);
                }
                int curLen = i - stack.peek();
                maxLen = Math.max(curLen, maxLen);
            }
        }

        return maxLen;
    }
}
