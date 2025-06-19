package Recursion;
import java.util.*;

class GenerateDivTags {
    public ArrayList<String> generateDivTags(int numberOfTags) {
    // Write your code here.
    ArrayList<String> ret = new ArrayList<>();
    recursion(ret, numberOfTags, numberOfTags, new StringBuilder());
    // or instead recursion(ret, numberOfTags, numberOfTags, "")
    return ret;
  }

  private void recursion(ArrayList<String> ret, int leftNum, int rightNum, StringBuilder sb){// use String here instead of stringbuilder to avoid manual backtracking
    
    if(rightNum == 0) ret.add(sb.toString());

    if(leftNum > 0){
      sb.append("<div>"); // string str + "<div>"
      recursion(ret, leftNum - 1, rightNum, sb);
      sb.delete(sb.length() - 5, sb.length());
    }

    if(leftNum < rightNum){
      sb.append("</div>");// string str + "</div>"
      recursion(ret, leftNum, rightNum - 1, sb);
      sb.delete(sb.length() - 6, sb.length());
    }
  }
}
