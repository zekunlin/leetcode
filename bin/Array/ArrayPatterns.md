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

**HOWEVER** 2 pointers same directions usually can be optimized by combining with extra data structures, this can improve time complexity to O(N) or several passes, instead of O(N^2) like:

- using HashMap in two sum, hashmap stores <val, idx>
- using HashSet in Longest Substring without repeat chars, use hashset to check duplicates while right pointers extending the window, if duplicated, shrink left window


### two pointers different directions

1. Two pointers moving toward the middle, like:
    - binary search in sorted array;
    - twoSum sorted(small than target move left, greater than target move right);
    - check Palindrome from two side toward middle, e.g. Palindrome Number(two pointers check while moving toward middle), Valid Palindrome;

2. Two pointers moving away from the middle, like:
    - isPalindrome:

```java
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
```

## Divide and Conquer in Arrays (prob same in string)

Divide & Conquer often come with recursion, as it divide the problem on array to it smaller sections, normally divide to left & right by cutting in the middle, just like quick select/quick sort, partition, see LC0215_TopKElementinAnArray.

## recursion in Array

Recursion in array is often use to get all combinations of elements in the array, like subset, combination, permutation. And **BackTrack** is often required.