package java.LCtag.bfs;
import java.util.*;

public class LC0126_BFS_WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        //cc
        if(beginWord == null || beginWord.length() == 0 || endWord == null || endWord.length() == 0 || wordList == null || wordList.size() == 0) return res;

        Set<String> dict = new HashSet<String>(wordList);// build dictionary
        if(!wordList.contains(endWord)) return res;

        Map<String, List<String>> graph = new HashMap<>();//build graph to store edges
        Queue<String> queue = new LinkedList<String>();
        queue.offer(beginWord);
        //dict.remove(beginWord);

        boolean isOver = false;

        while(!queue.isEmpty()){
            int qsize = queue.size();
            Set<String> thisLevelVisited = new HashSet<String>();//store visited word at this level
            while(qsize-- > 0){
                String cur = queue.poll();//get the first element from queue
                char[] cc = cur.toCharArray();

                for(int i = 0; i < cc.length; i++){
                    char temp = cc[i];
                    for(char c = 'a'; c <= 'z'; c++){//covert the current word
                        cc[i] = c;
                        String next = String.valueOf(cc);

                        if(c != temp && dict.contains(next)){//only accept next word is in the wordDict and c is not it self;
                            if(next.equals(endWord)) isOver = true; //check if we have found the answer endword;

                            if(!thisLevelVisited.contains(next)){//case1.totally not visited
                                queue.offer(next);//1)add to queue
                                List<String> to_V = new ArrayList<String>();
                                to_V.add(cur);
                                graph.put(next, to_V); //2) add edge
                                thisLevelVisited.add(next);//3) mark visited
                            }else{//case2.same level visited
                                List<String> to_V = graph.get(next);
                                to_V.add(cur);
                                graph.put(next, to_V);
                            }
                        }

                    }
                    cc[i] = temp;//set char back
                }

            }
            dict.removeAll(thisLevelVisited);//remove all words that have been searched

            if(isOver){//before end of the current level, if answer has occurred, we need to recover path untill now and add to the res;
                List<String> to_V = new LinkedList<String>();
                to_V.add(endWord);
                search(res, to_V, endWord, beginWord, graph);
                return res;
            }
        }
        return res;
    }

    private void search(List<List<String>> res, List<String> to_V, String current, String end, Map<String, List<String>> graph) {
        //base case
        if (current.equals(end)) {
            List<String> copy = new ArrayList<String>(to_V);
            res.add(copy);
            return;
        }

        List<String> nexts = graph.get(current);
        for (String next : nexts) {
            to_V.add(0, next);
            search(res, to_V, next, end, graph);
            to_V.remove(0);
        }
    }
}
