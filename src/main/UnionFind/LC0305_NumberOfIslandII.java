package UnionFind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC0305_NumberOfIslandII {

    //union find
    // Time: for union and find , the complexity is Alpha(T), it can be considered as O(1) for small computation
    //building unionFind matrix = O(M *n), do k position union and find. so it's k*(m*n)
    // Space: O(m*n);
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        unionFind uf = new unionFind(m, n);
        List<Integer> res = new ArrayList<>();
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for(int[]pos : positions){
            int posIdx = pos[0] * n + pos[1];
            uf.addIsland(posIdx);

            for(int[] dir: dirs){
                int x = pos[0] + dir[0];
                int y = pos[1] + dir[1];

                if(x <0 || x >= m || y < 0 || y >= n) continue;

                int idx = x * n + y;
                if(uf.isIsland(idx) && !uf.findParent(posIdx, idx)){
                    uf.union(idx, posIdx);
                }
            }

            res.add(uf.numOfIsland);
        }

        return res;
    }

    class unionFind{
        int m;
        int n;
        int numOfIsland;
        int[] parent;
        int[] islandSize;

        public unionFind(int m, int n){
            this.m = m;
            this.n = n;
            numOfIsland = 0;
            parent = new int[m * n];
            islandSize = new int[m * n];

            Arrays.fill(parent, -1);
        }

        public int getRoot(int vert){
            int cur = vert;
            while(parent[cur] != cur){
                parent[cur] = parent[parent[cur]];
                cur = parent[cur];
            }
            parent[vert] = cur;
            return cur;
        }

        public boolean findParent(int node1, int node2){
            int parent1 = getRoot(node1);
            int parent2 = getRoot(node2);
            
            return parent1 == parent2;
        }

        public void union(int node1, int node2){
            int parent1 = getRoot(node1);
            int parent2 = getRoot(node2);

            if(islandSize[parent1] > islandSize[parent2]){
                //merge small island to large island
                parent[parent2] = parent[parent1];
                islandSize[parent1] += islandSize[parent2];
            }
            else{
                parent[parent1] = parent[parent2];
                islandSize[parent2] += islandSize[parent1];
            }

            numOfIsland--;
        }

        public void addIsland(int node){
            if(parent[node] == -1){
                parent[node] = node;
                islandSize[node] = 1;
                this.numOfIsland += 1;
            }
        }

        public boolean isIsland(int node){
            return parent[node] >= 0;
        }

        public int getIslandNum(){
            return numOfIsland;
        }
    }
}
