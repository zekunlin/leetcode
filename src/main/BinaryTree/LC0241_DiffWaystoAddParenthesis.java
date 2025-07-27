package BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Common.Pair;

public class LC0241_DiffWaystoAddParenthesis {
    public List<Integer> diffWaysToCompute(String expression) {
        HashMap<Pair<Integer, Integer>, List<Integer>> memo = new HashMap<>();
        List<Integer> ans = dfsHelper(expression, 0, expression.length() - 1);
        return ans;
    }

    public List<Integer> dfsHelper(String s, int start, int end){
        List<Integer> res = new ArrayList<>();
        for(int i = start; i <= end; i++){
            char curChar = s.charAt(i);
            if(curChar == '+' || curChar == '-' || curChar == '*'){
                List<Integer> leftValues = dfsHelper(s, start, i - 1);
                List<Integer> rightValues = dfsHelper(s, i + 1, end);

                for(int leftVal : leftValues){
                    for(int rightVal : rightValues){
                        res.add(calculate(leftVal, rightVal, curChar));
                    }
                }
            }
        }

        if(res.isEmpty()){
            res.add(Integer.valueOf(s.substring(start, end+1)));
        }

        return res;
    }

    private int calculate(int leftVal, int rightVal, char expression){
        int res = 0;
        if(expression == '+'){
            res = leftVal + rightVal;
        }
        else if(expression == '-'){
            res = leftVal - rightVal;
        }
        else if(expression == '*'){
            res = leftVal * rightVal;
        }
        return res;
    }
}
