package LCtag;

public class LC1152_AnalyzeWebPattern {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        //cc
        List<String> res = new ArrayList<>();

        int n = username.length;
        List<Pair> pairList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            pairList.add(new Pair(username[i],timestamp[i], website[i]));
        }

        //sort cellList
        Collections.sort(pairList, (o1, o2) -> (o1.time - o2.time));

        //HashMap1 : user - weblist
        Map<String, List<String>> webList = new HashMap<>();
        for(Pair p : pairList){
            String user = p.user;
            webList.putIfAbsent(user, new ArrayList<>());
            webList.get(user).add(p.web);
        }

        //HashMap2 : webpattern - freq
        Map<String, Integer> freqMap = new HashMap<>();
        for(List<String> list : webList.values()){
            HashSet<String> set = findWebPattern(list);
            for(String s : set){
                freqMap.put(s, freqMap.getOrDefault(s, 0) + 1);
            }
        }

        //
        int maxFreq = 0;
        String ans = "";
        for(String key : freqMap.keySet()){
            if(freqMap.get(key) >= maxFreq){
                if(freqMap.get(key) > maxFreq){
                    maxFreq = freqMap.get(key);
                    ans = key;
                }else{
                    if(key.compareTo(ans) < 0) ans = key;
                }
            }
        }

        String[] str = ans.split("#");
        for(String s : str) res.add(s);
        return res;
    }

    private HashSet<String> findWebPattern(List<String> webList){
        HashSet<String> set = new HashSet<>();
        int len = webList.size();
        for(int i = 0; i < len - 2; i++){
            for(int j = i + 1; j < len - 1; j++){
                for(int k = j + 1; k < len; k++){
                    String a = webList.get(i);
                    String b = webList.get(j);
                    String c = webList.get(k);
                    String key = a + "#" + b + "#" + c;
                    set.add(key);
                }
            }
        }
        return set;
    }
}
private class Pair{
    private String user, web;
    private int time;
    public Pair(String user, int time, String web){
        this.user = user;
        this.time = time;
        this.web = web;
    }
}

