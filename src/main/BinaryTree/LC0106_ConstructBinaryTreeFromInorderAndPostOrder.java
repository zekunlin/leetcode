package BinaryTree;

import java.util.HashMap;

import Common.TreeNode;

public class LC0106_ConstructBinaryTreeFromInorderAndPostOrder {
    HashMap<Integer, Integer> valIdxMap;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        valIdxMap = new HashMap<>();

        for(int i = 0; i < inorder.length; i++){
            valIdxMap.put(inorder[i], i);
        }

        TreeNode tree = construct(inorder, postorder, 0, postorder.length - 1, postorder.length - 1);
        return tree;
    }

    public TreeNode construct(int[] inorder, int[] postorder, int leftIdx, int rightIdx, int rootIdx){
        if(rootIdx < 0 || leftIdx > rightIdx) return null;

        int treeRootVal = postorder[rootIdx];
        int rootIdxInorder = valIdxMap.get(treeRootVal);
        
        TreeNode node = new TreeNode(treeRootVal);
        
        // NOTE: really need to pay attention to pass a correct idx for left tree
        // it's not rootIdx - 1, it's rootIdx - rightSize - 1;
        // inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
        // have to skip the 15, 7, 20 in the post order array
        int rightSize = rightIdx - rootIdxInorder; 
        
        node.left = construct(inorder, postorder, leftIdx, rootIdxInorder - 1, rootIdx -rightSize - 1);
        node.right = construct(inorder, postorder, rootIdxInorder + 1, rightIdx, rootIdx - 1);

        return node;
    }
}
