package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC1257_SmallestCommonRegion {
    //sol1: build tree-like graph, search two nodes top-down
    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        if(regions.size() == 0) return "";
        //1. build graph
        HashMap<String, Node> nodeMap = new HashMap<>();
        Set<String> childrenSet = new HashSet<>();

        for(int i = 0; i < regions.size(); i++){
            List<String> cur = regions.get(i);
            if(cur.size() == 0) continue;
            
            String curRoot = cur.get(0);
            nodeMap.getOrDefault(curRoot, new Node(curRoot));
            nodeMap.putIfAbsent(curRoot, new Node(curRoot));
            Node root = nodeMap.get(curRoot);

            for(int j = 1; j < cur.size(); j++){
                String child = cur.get(j);
                childrenSet.add(child);

                nodeMap.putIfAbsent(child, new Node(child));
                
                root.child.add(nodeMap.get(child));
            }
        }

        String rootName = "";
        for(String key : nodeMap.keySet()){
            if(!childrenSet.contains(key)){
                rootName = key;
                break;
            }
        }
        
        Node ans = dfsHelper(nodeMap.get(rootName), region1, region2);
        return ans == null ? "" : ans.val;
    }

    private Node dfsHelper(Node root, String region1, String region2){
        if(root == null) return null;

        if(root.val.equals(region1) || root.val.equals(region2)){
            return root;
        }

        int counter = 0;//count how many target region found
        Node parent = null;

        for(Node child : root.child){
            Node node = dfsHelper(child, region1, region2);
            if(node != null){
                counter++;
                if(parent == null){
                    parent = node;
                }
            }
        }

        if(counter == 2) return root;
        return parent;
    }

    private class Node{
        String val;
        List<Node> child;
        public Node(String val){
            this.val = val;
            this.child = new ArrayList<>();
        }
    }
}

