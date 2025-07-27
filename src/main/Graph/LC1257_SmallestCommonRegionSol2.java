package Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class LC1257_SmallestCommonRegionSol2 {
    //sol2: build map child-parent,
    //then build path from bottom-up
    //then start from the root traverse both paths,
    // when paths diverge, we found the LCA for the two regions
    //Time Complexity: O(m∗n)
    //Space Complexity: O(m∗n)
    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        HashMap<String, String> childrenParentMap = new HashMap<>();
        //1.build graph
        for(List<String> region : regions){
            if(region.size() == 0) continue;
            String curRoot = region.get(0);

            for(int i = 1; i < region.size(); i++){
                String child = region.get(i);
                childrenParentMap.put(child, curRoot);
            }
        }

        List<String> path1 = getPath(region1, childrenParentMap);
        List<String> path2 = getPath(region2, childrenParentMap);

        int j = 0;
        String smallestRegion = "";
        while(j < path1.size() && j < path2.size() && path1.get(j).equals(path2.get(j))){
            smallestRegion = path1.get(j);
            j++;
        }

        return smallestRegion;
    }

    private List<String> getPath(String region, HashMap<String, String> childrenParentMap){
        List<String> path = new ArrayList<>();
        path.add(region);

        while(childrenParentMap.containsKey(region)){
            String parent = childrenParentMap.get(region);
            path.add(parent);
            region = parent;
        }

        Collections.reverse(path);
        return path;
    }
}
