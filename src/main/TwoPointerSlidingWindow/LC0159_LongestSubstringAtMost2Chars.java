package TwoPointerSlidingWindow;

import java.util.HashMap;

public class LC0159_LongestSubstringAtMost2Chars {
    //sol2: HashMap store frequency: Time: O(N), space: O(1);
    public int lengthOfLongestSubstringTwoDistinct2(String s) {
        int l = 0;
        int r = 0;
        HashMap<Character, Integer> charFreq = new HashMap<>();
        int count = 0;
        int maxLen = 0;
        while(r < s.length()){
            char cur = s.charAt(r);
            if(!charFreq.containsKey(cur)){
                charFreq.put(cur, 1);
                count++;
            }
            else{
                charFreq.put(cur, charFreq.get(cur) + 1);
            }

            while(count > 2){
                char charLeft = s.charAt(l);
                int leftCharFrq = charFreq.get(charLeft);
                leftCharFrq--;

                if(leftCharFrq == 0){
                    count--;
                    charFreq.remove(charLeft);
                }
                else{
                    charFreq.put(charLeft, leftCharFrq);
                }
                l++;
            }

            maxLen = Math.max(r - l + 1, maxLen);
            r++;
        }

        return maxLen;
    }
    
    //Time: O(n), Space: O(1)
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int l = 0;
        int r = 0;
        char ch1 = '\0';
        char ch2 = '\0';
        int lastSeenChar1 = -1;
        int lastSeenChar2 = -1;
        int maxLen = 0;
        while(r < s.length()){
            char cur = s.charAt(r);
            if(cur == ch1){
                lastSeenChar1 = r;
            }
            else if(cur == ch2){
                lastSeenChar2 = r;
            }
            else{
                if(lastSeenChar1 < lastSeenChar2){
                    ch1 = cur;
                    l = lastSeenChar1 + 1; // move left to last seen char1 + 1, get rid of char1 
                    lastSeenChar1 = r; //char1 is the charAt(r) now, update lastSeenChar1 to r; 
                }
                else{
                    ch2 = cur;
                    l = lastSeenChar2 + 1;
                    lastSeenChar2 = r;
                }
            }

            maxLen = Math.max(r - l + 1, maxLen);
            r++;
        }

        return maxLen;
    }
}
