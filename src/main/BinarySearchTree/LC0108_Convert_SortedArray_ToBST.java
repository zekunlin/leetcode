package BinarySearchTree;

import Common.TreeNode;

class ConvertSortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return preorderConstructBST(0, nums.length - 1, nums);
    }

    public TreeNode preorderConstructBST(int left, int right, int[] nums){
        if(left > right) return null;

        int p = (left + right) / 2;

        TreeNode root = new TreeNode(nums[p]);
        root.left = preorderConstructBST(left, p - 1, nums);
        root.right = preorderConstructBST(p + 1, right, nums);
        return root;
    }
}