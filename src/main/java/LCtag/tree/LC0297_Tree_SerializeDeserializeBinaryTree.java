package LCtag.tree;
import java.util.*;
import LCtag.TreeNode;

public class LC0297_Tree_SerializeDeserializeBinaryTree {
    //serialize：用preorder遍历tree，碰到leaf node下面挂null就加null
    //deserialize：同样用preorder构造tree，
    // 用linkedlist为了O(1)删除string 的第一个，每次构造碰到null就return null，
    //否则就先go left 然后go right；

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serial_helper(root, sb);
        System.out.println(sb.toString());
        return sb.toString();
    }
    private void serial_helper(TreeNode root, StringBuilder sb){
        //cc
        if(root == null){
            sb.append("null,");
            return;
        }
        sb.append(root.val).append(",");
        serial_helper(root.left, sb);
        serial_helper(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //cc
        if(data == null || data.length() == 0) return null;
        String[] str = data.split(",");
        List<String> strList = new LinkedList<String>(Arrays.asList(str));
        TreeNode root = buildTree(strList);
        return root;
    }
    private TreeNode buildTree(List<String> strList){
        if(strList.get(0).equals("null")){
            strList.remove(0);
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(strList.get(0)));
        strList.remove(0);
        node.left = buildTree(strList);
        node.right = buildTree(strList);
        return node;
    }
}
