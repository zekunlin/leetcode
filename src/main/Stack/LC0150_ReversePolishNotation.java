package Stack;
import java.util.*;

class ReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();

        for(String token : tokens){
        if(token.equals("+")){
            stack.add(stack.pop() + stack.pop());
        }
        else if(token.equals("-")){
            int val1 = stack.pop();
            stack.add(stack.pop() - val1);
        }
        else if(token.equals("*")){
            stack.add(stack.pop() * stack.pop());
        }
        else if(token.equals("/")){
            int val1 = stack.pop();
            stack.add(stack.pop() / val1);
        }
        else{
            stack.add(Integer.parseInt(token));
        }
        }
        return stack.pop();
    }
}