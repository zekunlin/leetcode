package Search;

public class LC0034_FindFirstLastPositionInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        res[0] = binarySearch(nums, target, true);
        res[1] = binarySearch(nums, target, false);
        return res;
    }

    private int binarySearch(int[] nums, int target, boolean mostLeft){
        int left = 0;
        int right = nums.length - 1;
        int idx = -1;
        //[5,7,7,8,8,10]
           
        while(left <= right){
            int mid = left + (right - left) /2;
            if(nums[mid] > target){
                right = mid - 1;
            }
            else if(nums[mid] < target){
                left = mid + 1;
            }
            else{
                idx = mid;
                if(mostLeft){
                    right = mid - 1;
                }
                else{
                    left = mid + 1;
                }
            }
        }

        return idx;
    }
}
