package BinarySearchTree;
import Common.TreeNode;
import java.util.*;


class Solution {
    int rootIdx;
    HashMap<Integer, Integer> idxMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        rootIdx = 0;
        idxMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            idxMap.put(inorder[i], i);
        }

        return buildTree(preorder, 0, preorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int left, int right){
        if(left > right) return null;

        int rootVal = preorder[rootIdx++];
        TreeNode curNode = new TreeNode(rootVal);
        curNode.left = buildTree(preorder, left, idxMap.get(rootVal) - 1);
        curNode.right = buildTree(preorder, idxMap.get(rootVal) + 1, right);
        return curNode;
    }
}