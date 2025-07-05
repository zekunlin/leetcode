# Binary Search, but when?

"Monotonicity" is they key, If we can discover some kind of Monotonicity, for example, if condition(k) is True then condition(k + 1) is True, then we can consider binary search.

## different template for binary search

target: return lower boundary of a target, the poistion where the first item >= target.

### close left and close right: [l, r]

```java
        int left = 0, right = n-1;
        while(left <= right){
            int mid = left + (right - left)/ 2;
            if(nums[mid] < target){
                left = mid + 1 //[mid + 1, right]
            }
            else{
                right = mid - 1;
            }
        }
        return left;
```

### close left and open right : [l, r)

this method, the right idx is not considered to be a potential answer

```java
        int left = 0, right = n;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < target){
                left = mid + 1; //[mid + 1, right)
            }
            else{ // nums[mid] >= target, 
                right = mid; //because [left, mid), so [l, r), right = mid
            }
        }
        return left;

```

### open left, open right (l, r)

```java
        int left = -1, right = n;
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < target){
                left = mid;
            }
            else{
                right = mid;
            }
        }
        return right;
```

## what if we don't want the first greater or equal than target

the previous requirement is: find the first element >= target,

1. '>='
2. '>' first item greater than target x: it's equivalent to find the first item >= x + 1 (target + 1)
3. '<' first item smaller than target x: equivalent to find the first element k that >= x, then the left of k is the answer
4. '<=' first item smaller or equal than target x: equivalent to find the first element k that > x, means the target is x + 1, then the left of k is the answer (if using second template return left - 1);

can also refer to this post:
<https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/solutions/769703/Python-Clear-explanation-Powerful-Ultimate-Binary-Search-Template.-Solved-many-problems>
