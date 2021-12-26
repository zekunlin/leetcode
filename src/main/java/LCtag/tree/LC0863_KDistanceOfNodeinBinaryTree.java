package LCtag.tree;

public class LC0863_KDistanceOfNodeinBinaryTree {
    List<Integer> res = new ArrayList<>();
    //Map<TreeNode, TreeNode> graph = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k){
        //cc
        if(root == null || target == null) return res;
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        buildGraph(root, null, map);

        //bfs
        Queue<TreeNode> q = new LinkedList<>();
        int minLen = 0;
        HashSet<TreeNode> visited = new HashSet<>();
        visited.add(target);
        q.offer(node);
        while(!q.isEmpty()) {
            if (minLen == k) break;
            int size = q.size();
            while(size-- > 0){
                TreeNode cur = q.poll();
                if(map.containsKey(cur) && visited.add(cur)){
                    q.offer(map.get(cur));
                }
                if(cur.left != null && visited.add(cur.left)) q.offer(cur.left);
                if(cur.right != null && visited.add(cur.right)) q.offer(cur.right);
            }
            minLen++;
        }

        while(!q.isEmpty()){
            res.add(q.poll().val);
        }
        return res;

    }
    private void buildGraph(TreeNode node, TreeNode node, HashMap<TreeNode, TreeNode> map){
        //basecase
        if(root == null) return;
        if(root.left != null){
            map.put(root.left, root);
            buildGraph(root.left, root, map);
        }
        if(root.right != null){
            map.put(root.right, root);
            buildGraph(root.right, root, map);
        }
    }

}
