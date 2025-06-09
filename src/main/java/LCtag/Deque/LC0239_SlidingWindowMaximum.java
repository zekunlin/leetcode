package java.LCtag.Deque;

public class LC0239_SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        int idx = 0;//用来往res里加答案

        for(int i = 0; i < n; i++){
            //step 1: 维持单调递减deque，从队尾poll出deque里比新来的元素i小的所有元素
            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]){
                deque.pollLast();
            }

            //step 2: 把元素i加进去
            deque.offerLast(i);

            //step 3: 判断随着窗口滑动，队首是否要出去
            while(!deque.isEmpty() && i - k >= deque.peekFirst()){
                deque.pollFirst();
            }

            //step 4:往res里加答案；
            if(i - k + 1 >= 0) res[idx++] = nums[deque.peekFirst()];
        }

        return res;
    }
}
