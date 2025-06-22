package BinaryTree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import Common.TreeNode;

public class LC0297_SerializeNDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return serializeHelper(root, "");
    }
    

    public String serializeHelper (TreeNode root, String str){
        if(root == null){
            str += "null,";
        }
        else{
            str += String.valueOf(root.val) + ",";
            str = serializeHelper(root.left, str);
            str = serializeHelper(root.right, str);
        }

        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;
       String[] strArray = data.split(",");
       List<String> strList = new LinkedList<String>(Arrays.asList(strArray));

       return deserializeHelper(strList);
    }

    public TreeNode deserializeHelper(List<String> strList){
        if(strList.size() == 0) return null;

        if(strList.get(0).equals("null")){
            strList.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(strList.get(0)));

        strList.remove(0);

        root.left = deserializeHelper(strList);
        root.right = deserializeHelper(strList);

        return root;
    }
}
