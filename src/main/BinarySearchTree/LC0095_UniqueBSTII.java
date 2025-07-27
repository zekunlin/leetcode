package BinarySearchTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Common.Pair;
import Common.TreeNode;

public class LC0095_UniqueBSTII {
    public List<TreeNode> generateTrees(int n) {
        HashMap<Pair<Integer, Integer>, List<TreeNode>> memo = new HashMap<>();
        List<TreeNode> ans = dfsHelper(1, n, memo);
        return ans;
    }

    private List<TreeNode> dfsHelper(int left, int right, HashMap<Pair<Integer, Integer>, List<TreeNode>> memo){
        ArrayList<TreeNode> result = new ArrayList<>();
        if(left > right){
            result.add(null);
            return result;
        }
        Pair<Integer, Integer> curRange = new Pair<Integer, Integer>(left, right);
        if(memo.containsKey(curRange)) return memo.get(curRange);

        for(int i = left; i <= right; i++){
            List<TreeNode> leftSubTree = dfsHelper(left, i -1, memo);
            List<TreeNode> rightSubTree = dfsHelper(i + 1, right, memo);
            
            for(TreeNode leftNode : leftSubTree){
                for(TreeNode rightNode : rightSubTree){
                    TreeNode root = new TreeNode(i, leftNode, rightNode);
                    result.add(root);
                }
            }
        }

        memo.put(curRange, result);
        return result;
    }
}
