# What can you bring up to solve Array problems?

## Two pointers/sliding window

### two pointers same direction, loop through combinations of i,j

Brutal forces solution usually use two pointers, like "Two Sum", "Maximum Subarray", loop through pointer1 and pointer2 can generate combinations of two integers at p1 or p2, or a **range/window** between [p1, p2]. Double for-loop is used:
    for(int i = 0; i < len; i++){
        for(int j = 0 / j = i/ j = i + 1; j < len; j++){
            do something.
            if(array[i] = target - array[j]) return true;
        }
    }

And Time Complexity hence is O(N^2) minimum, also depends on the operations within the for-loop;

### two pointers different directions

1. 2 pointers moving toward the middle, like:
    binary search in sorted array;
    twoSum sorted(small than target move left, greater than target move right);
    check Palindrome from two side toward middle, e.g. Palindrome Number(two pointers check while moving toward middle), Valid Palindrome;

2. 2 pointers moving away from the middle, like:
    isPalindrome:
        private int[] isPalindrome(String s, int leftInd, int rightInd)
        {
            while(leftInd >= 0 && rightInd < len)
            {
                if (s.charAt(leftInd) != s.charAt(rightInd)) break;
                leftInd--;
                rightInd++;
            }

            return new int[]{leftInd + 1, rightInd};
        }
    