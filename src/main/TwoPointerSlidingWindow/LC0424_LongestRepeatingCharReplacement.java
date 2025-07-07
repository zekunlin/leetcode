package TwoPointerSlidingWindow;

import java.util.HashMap;

public class LC0424_LongestRepeatingCharReplacement {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int maxLen = 0;
        HashMap<Character, Integer> charFreq = new HashMap<>();
        char maxChar = '\0';

        for(int right = 0; right < s.length(); right++){
            char cur = s.charAt(right);
            charFreq.put(cur, charFreq.getOrDefault(cur, 0) + 1);

            if(maxChar == '\0' || charFreq.get(cur) > charFreq.get(maxChar)){
                maxChar = cur;
            }

            while(right > left && right - left + 1 - charFreq.get(maxChar) > k){
                char leftChar = s.charAt(left);
                charFreq.put(s.charAt(left), charFreq.get(leftChar) - 1);
                left++;
                
                //update maxChar if necessary
                if(maxChar == leftChar){
                    for(Character key : charFreq.keySet()){
                        if(charFreq.get(key) > charFreq.get(maxChar)){
                            maxChar = key;
                        }
                    }
                }
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    //sol2:
    public int characterReplacement2(String s, int k) {
        int start = 0;
        int[] frequencyMap = new int[26];
        int maxFrequency = 0;
        int longestSubstringLength = 0;

        for (int end = 0; end < s.length(); end += 1) {
            // if 'A' is 0, then what is the relative order
            // or offset of the current character entering the window
            // 0 is 'A', 1 is 'B' and so on
            int currentChar = s.charAt(end) - 'A';

            frequencyMap[currentChar] += 1;

            // the maximum frequency we have seen in any window yet
            maxFrequency = Math.max(maxFrequency, frequencyMap[currentChar]);

            // move the start pointer towards right if the current
            // window is invalid
            Boolean isValid = (end + 1 - start - maxFrequency <= k);
            if (!isValid) {
                // offset of the character moving out of the window
                int outgoingChar = s.charAt(start) - 'A';

                // decrease its frequency
                frequencyMap[outgoingChar] -= 1;

                // move the start pointer forward
                start += 1;
            }

            // the window is valid at this point, note down the length
            // size of the window never decreases
            longestSubstringLength = end + 1 - start;
        }

        return longestSubstringLength;
    }

}
