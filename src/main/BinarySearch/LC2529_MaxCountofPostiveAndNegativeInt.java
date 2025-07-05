package BinarySearch;

public class LC2529_MaxCountofPostiveAndNegativeInt {
    public int maximumCount(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = len; //[left, right)

        //binary search
        //find first zero (first element >= 0)
        while(left < right){ 
            int mid = left + (right - left)/2;
            if(nums[mid] < 0)
            {
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }

        int numNegative = left;// left is the first 0, so the num of negative is left - 1 + 1 just left

        //find the last zero, first element > 0
        // same as first element >= 1
        // use the same template
        left = 0;
        right = len;
        while(left < right){
            int mid = left+(right - left)/2;
            if(nums[mid] < 1){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        int numPositive = len - left; //out of loop, left is the idx of first element >= 1


        return Math.max(numNegative, numPositive);
    }
}
