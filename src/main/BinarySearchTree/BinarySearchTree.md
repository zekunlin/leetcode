## A Binary Search Tree (BST) is a binary tree data structure in which each node has at most two children, 
referred to as the left child and the right child. For every node:

- The value of all nodes in the left subtree is less than the value of the node. (stricly less than)
- The value of all nodes in the right subtree is greater than the value of the node. (stricly greater than)
- Both the left and right subtrees must also be binary search trees.

Node: the definition above means it doesn't allow duplicate values.
If want to allow duplicate values, we can say, the value of all nodes in the right subtree is greater or 
equal than the value of the node.

This property allows efficient searching, insertion, and deletion operations.

