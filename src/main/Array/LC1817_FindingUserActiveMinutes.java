package Array;

import java.util.HashMap;
import java.util.HashSet;

class FindingUserActiveMinutes {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        HashMap<Integer, HashSet<Integer>> userMap = new HashMap<>();

        for(int[] log : logs){
            int user = log[0];
            int activeMinute = log[1];

            userMap.putIfAbsent(user, new HashSet<>());
            userMap.get(user).add(activeMinute);// remove duplicate active minutes
        }

        int[] res = new int[k];

        for(int user : userMap.keySet()){
            int uam = userMap.get(user).size();
            res[uam - 1]++;
        }

        return res;
    }
}
