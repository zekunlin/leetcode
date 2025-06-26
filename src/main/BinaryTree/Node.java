package BinaryTree;

class Node {
   public int val;
   public Node left;
   public Node right;
   public Node next;

   public Node() {
   }

   public Node(int var1) {
      this.val = var1;
   }

   public Node(int var1, Node var2, Node var3, Node var4) {
      this.val = var1;
      this.left = var2;
      this.right = var3;
      this.next = var4;
   }
}
