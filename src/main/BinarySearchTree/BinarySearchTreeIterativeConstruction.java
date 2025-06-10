package BinarySearchTree;
import Common.BinarySearchTree;
import java.util.*;

public class BinarySearchTreeIterativeConstruction {
    public BinarySearchTree root;

    public BinarySearchTree Insert(int target, BinarySearchTree root){
        BinarySearchTree cur = root;
        
        while(true)
        {
            if(target < cur.value)
            {
                if(cur.left != null){
                    cur = cur.left;
                }
                else
                {
                    cur.left = new BinarySearchTree(target);
                    break;
                }
            }
            else
            {
                if(cur.right != null)
                {
                    cur = cur.right;
                }
                else
                {
                    cur.right = new BinarySearchTree(target);
                    break;
                }
            }
        }

        return root;
    }

    public boolean Contain(int target, BinarySearchTree root){
        BinarySearchTree cur = root;
        
        while(cur != null)
        {
            if(cur.value > target)
            {
                cur = cur.left;
            }
            else if(cur.value < target)
            {
                cur = cur.right;
            }
            else
            {
                return true;
            }
        }
        return false;
    }

    public BinarySearchTree Remove(int target, BinarySearchTree root){
        this.Remove(target, root, null);
        return root;
    }

    private void Remove(int target, BinarySearchTree root, BinarySearchTree parent)
    {
        BinarySearchTree cur = root;

        while(cur != null)
        {
            if(cur.value > target)
            {
                parent = cur;
                cur = cur.left;
            }
            else if(cur.value < target)
            {
                parent = cur;
                cur = cur.right;
            }
            else
            {
                if(cur.left != null & cur.right != null)
                {
                    cur.value = getMinVal(cur.right);
                    this.Remove(cur.value, cur);
                }
                else if(parent == null)
                {
                    if(cur.left != null)
                    {
                        cur.value = cur.left.value;
                        cur.right = cur.left.right;
                        cur.left = cur.left.left;
                    }
                    else if(cur.right != null)
                    {
                        cur.value = cur.right.value;
                        cur.left = cur.right.left;
                        cur.right = cur.right.right;
                    }
                }
                else if(cur == parent.left)
                {
                    parent.left = cur.left != null ? cur.left : cur.right; 
                }
                else if(cur == parent.right)
                {
                    parent.right = cur.left != null ? cur.left : cur.right;
                }
                break;
            }
        }
    }

    private int getMinVal(BinarySearchTree node){
        if(node.left == null)
        {
            return node.value;
        }
        else
        {
            return getMinVal(node.left);
        }
    }
}
