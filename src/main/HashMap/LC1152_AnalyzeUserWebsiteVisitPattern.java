package HashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class LC1152_AnalyzeUserWebsiteVisitPattern {
    class Visit{
        String userName;
        String website;
        int timeStamp;

        public Visit(String user, String web, int time){
            this.userName = user;
            this.website = web;
            this.timeStamp = time;
        }
        public Visit(){}
    }
    
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        /*
        username
        timestamp
        website
        pattern: 3 websites 
        */

        List<Visit> visitList = new ArrayList<>();
        for(int i = 0; i < username.length; i++){
            Visit visit = new Visit(username[i], website[i], timestamp[i]);
            visitList.add(visit);
        }

        //give me sorted visit record based on timestamp
        Collections.sort(visitList, (v1, v2) -> (v1.timeStamp - v2.timeStamp));

        //find out web visit record for each user
        HashMap<String, List<String>> userVisitRecord = new HashMap<>();
        for(Visit visit : visitList){
            userVisitRecord.putIfAbsent(visit.userName, new ArrayList<>());
            userVisitRecord.get(visit.userName).add(visit.website);
        }

        //find out visit website pattern and count frequency
        HashMap<String, Integer> patternFreq = new HashMap<>();
        for(List<String> webList : userVisitRecord.values()){
            //use a hashset to remove dupliacte patterns from same user
            HashSet<String> userVisitedWeb = new HashSet<>();
            int size = webList.size();
            for(int i = 0; i < size - 2; i++){
                for(int j = i + 1; j < size - 1; j++){
                    for(int k = j + 1; k < size; k++){
                        String web1 = webList.get(i);
                        String web2 = webList.get(j);
                        String web3 = webList.get(k);
                        String pattern = web1 + "#" + web2 + "#" + web3;
                        if(!userVisitedWeb.contains(pattern)){
                            userVisitedWeb.add(pattern);
                            patternFreq.put(pattern, patternFreq.getOrDefault(pattern, 0) + 1);
                        }
                    }
                }
            }
        }

        //got pattern frequency, find out the most frequently visited pattern
        String bestPattern = null;
        int maxVisit = 0;
        for(Map.Entry<String, Integer> entry: patternFreq.entrySet()){
            String curPattern = entry.getKey();
            int curFreq = entry.getValue();
            
            if (curFreq > maxVisit || (curFreq == maxVisit && curPattern.compareTo(bestPattern) < 0)) {
                maxVisit = curFreq;
                bestPattern = curPattern;
            }

        }   

        String[] bestPatternArr = bestPattern.split("#");
        return Arrays.asList(bestPatternArr);
    }
}
