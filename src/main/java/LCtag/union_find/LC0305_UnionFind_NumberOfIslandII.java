package LCtag.union_find;

import java.util.ArrayList;
import java.util.List;

public class LC0305_UnionFind_NumberOfIslandII {
    private static final int[][] DIRECTIONS = {{1,0},{0,1},{0,-1},{-1,0}};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        //union find klogk.. k * m * n
        List<Integer> res = new ArrayList<>();
        UnionFind uf = new UnionFind(m, n);
        for(int[] pos: positions){
            int i = pos[0], j = pos[1];
            int p = i * n + j;
            uf.addIsland(p);
            for(int[] dir: DIRECTIONS){
                int ii = i + dir[0], jj = j + dir[1];
                if(ii < 0 || ii >= m || jj < 0 || jj >= n ) continue;
                int q = ii * n +jj;
                if(uf.isIsland(q) && (!uf.find(p,q))){
                    uf.union(p,q);
                }
            }
            res.add(uf.numOfIsland());
        }
        return res;
    }

    class UnionFind{
        private int[] parent;
        private int[] size;
        private int numOfIsland;
        public UnionFind(int m, int n){
            this.parent = new int[m * n];
            this.size = new int[m * n];
            this.numOfIsland = 0;
            for(int i = 0; i < m * n; i++){
                parent[i] = -1;
            }
        }
        private int getRoot(int p){
            int cur = p;
            while(parent[cur] != cur){
                parent[cur] = parent[parent[cur]];
                cur = parent[cur];
            }
            parent[p] = cur;
            return cur;
        }
        public boolean find(int p, int q){
            int rootP = getRoot(p);
            int rootQ = getRoot(q);
            return rootP == rootQ;
        }
        public void union(int p, int q){
            int rootP = getRoot(p), rootQ = getRoot(q);
            if(this.size[rootP] < this.size[rootQ]){//p->q
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            } else {//q -> p
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            }//
            this.numOfIsland--;
        }
        public void addIsland(int p){
            if(parent[p] == -1){//必须是没有赋过值的位置才可以+ island
                parent[p] = p;
                size[p] = 1;
                this.numOfIsland++;
            }
        }
        public boolean isIsland(int p){
            return parent[p] >= 0;
        }
        public int numOfIsland(){
            return this.numOfIsland;
        }
    }
}
