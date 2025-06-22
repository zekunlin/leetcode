package String;

class LongestCommonPrefix{
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";

        String prefix = strs[0];
        
        for(int i = 1; i < strs.length; i++){
            String cur = strs[i];
            int idx = 0;
            while(idx < cur.length() && idx < prefix.length() && cur.charAt(idx) == prefix.charAt(idx)){
                idx++;
            }
            prefix = prefix.substring(0, idx);
        }

        return prefix;
    }
}