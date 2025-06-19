package Recursion;
import java.util.*;

class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<>();

        backtrack(n, k, ret, new ArrayList<>());
        return ret;
    }

    public void backtrack(int n, int k, List<List<Integer>> ret, List<Integer> trackPath){
        if(trackPath.size() == k){
            ret.add(new ArrayList<>(trackPath));
            return;
        }

        for(int i = n; i > 0; i--){
            trackPath.add(i);
            backtrack(i - 1, k, ret, trackPath);
            trackPath.remove(trackPath.size() - 1);
        }
    }
}
