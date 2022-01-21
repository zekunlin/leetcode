package LCtag.graph;

public class LC0269_Graph_AlienDictionary {
    public String alienOrder(String[] words) {
        //cc

        Map<Character, Integer> statusMap = new HashMap<>();
        Map<Character, List<Character>> map = new HashMap<>();
        boolean hasPrefix = buildGraph(words, map, statusMap);
        if(hasPrefix) return "";
        StringBuilder sb = new StringBuilder();

        for(Character ch : map.keySet()){
            if(topo(ch, map, statusMap, sb)) return "";
        }
        return sb.reverse().toString();
    }

    private boolean buildGraph(String[] words, Map<Character, List<Character>> map, Map<Character, Integer> statusMap){
        for(String word : words){
            for(int i = 0; i < word.length(); i++){
                if(!map.containsKey(word.charAt(i))){
                    map.put(word.charAt(i), new ArrayList<Character>());
                    statusMap.put(word.charAt(i), 0);
                }
            }
        }
        for(int i = 0; i < words.length - 1; i ++){
            String word1 = words[i];
            String word2 = words[i + 1];
            if(word1.length() > word2.length()){
                if(word1.startsWith(word2) || word2.startsWith(word1)) return true;
            }

            int minLen = Math.min(word1.length(), word2.length());
            for(int j = 0; j < minLen; j++){
                char ch1 = word1.charAt(j);
                char ch2 = word2.charAt(j);
                if(ch1 != ch2){
                    if(!map.get(ch1).contains(ch2)){
                        map.get(ch1).add(ch2);
                    }
                    break;
                }
            }
        }
        return false;
    }
    private boolean topo(char cur, Map<Character, List<Character>> map, Map<Character, Integer> statusMap, StringBuilder sb){
        //basecase
        if(statusMap.get(cur) == 1) return true;//0:initial, 1:visiting, 2:visited
        if(statusMap.get(cur) == 2) return false;

        statusMap.put(cur, 1);
        List<Character> nexts = map.get(cur);
        if(nexts != null){
            for(Character next : nexts){
                if(topo(next, map, statusMap, sb)) return true;
            }
        }
        statusMap.put(cur, 2);
        sb.append(cur);
        return false;
    }



}
