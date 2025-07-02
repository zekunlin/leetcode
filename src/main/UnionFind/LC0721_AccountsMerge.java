package UnionFind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

public class LC0721_AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, String> parentMap = new HashMap<>(); //node : parent
        HashMap<String, Integer> sizeCounter = new HashMap<>();
        HashMap<String, String> userMap = new HashMap<>(); //node : userMap
        HashMap<String, TreeSet<String>> accountEmails = new HashMap<>();
        List<List<String>> ret = new ArrayList<>();

        //build each node as its parent node
        //merge node to same root node
        //for each user, find out merged emails belongs to him,
        //add to result

        for(List<String> list : accounts){
            String user = list.get(0);
            String rootEmail = list.get(1);
            if(!parentMap.containsKey(rootEmail)){
                parentMap.put(rootEmail, rootEmail); //node, node's parent
                sizeCounter.put(rootEmail, sizeCounter.getOrDefault(rootEmail, 0) + 1);
            }

            userMap.put(rootEmail, user);//point root to its user

            for(int i = 2; i < list.size(); i++){
                String email = list.get(i);
                if(!parentMap.containsKey(email)) {
                    parentMap.put(email, email);//node: nodes' parent
                    sizeCounter.put(email, sizeCounter.getOrDefault(email, 0) + 1);
                }
                userMap.put(email, user);

                String parent = findParent(email, parentMap);
                String rootParent = findParent(rootEmail, parentMap);

                if(!parent.equals(rootParent)){
                    union(parent, rootParent, parentMap, sizeCounter);
                }
            }
        }
            // for each parentNode in parentMap
            // get user that owns this parent node
            // put the user and parent node in the TreeSet<User, Emails>
        for(String key : parentMap.keySet()){
            String keyParent = findParent(key, parentMap);
            accountEmails.putIfAbsent(keyParent, new TreeSet<>());
            accountEmails.get(keyParent).add(key);
        }


        for(String root : accountEmails.keySet()){
            String curUser = userMap.get(root);

            ArrayList<String> userEmailList = new ArrayList<>();
            userEmailList.add(curUser);

            for(String childEmail : accountEmails.get(root)){
                userEmailList.add(childEmail);
            }
            ret.add(userEmailList);
        }
        
        
        return ret;
    }

    public String findParent(String email, HashMap<String, String> parentMap){
        String parent = parentMap.get(email);

        if(!email.equals(parent)){
            parentMap.put(email, findParent(parent, parentMap));
        }

        return parentMap.get(email);
    }

    public void union(String email, String rootEmail, HashMap<String, String> parentMap, HashMap<String, Integer> counterMap){
        String emailParent = findParent(email, parentMap);
        String rootParent = findParent(rootEmail, parentMap);

        if(emailParent.equals(rootParent)) return;

        int emailParentSize = counterMap.get(emailParent);
        int rootParentSize = counterMap.get(rootParent);

        if(emailParentSize > rootParentSize){
            parentMap.put(rootParent, emailParent);
            counterMap.put(emailParent, emailParentSize + rootParentSize);
        }
        else{
            parentMap.put(emailParent, rootParent);
            counterMap.put(rootParent, emailParentSize + rootParentSize);
        }
    }
}
