package BinarySearchTree;
import Common.TreeNode;
// Time: O(nLogn), Space: O(N)
class ReconstructBST {
    public TreeNode bstFromPreorder(int[] preorder) {
        int len = preorder.length;
        return buildBST(0, len, preorder);
    }

    public TreeNode buildBST(int lowerBound, int upperBound, int[] preorder)
    {
        if(lowerBound >= upperBound) return null;

        int curRootVal = preorder[lowerBound];
        
        int rightSubtreeIdx = upperBound;

        for(int i = lowerBound + 1; i < upperBound; i++)
        {
            if(preorder[i] > curRootVal){
                rightSubtreeIdx = i;
                break;
            }
        }

        TreeNode curRoot = new TreeNode(curRootVal);
        curRoot.left = buildBST(lowerBound + 1, rightSubtreeIdx, preorder);
        curRoot.right = buildBST(rightSubtreeIdx, upperBound, preorder);

        return curRoot;
    }
}