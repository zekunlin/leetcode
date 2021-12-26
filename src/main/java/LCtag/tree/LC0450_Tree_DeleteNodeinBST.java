package LCtag.tree;
import LCtag.TreeNode;
public class LC0450_Tree_DeleteNodeinBST {
    public TreeNode deleteNode(TreeNode root, int key){
        if(root == null) return null;

        if(root.val < key){//go right and delete in right subtree
            root.right = deleteNode(root.right, key);
        }else if(root.val > key){//go left and delete in right subtree
            root.left = deleteNode(root.left, key);
        }else{
            if(root.left == null && root.right == null) root = null; // the node to be deleted is leave node

            else if(root.right != null){
                root.val = successor(root);
                root.right = deleteNode(root.right, root.val);
            }else{
                root.val = predecessor(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }
    /*
    one step right then always left
     */
    private int successor(TreeNode root){
        root = root.right;
        while(root.left != null){
            root = root.left;
        }
        return root.val;
    }
    /*
    one step left then always right;
     */
    private int predecessor(TreeNode root){
        root = root.left;
        while(root.right != null){
            root = root.right;
        }
        return root.val;
    }
}
