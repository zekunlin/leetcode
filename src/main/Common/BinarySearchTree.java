package Common;

public class BinarySearchTree {
    public int value;
    public BinarySearchTree left;
    public BinarySearchTree right;

    public BinarySearchTree(){}
    
    public BinarySearchTree(int value){
        this. value = value;
    }

    public BinarySearchTree(int value, BinarySearchTree left, BinarySearchTree right){
        this. value = value;
        this.left = left;
        this.right = right;
    }
}
