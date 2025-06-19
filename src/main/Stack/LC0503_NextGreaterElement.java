package Stack;
import java.util.*;

class NextGreaterElement{
    //sol1: Time: O(2* n), Space: O(N)
    // to satisify the 'circular array', use a circular idx by double loop by 2*len and idx % len
    // 2 passes , and use stack + space to store result -> O(N)

    public int[] nextGreaterElement(int[] array) {
    // Write your code here.
    Stack<Integer> stack = new Stack<>();
    int[] res = new int[array.length];
    Arrays.fill(res, -1);

    for(int idx = 0; idx < 2 * array.length; idx++){
      int circularIdx = idx % array.length; //circularidx -> so can go back to array[0] when at the end
      
      //because stack is FILO, stack top is the latest element, 
      // compare stack top vs next element in array when iterating
      // will always find "NEXT" greater element.
      // stack store idx not element
      while(!stack.isEmpty() && array[stack.peek()] < array[circularIdx]){
        int topIdx = stack.pop();
        res[topIdx] = array[circularIdx];
      }
      stack.push(circularIdx);
    }

    return res;
  }

  //sol2: going back ward
  public int[] nextGreaterElementII(int[] array) {
    // Write your code here.
    Stack<Integer> stack = new Stack<>();
    int[] res = new int[array.length];
    Arrays.fill(res, -1);
    //by going backward, we are basically saying
    //check stack top vs next element on the left
    //if stacktop <= element -> means stack top cant be the next greater for the element at the left -> pop
    //else stacktop > element -> stacktop is the next greater element for the left element -> assign ans

    for(int i = 2* array.length - 1; i >=0; i--){
      int circularIdx = i % array.length;

      while(!stack.isEmpty()){
        if(stack.peek() <= array[circularIdx])
        {
          stack.pop();
        }
        else
        {
          res[circularIdx] = stack.peek();
          break;
        }
        
        
      }
      stack.push(array[circularIdx]); //we store value, not idx
    }

    return res;
  }
}