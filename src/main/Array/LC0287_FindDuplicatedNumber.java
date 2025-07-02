package Array;

public class LC0287_FindDuplicatedNumber {
    //sol1: array as hashmap
    // Time: O(n), space:O(1)
    //[1,3,4,2,2]
    //there would only be 1 duplicated in 1:n,
    // so each element will have its own place
    // except the duplicate one
    //idx 0 will be the duplicated one
    // put 1 at idx = 1, 3 at idx = 3, 4 at idx = 4
    public int findDuplicate(int[] nums) {
        if(nums.length == 0) return 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[0] == nums[nums[0]]) break;
            int tmp = nums[nums[0]];
            nums[nums[0]] = nums[0];
            nums[0] = tmp;
        }
        return nums[0];
    }

    //sol2: fast-slow pointer
    public int findDuplicate2(int[] nums) {
        int fast = nums[0];
        int slow = nums[0];

        do{
            fast = nums[nums[fast]];
            slow = nums[slow];
        }while(fast != slow);

        slow = nums[0];

        while(fast != slow){
            fast = nums[fast];
            slow = nums[slow];
        }

        return slow;
    }
}
