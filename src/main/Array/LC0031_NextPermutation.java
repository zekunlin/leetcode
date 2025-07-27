package Array;

class NextPermutation{
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int breakPoint = -1;

        for(int i = len - 2; i >= 0; i--){
            if(nums[i] < nums[i + 1]){
                //found the point where, after this idx, array is descending
                //
                breakPoint = i;
                break;
            }
        }

        //the entire array is sorted in descending way, 
        //and current sort is max, so return reversed array
        if(breakPoint == -1){
            reverse(nums, 0, len - 1);
            return;
        }

        //reverse the part after break point, as it was descending
        //  
        for(int j = len - 1; j >= 0; j--){
            if(nums[j] > nums[breakPoint]){
                swap(nums, breakPoint, j);
                break;
            }
        }

        reverse(nums, breakPoint + 1, len - 1);
    }

    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void reverse(int[] nums, int start, int end){
        while(start <= end){
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}