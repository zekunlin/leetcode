package BinarySearchTree;
import java.util.*;
import Common.TreeNode;

public class BSTTraversalIterativeStack {

    public List<Integer> inOrderTraverse(TreeNode root, List<Integer> array)
    {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curNode = root;

        while(curNode != null || !stack.isEmpty()){
            while(curNode != null){
                stack.push(curNode);

                curNode = curNode.left;
            }

            curNode = stack.pop();
            array.add(curNode.val);
            curNode = curNode.right;
        }

        return array;
    }

    public List<Integer> preOrderTraverse(TreeNode root, List<Integer> array)
    {
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        while(!stack.isEmpty())
        {
            TreeNode curNode = stack.pop();
            if(curNode != null)
            {
                array.add(curNode.val);
                stack.push(curNode.right);
                stack.push(curNode.left);
            }
        }

        return array;
    }

    public List<Integer> postOrderTraverse(TreeNode root, List<Integer> array)
    {
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> output = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode curNode = stack.pop();

            if(curNode != null){
                output.push(curNode);
                stack.push(curNode.left);
                stack.push(curNode.right);
            }
        }

        while(!output.isEmpty()){
            array.add(output.pop().val);
        }

        return array;
    }
}
