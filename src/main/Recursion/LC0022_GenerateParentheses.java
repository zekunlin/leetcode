package Recursion;
import java.util.*;

class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> ret = new ArrayList<>();
        generate(n, n, ret, new StringBuilder());
        return ret;
    }

    public void generate(int opening, int closing, ArrayList<String> ret, StringBuilder sb){
        if(closing == 0){
            ret.add(sb.toString());
            return;
        }

        if(opening > 0){
            sb.append("(");
            generate(opening - 1, closing, ret, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(opening < closing){
            sb.append(")");
            generate(opening, closing - 1, ret, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
