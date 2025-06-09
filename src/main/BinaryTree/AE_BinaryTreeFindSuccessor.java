package BinaryTree;


import java.util.*;
//sol1: Time: O(N) | Space : O(N)
class Program {
  // This is an input class. Do not edit.
  static class BinaryTree {
    public int value;
    public BinaryTree left = null;
    public BinaryTree right = null;
    public BinaryTree parent = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }

  public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
    // Write your code here.
    ArrayList<BinaryTree> res = new ArrayList<>();

    dfs(tree, res);

    for(int i =0; i < res.size(); i++){
      if(res.get(i).value != node.value) continue;

      if(i == res.size() - 1) return null;

      return res.get(i );
    }

    return null;
  }

  private static void dfs(BinaryTree tree, ArrayList<BinaryTree> res){
    if(tree == null) return;

    dfs(tree.left, res);
    res.add(tree);
    dfs(tree.right, res);
  }
}


//sol2: Time: O(h) | Space: O(1): 
/*
1. For looking for a node's in-order successor, if it has right child node, we only look for the left most child node of its right child sub tree.
2. if it doesn't have right child node, based on the fact of: 
inorder traversal, the successor of a node with no right node will only be it right-most parent node
bc if the target node X is the right child of a parent node A, that means we already pass the parent node A when we traverse, hence parent Node A can't be it's successor
node X's successor can only be: node X's parent B but only when X is the from the left subtree, which means we haven't visit the parent node B.

so that means we are looking for the right most parent:

import java.util.*;

class Program {
  // This is an input class. Do not edit.
  static class BinaryTree {
    public int value;
    public BinaryTree left = null;
    public BinaryTree right = null;
    public BinaryTree parent = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }

  public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
    // Write your code here.
    if(node.right != null) return findLeftMostChild(node.right);

    return findRightMostParent(node);
  }

  private BinaryTree findLeftMostChild(BinaryTree node){
    BinaryTree curNode = node;
    while(curNode.left != null){
      curNode = curNode.left;
    }

    return curNode;
  }

  private BinaryTree findRightMostParent(BinaryTree node){
    BinaryTree curNode = node;
    while(curNode.parent != null && curNode.parent.right == curNode){
      curNode = curNode.parent;
    }
    return curNode.parent;
  }
}
  */
