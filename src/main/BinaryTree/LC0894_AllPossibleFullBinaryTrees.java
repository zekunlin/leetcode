package BinaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import Common.TreeNode;

public class LC0894_AllPossibleFullBinaryTrees {
    Map<Integer, List<TreeNode>> memo;
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> res = new ArrayList<>();
        if(memo.containsKey(n)) return memo.get(n);
        if (n == 1) {
            return Arrays.asList(new TreeNode());
        }
        for(int i = 1; i < n; i++){
            List<TreeNode> leftNodes = allPossibleFBT(i);
            List<TreeNode> rightNodes = allPossibleFBT(n - i - 1);

            for(TreeNode leftNode : leftNodes){
                for(TreeNode rightNode : rightNodes){
                    TreeNode root = new TreeNode(0, leftNode, rightNode);
                    res.add(root);
                }
            }
        }
        memo.put(n, res);
        return res;
    }
}
