package Calculator;

import java.util.Stack;

public class LC0227_BasicCalculator {
    public int calculate(String s) {
        Stack<Integer> numStack = new Stack<>();

        int num = 0;
        int topNum = 0;
        char operation = '+';
        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            if(Character.isDigit(cur)){
                num = num * 10 + (cur - '0');
            }
            
            if(cur == '+' || cur == '-' || cur == '*' || cur == '/' || i == s.length() - 1){
                switch (operation) {
                    case '+':
                        numStack.add(num);
                        break;
                    case '-':
                        numStack.add(num * -1);
                        break;
                    case '*':
                        if(numStack.isEmpty()) return -1;
                        topNum = numStack.pop();
                        numStack.add(topNum * num);
                        break;
                    case '/':
                        if(numStack.isEmpty()) return -1;
                        topNum = numStack.pop();
                        numStack.add(topNum / num);
                        break;
                }

                num = 0;
                operation = cur;
            }
        }

        int ans = 0;
        while(!numStack.isEmpty()){
            ans += numStack.pop();
        }
        return ans;
    }
}
