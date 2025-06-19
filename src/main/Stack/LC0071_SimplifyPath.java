package Stack;
import java.util.*;

class SimplifyPath{
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] stringPath = path.split("/");

        for(String str : stringPath){
            if(str.equals(".") || str.equals("")){
                continue;
            }
            else if(str.equals("..")){
                if(!stack.isEmpty())stack.pop();
            }
            else{
                stack.push(str);
            }
        }

        StringBuilder sb = new StringBuilder();

        for(String str : stack){
            sb.append("/");
            sb.append(str);
        }

        return sb.length() > 0 ? sb.toString() : "/";
    }
}