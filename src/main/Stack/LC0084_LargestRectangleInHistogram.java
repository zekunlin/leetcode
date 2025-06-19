package Stack;
import java.util.*;

class LargestRectangleInHistogram{
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int len = heights.length;
        int maxArea = 0;

        for(int idx = 0; idx < len; idx++){
            while(stack.peek() != -1 && heights[stack.peek()] >= heights[idx]){
                int curHeight = heights[stack.pop()];
                int curWidth = idx - stack.peek() - 1;
                maxArea = Math.max(curHeight * curWidth, maxArea);
            }

            stack.push(idx);
        }

        while(stack.peek() != -1){
            int curHeight = heights[stack.pop()];
            int curWidth = len - stack.peek() - 1;
            maxArea = Math.max(maxArea, curHeight * curWidth);
        }

        return maxArea;
    }
}