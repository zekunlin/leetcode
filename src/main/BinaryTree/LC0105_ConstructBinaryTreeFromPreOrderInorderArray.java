package BinaryTree;
import Common.TreeNode;
import java.util.*;


class ConstructBinaryTree {
    HashMap<Integer, Integer> valIdxMap;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        valIdxMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            valIdxMap.put(inorder[i], i);
        }
        
        TreeNode root = construct(preorder, inorder, 0, inorder.length - 1, 0);
        return root;
    }
    
    public TreeNode construct(int[] preorder, int[] inorder, int leftIdx, int rightIdx, int rootIdx){
        if(rootIdx >= inorder.length || leftIdx > rightIdx) return null;
        
        int rootVal = preorder[rootIdx];
        int rootIdxInorder = valIdxMap.get(rootVal);
        int leftSize = rootIdxInorder - leftIdx;
        
        TreeNode node = new TreeNode(rootVal);
        
        node.left = construct(preorder, inorder, leftIdx, rootIdxInorder - 1, rootIdx + 1);
        node.right = construct(preorder, inorder, rootIdxInorder + 1, rightIdx, rootIdx + leftSize + 1);
        return node;
    }
}