package TwoPointerSlidingWindow;

import java.util.HashMap;

public class LC0340_LongestSubstringAtMostKChars {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        HashMap<Character, Integer> charFreq = new HashMap<>();
        int left = 0;
        int charCount = 0;
        int maxLen = 0;
        for(int right = 0; right < s.length(); right++){
            char cur = s.charAt(right);
            if(!charFreq.containsKey(cur)){
                charFreq.put(cur, 1);
                charCount++;
            }else{
                charFreq.put(cur, charFreq.get(cur) + 1);
            }

            while(charCount > k){
                char leftChar = s.charAt(left);
                int leftCharFrq = charFreq.get(leftChar);
                leftCharFrq--;

                if(leftCharFrq == 0){
                    charFreq.remove(leftChar);
                    charCount--;
                }
                else{
                    charFreq.put(leftChar, leftCharFrq);
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
