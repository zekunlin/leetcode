package LCtag.tree;
import LCtag.Node;

import java.util.ArrayList;

public class LC0428_Tree_SerializeDesrializeNNaryTree {
}

class Codec {
    public String serialize(Node root) {
        if (root == null) return "";

        StringBuilder builder = new StringBuilder();
        dfsEnocde(root, builder);
        return builder.toString();
    }

    private void dfsEnocde(Node root, StringBuilder builder) {
        builder.append(root.val).append(" ");
        builder.append(root.children.size()).append(" ");
        for (int i = 0; i < root.children.size(); i++) {
            dfsEnocde(root.children.get(i), builder);
        }
    }

    int i;
    public Node deserialize(String data) {
        if (data == null || data.isEmpty()) return null;

        String[] arr = data.split(" ");
        i = 0;
        return decode(arr);
    }

    private Node decode(String[] arr) {
        if (i == arr.length) return null;

        Node root = new Node(Integer.valueOf(arr[i++]), new ArrayList<>());
        int size = Integer.valueOf(arr[i++]);
        for (int j = 0; j < size; j++) { // 如果size == 0，则跳过，直接返回root
            Node child = decode(arr);
            root.children.add(child);
        }
        return root;
    }
}
