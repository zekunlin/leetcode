package Stack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class LC1249_MinRemoveToMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        Set<Integer> idxToRemove = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        int len = s.length();
        for(int i = 0; i < len; i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }
            else if(s.charAt(i) == ')'){
                if(stack.isEmpty()){
                    idxToRemove.add(i);
                }
                else{
                    stack.pop();
                }
            }
        }

        while(!stack.isEmpty()){
            idxToRemove.add(stack.pop());
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < len; i++){
            if(!idxToRemove.contains(i)){
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}
