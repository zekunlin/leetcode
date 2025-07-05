package BinarySearch;

import java.util.ArrayList;
import java.util.List;

public class LC0658_FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        
        if(k >= arr.length){
            for(int i : arr){
                res.add(i);
            }
            return res;
        }

        //binary search to find element in array that closest to x
        // mid is the idx of ^
        int mid;
        int leftIdx = 0;
        int rightIdx = arr.length - 1;
        while(leftIdx < rightIdx){
            mid = leftIdx + (rightIdx - leftIdx) / 2;
            if(arr[mid] >= x){
                rightIdx = mid;
            }else{
                leftIdx = mid + 1;
            }
        }

        leftIdx -= 1;
        while(rightIdx - leftIdx - 1 < k){
            if(leftIdx == -1){
                rightIdx += 1;
                continue;
            }

            if(rightIdx == arr.length || Math.abs(arr[leftIdx] - x) <= Math.abs(arr[rightIdx] - x)){
                leftIdx -= 1;
            }
            else{
                rightIdx += 1;
            }
        }

        for(int i = leftIdx + 1; i < rightIdx; i++){
            res.add(arr[i]);
        }

        return res;
    }
}
