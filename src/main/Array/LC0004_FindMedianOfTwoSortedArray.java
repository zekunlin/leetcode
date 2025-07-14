package Array;

public class LC0004_FindMedianOfTwoSortedArray {
    //sol1: Time: O(m + n), space: O(1)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLen = nums1.length + nums2.length;
        int p1 = 0, p2 = 0;
        int prev = 0, curr = 0;

        for (int i = 0; i <= totalLen / 2; i++) {
            prev = curr;
            if (p1 < nums1.length && (p2 >= nums2.length || nums1[p1] < nums2[p2])) {
                curr = nums1[p1++];
            } else {
                curr = nums2[p2++];
            }
        }

        if (totalLen % 2 == 0) {
            return (prev + curr) / 2.0;
        } else {
            return curr;
        }
    }

    
}
