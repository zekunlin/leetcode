package Recursion;
import java.util.*;

// sol: with momoize, Time: O(n * k) | O(n) space
// n - height of the stairecase and k  - num of allowed steps
class StairCases {
    public int staircaseTraversal(int height, int maxSteps) {
    // Write your code here.
    Map<Integer, Integer> memo = new HashMap<>();

    return backtrack(height, maxSteps, 0, memo);
    
  }

  private int backtrack(int height, int maxSteps, int step, Map<Integer, Integer> memo){
    if(step == height){
      return 1;
    } 
    if(step > height) return 0;
    
    int totalWay = 0;
    for(int i = 1; i <= maxSteps; i++){
      
      totalWay += backtrack(height, maxSteps, step + i, memo);
    }

    memo.put(step, totalWay);
    return totalWay;
  }
}
