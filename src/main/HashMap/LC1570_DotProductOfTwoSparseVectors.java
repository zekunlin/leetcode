package HashMap;

import java.util.HashMap;

class SparseVector {
    //Time: O(n) for creating map, O(L) for calculating product
    HashMap<Integer, Integer> vectorMap;
    SparseVector(int[] nums) {
        vectorMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                vectorMap.put(i, nums[i]);
            }
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int res = 0;
        HashMap<Integer, Integer> inputMap = vec.vectorMap;
        for(Integer key : inputMap.keySet()){
            if(this.vectorMap.containsKey(key)){
                res += this.vectorMap.get(key) * inputMap.get(key);
            }
        }

        return res;
    }
}
