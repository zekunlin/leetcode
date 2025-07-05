package TwoPointers;

public class LC0011_ContainerWithMostWater {
    //two pointers,who small moves who. Time:O(N), Space: O(1)
    public int maxArea(int[] height) {
        int len = height.length;
        int left = 0;
        int right = len - 1;
        int maxContained = 0;

        while(left <= right){
            int curArea = (right - left) * Math.min(height[right], height[left]);
            maxContained = Math.max(maxContained, curArea);
            if(height[left] < height[right]){
                left++;
            }
            else{
                right--;
            }
        }

        return maxContained;
    }
}
